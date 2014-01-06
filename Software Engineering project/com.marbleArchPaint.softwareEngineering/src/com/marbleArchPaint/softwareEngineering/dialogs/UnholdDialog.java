package com.marbleArchPaint.softwareEngineering.dialogs;

import java.util.List;


import general.Order;
//import general.Product;

import org.eclipse.jface.dialogs.Dialog;
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
import com.marbleArchPaint.softwareEngineering.SessionSourceProvider;
import com.marbleArchPaint.softwareEngineering.views.Pos;

import dao.DaoFactory;
import dao.OrderDao;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class UnholdDialog extends Dialog {
	private Table table;
	private TableViewer tv;
	protected ISelection jfaceSelection;
	protected IStructuredSelection structuredSelection;
	List <Order> pList;
	public UnholdDialog(Shell parentShell, List<Order> pList) {

		super(parentShell);
		this.pList = pList;


	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Unhold Dialog");
	}
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setLayout(null);

		tv = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tv.getTable();
		table.setBounds(10, 10, 643, 200);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnNewColumn =  new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setText("OrderDate");
		TableViewerColumn tblclmnNewColumnn = new TableViewerColumn(tv, tblclmnNewColumn);

		tblclmnNewColumn.setWidth(84);
		tblclmnNewColumnn.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Order)
				{
					return ((Order)element).getOrderDate().toString();
				}
				return null;
			}
		});

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE); 
		TableViewerColumn tblclmnNewColumn_11 = new TableViewerColumn(tv, tblclmnNewColumn_1);

		tblclmnNewColumn_1.setWidth(102);
		tblclmnNewColumn_1.setText("Sales Person");

		tblclmnNewColumn_11.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Order)
				{
					return ((Order)element).getSalesPerson().getUsername();
				}
				return null;
			}
		});

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE); 
		TableViewerColumn tblclmnNewColumn_22 = new TableViewerColumn(tv, tblclmnNewColumn_2);

		tblclmnNewColumn_2.setWidth(85);
		tblclmnNewColumn_2.setText("On Hold");
		tblclmnNewColumn_22.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Order)
				{
					return (Boolean.toString(((Order)element).isOnHold()));
				}
				return null;
			}
		});
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE); 

		TableViewerColumn tblclmnNewColumn_33 = new TableViewerColumn(tv, tblclmnNewColumn_3);
		tblclmnNewColumn_3.setWidth(82);
		tblclmnNewColumn_3.setText("Total Price");
		tblclmnNewColumn_33.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				try{
					if(element instanceof Order)
					{
						return Double.toString(((Order)element).getTotalPrice());
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
		tblclmnNewColumn_4.setText("Total Discount");
		tblclmnNewColumn_4.setWidth(84);
		tblclmnNewColumn_44.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Order)
					{
						return Double.toString(((Order)element).getTotalDiscount());
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
		tblclmnNewColumn_5.setText("OrderId");
		tblclmnNewColumn_55.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Order)
					{
						return ((Order)element).getOrderId();
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

		tblclmnNewColumn_6.setWidth(107);
		tblclmnNewColumn_6.setText("Customer");
		tblclmnNewColumn_66.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {
				try{
					if(element instanceof Order)
					{
						return ((Order)element).getCustomerId().getFirstName()+" "+((Order)element).getCustomerId().getLastName();
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
				return ((java.util.List<Order>)inputElement ) .toArray();
			}
		});


		tv.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Order ) {
						SessionSourceProvider.CURRENT_ORDER = (Order) structuredSelection.getFirstElement();
						SessionSourceProvider.CURRENT_CUSTOMER = SessionSourceProvider.CURRENT_ORDER.getCustomerId();
						
						try{
							Pos.lblNewLabel_14.setText(SessionSourceProvider.CURRENT_CUSTOMER.getFirstName()+" "+SessionSourceProvider.CURRENT_CUSTOMER.getLastName());
							}
							catch(NullPointerException e)
							{
								Pos.lblNewLabel_14.setText("");
							}
						//text.setText(SessionSourceProvider.CURRENT_CATEGORY.getCategoryName());
					}
				}

			}
		});
		tv.setInput(pList);

		return container;
	}

	protected void okPressed()  {
		if(SessionSourceProvider.CURRENT_ORDER!=null)
		{
			OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
			Order o = SessionSourceProvider.CURRENT_ORDER;
			o.setOnHold(false);
			oDao.update(o);
			SessionSourceProvider.OrderDetails_List = oDao.getListOfOrderDetails(SessionSourceProvider.CURRENT_ORDER);
			//Collections.sort(SessionSourceProvider.OrderDetails_List, new DateComparator());
			Pos.tv_1.setInput(SessionSourceProvider.OrderDetails_List);
		}
		else
		{
			Pos.table_1.removeAll();
		}
		super.okPressed();

	}
}
