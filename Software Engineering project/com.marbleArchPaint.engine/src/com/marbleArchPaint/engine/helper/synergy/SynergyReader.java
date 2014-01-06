package com.marbleArchPaint.engine.helper.synergy;

import general.CR;
import general.Connection;
import general.File;
import general.Folder;
import general.GeneralFactory;
import general.Snapshot;
import general.SynTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.runtime.Platform;

import dao.CRDao;
import dao.DaoFactory;
import dao.FileDao;
import dao.FolderDao;
import dao.SynTaskDao;

public class SynergyReader {

	private String sessionID;
	private Snapshot snapshot;
	private Connection connection;
	private List<Folder> folders;
	private List<File> files;
	private FolderDao folderDao;
	private FileDao fileDao;
	private CRDao crDao;
	private List<CR> crs;
	private List<SynTask> synTasks;
	private SynTaskDao syntaskdao;
	int counter;
	boolean once = true;
	Folder rootMe;
	double start1;
	double end1;
	double start2;
	double end2;
	double start3;
	double end3;
	public double startFilesAndFolders;
	public double endFilesAndFolders;
	public double startTasks;
	public double endTasks;
	public double startCRs;
	public double endCRs;
	public double startpersistTasks;
	public double endpersistTasks;
	public double startpersistCRs;
	public double endpersistCRs;
	Folder folderSpare;
	CR crSpare;
	String onSpare;
	
