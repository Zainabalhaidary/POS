package com.marbleArchPaint.softwareEngineering.views;

import general.Category;
import org.eclipse.ui.PlatformUI;
import general.Customer;
import general.GeneralFactory;
import general.Order;
import general.OrderDetails;
import general.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.eclipse.ui.ISharedImages;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import com.marbleArchPaint.softwareEngineering.SessionSourceProvider;
import com.marbleArchPaint.softwareEngineering.LabelProvider.GenericNameLabelProvider;
import com.marbleArchPaint.softwareEngineering.dialogs.AddCategoryDialog;
import com.marbleArchPaint.softwareEngineering.dialogs.CustomerDialog;
import com.marbleArchPaint.softwareEngineering.dialogs.UnholdDialog;
import com.marbleArchPaint.softwareEngineering.dialogs.searchDialog;
import com.marbleArchPaint.softwareEngineering.listComparators.DateComparator;
import com.marbleArchPaint.softwareEngineering.listComparators.stringComparator;

import dao.CategoryDao;
import dao.CustomerDao;
import dao.DaoFactory;
import dao.OrderDao;
import dao.OrderDetailsDao;
import dao.ProductDao;
import edu.emory.mathcs.backport.java.util.Collections;
//import org.eclipse.emf.common.notify.impl.BasicNotifierImpl.EObservableAdapterList.Listener;




public class Pos extends ViewPart implements Listener {
	String searchValue = "";
	Combo c;
	public static Label lblNewLabel_14;
	private ISelection jfaceSelection;
	private IStructuredSelection structuredSelection;
	private Text text;
	private Text text_1;
	public static TableViewer tv;
	private Table table;
	public static TableViewer tv_1;
	public static Table table_1;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	String price = "";
	private Text text_8;
	CategoryDao cDao ;
	ComboViewer combo;
	private Text searchText;


	public Pos() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void createPartControl(final Composite parent) {
		parent.setLayout(new GridLayout(12, false));
		cDao = DaoFactory.eINSTANCE.createCategoryDao();
		Composite composite_2 = new Composite(parent, SWT.NONE);
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, true, true, 10, 1);
		gd_composite_2.widthHint = 253;
		composite_2.setLayoutData(gd_composite_2);

		Label lblNewLabel_2 = new Label(composite_2, SWT.NONE);
		lblNewLabel_2.setText(SessionSourceProvider.USER.getUsername());
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_2.setBounds(83, 1, 125, 15);

		Composite composite_5 = new Composite(composite_2, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(255, 239, 213));
		composite_5.setBounds(10, 22, 405, 54);
		Label lblCode = new Label(composite_5, SWT.NONE);
		lblCode.setBackground(SWTResourceManager.getColor(255, 239, 213));
		lblCode.setBounds(10, 3, 36, 15);
		lblCode.setText("Code");

