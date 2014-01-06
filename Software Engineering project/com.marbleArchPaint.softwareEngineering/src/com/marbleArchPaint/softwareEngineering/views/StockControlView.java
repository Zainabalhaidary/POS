package com.marbleArchPaint.softwareEngineering.views;

import java.awt.Desktop;
import java.net.URI;
import java.util.List;

import general.GeneralFactory;
import general.Product;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;

import com.marbleArchPaint.softwareEngineering.SessionSourceProvider;
import com.marbleArchPaint.softwareEngineering.dialogs.AddProductDialog;
import com.marbleArchPaint.softwareEngineering.dialogs.AddSupplierDialog;
import com.marbleArchPaint.softwareEngineering.dialogs.CreateReportDialog;
import com.marbleArchPaint.softwareEngineering.dialogs.LoadProductsDialog;

import dao.DaoFactory;
import dao.ProductDao;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StockControlView extends ViewPart {
	private  TableViewer tv;
	private Table table;
	protected ISelection jfaceSelection;
	protected IStructuredSelection structuredSelection;

	public StockControlView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(final Composite parent) {
		parent.setLayout(null);

		tv = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tv.getTable();
		table.setBounds(10, 10, 716, 518);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);



		TableColumn tblclmnNewColumn =  new TableColumn(table, SWT.NONE);
		TableViewerColumn tblclmnNewColumnn = new TableViewerColumn(tv, tblclmnNewColumn);

		tblclmnNewColumn.setWidth(61);
		tblclmnNewColumn.setText("SKU");
		tblclmnNewColumnn.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Product)
				{
					return ((Product)element).getSKU();
				}
				return null;
			}
		});

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE); 
		TableViewerColumn tblclmnNewColumn_11 = new TableViewerColumn(tv, tblclmnNewColumn_1);

		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Product name");

		tblclmnNewColumn_11.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Product)
				{
					return ((Product)element).getProductName();
				}
				return null;
			}
		});

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE); 
		TableViewerColumn tblclmnNewColumn_22 = new TableViewerColumn(tv, tblclmnNewColumn_2);

		tblclmnNewColumn_2.setWidth(116);
		tblclmnNewColumn_2.setText("Description");
		tblclmnNewColumn_22.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Product)
				{
					return ((Product)element).getProductDescription();
				}
				return null;
			}
		});
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE); 

		TableViewerColumn tblclmnNewColumn_33 = new TableViewerColumn(tv, tblclmnNewColumn_3);
		tblclmnNewColumn_3.setWidth(82);
		tblclmnNewColumn_3.setText("Supplier");
		tblclmnNewColumn_33.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				try{
					if(element instanceof Product)
					{
						return ((Product)element).getSupplierId().getCompanyName();
					}
				}
				catch(Exception e)
				{

				}
				return null;
			}
		});
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE); 

		TableViewerColumn tblclmnNewColumn_44 = new TableViewerColumn(tv, tblclmnNewColumn_4);
		tblclmnNewColumn_4.setText("Price/Unit");
		tblclmnNewColumn_4.setWidth(76);
		tblclmnNewColumn_44.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Product)
					{
						return (Double.toString(((Product)element).getUnitPrice()));
					}
				}
				catch(Exception e)
				{

				}
				return null;
			}
		});
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table, SWT.NONE);
		TableViewerColumn tblViewerclmnDiscount = new TableViewerColumn(tv, tblclmnNewColumn_8);
		tblViewerclmnDiscount.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Product)
					{
						return (Double.toString(((Product)element).getDiscount()));
					}
				}
				catch(Exception e)
				{

				}
				return null;
			}
		});
		
		tblclmnNewColumn_8.setWidth(100);
		tblclmnNewColumn_8.setText("Discount");
		tblViewerclmnDiscount.setEditingSupport(new EditingSupport(tv) {

			@Override
			protected void setValue(Object element, Object value) {

				if(value instanceof String )
				{
					if(element instanceof Product)
					{
						try
						{
							System.out.println("Im a quantity being changed");
							ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
							Product p = GeneralFactory.eINSTANCE.createProduct();
							p = SessionSourceProvider.CURRENT_PRODUCT;

							p.setDiscount(Double.parseDouble((String)value));

							
							pDao.update(p);
							listProducts();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			}

			@Override
			protected Object getValue(Object element) {

				return(element == null ? " " : Double.toString(((Product)element).getDiscount()));
				//return ((OrderDetails)element).getQuantity();
			}

			@Override
			protected CellEditor getCellEditor(Object element) {

				return new TextCellEditor(tv.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {

				return true;
			}


		});
		
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE); 
		TableViewerColumn tblclmnNewColumn_55 = new TableViewerColumn(tv, tblclmnNewColumn_5);

		tblclmnNewColumn_5.setWidth(63);
		tblclmnNewColumn_5.setText("Size");
		tblclmnNewColumn_55.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Product)
					{
						return (((Product)element).getSize());
					}
				}
				catch(Exception e)
				{

				}
				return null;
			}
		});

		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE); ;
		TableViewerColumn tblclmnNewColumn_66 = new TableViewerColumn(tv, tblclmnNewColumn_6);

		tblclmnNewColumn_6.setWidth(51);
		tblclmnNewColumn_6.setText("Color");
		tblclmnNewColumn_66.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Product)
					{
						return (((Product)element).getColor());
					}
				}
				catch(Exception e)
				{

				}
				return null;
			}
		});


		//TableViewerColumn tvcq  = new TableViewerColumn(tv_1, tblclmnNewColumn_1);

		TableColumn tblclmnNewColumn_7 =  new TableColumn(table, SWT.NONE);
		TableViewerColumn tblclmnNewColumn_77 = new TableViewerColumn(tv, tblclmnNewColumn_7);
		tblclmnNewColumn_7.setWidth(91);
		tblclmnNewColumn_7.setText("In Stock");
		tblclmnNewColumn_77.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Product)
					{

						return (Integer.toString(((Product)element).getTotalQuantity()));
					}
				}
				catch(Exception e)
				{

				}
				return null;
			}
		});

		tblclmnNewColumn_77.setEditingSupport(new EditingSupport(tv) {

			@Override
			protected void setValue(Object element, Object value) {

				if(value instanceof String )
				{
					if(element instanceof Product)
					{
						try
						{
							System.out.println("Im a quantity being changed");
							ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
							Product p = GeneralFactory.eINSTANCE.createProduct();
							p = SessionSourceProvider.CURRENT_PRODUCT;

							p.setTotalQuantity(Integer.parseInt((String)value));

							if(((Product)element).getTotalQuantity()>1 &&((Product)element).getTotalQuantity()<5 )
							{
								p.setImage("icons/workbench/general/R Yellow.png");

							}
							else if(((Product)element).getTotalQuantity()<=1 )
							{
								p.setImage("icons/workbench/general/R Red.png");
							}
							else
							{
								p.setImage("icons/workbench/general/R White.png");
							}
							pDao.update(p);
							listProducts();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			}

			@Override
			protected Object getValue(Object element) {

				return(element == null ? " " : Integer.toString(((Product)element).getTotalQuantity()));
				//return ((OrderDetails)element).getQuantity();
			}

			@Override
			protected CellEditor getCellEditor(Object element) {

				return new TextCellEditor(tv.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {

				return true;
			}


		});
		
		Button btnNewButton = new Button(parent, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddProductDialog apd = new AddProductDialog(parent.getShell());
				if(apd.open()==0)
				{
					
				}
				listProducts();
			}
		});
		btnNewButton.setBounds(732, 10, 112, 25);
		btnNewButton.setText("Insert New Product");
		
		Button btnNewButton_1 = new Button(parent, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LoadProductsDialog lpd = new LoadProductsDialog(parent.getShell());
				if(lpd.open()==0)
				{
					
				}
				listProducts();
			}
		});
		btnNewButton_1.setBounds(732, 102, 112, 25);
		btnNewButton_1.setText("Load Products");
		
		Button btnNewButton_2 = new Button(parent, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				listProducts();
			}
		});
		btnNewButton_2.setBounds(732, 133, 112, 25);
		btnNewButton_2.setText("Refresh");
		
		Button btnNewButton_3 = new Button(parent, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddSupplierDialog asd = new AddSupplierDialog(parent.getShell());
				if(asd.open()==0)
				{
					
				}
			}
		});
		btnNewButton_3.setBounds(732, 71, 112, 25);
		btnNewButton_3.setText("Insert New Supplier");
		
		Button btnNewButton_4 = new Button(parent, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!tv.getSelection().toString().equals("<empty selection>")){
					MessageDialog.openError(parent.getShell(), "Instruction", "Are you sure you want to delete the product : "+SessionSourceProvider.CURRENT_PRODUCT.getProductName()+" ?");
					ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
					Product p = SessionSourceProvider.CURRENT_PRODUCT;
					pDao.delete(p);
					listProducts();
				}
				else
				{
					MessageDialog.openError(parent.getShell(), "Instruction", "Please select a product from the table to delete it");
				}
			}
		});
		btnNewButton_4.setBounds(732, 40, 112, 25);
		btnNewButton_4.setText("Delete Product");

		//		TableColumn tblclmnNewColumn_8 = new TableColumn(table, SWT.NONE);
		//		tblclmnNewColumn_8.setWidth(100);
		//		tblclmnNewColumn_8.setText("Stock Status");
		//		tblclmnNewColumn_8.set
		//		TableViewerColumn tblclmnNewColumn_88 = new TableViewerColumn(tv, tblclmnNewColumn_8);
		//		
		//		tblclmnNewColumn_88.setLabelProvider( new ColumnLabelProvider() {
		//			public String getText(Object element) {
		//				try{
		//					if(element instanceof Product)
		//					{
		//						
		//						return (((Product)element).getImage());
		//					}
		//				}
		//				catch(Exception e)
		//				{
		//
		//				}
		//				return null;
		//			}
		//		});


		//tv.setLabelProvider(new GenericNameLabelProvider());
		tv.setContentProvider(new ArrayContentProvider()
		{


			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Product>)inputElement ) .toArray();
			}
		});


		tv.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Product ) {
						SessionSourceProvider.CURRENT_PRODUCT = (Product) structuredSelection.getFirstElement();
//						URI mailto;
//						try {
//							mailto = new URI("mailto:"+SessionSourceProvider.CURRENT_PRODUCT.getSupplierId().getEmail()+"?subject=Reorder%20"+SessionSourceProvider.CURRENT_PRODUCT.getSKU());
//							Desktop desktop = Desktop.getDesktop();
//							desktop.mail(mailto);
//						} catch (Exception e) {
//							
//							e.printStackTrace();
//						}
						
						//text.setText(SessionSourceProvider.CURRENT_CATEGORY.getCategoryName());
					}
				}

			}
		});
		
		tv.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				URI mailto;
				try {
					mailto = new URI("mailto:"+SessionSourceProvider.CURRENT_PRODUCT.getSupplierId().getEmail()+"?subject=Reorder%20"+SessionSourceProvider.CURRENT_PRODUCT.getSKU());
					Desktop desktop = Desktop.getDesktop();
					desktop.mail(mailto);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				
			}
		});

		//tv.setInput(pList);
		listProducts();


		getSite().getWorkbenchWindow().addPerspectiveListener( new IPerspectiveListener(){

			@Override
			public void perspectiveActivated(IWorkbenchPage page,
					IPerspectiveDescriptor perspective) {
				try{
				listProducts();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
//				System.out.println("trigered perspective");

			}

			@Override
			public void perspectiveChanged(IWorkbenchPage page,
					IPerspectiveDescriptor perspective, String changeId) {
			//	listProducts();

			}

			

		});


		PlatformUI.getWorkbench().addWindowListener(new IWindowListener(){
			//
			@Override
			public void windowActivated(IWorkbenchWindow window) {

				listProducts();
//				System.out.println("window is activated");
			}

			@Override
			public void windowDeactivated(IWorkbenchWindow window) {
				listProducts();
//				System.out.println("window is deactivated");

			}

			@Override
			public void windowClosed(IWorkbenchWindow window) {
				//listProducts();
//				System.out.println("window is closed");

			}

			@Override
			public void windowOpened(IWorkbenchWindow window) {
				listProducts();
//				System.out.println("window is opened");

			}

		}
				);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public  void listProducts()
	{
		ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
		List<Product> pList = pDao.getList(Product.class);
		//System.out.println("size of plist is " +pList.size());
		tv.setInput(pList);
		for(TableColumn tc :table.getColumns())
		{
			tc.pack();
		}
		setImage();
		
	}

	public   void setImage()
	{
		//System.out.println(" set image");
		TableItem [] tis = table.getItems();
		for(TableItem ti : tis)
		{

			if(ti.getData() instanceof Product){

				ti.setImage(ResourceManager.getPluginImage("com.marbleArchPaint.softwareEngineering",((Product)ti.getData()).getImage()));
				//System.out.println(((Product)ti.getData()).getImage());
			}



		}
	}
}
