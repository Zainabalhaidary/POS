package com.marbleArchPaint.softwareEngineering.dialogs;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import general.Category;
import general.Customer;
import general.GeneralFactory;
import general.Product;
import general.Supplier;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.marbleArchPaint.softwareEngineering.SessionSourceProvider;
import com.marbleArchPaint.softwareEngineering.LabelProvider.GenericNameLabelProvider;
import com.marbleArchPaint.softwareEngineering.views.Pos;

import dao.CategoryDao;
import dao.CustomerDao;
import dao.DaoFactory;
import dao.ProductDao;
import dao.SupplierDao;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

public class LoadProductsDialog extends Dialog {
	ComboViewer cv2;
	private Text text;
	protected String selectedDir;
	protected ISelection jfaceSelection;
	protected IStructuredSelection structuredSelection;
	ComboViewer comboViewer ;

	public LoadProductsDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Load Products");
	}
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setLayout(null);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 27, 112, 15);
		lblNewLabel.setText("Product List Location");

		text = new Text(container, SWT.BORDER);
		text.setBounds(128, 24, 321, 21);

		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				FileDialog fileDialog = new FileDialog(getShell());

				fileDialog.setFilterPath(selectedDir);
				//				fileDialog.setMessage("Please select a directory and click OK");

				String dir2 = fileDialog.open();
				if(dir2 != null) {
					text.setText(dir2);
					selectedDir = dir2;
					System.out.println(selectedDir);
				}
			}
		});
		btnBrowse.setBounds(455, 22, 58, 25);
		btnBrowse.setText("Browse");

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setBounds(10, 60, 112, 15);
		lblNewLabel_1.setText("Supplier");

		cv2 = new ComboViewer(container, SWT.NONE);
		Combo combo = cv2.getCombo();
		combo.setBounds(128, 57, 321, 23);

		Label lblCategory = new Label(container, SWT.NONE);
		lblCategory.setText("Category");
		lblCategory.setBounds(10, 95, 112, 15);

		comboViewer = new ComboViewer(container, SWT.NONE);
		Combo combo_1 = comboViewer.getCombo();
		combo_1.setBounds(128, 92, 321, 23);
		comboViewer.setLabelProvider(new GenericNameLabelProvider());
		comboViewer.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Category>)inputElement ) .toArray();
			}
		});
		CategoryDao cDao = DaoFactory.eINSTANCE.createCategoryDao();
		//Category c = GeneralFactory.eINSTANCE.createCategory();
		List<Category> cList = cDao.getList(Category.class);
		comboViewer.setInput(cList);

		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;

				if ( !structuredSelection.isEmpty()) {

					if ( structuredSelection.getFirstElement() instanceof Category) {
						SessionSourceProvider.CURRENT_CATEGORY=  (Category)structuredSelection.getFirstElement(); 
					}
				}
			}
		});


		cv2.setLabelProvider(new GenericNameLabelProvider());
		cv2.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Supplier>)inputElement ) .toArray();
			}
		});
		SupplierDao sDao = DaoFactory.eINSTANCE.createSupplierDao();
		List<Supplier> sList = sDao.getList(Supplier.class);
		cv2.setInput(sList);
		cv2.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;

				if ( !structuredSelection.isEmpty()) {

					if ( structuredSelection.getFirstElement() instanceof Supplier) {
						SessionSourceProvider.CURRENT_SUPPLIER=  (Supplier)structuredSelection.getFirstElement(); 
					}
				}
			}
		});
		return container;
	}

	protected void okPressed()  {

		if(!(text.getText()==""|| cv2.getSelection().toString().equals("<empty selection>")||comboViewer.getSelection().toString().equals("<empty selection>")))
		{
			try {
				File workbookFile = new File(text.getText());

				FileInputStream fis = new FileInputStream(workbookFile);
				Workbook workbook = WorkbookFactory.create(fis);
				Sheet sheet =workbook.getSheetAt(0) ;
				//for ( int i = 5 ; i<=sheet.getLastRowNum(); i=i+2)
				for ( int i = 5 ; i<=sheet.getLastRowNum(); i++)
				{

					System.out.println("#################################################");
					//										Row row = sheet.getRow( i ) ;
					//										System.out.println("row number is "+ i);
					//										for(int j = 0; j<34;j++)
					//										{
					//											
					//											Cell qty = row.getCell(j);
					//											try{
					//											System.out.println("string value in "+ j+ " is "+qty.getStringCellValue());
					//											}
					//											catch(Exception e)
					//											{
					//												try
					//												{
					//												System.out.println(" numeric value in "+ j+ " is "+qty.getNumericCellValue());
					//												}
					//												catch(Exception ee)
					//												{
					//													
					//												}
					//											}
					//													
					//									}
					try{
						Row row = sheet.getRow( i ) ;
						Cell qty = row.getCell(0);

						System.out.println("quantity is "+qty.getNumericCellValue());



						Cell code =row.getCell(4);


						System.out.println(code.getStringCellValue());


						Cell desc = row.getCell(8);
						System.out.println(desc.getStringCellValue());

						Cell price = row.getCell(20);
						System.out.println(price.getNumericCellValue());

						ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
						Product p = GeneralFactory.eINSTANCE.createProduct();
						p.setCatergoryId(SessionSourceProvider.CURRENT_CATEGORY);
						p.setProductName(desc.getStringCellValue());

						p.setProductDescription(desc.getStringCellValue());
						p.setQuantityPerUnit(1);
						p.setSKU(code.getStringCellValue());
						p.setSupplierId(SessionSourceProvider.CURRENT_SUPPLIER);
						p.setUnitPrice(price.getNumericCellValue());

						//p.setUnitsInStock(Integer.parseInt(Double.toString(qty.getNumericCellValue())));
						p.setUnitsInStock((int) Math.round(qty.getNumericCellValue()));

						p.setTotalQuantity(p.getUnitsInStock()*p.getQuantityPerUnit());

						if(p.getTotalQuantity()>1 &&p.getTotalQuantity()<5 )
						{
							p.setImage("icons/workbench/general/R Yellow.png");

						}
						else if(p.getTotalQuantity()<=1 )
						{
							p.setImage("icons/workbench/general/R Red.png");
						}
						else
						{
							p.setImage("icons/workbench/general/R White.png");
						}
						
						if((pDao.getBySKU2(p.getSKU())).size()==0){


							pDao.create(p);
							SessionSourceProvider.CURRENT_PRODUCT =p;
						}
						else
						{
							//MessageDialog.openError(getParentShell(), "Insruction", "This product's sku already exist in the database, you can search for it");
							 pDao = DaoFactory.eINSTANCE.createProductDao();
							Product pp = pDao.getBySKU2(p.getSKU()).get(0);
							
							pp.setUnitsInStock(pp.getUnitsInStock() + (int) Math.round(qty.getNumericCellValue()));
							
							pp.setTotalQuantity(( pp.getUnitsInStock()*pp.getQuantityPerUnit()));
							System.out.println("quantity increased by "+ pp.getTotalQuantity());
							if(pp.getTotalQuantity()>1 &&pp.getTotalQuantity()<5 )
							{
								pp.setImage("icons/workbench/general/R Yellow.png");

							}
							else if(pp.getTotalQuantity()<=1 )
							{
								pp.setImage("icons/workbench/general/R Red.png");
							}
							else
							{
								pp.setImage("icons/workbench/general/R White.png");
							}
							pDao.create(pp);
							SessionSourceProvider.CURRENT_PRODUCT =pp;
						}
					}catch(Exception e)
					{
						continue;
					}

				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		else
		{
			MessageDialog.openError(getParentShell(), "Instruction", "Please sfill all the fields");
			return;
		}



		super.okPressed();
	}
}
