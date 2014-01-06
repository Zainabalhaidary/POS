package com.marbleArchPaint.softwareEngineering.views;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.marbleArchPaint.softwareEngineering.listComparators.DateComparator;
import com.marbleArchPaint.softwareEngineering.views.SelectionProviderWrapper;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import general.OrderDetails;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.SWT;

import com.marbleArchPaint.softwareEngineering.SessionSourceProvider;
import dao.DaoFactory;
import dao.OrderDetailsDao;
import general.Order;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Tree;
//import org.eclipse.swt.widgets.List;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

import com.marbleArchPaint.softwareEngineering.LabelProvider.GenericNameLabelProvider;

import dao.OrderDao;
import edu.emory.mathcs.backport.java.util.Collections;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class Orders extends ViewPart {

	SelectionProviderWrapper selectionProviderWrapper;
	protected Object jfaceSelection;
	protected IStructuredSelection structuredSelection;
	ListViewer lv;
	TreeViewer tv;
	private EContentAdapter adapter;
	Tree tree;
	public Composite parent;
	public Orders() {
		adapter = new EContentAdapter () {
			public void notifyChanged ( Notification not) {
				super.notifyChanged(not);
				lv.refresh();
				tv.refresh();
			}
		};
	}

	@Override
	public void createPartControl(final Composite parent) {
		this.parent = parent;
		parent.setLayout(new GridLayout(1, false));
		
		Label lblOrdersList = new Label(parent, SWT.NONE);
		lblOrdersList.setText("          Orders List");

		lv = new ListViewer(parent, SWT.BORDER | SWT.V_SCROLL);
		org.eclipse.swt.widgets.List list = lv.getList();
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_list.heightHint = 182;
		gd_list.widthHint = 334;
		list.setLayoutData(gd_list);


		lv.setLabelProvider(new GenericNameLabelProvider());
		lv.setContentProvider(new ArrayContentProvider()
		{
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Order>)inputElement ) .toArray();
			}
		});


		lv.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Order ) {
						//getSite().setSelectionProvider(lv);
						//selectionProviderWrapper.setSelectionProvider(getSite().getSelectionProvider());
						SessionSourceProvider.CURRENT_ORDER = (Order) structuredSelection.getFirstElement();
						//						SessionSourceProvider.CURRENT_ORDER.eAdapters().add(adapter);
						tv.setInput(SessionSourceProvider.CURRENT_ORDER);

						SessionSourceProvider.CURRENT_ORDER = null;
					}
				}

			}
		});

		selectionProviderWrapper = new SelectionProviderWrapper();

		getSite().setSelectionProvider( selectionProviderWrapper);

		list.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("orders should be detetcted");
				selectionProviderWrapper.setSelectionProvider(lv);
			}
		});

		//		getSite().setSelectionProvider(new ISelectionProvider() {
		//			
		//			@Override
		//			public void setSelection(ISelection selection) {
		//				// TODO Auto-generated method stub
		//				
		//			}
		//			
		//			@Override
		//			public void removeSelectionChangedListener(
		//					ISelectionChangedListener listener) {
		//				// TODO Auto-generated method stub
		//				
		//			}
		//			
		//			@Override
		//			public ISelection getSelection() {
		//				// TODO Auto-generated method stub
		//				return null;
		//			}
		//			
		//			@Override
		//			public void addSelectionChangedListener(ISelectionChangedListener listener) {
		//				// TODO Auto-generated method stub
		//				
		//			}
		//		};

		//Order o = GeneralFactory.eINSTANCE.createOrder();
		OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
		java.util.List <Order> oList = oDao.getList(Order.class);
		lv.setInput(oList);
		
		Label lblItemsWithinThe = new Label(parent, SWT.NONE);
		lblItemsWithinThe.setText("           Items within the Order");

		tv = new TreeViewer(parent, SWT.BORDER | SWT.V_SCROLL);
		tree = tv.getTree();
		GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_tree.widthHint = 358;
		gd_tree.heightHint = 239;
		tree.setLayoutData(gd_tree);

		Button btnCreateReport = new Button(parent, SWT.NONE);
		btnCreateReport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//				CreateReportDialog crd = new CreateReportDialog(parent.getShell());
				//				if(crd.open()==0)
				//				{
				//					
				//				}
				HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFSheet sheet = workbook.createSheet("Orders sheet");
				CreationHelper createHelper = workbook.getCreationHelper();
				OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
				java.util.List<Order> oList = oDao.getList(Order.class);
				int rownum=0;
				int cellnum=0;
				
				for (Order o :oList) {
					
					HSSFRow row = sheet.createRow(rownum++);



					CellStyle cellStyle = workbook.createCellStyle();
					Font font = workbook.createFont();
					font.setBoldweight(Font.BOLDWEIGHT_BOLD);
					cellStyle.setFont(font);
					cellStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					cellStyle.setFillPattern(CellStyle.FINE_DOTS);
					//cellStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
					//cellStyle.setFont(font); 

					//row.setRowStyle(cellStyle);
					HSSFCell cell = row.createCell(cellnum++);
					cell.setCellValue("Order Id");
					cell.setCellStyle(cellStyle);
					
					cell = row.createCell(cellnum++);
					cell.setCellValue("OrderDate");
					cell.setCellStyle(cellStyle);
					

					cell = row.createCell(cellnum++);
					try{
						cell.setCellValue("Payment Date");
						cell.setCellStyle(cellStyle);
						
					}catch(Exception eee)
					{

					}

					cell = row.createCell(cellnum++);
					cell.setCellValue("Total Price");
					cell.setCellStyle(cellStyle);
					

					cell = row.createCell(cellnum++);
					cell.setCellValue("Total Discount");
					cell.setCellStyle(cellStyle);
					

					cell = row.createCell(cellnum++);
					cell.setCellValue("Sales Person");
					cell.setCellStyle(cellStyle);
					

					cell = row.createCell(cellnum++);
					cell.setCellValue("Customer");
					cell.setCellStyle(cellStyle);
					

					cell = row.createCell(cellnum++);
					cell.setCellValue("Shipper");
					cell.setCellStyle(cellStyle);
					


					cellnum =0;
					
					///////////////////////////////////////////
					row = sheet.createRow(rownum++);


					cell = row.createCell(cellnum++);
					cell.setCellValue(o.getOrderId());

					cell = row.createCell(cellnum++);
					//Column col = sheet.get
					DateFormat df =new SimpleDateFormat("mm/dd/yyyy");
					//cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					cellStyle = workbook.createCellStyle();
					cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("mm/dd/yyyy hh:mm"));
					cell.setCellStyle(cellStyle);
					cell.setCellValue(o.getOrderDate());
					
					//System.out.println(o.getOrderDate());
					cell = row.createCell(cellnum++);
					try{
						//cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						cell.setCellStyle(cellStyle);
						cell.setCellValue(o.getPaymentDate());
					}catch(Exception eee)
					{

					}
					cell = row.createCell(cellnum++);
					cell.setCellValue(o.getTotalPrice());

					cell = row.createCell(cellnum++);
					cell.setCellValue(o.getTotalDiscount());

					cell = row.createCell(cellnum++);
					cell.setCellValue(o.getSalesPerson().getUsername());

					cell = row.createCell(cellnum++);
					try
					{
						cell.setCellValue(o.getCustomerId().getFirstName()+" "+o.getCustomerId().getLastName());
					}catch(Exception eee)
					{

					}

					cell = row.createCell(cellnum++);
					try
					{
						cell.setCellValue(o.getShipperId().getCompanyName());
					}catch(Exception eee)
					{

					}
					cellnum =1;
					java.util.List <OrderDetails> odList = oDao.getListOfOrderDetails(o);
					
					
					row = sheet.createRow(rownum++);
					cellStyle = workbook.createCellStyle();
					font = workbook.createFont();
					font.setBoldweight(Font.BOLDWEIGHT_BOLD);
					cellStyle.setFont(font);
					cellStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					cellStyle.setFillPattern(CellStyle.FINE_DOTS);
					//cellStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
					//cellStyle.setFont(font); 

					//row.setRowStyle(cellStyle);
					cell = row.createCell(cellnum++);
					cell.setCellValue("OrderDetail Id");
					cell.setCellStyle(cellStyle);
					
					
					cell = row.createCell(cellnum++);
					cell.setCellValue("Product Name");
					cell.setCellStyle(cellStyle);
					
					cell = row.createCell(cellnum++);
					cell.setCellValue("OrderDetail Date");
					cell.setCellStyle(cellStyle);
					
					
					cell = row.createCell(cellnum++);
					cell.setCellValue("Quantity");
					cell.setCellStyle(cellStyle);

					
					cell = row.createCell(cellnum++);
					cell.setCellValue("Price");
					cell.setCellStyle(cellStyle);
					
					cell = row.createCell(cellnum++);
					cell.setCellValue("Discount");
					cell.setCellStyle(cellStyle);
					
					cell = row.createCell(cellnum++);
					cell.setCellValue("Total");
					cell.setCellStyle(cellStyle);
					
					
					for(OrderDetails od : odList)
					{
						
						cellnum =1;
						row = sheet.createRow(rownum++);
						
						cell = row.createCell(cellnum++);
						cell.setCellValue(od.getOrderDetailId());
						
						cell = row.createCell(cellnum++);
						cell.setCellValue(od.getProductId().getProductName());
						
						cell = row.createCell(cellnum++);
						cell.setCellValue(od.getDate());
						
						cell = row.createCell(cellnum++);
						cell.setCellValue(od.getQuantity());
						
						cell = row.createCell(cellnum++);
						cell.setCellValue(od.getPrice());
						
						cell = row.createCell(cellnum++);
						cell.setCellValue(od.getDiscount());
						
						cell = row.createCell(cellnum++);
						cell.setCellValue(od.getTotal());
						
						
						
						
						
						
						
						
						cellnum=0;
					}
					
				}
				for(int i = 0;i<20;i++)
				{
					sheet.autoSizeColumn(i);
				}
				try {
					File f = new File("OrdersReport.xls");
					if(f.exists())
						f.delete();
					f.createNewFile();
					FileOutputStream out = new FileOutputStream(f);
					workbook.write(out);
					out.close();
					System.out.println("Excel written successfully..");

					 try{    
				          Runtime.getRuntime().exec("cmd /c start OrdersReport.xls");    
				          }catch(IOException  ioe){  
				              ioe.printStackTrace();  
				          }    
					 
				} catch (Exception ee) {
					ee.printStackTrace();

				}
				
			}
		});
		
		
		GridData gd_btnCreateReport = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnCreateReport.widthHint = 154;
		btnCreateReport.setLayoutData(gd_btnCreateReport);
		btnCreateReport.setText("Create Report");
		// TODO Auto-generated method stub

		tv.setLabelProvider(new GenericNameLabelProvider());
		tv.setContentProvider(new ITreeContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean hasChildren(Object element) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Object getParent(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				if ( inputElement instanceof Order ) {
					OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
					java.util.List<OrderDetails> odList = odDao.getByQuery("from OrderDetails where orderId='"+SessionSourceProvider.CURRENT_ORDER.getOrderId()+"'");
					return odList.toArray();
				}
				return null;
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				// TODO Auto-generated method stub
				return null;
			}
		});

		tv.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof OrderDetails ) {
						getSite().setSelectionProvider(tv);
						SessionSourceProvider.CURRENT_ORDERDETAILS = (OrderDetails) structuredSelection.getFirstElement();
						//						SessionSourceProvider.CURRENT_ORDERDETAILS.eAdapters().add(adapter);
						//tv.setInput(SessionSourceProvider.CURRENT_ORDER);
						SessionSourceProvider.CURRENT_ORDERDETAILS = null;

					}
				}

			}
		});


		tree.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("orderDetails should be detetcted");
				selectionProviderWrapper.setSelectionProvider(tv);
			}
		});



		getSite().getWorkbenchWindow().addPerspectiveListener( new IPerspectiveListener(){

			@Override
			public void perspectiveActivated(IWorkbenchPage page,
					IPerspectiveDescriptor perspective) {
				try{
					listOrders();
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
				//				SessionSourceProvider.CURRENT_ORDER = null;
				//				SessionSourceProvider.CURRENT_ORDERDETAILS=null;
				//				System.out.println("prespective changed");


			}



		});


		PlatformUI.getWorkbench().addWindowListener(new IWindowListener(){
			//
			@Override
			public void windowActivated(IWorkbenchWindow window) {

				listOrders();
				//				System.out.println("window is activated");
			}

			@Override
			public void windowDeactivated(IWorkbenchWindow window) {
				listOrders();
				//				SessionSourceProvider.CURRENT_ORDER = null;
				//				SessionSourceProvider.CURRENT_ORDERDETAILS=null;
				//				System.out.println("window is deactivated");

			}

			@Override
			public void windowClosed(IWorkbenchWindow window) {
				//listProducts();
				//				SessionSourceProvider.CURRENT_ORDER = null;
				//				SessionSourceProvider.CURRENT_ORDERDETAILS=null;
				//				System.out.println("window is closed");

			}

			@Override
			public void windowOpened(IWorkbenchWindow window) {
				listOrders();
				//				System.out.println("window is opened");

			}

		}
				);
	}


	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}


	public  void listOrders()
	{
		OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
		java.util.List<Order> oList = oDao.getList(Order.class);
		//System.out.println("size of olist is " +oList.size());
		Collections.sort(oList, new DateComparator());
		lv.setInput(oList);


	}

	//	public  void listOrderDetails()
	//	{
	//		OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
	//		java.util.List<OrderDetails> odList = odDao.getByQuery("from OrderDetails where orderId='"+SessionSourceProvider.CURRENT_ORDER.getOrderId()+"'");
	//		//System.out.println("size of olist is " +oList.size());
	//		tv.setInput(odList);
	//
	//
	//	}
}
