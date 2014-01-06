package com.marbleArchPaint.engine.helper.compare;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import dao.DaoFactory;
import dao.FileDao;
import dao.FolderDao;

import general.ContentObject;
import general.File;
import general.Folder;

public class SnapshotComparator {

	// General things
	private List<ContentObject> contentObjects1;
	private List<ContentObject> contentObjects2;
	private List<GridItem> gridItems;
	private List<CompareViewObject> compareViewObjects;
	public boolean difference;
	public int changedFiles;
	public int changedFolders;
	// Snapshot left
	private List<Folder> folders1;
	private List<File> files1;
	
	// Snapshot right
	private List<Folder> folders2;
	private List<File> files2;
	private FolderDao folderDao;
	private FileDao fileDao;
	
	@SuppressWarnings("unused")
	private SnapshotComparator() {
	}
	
	public SnapshotComparator ( List<ContentObject> contentObjects1, 
			List<ContentObject> contentObjects2 ) {
		
		this.contentObjects1 = contentObjects1;
		this.contentObjects2 = contentObjects2;
		
		folderDao = DaoFactory.eINSTANCE.createFolderDao();
		fileDao = DaoFactory.eINSTANCE.createFileDao();
		// Instantiate the arrays 
		compareViewObjects = new ArrayList<CompareViewObject>();
		gridItems = new ArrayList<GridItem>();
		
		folders1 = new ArrayList<Folder>();
		files1 = new ArrayList<File>();
		
		folders2 = new ArrayList<Folder>();
		files2 = new ArrayList<File>();
		
		difference = true;
		changedFiles=0;
		changedFolders=0;
	}
	
	public List<CompareViewObject> createCompareViewObjects() {

		files1.clear();
		folders1.clear();
		files2.clear();
		folders2.clear();
		
		// fill lists with corresponding file and folder data
		for ( ContentObject co1 : contentObjects1 ) {
			if ( co1 instanceof File)
				files1.add((File)co1);
			else if(co1 instanceof Folder)
				folders1.add((Folder)co1);
		}
		
		for ( ContentObject co2 : contentObjects2 ) {
			if ( co2 instanceof File)
				files2.add((File)co2);
			else if(co2 instanceof Folder)
				folders2.add((Folder)co2);
		}
		
		CompareViewObject cvo;
		
		/*
		 *  run through list and create the Compare View Objects
		 *  folders1 should contain the "older" version
		 *  and hence folder 2 should always contain the earlier versions files
		 */
		
		for ( Folder f1 : folders1 ) {
			boolean foundFolder = false;
			for ( Folder f2 : folders2 ) {
				if ( f1.getName().equals(f2.getName()) ){
					// folder found
					// create CompareViewObject and add it to list
					if ( f1.getRootDirectory() == null || 
							f2.getRootDirectory() == null || 
							f1.getRootDirectory().getName().equals(f2.getRootDirectory().getName()) ) {
						cvo = new CompareViewObject(f1, f2, "==");
						compareViewObjects.add(cvo);
						// set found folder to true and clear object
						// remove the found folder from folders2 to shorten the runtime
						foundFolder = true;
						cvo = null;
						folders2.remove(f2);
						break;
					}
				} // else do nothing
			}
			if ( !foundFolder ) {
				// folder 1 did not exist in new snapshot
				cvo = new CompareViewObject(f1, null, "!=");
				difference = false;
				f1.setChanged("Red");
				
				folderDao.update(f1);
				changedFolders++;
				compareViewObjects.add(cvo);
				cvo = null;
			}
		}
		// Now we have to worry about folders that are in folder2 but not in folder1
		for ( Folder f2 : folders2 ) {
			cvo = new CompareViewObject(null, f2, "!=");
			difference = false;
			f2.setChanged("Red");
			folderDao.update(f2);
			changedFolders++;
			compareViewObjects.add(cvo);
			cvo = null;
		}
		
		/*
		 * next the same with the files
		 */
		for ( File f1 : files1 ) {
			boolean foundFile = false;
			for ( File f2 : files2 ) {
				if ( f1.getName().equals(f2.getName()) ){
					// folder found
					// now lets check the version and modification date
					if ( f1.getRootDir().getName().equals(f2.getRootDir().getName())) {
						String differenciator = null;
						if ( f1.getModfiedDate().after(f2.getModfiedDate() )) {
							// f1 is newer
							differenciator = ">";
							difference = false;
							
							f1.setChanged("Yello");
							fileDao.update(f1);
							System.out.println("updated "+f1.getName()+" yello");
							changedFiles++;
						} else if ( f1.getModfiedDate().before(f2.getModfiedDate() )) {
							differenciator = "<";
							difference = false;
							f2.setChanged("Yello");
							fileDao.update(f2);
							System.out.println("updated "+f2.getName()+" yello");
							changedFiles++;
						} else {
							differenciator = "==";
						}
						// create CompareViewObject and add it to list
						cvo = new CompareViewObject(f1, f2, differenciator);
						compareViewObjects.add(cvo);
						// set found folder to true and clear object
						// remove the found folder from folders2 to shorten the runtime
						foundFile = true;
						cvo = null;
						files2.remove(f2);
						break;
					}
				} // else do nothing
			}
			if ( !foundFile ) {
				// file 1 did not exist in new snapshot
				cvo = new CompareViewObject(f1, null, "!=");
				difference = false;
				f1.setChanged("Red");
				fileDao.update(f1);
				changedFiles++;
				compareViewObjects.add(cvo);
				cvo = null;
			}
		}
		// Now we have to worry about folders that are in folder2 but not in folder1
		for ( File f2 : files2 ) {
			cvo = new CompareViewObject(null, f2, "!=");
			difference = false;
			f2.setChanged("Red");
			fileDao.update(f2);
			changedFiles++;
			compareViewObjects.add(cvo);
			cvo = null;
		}
		
		return compareViewObjects;
	}
	
