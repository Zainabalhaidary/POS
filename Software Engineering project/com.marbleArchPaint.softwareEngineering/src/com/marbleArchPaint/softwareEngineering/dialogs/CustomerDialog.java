package com.marbleArchPaint.softwareEngineering.dialogs;

import java.util.Date;
import java.util.List;


import general.Customer;
import general.GeneralFactory;
import general.Order;
import general.OrderDetails;
//import general.Order;
//import general.OrderDetails;
//import general.Product;

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

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CustomerDialog extends Dialog {
	private Table table;
	private TableViewer tv;
	protected ISelection jfaceSelection;
	protected IStructuredSelection structuredSelection;
	List <Customer> pList;
	public CustomerDialog(Shell parentShell, List<Customer> pList) {

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
		table.setBounds(10, 10, 695, 227);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn =  new TableColumn(table, SWT.NONE);
		TableViewerColumn tblclmnNewColumnn = new TableViewerColumn(tv, tblclmnNewColumn);

		tblclmnNewColumn.setWidth(45);
		tblclmnNewColumn.setText("Id");
		tblclmnNewColumnn.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Customer)
				{
					return ((Customer)element).getCustomerId();
				}
				return null;
			}
		});

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE); 
		TableViewerColumn tblclmnNewColumn_11 = new TableViewerColumn(tv, tblclmnNewColumn_1);

		tblclmnNewColumn_1.setWidth(87);
		tblclmnNewColumn_1.setText("Firstname");

		tblclmnNewColumn_11.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Customer)
				{
					return ((Customer)element).getFirstName();
				}
				return null;
			}
		});

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE); 
		TableViewerColumn tblclmnNewColumn_22 = new TableViewerColumn(tv, tblclmnNewColumn_2);

		tblclmnNewColumn_2.setWidth(78);
		tblclmnNewColumn_2.setText("Lastname");
		tblclmnNewColumn_22.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Customer)
				{
					return ((Customer)element).getLastName();
				}
				return null;
			}
		});
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE); 

		TableViewerColumn tblclmnNewColumn_33 = new TableViewerColumn(tv, tblclmnNewColumn_3);
		tblclmnNewColumn_3.setWidth(82);
		tblclmnNewColumn_3.setText("Address");
		tblclmnNewColumn_33.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				try{
					if(element instanceof Customer)
					{
						return ((Customer)element).getAddress();
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
		tblclmnNewColumn_4.setText("Shipping Address");
		tblclmnNewColumn_4.setWidth(129);
		tblclmnNewColumn_44.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Customer)
					{
						return ((Customer)element).getShippingAddress();
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

		tblclmnNewColumn_5.setWidth(109);
		tblclmnNewColumn_5.setText("Billing Address");
		tblclmnNewColumn_55.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Customer)
					{
						return ((Customer)element).getBillingAddress();
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
		tblclmnNewColumn_6.setText("Phone");
		tblclmnNewColumn_66.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Customer)
					{
						return ((Customer)element).getPhone();
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
		tblclmnNewColumn_7.setText("Email");
		tblclmnNewColumn_77.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Customer)
					{
						return ((Customer)element).getEmail();
					}
					//return null;
				}
				catch(Exception e)
				{

				}
				return null;
			}
		});

		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddCustomerDialog acd = new AddCustomerDialog(getParentShell());
				if(acd.open()==0)
				{

				}
				CustomerDao cDao = DaoFactory.eINSTANCE.createCustomerDao();
				List <Customer> cList =cDao.getList(Customer.class);
				tv.setInput(cList);
				//tv.refresh();
			}
		});
		btnNewButton.setBounds(589, 243, 116, 25);
		btnNewButton.setText("Add New Customer");
		
		Button btnNewButton_1 = new Button(container, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(SessionSourceProvider.CURRENT_CUSTOMER!= null)
				{
					boolean m = MessageDialog.openQuestion(getParentShell(), "Warning", "Are you sure you want to delete the selected customer");
					if(m)
					{
						Customer c = SessionSourceProvider.CURRENT_CUSTOMER;
						CustomerDao cDao = DaoFactory.eINSTANCE.createCustomerDao();
						cDao.delete(c);
						
						List <Customer> cList =cDao.getList(Customer.class);
						tv.setInput(cList);
					}
					
				}
			}
		});
		btnNewButton_1.setBounds(465, 243, 116, 25);
		btnNewButton_1.setText("Delete Customer");

		//tv.setLabelProvider(new GenericNameLabelProvider());
		tv.setContentProvider(new ArrayContentProvider()
		{


			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Customer>)inputElement ) .toArray();
			}
		});


		tv.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Customer) {
						SessionSourceProvider.CURRENT_CUSTOMER = (Customer) structuredSelection.getFirstElement();
						//text.setText(SessionSourceProvider.CURRENT_CATEGORY.getCategoryName());
					}
				}

			}
		});
		tv.setInput(pList);

		return container;
	}

	protected void okPressed()  {
		//		OrderDetails od = GeneralFactory.eINSTANCE.createOrderDetails();
		//		OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
		OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
		if(SessionSourceProvider.CURRENT_ORDER!=null){
			Order o = SessionSourceProvider.CURRENT_ORDER;
			o.setCustomerId(SessionSourceProvider.CURRENT_CUSTOMER);
			try{
				Pos.lblNewLabel_14.setText(SessionSourceProvider.CURRENT_CUSTOMER.getFirstName()+" "+SessionSourceProvider.CURRENT_CUSTOMER.getLastName());
			}
			catch(NullPointerException e)
			{
				Pos.lblNewLabel_14.setText("");
			}
			oDao.update(o);
		}
		else{
			MessageDialog.openError(getParentShell(), "Instruction", "currently there is no running order to assign this customer to it");
			return;
		}

		super.okPressed();

	}
}