	private String ccmEXEFolder = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYCCM_EXE" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\ccm.exe" , null );
	
	private String ccmHomeFolder = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYCCM_DIR" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105" , null );
	
	private String ccmIniFile = Platform.getPreferencesService().getString( 
			"com.amenity.workbench" , 
			"SGYINI_FILE" , System.getenv("userprofile").replace('\\', '/') + "\\ccm71.ini" , null );
	private Map<String, String> env2;
	public double startpersistFilesAndFolders;
	public double endpersistFilesAndFolders;
	
	@SuppressWarnings("unused")
	private SynergyReader() {
		startFilesAndFolders=0;
		endFilesAndFolders=0;
		startTasks=0;
		endTasks=0;
		startCRs=0;
		endCRs=0;
		startpersistTasks=0;
		endpersistTasks=0;
		startpersistCRs=0;
		endpersistCRs=0;
		startpersistFilesAndFolders=0;
		endpersistFilesAndFolders=0;
	}
	
	public SynergyReader ( String sessionID, Connection connection, Snapshot snapshot ) {
		this.sessionID = sessionID;
		this.connection = connection;
		this.snapshot = snapshot;
		folderDao = DaoFactory.eINSTANCE.createFolderDao();
		fileDao = DaoFactory.eINSTANCE.createFileDao();
		crDao = DaoFactory.eINSTANCE.createCRDao();
		syntaskdao = DaoFactory.eINSTANCE.createSynTaskDao();
		folders = new ArrayList<Folder>();
		files = new ArrayList<File>();
		crs = new ArrayList<CR>();
		synTasks = new ArrayList<SynTask>();
		counter = 0;
		rootMe = GeneralFactory.eINSTANCE.createFolder();
		startFilesAndFolders = 0;
		endFilesAndFolders = 0;
		startTasks=0;
		endTasks=0;
		startCRs=0;
		endCRs=0;
		startpersistTasks=0;
		endpersistTasks=0;
		startpersistCRs=0;
		endpersistCRs=0;
		startpersistFilesAndFolders=0;
		endpersistFilesAndFolders=0;
		folderSpare = GeneralFactory.eINSTANCE.createFolder();
		
	}
	
	public boolean getProjectFiles()  {
		
		Folder folder1 = GeneralFactory.eINSTANCE.createFolder();
		folder1.setName("root");
		folders.add(folder1);
//		System.out.println("Calling generateContentObject : directoryName is "+connection.getDatabase()+"ProjectName: "+connection.getDatabase()+"root folder "+folder1);
		
		startFilesAndFolders=System.currentTimeMillis()/1000;
		System.out.println("startFilesAndFolders "+startFilesAndFolders);
		generateContentObject(connection.getDatabase(), connection.getDatabase(), folder1 );
		
		endFilesAndFolders=System.currentTimeMillis()/1000;
		System.out.println("endFilesAndFolders "+endFilesAndFolders);
//		System.out.println("Calling generateContentObject : directoryName is "+connection.getDatabase()+"ProjectName: "+connection.getDatabase()+"root folder "+folder1);
//		getChangeRequest();
		startpersistFilesAndFolders=System.currentTimeMillis()/1000;
		System.out.println("startpersistFilesAndFolders "+startpersistFilesAndFolders);
		if ( doPersist() )
		{
			
			endpersistFilesAndFolders=System.currentTimeMillis()/1000;
			System.out.println("endpersistFilesAndFolders "+endpersistFilesAndFolders);
			return true;
		}
		else 
			return false;
	}
	
	public boolean getProjectCRs()
	{
		crs.clear();
		startCRs = System.currentTimeMillis()/1000;
		System.out.println("startCRs "+startCRs);
		getChangeRequest();
		endCRs = System.currentTimeMillis()/1000;
		System.out.println("endCRs "+endCRs);
		
		startpersistCRs = System.currentTimeMillis()/1000;
		System.out.println("startpersistCRs "+startpersistCRs);
		if ( doPersist2()  && doPersist3()  )
		{
			endpersistCRs  = System.currentTimeMillis()/1000;
			System.out.println("endpersistCRs "+endpersistCRs);
			return true;
		}
		else 
			return false;
		
	}
	
	public boolean getAssociatedtsks(CR c, String objectName)
	{
//		synTasks.clear();
		startTasks = System.currentTimeMillis()/1000;
//		System.out.println("startTasks "+startTasks);
		getAssociatedTasks(c,  objectName);
		endTasks = System.currentTimeMillis()/1000;
//		System.out.println("endTasks "+endTasks);
		
		startpersistTasks  = System.currentTimeMillis();
//		System.out.println("startpersistTasks "+startpersistTasks);
//		if ( doPersist3() )
//		{
//			
//			endpersistTasks  = System.currentTimeMillis();
////			System.out.println("endpersistTasks "+endpersistTasks);
//			return true;
//		}
//		else 
		return true;
		
	}
	
	
	
	private boolean doPersist3()
	{
		try{
			
		
//		System.err.println("SynTasks list size is "+synTasks.size());
		

		syntaskdao.massInsert(synTasks, SynTask.class,snapshot);
		synTasks.clear();
		return true;
	}
		catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	}
	
	private void generateContentObject( String directoryName, String projectName, Folder root ) {
		
//		System.out.println("Directory Name is : "+directoryName);
//		System.out.println("Project Name is : "+projectName);
		
		ProcessBuilder pb = null;
		
		Process pr =null;
		try {
			pb = new ProcessBuilder("cmd", "/c", 
					ccmEXEFolder,
					"query",
					"-u",
					"\"is_child_of('" + directoryName +"','" + projectName + "')\"",
					"-f",
					"\"%objectname#%type#%displayname#%modify_time#%version#%status#%release#%name\"" 
					);
			/*
			 * Resultset Information:
			 * %objectname#%type#%displayname#%modify_time#%version#%status#%release#%name....
			 * 		0		1		2			3				4		5		6		7
			 * 
			 */
			Map<String, String> env = pb.environment();

			env.put("CCM_HOME", ccmHomeFolder);
			env.put("CCM_INI_FILE", ccmIniFile );
			env.put("CCM_ADDR", sessionID);
			pr = pb.start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String resultset = null;
//			 FileWriter output;
//			 java.io.File o= new java.io.File("SynergyCRresult.txt");
//			 	if(o.exists())
//			 		o.delete();
//			    o.createNewFile();
//			    output = new FileWriter(o,true);
			
			while (( resultset = br.readLine()) != null ){
				
				// Create Folder Object
				String[] rsArray =  resultset.split("#");
				System.out.println("resiltset to string is : "+ resultset.toString());
		
					String type;
					String objectName = rsArray[0].toString().trim();
					try
					{
						 type= rsArray[1].toString().trim();
					}
					catch(Exception exx)
					
					{
						exx.printStackTrace();
						System.out.println("I did break");
						System.out.println("I'm in the catch");
						SynergyLogin sl = new SynergyLogin();
//						closing the session stuck 
						
//						sl.closeSynergySession(sessionID);
//						System.out.println("close synergy session");
						
						sessionID = sl.getSynergySessionId();
						System.out.println("open new session");
						System.out.println("generateContentObject( "+folderSpare.getFullName()+","+projectName + ","+ folderSpare+")");
						generateContentObject( folderSpare.getFullName(), projectName, folderSpare );
						
						break;
						
						
					}
					System.out.println("shouldn't see this before result set");
					Date modifyTime = getFileDate(rsArray[3].toString().trim());
					String version = rsArray[4].toString().trim();
					String status = rsArray[5].toString().trim();
					String release = rsArray[6].toString().trim();
					String name = rsArray[7].toString().trim();

//					

					
					
					if ( type.equalsIgnoreCase("dir") ) {
						// its a folder 
						Folder folder;
						 folder = GeneralFactory.eINSTANCE.createFolder();
						
						folder.setLevel(( root.getName() == "root" ) ? 1 : root.getLevel()+1);
						folder.setName(name);
						folder.setVersion(version);
						folder.setModfiedDate(modifyTime);
						folder.setFullName(objectName);
						folder.setPartOf(snapshot);
						
							
						folder.setRootDirectory(root);
						
						
						folder.setRelease(release);
						folderSpare=folder;
					    folders.add(folder);
//						System.out.println("Calling generateContentObject : directoryName is "+folder.getFullName()+"ProjectName: "+projectName+"root folder "+folder);

					    generateContentObject(folder.getFullName(), projectName, folder);
					    
					} else if(!type.equalsIgnoreCase("dir")){ 
						// its a file
						File file = GeneralFactory.eINSTANCE.createFile();
						file.setLevel(root.getLevel()+1);
						file.setName(name);
						file.setVersion(version);
						file.setModfiedDate(modifyTime);
						file.setFullName(objectName);
//						System.out.println("Url : "+file.getFullName());
						file.setObjectName(objectName);
						file.setPartOf(snapshot);
						file.setRootDir(root);
						
						String appending= "";
						try{
//							System.out.println(file.getFullName());
//							appending= appending+file.getFullName().substring(0, file.getFullName().indexOf("-"));
							appending= appending+file.getName();
							rootMe=root;
						while(!rootMe.equals(null))
						{
							if(!rootMe.getFullName().equals(null)){
//							System.out.println("Url : "+ rootMe.getFullName());
//							appending = rootMe.getFullName().substring(0, rootMe.getFullName().indexOf("-"))+"/"+appending;
								appending = rootMe.getName()+"/"+appending;
							rootMe = rootMe.getRootDirectory();
							}
						}
						}
						catch(Exception e)
						{
//							e.printStackTrace();
							
//							System.out.println("end url "+appending);
							file.setPath(appending);
							
						}
						file.setStatus(status);
						file.setSuffix(getFileSuffix(name));
						file.setRelease(release);
						files.add(file);
//						continue;
					}

					
					
			}
//			SynergyLogin synergyLogin = new SynergyLogin();
//			synergyLogin.closeSynergySession(sessionID);

		}  catch (ArrayIndexOutOfBoundsException aiobx ) {
			aiobx.printStackTrace();
		}catch (Exception ex ){
			ex.printStackTrace();
			System.out.println(" >> Exception " + ex.getMessage());
			pr.destroy();
		}
	}
	
	private Date getFileDate ( String date ) {
		/**
		 * example input: 
		 * Sat Mar 17 02:40:39 2007
		 */
		if ( date.length() > 1 ) {
		
			Date returnDate = null;
			DateFormat df = new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy", 
					Locale.ENGLISH);
			
			try {
				returnDate = df.parse(date);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			return returnDate;
		}
		return null;
	}
	
	private boolean doPersist() {
		try {

			System.err.println("there are: " + folders.size() + " folders and " +
					files.size() + " files to be inserted");// and "+crs.size()+" CRs and "+synTasks.size()+" tasks");
			
			folderDao.massInsert(folders, Folder.class, snapshot);
			
			fileDao.massInsert(files, File.class, snapshot);
//			System.err.println("CRs list size is "+crs.size());
//			crDao.massInsert(crs, CR.class, snapshot);
//			syntaskdao.massInsert(synTasks, SynTask.class,snapshot);
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	private boolean doPersist2()
	{
		try{
			
		
		System.err.println("CRs list size before persisting is "+crs.size()+ "ans syntask list is "+synTasks.size());
		
		crDao.massInsert(crs, CR.class, snapshot);
//		syntaskdao.massInsert(synTasks, SynTask.class,snapshot);
		return true;
	}
		catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	}
	private void getChangeRequest() 
	{

		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", 
				ccmEXEFolder,
				"query",
				"\"cvtype='problem' and ((sie_project_name='"+connection.getChangeSynergyName()+"'))\"",
//				"\"cvtype='problem' and ((sie_project_name='StmTS'))\"",
				"-f",
				"\"%objectname#%type#%displayname#%modify_time#%change_request#%change_request_release#%change_request_synopsis#%change_request_status#%create_time#%requirement_id#%\"" 
				); 
		
//		(cvtype='task') and  is_associated_task_of('problem2-1:problem:CPMTQ')
		
		 Map<String, String> env = pb.environment();

		env.put("CCM_HOME", ccmHomeFolder);
		env.put("CCM_INI_FILE", ccmIniFile );
		env.put("CCM_ADDR", sessionID);
		Process pr;
		BufferedReader br;

			
			
			try {
				pr = pb.start();
				  br = new BufferedReader(new InputStreamReader(pr.getInputStream()),30 * 1024);
				 

			String resultset = null;
			
				
					
						while (( resultset = br.readLine()) != null ){
							try{
							
						System.out.println("MY Problems"+resultset.toString());	
						
						String[] rsArray =  resultset.split("#");
						
						String objectName = rsArray[0].toString().trim();
						String type = rsArray[1].toString().trim();

						String displayname = rsArray[2].toString().trim();
						Date modifyTime = getFileDate(rsArray[3].toString().trim());
						
						String change_request = rsArray[4].toString().trim();
						String change_request_release = rsArray[5].toString().trim();
						String change_request_synopsis = rsArray[6].toString().trim();
						String change_request_status = rsArray[7].toString().trim();
						
						Date change_request_create_time = getFileDate(rsArray[8].toString().trim());
//					
						CR cr = GeneralFactory.eINSTANCE.createCR();



						cr.setPartOf(snapshot);
						cr.setCR_Type(type);
						cr.setObjectName(objectName);
						cr.setFullName(change_request);
						cr.setLevel(0);
						cr.setName(displayname);
						cr.setModfiedDate(modifyTime);
						cr.setCreationDate(change_request_create_time);
						cr.setAssignedUser("");
						cr.setProject(connection.getDatabase());
						cr.setSummary(displayname+" "+change_request_synopsis );
						cr.setState(change_request_status);
						cr.setObjectId(null);
						cr.setRelease(change_request_release);
						crSpare  = cr;
						onSpare = objectName;
						
						crs.add(cr);
						getAssociatedtsks(cr, objectName);
						
						}
						catch(Exception exception){
							System.out.println("inside the loop exception");
							exception.printStackTrace();
						}
							
						}
					

					
		}
		catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	private void getAssociatedTasks(CR crr, String objectName)
	{
		
//		System.out.println("check the problem name"+objectName.substring(objectName.indexOf("p")));
//		System.out.println("\"(cvtype='task') and is_associated_task_of('"+objectName.substring(objectName.indexOf("p"))+"')\"");
		ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", 
					ccmEXEFolder,
					"query",
//					"\"(cvtype='task') and is_associated_task_of('problem2-1:problem:CPMTQ')\"",
					"\"(cvtype='task') and is_associated_task_of('"+objectName.substring(objectName.indexOf("p"))+"')\"",
//					"\"(cvtype='task') and is_associated_task_of('problem2-1:problem:CPMTQ')\"",
//					"(cvtype='task') and  is_associated_task_of('"+objectName.substring(objectName.indexOf("p"))+"')",
//					"–type task \"is_associated_task_of('problem2-1:problem:CPMTQ')\" ",
					"-f",
					"\"%displayname#%task#%task_release#%task_status#%task_synopsis#%type\"" 
					); 
//			 (cvtype='task') and  is_associated_task_of('problem289-1:problem:HPMTQ')
//			 no matches were found
			 	
		 
			 	env2 = pb2.environment();

				env2.put("CCM_HOME", ccmHomeFolder);
				env2.put("CCM_INI_FILE", ccmIniFile );
				env2.put("CCM_ADDR", sessionID);
				 
				
					try {
						
						
						Process pr2 = pb2.start();
						
						
					 BufferedReader br2 = new BufferedReader(new InputStreamReader(pr2.getInputStream()));
					 String resultset2 = null;

//							System.out.println("Checking condition");
							while (( resultset2 = br2.readLine()) != null ){
//							System.out.println("the problem is "+objectName);
//							System.out.println("Task Task "+resultset2.toString());	
							
							String[] rsArray2 =  resultset2.split("#");
							String objectname = rsArray2[0].toString().trim();
							try
							{
							@SuppressWarnings("unused")
							String task = rsArray2[1].toString().trim();
							}catch(Exception exx)
							{
								exx.printStackTrace();
								System.out.println("I did break");
								System.out.println("I'm in the catch");
								SynergyLogin sl = new SynergyLogin();
//								sl.closeSynergySession(sessionID);
//								System.out.println("close synergy session");
								sessionID = sl.getSynergySessionId();
								System.out.println("open new session");
								getAssociatedTasks(crSpare, onSpare);
								
								break;
							}
							String task_release = rsArray2[2].toString().trim();
							String task_status = rsArray2[3].toString().trim();//getFileDate(rsArray[3].toString().trim());
							
							String task_synopsis = rsArray2[4].toString().trim();
							@SuppressWarnings("unused")
							String type = rsArray2[5].toString().trim();
							SynTask st = GeneralFactory.eINSTANCE.createSynTask();
							
							
							st.setName(objectname);
							st.setLevel(0);
							st.setFullName(objectname);
							
							st.setPartOf(snapshot);
							st.setNamee(objectname);
							st.setPartOfCR(crr);
							st.setReleasee(task_release);
							st.setState(task_status);
							st.setSynopsis(task_synopsis);
							
							synTasks.add(st);
							
							}
							
							} catch (Exception e ) {
								
								if(e instanceof TimeoutException)
								{
									e.printStackTrace();
								}
								e.printStackTrace();
							}
	}
	
	private String getFileSuffix(String idOut) {
		int i = 0;
		int lastDotPosition = 0;
		for ( i = 0; i < idOut.length(); i++ ) {
			if ( idOut.charAt(i) == '.' ){
				lastDotPosition = i;
			}
		}
		if ( lastDotPosition < 1)
			return "-";
		return idOut.substring(lastDotPosition, idOut.length());
	}
	
	
	public double getCRsTime()
	{
		return endCRs - startCRs;
	}
	
	public double getFilesAndFolders()
	{
		return endFilesAndFolders - startFilesAndFolders;
	}
	
	public double getpersistFilesAndFolders()
	{
		
		return endpersistFilesAndFolders - startpersistFilesAndFolders;
	}
	
	
	
	public double getpersistTasksTime()
	{
		return endpersistTasks - startpersistTasks;
	}
	
	
	public double getTasksTime()
	{
		return endTasks - startTasks;
	}
	
	
	public double getpersistCRsTime()
	{
		return endpersistCRs - startpersistCRs;
	}
	
	
	
}
