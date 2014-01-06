package com.marbleArchPaint.softwareEngineering.dialogs;

import java.util.Date;
import java.util.List;


import general.Customer;
import general.GeneralFactory;
import general.Order;
import general.OrderDetails;
import general.Product;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
import dao.OrderDao;
import dao.OrderDetailsDao;
import dao.ProductDao;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class searchDialog extends Dialog {
	private Table table;
	private TableViewer tv;
	protected ISelection jfaceSelection;
	protected IStructuredSelection structuredSelection;
	List <Product> pList;
	public searchDialog(Shell parentShell, List<Product> pList) {

		super(parentShell);
		this.pList = pList;


	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Search Dialog");
	}
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setLayout(null);

		tv = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tv.getTable();
		table.setBounds(10, 10, 540, 200);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn =  new TableColumn(table, SWT.NONE);
		TableViewerColumn tblclmnNewColumnn = new TableViewerColumn(tv, tblclmnNewColumn);

		tblclmnNewColumn.setWidth(45);
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

		tblclmnNewColumn_1.setWidth(87);
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

		tblclmnNewColumn_2.setWidth(69);
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
		tblclmnNewColumn_4.setWidth(65);
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

		tblclmnNewColumn_6.setWidth(60);
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
		tblclmnNewColumn_7.setWidth(100);
		tblclmnNewColumn_7.setText("In Stock");
		tblclmnNewColumn_77.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Product)
					{
						return (Integer.toString(((Product)element).getUnitsInStock()));
					}
				}
				catch(Exception e)
				{

				}
				return null;
			}
		});

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
						//text.setText(SessionSourceProvider.CURRENT_CATEGORY.getCategoryName());
					}
				}

			}
		});
		tv.setInput(pList);

		return container;
	}

	protected void okPressed()  {
		Order o = GeneralFactory.eINSTANCE.createOrder();
		OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
		OrderDetails od = GeneralFactory.eINSTANCE.createOrderDetails();
		OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
		ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
		if(SessionSourceProvider.CURRENT_ORDER!=null){
			if(oDao.findOrderDetails(SessionSourceProvider.CURRENT_ORDER, SessionSourceProvider.CURRENT_PRODUCT))
			{
				MessageDialog.openError(getParentShell(), "instruction", "You already have this item in your order");
				super.okPressed();
				return;
			}
			od.setOrderId(SessionSourceProvider.CURRENT_ORDER);
			
		}
		else{
			
			o.setCompleted(false);
			SessionSourceProvider.CURRENT_CUSTOMER = null;
			o.setCustomerId(null);
			o.setDeleted(false);
			o.setOrderDate(new Date());
			o.setPaid(false);
			o.setOnHold(false);
			o.setSalesPerson(SessionSourceProvider.USER);
			oDao.create(o);

			SessionSourceProvider.CURRENT_ORDER = o;
			od.setOrderId(SessionSourceProvider.CURRENT_ORDER);
			System.err.println("I did set order id");
		}
		od.setProductId(SessionSourceProvider.CURRENT_PRODUCT);
		
		od.setPrice(SessionSourceProvider.CURRENT_PRODUCT.getUnitPrice()/SessionSourceProvider.CURRENT_PRODUCT.getQuantityPerUnit());
		System.err.println("price is "+SessionSourceProvider.CURRENT_PRODUCT.getUnitPrice()/SessionSourceProvider.CURRENT_PRODUCT.getQuantityPerUnit());
		try
		{
			od.setDiscount(SessionSourceProvider.CURRENT_PRODUCT.getDiscount());
			System.err.println("Discount  is "+SessionSourceProvider.CURRENT_PRODUCT.getDiscount());
			
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		od.setQuantity(1);
		od.setTotal(od.getPrice()*od.getQuantity());
		
		
		//od.setPrice(SessionSourceProvider.CURRENT_PRODUCT.getUnitPrice());
		//od.setQuantity(1);
		//od.setTotal(SessionSourceProvider.CURRENT_PRODUCT.getUnitPrice());
		od.setColor(SessionSourceProvider.CURRENT_PRODUCT.getColor());
		od.setDate(new Date());
		try{
			od.setSize(Double.parseDouble(SessionSourceProvider.CURRENT_PRODUCT.getSize()));	
		}
		catch(Exception e){

		}

		odDao.create(od);
//		Product p =SessionSourceProvider.CURRENT_PRODUCT;
//		p.setTotalQuantity(p.getTotalQuantity()-1);
//		pDao.update(p);
//		if(p.getTotalQuantity()<=0)
//		{
//			MessageDialog.openWarning(getShell(), "Warning", "The product : "+p.getProductName()+" is running out, please re-order it from supplier : "+p.getSupplierId().getCompanyName());
//		}
		SessionSourceProvider.CURRENT_ORDERDETAILS = od;

		//		refreshOrderView();

		//		clearFields();
		super.okPressed();

	}
}