	public List<GridItem> getComparableGrid( Grid grid ) {

		createCompareViewObjects();
		
		files1.clear();
		folders1.clear();
		files2.clear();
		folders2.clear();
		
		List<CompareViewObject> compareViewFolderObjects = new ArrayList<CompareViewObject>();
		List<CompareViewObject> compareViewFileObjects = new ArrayList<CompareViewObject>();
		
		// fill lists with corresponding file and folder data
		for ( CompareViewObject cvo : compareViewObjects ) {
			
			if ( cvo.getFile1() != null || cvo.getFile2() != null ) {
				// its a file
				compareViewFileObjects.add(cvo);
//				System.err.println("--"+cvo.getFile1().getName()+
//						"--"+cvo.getFile2().getName()+"--"+cvo.getDifferenciator()+"--");
			} else {
				// its a folder
				compareViewFolderObjects.add(cvo);
			}
		}
		
		
		GridItem gridItem;
		// create folders
		int noLevelResult = 0;
		SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
		
		for ( int i = 0 ; i < 999 ; i++ ){
			int itemsFound = 0;
			// break operation to not waste runtime! 
			if ( noLevelResult > 20 ) {
				break;
			}
			for ( CompareViewObject cvfo : compareViewFolderObjects ) {

				if ( cvfo.getFolder1() != null ) {
				if ( cvfo.getFolder1().getLevel() == i ) { // || cvfo.getFolder2().getLevel() == i) {
					/*
					 * now we use the differenciator to diff between the folders
					 * in order to know what folder to use
					 */
					if ( cvfo.getDifferenciator().equalsIgnoreCase("==") || 
							cvfo.getDifferenciator().equalsIgnoreCase("<") || 
							cvfo.getDifferenciator().equalsIgnoreCase(">") ) {
						// They both exist, so we use Folder1 as "main" folder
						
//						System.err.println("--" + cvfo.getFolder1().getName() + "--"
//								+cvfo.getFolder2().getName() + "--" + cvfo.getDifferenciator()+"--" + 
//								cvfo.getFolder1().getRootDirectory() + "--" + 
//								cvfo.getFolder2().getRootDirectory()  + "--" );
						
						if ( cvfo.getFolder1().getRootDirectory() == null ) {
							// folder is root! 
							// static new root creation!
							gridItem = new GridItem ( grid, SWT.NONE );
							gridItem.setExpanded(true);
						} else {
							// it has a daddy which is already created and hence is looked up
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFolder1().getRootDirectory()), SWT.NONE);
						}
					} else if ( cvfo.getDifferenciator().equalsIgnoreCase("!=")) {
						
						if ( cvfo.getFolder1() == null ) {
							// we use folder 2 as master
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFolder2().getRootDirectory()), SWT.NONE);
							
						} else {
							
							// we use folder 1 as master
							System.out.println("cvfo.getFolder1().getRootDirectory() is : "+cvfo.getFolder1().getRootDirectory().getName());
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFolder1().getRootDirectory()), SWT.NONE);
						}
						gridItem = colorGrid(gridItem, 192, 80, 77);
						
					} else {
						/*
						 * TODO nicer messages
						 */
						System.out.println("an error occured");
						continue;
					}
					if ( cvfo.getFolder1() != null ) {
						gridItem.setText(0,cvfo.getFolder1().getName().toString());
						gridItem.setText(3,cvfo.getFolder1().getObjectId());
						gridItem.setImage(0,PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJ_FOLDER));
					}
					if ( cvfo.getFolder2() != null ) {
						gridItem.setText(5,cvfo.getFolder2().getName().toString());
						gridItem.setText(8,cvfo.getFolder2().getObjectId());
						gridItem.setImage(5,PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJ_FOLDER));
					}
					gridItem.setText(4, cvfo.getDifferenciator());
					
					gridItems.add(gridItem);
					itemsFound++;
				}
			} 

				else 
				if ( cvfo.getFolder2() != null &&
						cvfo.getFolder1() == null ) {
					if ( cvfo.getFolder2().getLevel() == i ) { // || cvfo.getFolder2().getLevel() == i) {
						/*
						 * now we use the differenciator to diff between the folders
						 * in order to know what folder to use
						 */
						if ( cvfo.getDifferenciator().equalsIgnoreCase("==") || 
								cvfo.getDifferenciator().equalsIgnoreCase("<") || 
								cvfo.getDifferenciator().equalsIgnoreCase(">") ) {
							// They both exist, so we use Folder1 as "main" folder
							
//							System.err.println("--" + cvfo.getFolder1().getName() + "--"
//									+cvfo.getFolder2().getName() + "--" + cvfo.getDifferenciator()+"--" + 
//									cvfo.getFolder1().getRootDirectory() + "--" + 
//									cvfo.getFolder2().getRootDirectory()  + "--" );
							
							if ( cvfo.getFolder2().getRootDirectory() == null ) {
								// folder is root! 
								// static new root creation!
								gridItem = new GridItem ( grid, SWT.NONE );
								gridItem.setExpanded(true);
							} else {
								// it has a daddy which is already created and hence is looked up
								gridItem = new GridItem ( 
										getParentGrid(cvfo.getFolder2().getRootDirectory()), SWT.NONE);
							}
						} else if ( cvfo.getDifferenciator().equalsIgnoreCase("!=")) {
							
							if ( cvfo.getFolder2() == null ) {
								// we use folder 2 as master
								gridItem = new GridItem ( 
										getParentGrid(cvfo.getFolder1().getRootDirectory()), SWT.NONE);
								
							} else {
								// we use folder 1 as master
								gridItem = new GridItem ( 
										getParentGrid(cvfo.getFolder2().getRootDirectory()), SWT.NONE);
							}
							gridItem = colorGrid(gridItem, 192, 80, 77);
							
						} else {
							/*
							 * TODO: nicer messages
							 */
							System.out.println("an error occured");
							continue;
						}
						if ( cvfo.getFolder1() != null ) {
							gridItem.setText(0,cvfo.getFolder1().getName().toString());
							gridItem.setText(3,cvfo.getFolder1().getObjectId());
							gridItem.setImage(0,PlatformUI.getWorkbench().getSharedImages()
									.getImage(ISharedImages.IMG_OBJ_FOLDER));
						}
						if ( cvfo.getFolder2() != null ) {
							gridItem.setText(5,cvfo.getFolder2().getName().toString());
							gridItem.setText(8,cvfo.getFolder2().getObjectId());
							gridItem.setImage(5,PlatformUI.getWorkbench().getSharedImages()
									.getImage(ISharedImages.IMG_OBJ_FOLDER));
						}
						gridItem.setText(4, cvfo.getDifferenciator());
						
						gridItems.add(gridItem);
						itemsFound++;
					}
				}
				
			}
			
			
			
			
			
			/**
			 * END TEMP
			 */
			if ( itemsFound < 1 ) 
				noLevelResult++;
		}
		
		noLevelResult = 0;
		// now lets check out the files
		for ( int i = 0 ; i < 999 ; i++ ){
			int itemsFound = 0;
			// break operation to not waste runtime! 
			if ( noLevelResult > 20 ) {
				break;
			}
			for ( CompareViewObject cvfo : compareViewFileObjects ) {
				if ( cvfo.getFile1() != null ) {
				if ( cvfo.getFile1().getLevel() == i  ) { //|| cvfo.getFile1().getLevel() == i ) {
					/*
					 * now we use the differenciator to diff between the folders
					 * in order to know what folder to use
					 */
					if ( cvfo.getDifferenciator().equalsIgnoreCase("==") || 
							cvfo.getDifferenciator().equalsIgnoreCase("<") || 
							cvfo.getDifferenciator().equalsIgnoreCase(">") ) {
						// They both exist, so we use Folder1 as "main" folder
						
						// it has a daddy which is already created and hence is looked up
						gridItem = new GridItem ( 
								getParentGrid(cvfo.getFile1().getRootDir()), SWT.NONE);

						
						if ( cvfo.getDifferenciator().equalsIgnoreCase("<") || 
								cvfo.getDifferenciator().equalsIgnoreCase(">") ) {
//							System.out.println("set color " + cvfo.getFile1().getRootDir());
							// hellrot
//							gridItem = colorGrid(gridItem, 230, 184, 184);
							// gelb
							gridItem = colorGrid(gridItem, 238, 232, 170); //yellow
							
							// here I should trigger the "changed2 attribute to TRUE
							
							getParentGrid(cvfo.getFile1().getRootDir()).setExpanded(true);
						}
					} else if ( cvfo.getDifferenciator().equalsIgnoreCase("!=")) {
						
						if ( cvfo.getFile1() == null ) {
							// we use folder 2 as master
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFile2().getRootDir()), SWT.NONE);
							
						} else {
							// we use folder 1 as master
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFile1().getRootDir()), SWT.NONE);
						}
						gridItem = colorGrid(gridItem, 192, 80, 77);
						
					} else {
						/*
						 * TODO: nicer messages
						 */
						System.out.println("an error occured");
						continue;
					}
					if ( cvfo.getFile1() != null ) {
						gridItem.setText(0,cvfo.getFile1().getName().toString());
						gridItem.setText(1,cvfo.getFile1().getVersion());
						gridItem.setText(2,df.format(cvfo.getFile1().getModfiedDate()));
						gridItem.setText(3,cvfo.getFile1().getObjectId());
						gridItem.setImage(0,PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJ_FILE));
					}
					if ( cvfo.getFile2() != null ) {
						gridItem.setText(5,cvfo.getFile2().getName().toString());
						gridItem.setText(6,cvfo.getFile2().getVersion());
						gridItem.setText(7,df.format(cvfo.getFile2().getModfiedDate()));
						gridItem.setText(8,cvfo.getFile2().getObjectId());
						gridItem.setImage(5,PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJ_FILE));
					}
					gridItem.setText(4, cvfo.getDifferenciator());
					
					gridItems.add(gridItem);
					itemsFound++;
				}
				}
				
				if ( cvfo.getFile2() != null &&
						cvfo.getFile1() == null) {
					if ( cvfo.getFile2().getLevel() == i  ) { //|| cvfo.getFile1().getLevel() == i ) {
						/*
						 * now we use the differenciator to diff between the folders
						 * in order to know what folder to use
						 */
						if ( cvfo.getDifferenciator().equalsIgnoreCase("==") || 
								cvfo.getDifferenciator().equalsIgnoreCase("<") || 
								cvfo.getDifferenciator().equalsIgnoreCase(">") ) {
							// They both exist, so we use Folder1 as "main" folder
							
							// it has a daddy which is already created and hence is looked up
							gridItem = new GridItem ( 
									getParentGrid(cvfo.getFile2().getRootDir()), SWT.NONE);

							
							if ( cvfo.getDifferenciator().equalsIgnoreCase("<") || 
									cvfo.getDifferenciator().equalsIgnoreCase(">") ) {
//								System.out.println("set color " + cvfo.getFile1().getRootDir());
								// hellrot
//								gridItem = colorGrid(gridItem, 230, 184, 184);
								// gelb
								gridItem = colorGrid(gridItem, 238, 232, 170);
								
								// here I should trigger the "changed2 attribute to TRUE
								getParentGrid(cvfo.getFile1().getRootDir()).setExpanded(true);
							}
						} else if ( cvfo.getDifferenciator().equalsIgnoreCase("!=")) {
							
							if ( cvfo.getFile1() == null ) {
								// we use folder 2 as master
								gridItem = new GridItem ( 
										getParentGrid(cvfo.getFile2().getRootDir()), SWT.NONE);
								
							} else {
								// we use folder 1 as master
								gridItem = new GridItem ( 
										getParentGrid(cvfo.getFile1().getRootDir()), SWT.NONE);
							}
							gridItem = colorGrid(gridItem, 192, 80, 77);
							
						} else {
							/*
							 * TODO: nicer messages
							 */
							System.out.println("an error occured");
							continue;
						}
						if ( cvfo.getFile1() != null ) {
							gridItem.setText(0,cvfo.getFile1().getName().toString());
							gridItem.setText(1,cvfo.getFile1().getVersion());
							gridItem.setText(2,df.format(cvfo.getFile1().getModfiedDate()));
							gridItem.setText(3,cvfo.getFile1().getObjectId());
							gridItem.setImage(0,PlatformUI.getWorkbench().getSharedImages()
									.getImage(ISharedImages.IMG_OBJ_FILE));
						}
						if ( cvfo.getFile2() != null ) {
							gridItem.setText(5,cvfo.getFile2().getName().toString());
							gridItem.setText(6,cvfo.getFile2().getVersion());
							gridItem.setText(7,df.format(cvfo.getFile2().getModfiedDate()));
							gridItem.setText(8,cvfo.getFile2().getObjectId());
							gridItem.setImage(5,PlatformUI.getWorkbench().getSharedImages()
									.getImage(ISharedImages.IMG_OBJ_FILE));
						}
						gridItem.setText(4, cvfo.getDifferenciator());
						
						gridItems.add(gridItem);
						itemsFound++;
					}
					}
				
				
			}
			if ( itemsFound < 1 ) 
				noLevelResult++;
		}
		
		
		
		return gridItems;
	}
	
	public GridItem getParentGrid(Folder rootDirectory) {
		for ( GridItem gi : gridItems ) {
			if ( gi.getText(3).equals(rootDirectory.getObjectId() )) {
				return gi;
			} 
			if ( gi.getText(8).equals(rootDirectory.getObjectId() )) {
				return gi;
			}
		}
		return null;
	}
	
	private GridItem colorGrid( GridItem gridItem, int r, int g, int b ) {

		gridItem.setBackground(0, new Color(Display.getCurrent(), r, g, b));
		gridItem.setBackground(1, new Color(Display.getCurrent(), r, g, b));
		gridItem.setBackground(2, new Color(Display.getCurrent(), r, g, b));
		gridItem.setBackground(3, new Color(Display.getCurrent(), r, g, b));
		gridItem.setBackground(4, new Color(Display.getCurrent(), r, g, b));
		gridItem.setBackground(5, new Color(Display.getCurrent(), r, g, b));
		gridItem.setBackground(6, new Color(Display.getCurrent(), r, g, b));
		gridItem.setBackground(7, new Color(Display.getCurrent(), r, g, b));
		gridItem.setBackground(8, new Color(Display.getCurrent(), r, g, b));
		
		return gridItem;
	}
	
	public boolean getDifference()
	{
		return difference;
	}
	
	public int getChangedFolders()
	{
		return changedFolders;
	}
	public int getChangedFiles()
	{
		return changedFiles;
	}
}