		Button btnNewButton_5 = new Button(composite_5, SWT.NONE);
		btnNewButton_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
				List <Product> pList = pDao.getBySKU(searchText.getText());
				//System.out.println("result size is "+pList.size());
				searchDialog sd = new searchDialog(parent.getShell(), pList);
				if(sd.open()==0)
				{


				}
				searchText.setText("");
				c.removeAll();
				OS.SendMessage(c.handle, OS.CB_SHOWDROPDOWN, false ? 1 : 0, 0);
				refreshOrderView();
				calculateTotal();
				clearFields();
			}
		});

		btnNewButton_5.setBounds(343, 0, 62, 42);
		btnNewButton_5.setText("Search");

		searchText = new Text(composite_5, SWT.BORDER);
		searchText.setBounds(52, 3, 285, 21);


		combo = new ComboViewer(composite_5, SWT.DROP_DOWN);
		c = combo.getCombo();
		c.setBounds(52, 27, 285, 23);
		c.addListener(SWT.Modify, this);
		combo.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				System.out.println("I entered the listener once");
				Order o = GeneralFactory.eINSTANCE.createOrder();
				OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;

				if ( !structuredSelection.isEmpty()) {

					if ( structuredSelection.getFirstElement() instanceof Product) {

						SessionSourceProvider.CURRENT_PRODUCT = (Product) structuredSelection.getFirstElement();


						OrderDetails od = GeneralFactory.eINSTANCE.createOrderDetails();
						OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
						if(SessionSourceProvider.CURRENT_ORDER!=null){
							if(oDao.findOrderDetails(SessionSourceProvider.CURRENT_ORDER, SessionSourceProvider.CURRENT_PRODUCT))
							{
								MessageDialog.openError(parent.getShell(), "instruction", "You already have this item in your order");


							}
							else
							{
								od.setOrderId(SessionSourceProvider.CURRENT_ORDER);
								od.setProductId(SessionSourceProvider.CURRENT_PRODUCT);
								//								od.setPrice((p.getUnitPrice()/p.getQuantityPerUnit()));
								//								try
								//								{
								//									od.setDiscount(p.getDiscount());
								//								}
								//								catch(Exception ee)
								//								{
								//									
								//								}
								od.setPrice(SessionSourceProvider.CURRENT_PRODUCT.getUnitPrice()/SessionSourceProvider.CURRENT_PRODUCT.getQuantityPerUnit());
								//								System.err.println("price is "+SessionSourceProvider.CURRENT_PRODUCT.getUnitPrice()/SessionSourceProvider.CURRENT_PRODUCT.getQuantityPerUnit());
								try
								{
									od.setDiscount(SessionSourceProvider.CURRENT_PRODUCT.getDiscount());
									//									System.err.println("Discount  is "+SessionSourceProvider.CURRENT_PRODUCT.getDiscount());

								}
								catch(Exception ee)
								{
									ee.printStackTrace();
								}
								od.setQuantity(1);
								od.setTotal(od.getPrice()*od.getQuantity());
								od.setColor(SessionSourceProvider.CURRENT_PRODUCT.getColor());
								od.setDate(new Date());
								try{
									od.setSize(Double.parseDouble(SessionSourceProvider.CURRENT_PRODUCT.getSize()));	
								}
								catch(Exception e){

								}

								odDao.create(od);
								SessionSourceProvider.CURRENT_ORDERDETAILS = od;

								clearOrderDetailsGroup();
								clearFields();
								refreshOrderView();
								calculateTotal();
								searchText.setText("");
								c.removeAll();
								OS.SendMessage(c.handle, OS.CB_SHOWDROPDOWN, false ? 1 : 0, 0);
							}

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
							od.setProductId(SessionSourceProvider.CURRENT_PRODUCT);
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
							SessionSourceProvider.CURRENT_ORDERDETAILS = od;

							clearOrderDetailsGroup();
							clearFields();
							refreshOrderView();
							calculateTotal();
							searchText.setText("");
							c.removeAll();
							OS.SendMessage(c.handle, OS.CB_SHOWDROPDOWN, false ? 1 : 0, 0);
						}


					}}}});

		c.addKeyListener(new KeyAdapter() { 
			@Override 
			public void keyPressed ( KeyEvent e) { 
				if (e.keyCode ==SWT.CR ) { 
					System.out.println("ENTER pressed"); 
					//buttonPressed(0);

				} 
			}} );


		c.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				c.removeAll();
				OS.SendMessage(c.handle, OS.CB_SHOWDROPDOWN, false ? 1 : 0, 0);


			}

			@Override
			public void focusGained(FocusEvent e) {
				//				try
				//				{
				////					ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
				////					List <Product>  plist = pDao.getBySKU(searchText.getText());
				////					System.out.println("list of search is updated");
				////					combo.setInput(plist);
				////					OS.SendMessage(c.handle, OS.CB_SHOWDROPDOWN, true ? 1 : 0, 0);
				//
				//				}
				//				catch(Exception ee)
				//				{
				//					ee.printStackTrace();
				//				}

			}
		});

		searchText.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				try
				{

					//searchValue = searchValue + c.getText();
					//c.setText(searchValue);

					final ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
					Display.getDefault().asyncExec(new Runnable() {

						@Override
						public void run() {
							try
							{
								List <Product>  plist = pDao.getBySKU(searchText.getText());
								//System.out.println("list of search is updated");
								combo.setInput(plist);
								OS.SendMessage(c.handle, OS.CB_SHOWDROPDOWN, true ? 1 : 0, 0);
							}
							catch(Exception e)
							{
								c.removeAll();
								OS.SendMessage(c.handle, OS.CB_SHOWDROPDOWN, false ? 1 : 0, 0);
							}
						}
					});




				}
				catch(Exception ee)
				{
					ee.printStackTrace();
					c.removeAll();
					OS.SendMessage(c.handle, OS.CB_SHOWDROPDOWN, false ? 1 : 0, 0);
					System.out.println("Im in the catch");
				}
			}

		});


		combo.setLabelProvider(new GenericNameLabelProvider());

		combo.setContentProvider(new ArrayContentProvider() {


			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<String>)inputElement ) .toArray();
			}
		});
		tv_1 = new TableViewer(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		tv_1.setContentProvider(new ArrayContentProvider(){


			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<OrderDetails>)inputElement ) .toArray();
			}
		});
		tv_1.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof OrderDetails ) {
						SessionSourceProvider.CURRENT_ORDERDETAILS = (OrderDetails) structuredSelection.getFirstElement();

						calculateTotal();
						//text.setText(SessionSourceProvider.CURRENT_CATEGORY.getCategoryName());
					}
				}

			}
		});


		table_1 = tv_1.getTable();
		table_1.setBounds(10, 75, 405, 186);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		TableColumn tblclmnSku = new TableColumn(table_1, SWT.NONE);
		tblclmnSku.setWidth(47);
		tblclmnSku.setText("SKU");
		TableViewerColumn tvcsku  = new TableViewerColumn(tv_1, tblclmnSku);
		TableColumn tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);
		tvcsku.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof OrderDetails)
				{
					OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
					Product p = odDao.getById(((OrderDetails)element).getProductId());
					return (p.getSKU());
				}
				return null;
			}
		});
		tblclmnNewColumn.setWidth(81);
		tblclmnNewColumn.setText("Description");
		TableViewerColumn tvcd  = new TableViewerColumn(tv_1, tblclmnNewColumn);
		tvcd.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof OrderDetails)
				{
					OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
					Product p = odDao.getById(((OrderDetails)element).getProductId());
					return (p.getProductName());
				}
				return null;
			}
		});

		TableColumn tblclmnNewColumn_1 = new TableColumn(table_1, SWT.NONE);
		TableViewerColumn tvcq  = new TableViewerColumn(tv_1, tblclmnNewColumn_1);
		tblclmnNewColumn_1.setWidth(38);
		tblclmnNewColumn_1.setText("Qty");

		tvcq.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof OrderDetails)
				{

					return (Integer.toString(((OrderDetails)element).getQuantity()));
				}
				return null;
			}
		});



		TableColumn tblclmnNewColumn_2 = new TableColumn(table_1, SWT.NONE);
		TableViewerColumn tvcp  = new TableViewerColumn(tv_1, tblclmnNewColumn_2);
		tblclmnNewColumn_2.setText("Price");
		tblclmnNewColumn_2.setWidth(80);
		tvcp.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof OrderDetails)
				{

					return (Double.toString(((OrderDetails)element).getPrice()));
				}
				return null;
			}
		});

		TableColumn tblclmnNewColumn_3 = new TableColumn(table_1, SWT.NONE);
		TableViewerColumn tvcds  = new TableViewerColumn(tv_1, tblclmnNewColumn_3);
		tblclmnNewColumn_3.setWidth(49);
		tblclmnNewColumn_3.setText("Disc");
		tvcds.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof OrderDetails)
				{

					return (Double.toString(((OrderDetails)element).getDiscount()));
				}
				return null;
			}
		});

		tvcds.setEditingSupport(new EditingSupport(tv_1) {

			@Override
			protected void setValue(Object element, Object value) {

				if(value instanceof String )
				{
					try{
					if((Double.parseDouble((String) value)) >=0.0 &&(Double.parseDouble((String) value)<0.9 )){
						if(element instanceof OrderDetails)
						{
							try
							{
								System.out.println("Im an OrderDetails being saved");
								OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
								OrderDetails od = GeneralFactory.eINSTANCE.createOrderDetails();
								od = SessionSourceProvider.CURRENT_ORDERDETAILS;

								od.setDiscount(Double.parseDouble((String) value));
								od.setTotal(od.getPrice()*od.getQuantity()- od.getDiscount()*od.getPrice()*od.getQuantity());

								odDao.update(od);
								refreshOrderView();
								calculateTotal();
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
					}
					else
					{
						MessageDialog.openWarning(parent.getShell(), "Invalid discount", "the discount value that you hav entered in invalid");
					}
					}catch(Exception ee){
						ee.printStackTrace();
					}
				}
			}

			@Override
			protected Object getValue(Object element) {

				return(element == null ? " " : Double.toString(((OrderDetails)element).getDiscount()));
				//return ((OrderDetails)element).getQuantity();
			}

			@Override
			protected CellEditor getCellEditor(Object element) {

				return new TextCellEditor(tv_1.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {

				return true;
			}


		});


		TableColumn tblclmnNewColumn_4 = new TableColumn(table_1, SWT.NONE);
		TableViewerColumn tvctp  = new TableViewerColumn(tv_1, tblclmnNewColumn_4);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("Total Price");
		tvctp.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof OrderDetails)
				{

					return (Double.toString(((OrderDetails)element).getTotal()));
				}
				return null;
			}
		});


		tvcq.setEditingSupport(new EditingSupport(tv_1) {

			@Override
			protected void setValue(Object element, Object value) {

				if(value instanceof String )
				{
					System.out.println("Im an OrderDetails being saved");
					OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
					OrderDetails od = GeneralFactory.eINSTANCE.createOrderDetails();
					od = SessionSourceProvider.CURRENT_ORDERDETAILS;
					try{
						if((Integer.parseInt((String) value))>0 &&(Integer.parseInt((String) value))<od.getProductId().getTotalQuantity()){
							if(element instanceof OrderDetails)
							{
								try
								{


									od.setQuantity((Integer.parseInt((String) value)));
									od.setTotal(od.getPrice()*(Integer.parseInt((String) value))- od.getDiscount()*(od.getPrice()*(Integer.parseInt((String) value))));

									odDao.update(od);
									refreshOrderView();
									calculateTotal();
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
							}
						}
						else
						{
							MessageDialog.openWarning(parent.getShell(), "Invalid value", "This quantity value is invalid");
						}
					}catch(Exception ee){
						ee.printStackTrace();
					}
				}	

			}

			@Override
			protected Object getValue(Object element) {

				return(element == null ? " " : Integer.toString(((OrderDetails)element).getQuantity()));
				//return ((OrderDetails)element).getQuantity();
			}

			@Override
			protected CellEditor getCellEditor(Object element) {

				return new TextCellEditor(tv_1.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {

				return true;
			}


		});



		Composite composite_6 = new Composite(composite_2, SWT.NONE);
		composite_6.setBackground(SWTResourceManager.getColor(255, 239, 213));
		composite_6.setBounds(10, 267, 405, 47);

		Button btnNewButton_6 = new Button(composite_6, SWT.NONE);
		btnNewButton_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				jfaceSelection = tv_1.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof OrderDetails ) {
						//SessionSourceProvider.CURRENT_ORDERDETAILS = (OrderDetails) structuredSelection.getFirstElement();
						//SessionSourceProvider.CURRENT_ORDERDETAILS =
						tv_1.setSelection((ISelection) structuredSelection.iterator().next());
						SessionSourceProvider.CURRENT_ORDERDETAILS = (OrderDetails)((IStructuredSelection) tv_1.getSelection()).getFirstElement();
					}
				}
			}
		});
		btnNewButton_6.setBounds(321, 0, 84, 47);
		btnNewButton_6.setText("Down");

		Button btnUp = new Button(composite_6, SWT.NONE);
		btnUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				jfaceSelection = tv_1.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof OrderDetails ) {
						//SessionSourceProvider.CURRENT_ORDERDETAILS = (OrderDetails) structuredSelection.getFirstElement();
						//SessionSourceProvider.CURRENT_ORDERDETAILS =
						tv_1.setSelection((ISelection) structuredSelection.iterator().next());
						SessionSourceProvider.CURRENT_ORDERDETAILS = (OrderDetails)((IStructuredSelection) tv_1.getSelection()).getFirstElement();
					}
				}

			}
		});
		btnUp.setText("Up");
		btnUp.setBounds(217, 0, 84, 47);

		Button btnUnholdOrder = new Button(composite_6, SWT.NONE);
		btnUnholdOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(SessionSourceProvider.CURRENT_ORDER!=null)
				{
					MessageDialog.openError(parent.getShell() ,"instruction", "there is an incomplete order in progress");
				}
				else
				{
					OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
					List<Order> oList=oDao.unhold();

					UnholdDialog uhd = new UnholdDialog(parent.getShell(), oList);
					if(uhd.open()==0)
					{

					}
					//					if(o!=null)
					//					{
					//						SessionSourceProvider.CURRENT_ORDER = o;
					//
					//						refreshOrderView();
					//						calculateTotal();
					//					}
					//					else
					//						MessageDialog.openError(parent.getShell() ,"instruction", "there is no order on hold");
				}
			}
		});
		btnUnholdOrder.setText("Unhold Order");
		btnUnholdOrder.setBounds(120, 0, 84, 47);

		Button btnHoldSalesOrder = new Button(composite_6, SWT.NONE);
		btnHoldSalesOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(SessionSourceProvider.CURRENT_ORDER!=null)
				{
					Order o = SessionSourceProvider.CURRENT_ORDER;
					OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
					o.setOnHold(true);
					oDao.update(o);
					clearFields();
					clearOrderDetailsGroup();
					SessionSourceProvider.CURRENT_ORDER = null;
					SessionSourceProvider.CURRENT_CUSTOMER = null;
					SessionSourceProvider.CURRENT_CATEGORY = null;
					SessionSourceProvider.CURRENT_ORDERDETAILS = null;
					SessionSourceProvider.CURRENT_PRODUCT = null;
					try{
						Pos.lblNewLabel_14.setText(SessionSourceProvider.CURRENT_CUSTOMER.getFirstName()+" "+SessionSourceProvider.CURRENT_CUSTOMER.getLastName());
					}
					catch(NullPointerException ee)
					{
						Pos.lblNewLabel_14.setText("");
					}
					refreshOrderView();
					//calculateTotal();
				}
				else
				{
					MessageDialog.openError(parent.getShell(), "instruction", "currently there is no active order to hold");
				}
			}
		});
		btnHoldSalesOrder.setText("Hold \r\nOrder");
		btnHoldSalesOrder.setBounds(19, 0, 84, 47);

		Group grpCustomerDetails = new Group(composite_2, SWT.NONE);
		grpCustomerDetails.setText("Customer Details");
		grpCustomerDetails.setBounds(10, 320, 190, 146);

		Label lblNewLabel_3 = new Label(grpCustomerDetails, SWT.NONE);
		lblNewLabel_3.setBounds(10, 23, 55, 15);
		lblNewLabel_3.setText("Name");

		Label lblNewLabel_4 = new Label(grpCustomerDetails, SWT.NONE);
		lblNewLabel_4.setBounds(10, 44, 55, 15);
		lblNewLabel_4.setText("Address");

		Label lblNewLabel_5 = new Label(grpCustomerDetails, SWT.NONE);
		lblNewLabel_5.setText("Town");
		lblNewLabel_5.setBounds(10, 102, 55, 15);

		Label lblNewLabel_6 = new Label(grpCustomerDetails, SWT.NONE);
		lblNewLabel_6.setBounds(10, 123, 55, 15);
		lblNewLabel_6.setText("Post Code");

		Group grpOrderDetails = new Group(composite_2, SWT.NONE);
		grpOrderDetails.setText("Order Details");
		grpOrderDetails.setBounds(207, 320, 208, 146);

		Label lblNewLabel_7 = new Label(grpOrderDetails, SWT.NONE);
		lblNewLabel_7.setBounds(10, 27, 74, 15);
		lblNewLabel_7.setText("Total Amount");

		Label lblNewLabel_8 = new Label(grpOrderDetails, SWT.NONE);
		lblNewLabel_8.setBounds(10, 54, 74, 15);
		lblNewLabel_8.setText("Line Discount");

		Label lblNewLabel_9 = new Label(grpOrderDetails, SWT.NONE);
		lblNewLabel_9.setBounds(10, 83, 74, 15);
		lblNewLabel_9.setText("Overall Disc");

		Label lblNewLabel_10 = new Label(grpOrderDetails, SWT.NONE);
		lblNewLabel_10.setBounds(10, 110, 74, 15);
		lblNewLabel_10.setText(" Total");

		text_4 = new Text(grpOrderDetails, SWT.BORDER);
		text_4.setBounds(90, 27, 108, 21);

		text_5 = new Text(grpOrderDetails, SWT.BORDER);
		text_5.setBounds(90, 54, 108, 21);

		text_6 = new Text(grpOrderDetails, SWT.BORDER);
		text_6.setBounds(90, 80, 108, 21);

		text_6.addKeyListener(new KeyAdapter() { 
			@Override 
			public void keyPressed ( KeyEvent e) { 
				if (e.keyCode ==SWT.CR ) { 
					System.out.println("ENTER pressed");
					Order o  =SessionSourceProvider.CURRENT_ORDER;
					o.setTotalDiscount(Double.parseDouble(text_6.getText()));
					OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
					oDao.update(o);
					calculateTotal();

				} 
			}} );
		text_7 = new Text(grpOrderDetails, SWT.BORDER);
		text_7.setBounds(90, 107, 108, 21);

		Composite composite_7 = new Composite(composite_2, SWT.NONE);
		composite_7.setBackground(SWTResourceManager.getColor(255, 239, 213));
		composite_7.setBounds(10, 472, 405, 48);

		Button btnNewButton_7 = new Button(composite_7, SWT.NONE);
		btnNewButton_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//implement payment
				ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
				Order o = SessionSourceProvider.CURRENT_ORDER;
				o.setCompleted(true);
				o.setPaid(false);
				o.setPaymentDate(new Date());
				OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
				List <OrderDetails> odList = oDao.getListOfOrderDetails(o);

				System.out.println(o.getOrderDate().toString());
				File file = new File(o.getOrderDate().toString().replace(":", "-").replace(" ", "_")+".txt");
				if (!file.exists()) {
					try {
						file.createNewFile();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				try{
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("Order Id: "+o.getOrderId());
					bw.newLine();
					bw.write("Order Date: "+o.getOrderDate().toString());
					bw.newLine();
					bw.write("Payment date: "+o.getPaymentDate());
					bw.newLine();
					bw.write("Total Price: "+o.getTotalPrice());
					bw.newLine();
					bw.write("Total Discount: "+o.getTotalDiscount());
					bw.newLine();
					bw.write("Sales Person: "+o.getSalesPerson().getUsername());
					bw.newLine();
					try{
						bw.write("Customer: "+o.getCustomerId().getFirstName()+" "+o.getCustomerId().getLastName());
						bw.newLine();
					}catch(Exception ee)
					{

					}
					// update product quantity 
					// manage completed orders
					for(int i = 0;i<odList.size();i++)
					{
						Product p =odList.get(i).getProductId();
						p.setTotalQuantity(p.getTotalQuantity()-odList.get(i).getQuantity());

						if(p.getTotalQuantity()<=1)
						{
							MessageDialog.openWarning(parent.getShell(), "Warning", "The product : "+p.getProductName()+" is running out, please re-order it from supplier ");
							p.setImage("icons/workbench/general/R Red.png");
						}
						else if(p.getTotalQuantity()>1 &&p.getTotalQuantity()<5 )
						{
							p.setImage("icons/workbench/general/R Yello.png");

						}

						else
						{
							p.setImage("icons/workbench/general/R White.png");
						}
						pDao.update(p);
						bw.write("	Item Name: "+odList.get(i).getProductId().getProductName());
						bw.newLine();
						bw.write("	Quantity: "+odList.get(i).getQuantity());
						bw.newLine();
						bw.write("	Price: "+odList.get(i).getPrice());
						bw.newLine();
						bw.write("	Discount: "+odList.get(i).getDiscount());
						bw.newLine();
						bw.write("	Total: "+odList.get(i).getTotal());
						bw.newLine();
						bw.newLine();

					}
					bw.close();
					System.out.println("cmd /c start "+file.getName());
					Runtime.getRuntime().exec("cmd /c start "+file.getName());//+o.getOrderDate().toString().replace(":", "-").replace(" ", "_")+".txt");

				}catch(Exception oo)
				{
					oo.printStackTrace();
				}
				oDao.update(o);


				SessionSourceProvider.CURRENT_ORDER = null;
				SessionSourceProvider.CURRENT_CUSTOMER = null;
				SessionSourceProvider.CURRENT_ORDERDETAILS = null;
				SessionSourceProvider.CURRENT_CATEGORY = null;
				SessionSourceProvider.CURRENT_PRODUCT = null;
				clearFields();
				clearOrderDetailsGroup();
				refreshOrderView();
				//calculateTotal();
			}
		});
		btnNewButton_7.setBounds(336, 0, 66, 48);
		btnNewButton_7.setText("Payment");

		Button btnPrintLastReceipt = new Button(composite_7, SWT.NONE);
		btnPrintLastReceipt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(SessionSourceProvider.CURRENT_ORDER==null)
				{
					OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
					SessionSourceProvider.CURRENT_ORDER = oDao.getLastReceipt();
					SessionSourceProvider.CURRENT_CUSTOMER = SessionSourceProvider.CURRENT_ORDER.getCustomerId();
					clearFields();
					clearOrderDetailsGroup();
					calculateTotal();
					refreshOrderView();
					try{
						Pos.lblNewLabel_14.setText(SessionSourceProvider.CURRENT_CUSTOMER.getFirstName()+" "+SessionSourceProvider.CURRENT_CUSTOMER.getLastName());
					}
					catch(NullPointerException ee)
					{
						Pos.lblNewLabel_14.setText("");
					}
				}
				else
				{
					MessageDialog.openError(parent.getShell(), "Error", "Currently, there is a running order, you either hold, complete or delete it please");
				}
			}
		});
		btnPrintLastReceipt.setText("last Receipt");
		btnPrintLastReceipt.setBounds(265, 0, 72, 48);

		Button btnDelItem = new Button(composite_7, SWT.NONE);
		btnDelItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//				//Delete All corresponding order Details
				//				Order o = SessionSourceProvider.CURRENT_ORDER;
				//
				//				OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
				//				List <OrderDetails> odList = oDao.getListOfOrderDetails(o);
				OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();

				//List <OrderDetails> odList2 = new ArrayList(odList);
				//				for(int i = 0; i<odList.size();i++)
				//				{
				OrderDetails od = SessionSourceProvider.CURRENT_ORDERDETAILS;
				SessionSourceProvider.CURRENT_ORDERDETAILS = null;
				odDao.delete(od);
				//				}
				//				oDao.delete(o);
				//				SessionSourceProvider.CURRENT_ORDER = null;


				refreshOrderView();
				clearFields();
				clearOrderDetailsGroup();
				calculateTotal();
			}
		});
		btnDelItem.setText("Del Item");
		btnDelItem.setBounds(199, 0, 66, 48);

		Button btnCustomer = new Button(composite_7, SWT.NONE);
		btnCustomer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CustomerDao cDao = DaoFactory.eINSTANCE.createCustomerDao();
				List <Customer> cList =cDao.getList(Customer.class);
				CustomerDialog cd = new CustomerDialog(parent.getShell(), cList);
				if(cd.open()==0)
				{

				}
			}
		});
		btnCustomer.setText("Customer");
		btnCustomer.setBounds(133, 0, 66, 48);

		Button btnNewOrder = new Button(composite_7, SWT.NONE);
		btnNewOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(SessionSourceProvider.CURRENT_ORDER!=null)
				{
					MessageDialog.openError(parent.getShell() ,"instruction", "there is an incomplete order in progress");
				}
				else
				{
					Order o = GeneralFactory.eINSTANCE.createOrder();
					OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
					o.setCompleted(false);
					SessionSourceProvider.CURRENT_CUSTOMER = null;

					o.setCustomerId(SessionSourceProvider.CURRENT_CUSTOMER);
					try{
						Pos.lblNewLabel_14.setText(SessionSourceProvider.CURRENT_CUSTOMER.getFirstName()+" "+SessionSourceProvider.CURRENT_CUSTOMER.getLastName());
					}
					catch(Exception ee)
					{

					}
					o.setDeleted(false);
					o.setOrderDate(new Date());
					o.setPaid(false);
					o.setOnHold(false);
					o.setSalesPerson(SessionSourceProvider.USER);
					oDao.create(o);

					SessionSourceProvider.CURRENT_ORDER = o;

					refreshOrderView();

					clearFields();
					clearOrderDetailsGroup();

				}
			}
		});
		btnNewOrder.setText("New Order");
		btnNewOrder.setBounds(0, 0, 66, 48);

		Button btnDelOrder = new Button(composite_7, SWT.NONE);
		btnDelOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean m = MessageDialog.openQuestion(parent.getShell(), "warning", "Are you sure you want to delete the currently running order");
				if(m)
				{
					//Delete All corresponding order Details
					Order o = SessionSourceProvider.CURRENT_ORDER;
					//System.out.println("current order is "+SessionSourceProvider.CURRENT_ORDER.getOrderId());
					OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
					List <OrderDetails> odList = oDao.getListOfOrderDetails(o);
					OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();

					//List <OrderDetails> odList2 = new ArrayList(odList);
					for(int i = 0; i<odList.size();i++)
					{
						OrderDetails od = odList.get(i);
						odDao.delete(od);
					}
					oDao.delete(o);
					SessionSourceProvider.CURRENT_ORDER = null;
					SessionSourceProvider.CURRENT_CUSTOMER = null;
					SessionSourceProvider.CURRENT_ORDERDETAILS = null;
					SessionSourceProvider.CURRENT_CATEGORY = null;
					SessionSourceProvider.CURRENT_PRODUCT = null;
					//Pos.lblNewLabel_14.setText(SessionSourceProvider.CURRENT_CUSTOMER.getFirstName()+" "+SessionSourceProvider.CURRENT_CUSTOMER.getLastName());
					Pos.lblNewLabel_14.setText("");
					refreshOrderView();
					clearFields();
					clearOrderDetailsGroup();
				}
			}
		});
		btnDelOrder.setText("Del Order");
		btnDelOrder.setBounds(66, 0, 66, 48);

		Label lblNewLabel_12 = new Label(composite_2, SWT.NONE);
		lblNewLabel_12.setBounds(10, 1, 67, 15);
		lblNewLabel_12.setText("SalesPerson");

		Label lblNewLabel_13 = new Label(composite_2, SWT.NONE);
		lblNewLabel_13.setBounds(214, 1, 61, 15);
		lblNewLabel_13.setText("Customer");

		lblNewLabel_14 = new Label(composite_2, SWT.NONE);
		lblNewLabel_14.setBounds(281, 8, 127, 15);
		//lblNewLabel_14.setText(SessionSourceProvider.CURRENT_CUSTOMER.getFirstName()+" "+SessionSourceProvider.CURRENT_CUSTOMER.getLastName());
		Label label = new Label(parent, SWT.SEPARATOR | SWT.VERTICAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		Composite composite = new Composite(parent, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite.widthHint = 247;
		composite.setLayoutData(gd_composite);

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(255, 239, 213));
		composite_1.setBounds(0, 0, 420, 54);

		Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1.setBounds(10, 0, 75, 54);
		btnNewButton_1.setText("Include VAT");

		Button btnNewButton_2 = new Button(composite_1, SWT.NONE);
		btnNewButton_2.setBounds(91, 0, 75, 54);
		btnNewButton_2.setText("Without VAT");

		Button btnNewButton_3 = new Button(composite_1, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddCategoryDialog acd = new AddCategoryDialog(parent.getShell());
				if(acd.open()==0)
				{

				}
			}

		});

		btnNewButton_3.setBounds(335, 0, 75, 54);
		btnNewButton_3.setText("Categories");

		Composite composite_3 = new Composite(composite, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(255, 239, 213));
		composite_3.setBounds(0, 70, 420, 190);


		tv = new TableViewer(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		table = tv.getTable();
		table.setBounds(10, 10, 390, 170);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tv.setLabelProvider(new GenericNameLabelProvider());
		tv.setContentProvider(new ArrayContentProvider()
		{


			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Category>)inputElement ) .toArray();
			}
		});


		tv.addSelectionChangedListener(new ISelectionChangedListener() {




			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;
				if ( !structuredSelection.isEmpty()) {
					if ( structuredSelection.getFirstElement() instanceof Category ) {
						SessionSourceProvider.CURRENT_CATEGORY = (Category) structuredSelection.getFirstElement();
						text.setText(SessionSourceProvider.CURRENT_CATEGORY.getCategoryName());
					}
				}

			}
		});

		TableColumn tblclmnCategoryName = new TableColumn(table, SWT.NONE);
		TableViewerColumn tvc = new TableViewerColumn(tv, tblclmnCategoryName);
		tblclmnCategoryName.setWidth(177);
		tblclmnCategoryName.setText("Category Name");

		tvc.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Category)
				{
					return ((Category)element).getCategoryName();
				}
				return null;
			}
		});
		TableColumn tblclmnCategoryDescription = new TableColumn(table, SWT.NONE);
		TableViewerColumn tvc2 = new TableViewerColumn(tv, tblclmnCategoryDescription);
		tblclmnCategoryDescription.setWidth(185);
		tblclmnCategoryDescription.setText("Category Description");
		tvc2.setLabelProvider( new ColumnLabelProvider() {
			public String getText(Object element) {

				if(element instanceof Category)
				{
					return ((Category)element).getDescription();
				}
				return null;
			}
		});




		SessionSourceProvider.Category_List= cDao.getList(Category.class);
		Pos.tv.setInput(SessionSourceProvider.Category_List);

		Composite composite_4 = new Composite(composite, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(255, 239, 213));
		composite_4.setBounds(208, 269, 202, 252);

		Button btnNewButton = new Button(composite_4, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"9";
				text_1.setText(price);
			}
		});
		btnNewButton.setBounds(136, 10, 56, 42);
		btnNewButton.setText("9");

		Button button = new Button(composite_4, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"7";
				text_1.setText(price);
			}
		});
		button.setText("7");
		button.setBounds(10, 10, 56, 42);

		Button button_1 = new Button(composite_4, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"8";
				text_1.setText(price);
			}
		});
		button_1.setText("8");
		button_1.setBounds(72, 10, 56, 42);

		Button button_2 = new Button(composite_4, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"6";
				text_1.setText(price);
			}
		});
		button_2.setText("6");
		button_2.setBounds(136, 58, 56, 42);

		Button button_3 = new Button(composite_4, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"5";
				text_1.setText(price);
			}
		});
		button_3.setText("5");
		button_3.setBounds(72, 58, 56, 42);

		Button button_4 = new Button(composite_4, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"4";
				text_1.setText(price);
			}
		});
		button_4.setText("4");
		button_4.setBounds(10, 58, 56, 42);

		Button button_5 = new Button(composite_4, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"3";
				text_1.setText(price);
			}
		});
		button_5.setText("3");
		button_5.setBounds(136, 106, 56, 42);

		Button button_6 = new Button(composite_4, SWT.NONE);
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"2";
				text_1.setText(price);
			}
		});
		button_6.setText("2");
		button_6.setBounds(72, 106, 56, 42);

		Button button_7 = new Button(composite_4, SWT.NONE);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"1";
				text_1.setText(price);
			}
		});
		button_7.setText("1");
		button_7.setBounds(10, 106, 56, 42);

		Button btnOk = new Button(composite_4, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+".";
				text_1.setText(price);
			}
		});
		btnOk.setText(".");
		btnOk.setBounds(136, 154, 56, 42);

		Button button_9 = new Button(composite_4, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"00";
				text_1.setText(price);
			}
		});
		button_9.setText("00");
		button_9.setBounds(72, 154, 56, 42);

		Button button_10 = new Button(composite_4, SWT.NONE);
		button_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price+"0";
				text_1.setText(price);
			}
		});
		button_10.setText("0");
		button_10.setBounds(10, 154, 56, 42);

		Button button_8 = new Button(composite_4, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Order o = GeneralFactory.eINSTANCE.createOrder();
				OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
				System.out.println(text.getText()==null);
				if(!(text.getText().equals("") || text_1.getText().equals("")|| text_8.getText().equals("") )){

					ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();

					Product p = GeneralFactory.eINSTANCE.createProduct();
					if(!(SessionSourceProvider.CURRENT_CATEGORY==null))
						p.setCatergoryId(SessionSourceProvider.CURRENT_CATEGORY);
					else
						p.setCatergoryId(cDao.getByName(text.getText()));
					p.setProductName(text.getText());
					p.setSKU(text_8.getText());
					//if(!oDao.findOrderDetails(SessionSourceProvider.CURRENT_ORDER, p)){
					p.setUnitPrice(Double.parseDouble(text_1.getText()));
					p.setQuantityPerUnit(1);
					p.setUnitsInStock(1);
					p.setTotalQuantity(p.getUnitsInStock()*p.getQuantityPerUnit());
					p.setImage("icons/workbench/general/R Red.png");

					if(SessionSourceProvider.CURRENT_ORDER==null)
					{

						o.setCompleted(false);
						SessionSourceProvider.CURRENT_CUSTOMER = null;
						o.setCustomerId(SessionSourceProvider.CURRENT_CUSTOMER);
						o.setDeleted(false);
						o.setOrderDate(new Date());
						o.setPaid(false);
						o.setOnHold(false);
						o.setSalesPerson(SessionSourceProvider.USER);
						oDao.create(o);

						SessionSourceProvider.CURRENT_ORDER = o;
					}
					//if(!oDao.findOrderDetails(SessionSourceProvider.CURRENT_ORDER, p)){
					if((pDao.getBySKU2(p.getSKU())).size()==0){
						pDao.create(p);
						SessionSourceProvider.CURRENT_PRODUCT =p;
						OrderDetails od = GeneralFactory.eINSTANCE.createOrderDetails();
						OrderDetailsDao odDao = DaoFactory.eINSTANCE.createOrderDetailsDao();
						od.setOrderId(SessionSourceProvider.CURRENT_ORDER);
						od.setProductId(SessionSourceProvider.CURRENT_PRODUCT);
						od.setPrice((p.getUnitPrice()/p.getQuantityPerUnit()));
						try
						{
							od.setDiscount(p.getDiscount());
						}
						catch(Exception ee)
						{

						}
						od.setQuantity(1);
						od.setTotal(od.getQuantity()*od.getPrice());
						od.setDate(new Date());
						odDao.create(od);
						SessionSourceProvider.CURRENT_ORDERDETAILS = od;

						refreshOrderView();
						calculateTotal();
						clearFields();
						//StockControlView.listProducts();
					}
					else
					{
						MessageDialog.openError(parent.getShell(), "Insruction", "This product's sku already exist in the database, you can search for it");
					}
				}
				else
				{
					MessageDialog.openError(parent.getShell(), "Insruction", "please fill in all the fields of the product");
				}

			}
		});
		button_8.setText("OK");
		button_8.setBounds(136, 200, 56, 42);

		Button btnBcksp = new Button(composite_4, SWT.NONE);
		btnBcksp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				price = price.substring(0, price.length()-1);
				text_1.setText(price);
			}
		});
		btnBcksp.setText("bcksp");
		btnBcksp.setBounds(72, 200, 56, 42);

		Button btnClear = new Button(composite_4, SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clearFields();
			}
		});
		btnClear.setText("CLEAR");
		btnClear.setBounds(10, 200, 56, 42);

		Group grpQuickProductDetails = new Group(composite, SWT.NONE);
		grpQuickProductDetails.setBackground(SWTResourceManager.getColor(255, 239, 213));
		grpQuickProductDetails.setText("Quick Product Details");
		grpQuickProductDetails.setBounds(0, 266, 192, 257);

		text_1 = new Text(grpQuickProductDetails, SWT.BORDER);
		text_1.setBounds(10, 166, 172, 21);

		Label lblNewLabel_1 = new Label(grpQuickProductDetails, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(255, 239, 213));
		lblNewLabel_1.setBounds(10, 145, 55, 15);
		lblNewLabel_1.setText("Price");

		text_8 = new Text(grpQuickProductDetails, SWT.BORDER);
		text_8.setBounds(10, 106, 172, 21);

		Label lblNewLabel_11 = new Label(grpQuickProductDetails, SWT.NONE);
		lblNewLabel_11.setBackground(SWTResourceManager.getColor(255, 239, 213));
		lblNewLabel_11.setBounds(10, 85, 55, 15);
		lblNewLabel_11.setText("SKU");

		text = new Text(grpQuickProductDetails, SWT.BORDER);
		text.setBounds(10, 47, 172, 21);

		Label lblNewLabel = new Label(grpQuickProductDetails, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 239, 213));
		lblNewLabel.setBounds(10, 26, 116, 15);
		lblNewLabel.setText("Description");


	}

	@Override
	public void setFocus() {


	}
	void clearFields()
	{
		text.setText("");
		text_1.setText("");
		text_8.setText("");
		price = "";
	}

	void clearOrderDetailsGroup()
	{
		text_4.setText("");
		text_5.setText("");
		text_6.setText("");
		text_7.setText("");

	}

	public void calculateTotal()
	{	
		OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
		SessionSourceProvider.OrderDetails_List = oDao.getListOfOrderDetails(SessionSourceProvider.CURRENT_ORDER);
		Order o  =SessionSourceProvider.CURRENT_ORDER;
		//OrderDao od = DaoFactory.eINSTANCE.createOrderDao();

		double sum = 0;
		for(int i=0;i<SessionSourceProvider.OrderDetails_List.size();i++)
		{	
			sum = sum + SessionSourceProvider.OrderDetails_List.get(i).getTotal();
		}
		try
		{
			text_4.setText(Double.toString(sum));
			System.out.println("sum is "+sum);
		}
		catch(Exception e)
		{
			//System.out.println();
			e.printStackTrace();
		}
		try
		{
			text_5.setText(Double.toString(SessionSourceProvider.CURRENT_ORDERDETAILS.getDiscount()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try{
			text_6.setText(Double.toString(SessionSourceProvider.CURRENT_ORDER.getTotalDiscount()));
		}
		catch(Exception e)
		{
			o.setTotalDiscount(Double.parseDouble(text_6.getText()));
		}
		//		text_6.addModifyListener(new ModifyListener() {
		//
		//			@Override
		//			public void modifyText(ModifyEvent e) {
		//				Order o  =SessionSourceProvider.CURRENT_ORDER;
		//				o.setTotalDiscount(Double.parseDouble(text_6.getText()));
		//				OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
		//				oDao.update(o);
		//
		//
		//			}
		//		});

		o.setTotalPrice(sum-(Double.parseDouble(text_6.getText())*  sum));
		System.out.println("total price is "+(sum-(Double.parseDouble(text_6.getText())*  sum)));
		o.setTotalDiscount(Double.parseDouble(text_6.getText()));
		//Double.toString(sum-(Double.parseDouble(text_6.getText())*  sum))
		oDao.update(o);
		try
		{
			text_7.setText(Double.toString(o.getTotalPrice()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public void refreshOrderView()
	{
		if(SessionSourceProvider.CURRENT_ORDER!=null)
		{
			OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();

			SessionSourceProvider.OrderDetails_List = oDao.getListOfOrderDetails(SessionSourceProvider.CURRENT_ORDER);
			Collections.sort(SessionSourceProvider.OrderDetails_List, new DateComparator());
			tv_1.setInput(SessionSourceProvider.OrderDetails_List);
		}
		else
		{
			table_1.removeAll();
		}
	}

	@Override
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub

	}
}
