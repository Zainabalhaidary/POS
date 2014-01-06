package com.marbleArchPaint.softwareEngineering.views;


import general.Payment;
import general.User;
import general.Category;
import general.Customer;
import general.Order;
import general.OrderDetails;
import general.PaymentType;
import general.Product;
import general.Shipper;
import general.Supplier;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;



import dao.DaoFactory;
import dao.GenericDao;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;

import com.marbleArchPaint.softwareEngineering.LabelProvider.GenericNameLabelProvider;
import org.eclipse.wb.swt.SWTResourceManager;

public class qQuery extends ViewPart implements Listener {
	private TableViewer tv;
	private Table tableResult;
	List <String> dbClasses;
	private Text textQuery;
	private ISelection objectSelection;
	private IStructuredSelection structuredSelection;
	String selectedClass;
	String result;
	String oldResult;
	public GenericDao gDao;
	ComboViewer cv1;
	String selectedAttribute;
	public String enteredValue;
	ComboViewer textValue;
	Combo textValue1;
	Class<?> ActualName;

	public qQuery() {
		dbClasses = new ArrayList<String>();
		result ="";
		gDao = DaoFactory.eINSTANCE.createGenericDao();
	}

	@Override
	public void createPartControl(Composite parent) {

		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(255, 239, 213));
		composite.setLayout(null);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(5, 27, 82, 15);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 239, 213));
		lblNewLabel.setText("DB Table Name");


		ComboViewer cv = new ComboViewer(composite, SWT.NONE);
		Combo comboFrom = cv.getCombo();
		comboFrom.setBounds(92, 23, 497, 23);
		cv.setLabelProvider(new GenericNameLabelProvider());
		cv.setContentProvider(new ArrayContentProvider() {

			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<String>)inputElement ) .toArray();
			}
		});

		tv = new TableViewer(composite, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		tableResult = tv.getTable();
		tableResult.setBounds(92, 344, 497, 193);
		tableResult.setLinesVisible(true);
		tv.setContentProvider(new ArrayContentProvider() {

			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<String>)inputElement ) .toArray();
			}
		});
		dbClasses.add(Category.class.getName().substring(Category.class.getName().indexOf(".")+1).toLowerCase());
		dbClasses.add(Customer.class.getName().substring(Customer.class.getName().indexOf(".")+1).toLowerCase());
		dbClasses.add(Order.class.getName().substring(Order.class.getName().indexOf(".")+1).toLowerCase());
		dbClasses.add(OrderDetails.class.getName().substring(OrderDetails.class.getName().indexOf(".")+1).toLowerCase());
		dbClasses.add(Product.class.getName().substring(Product.class.getName().indexOf(".")+1).toLowerCase());
		dbClasses.add(Shipper.class.getName().substring(Shipper.class.getName().indexOf(".")+1).toLowerCase());
		dbClasses.add(Supplier.class.getName().substring(Supplier.class.getName().indexOf(".")+1).toLowerCase());
		dbClasses.add(User.class.getName().substring(User.class.getName().indexOf(".")+1).toLowerCase());

		//		Session session = gDao.getSession();
		//		session.beginTransaction();
		//		Query query = session.createSQLQuery("select * from information_schema.tables where TABLE_SCHEMA = 'PUBLIC'");
		//
		//		System.out.println("select * from information_schema.tables where TABLE_SCHEMA = 'PUBLIC'");
		//		
		//		List results2 = query.list();


		cv.setInput(dbClasses);
		//		cv.setInput(results2);


		cv.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				//				lblDate.setVisible(true);
				//				lblDate.setText("");
				oldResult = "";
				//				result = "from ";
				result = "select * from ";

				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;

				if ( !structuredSelection.isEmpty()) {

					if ( structuredSelection.getFirstElement() instanceof String) {


						selectedClass = (String) structuredSelection.getFirstElement();


						Session session = gDao.getSession();
						session.beginTransaction();
						//							String string = ("select column_name from information_schema.columns where table_name = '" +selectedClass+"'");
						//							String string = ("SELECT table_name, column_name, data_type, data_length FROM USER_TAB_COLUMNS WHERE table_name = '" +selectedClass+"'");

						//							Query query = session.createSQLQuery("select column_name from information_schema.columns where table_name = '" +selectedClass+"'");     
						//							Query query = session.createSQLQuery("select column_name from information_schema.columns where table_name = 'connection'");
						//							Query query = session.createSQLQuery("select column_name from information_schema.columns where table_name = '" +selectedClass.substring(selectedClass.indexOf(".")+1).toLowerCase()+"'");

						//						Query query = session.createSQLQuery("select column_name from USER_TAB_COLUMNS where table_name = '" +selectedClass+"'"); oracle

						//							System.out.println(	"select column_name from information_schema.columns where table_name = '" +selectedClass.substring(selectedClass.indexOf(".")+1).toLowerCase()+"'");


						//SELECT table_name, column_name, data_type, data_length FROM USER_TAB_COLUMNS where table_name = 'connection'    oracle
						//						System.out.println(	"select column_name from information_schema.columns where table_name = '" +selectedClass+"'"); hsqldb
						Query query = session.createSQLQuery("select column_name from information_schema.columns where table_name = '" +selectedClass+"'");
						//						System.out.println(	"select column_name from USER_TAB_COLUMNS where table_name = '" +selectedClass+"'");

						//							Query query = session.createSQLQuery("SELECT * FROM   INFORMATION_SCHEMA.TABLES");
						List<?> results = query.list();
						results.remove("dtype");
						results.remove("E_VERSION");
						try
						{
							results.remove("password");
						}
						catch(Exception e)
						{

						}
						//							System.out.println(results.size());
						//							for(Object o : results)
						//							{
						//								System.out.println(o);
						//							}
						//
						//							String myQuery = "select column_name from information_schema.columns where table_name = 'connection'" ;
						//
						//							SessionFactoryImpl sessImpl = (SessionFactoryImpl) session.getSessionFactory(); 
						//
						//							NamedSQLQueryDefinition nsqlqd = sessImpl.getNamedSQLQuery(myQuery ); 
						//							NativeSQLQueryReturn[] columnDefinitions=nsqlqd.getQueryReturns();
						//							// get the column definitons 
						//							//SQLQueryScalarReturn[] columnDefinitions1 = nsqlqd.getScalarQueryReturns(); 
						//
						//
						//
						//							// get the query using the Plumtree Query Impl Helper class 
						//							Query query = PTSQLQueryImplHelper.getSQLQueryImpl(nsqlqd, (SessionImpl)session); 
						//							query.setCacheable( nsqlqd.isCacheable() ); 
						//							query.setCacheRegion( nsqlqd.getCacheRegion() ); 
						//							if ( nsqlqd.getTimeout()!=null ) query.setTimeout( nsqlqd.getTimeout().intValue() ); 
						//							if ( nsqlqd.getFetchSize()!=null ) query.setFetchSize( nsqlqd.getFetchSize().intValue() ); 
						//							List l = query.list(); 

						//							System.out.println(Connection.class.getName().substring(selectedClass.indexOf(".")+1).toLowerCase());
						//							if(selectedClass.equals(Connection.class.getName().substring(selectedClass.indexOf(".")+1).toLowerCase()))
						if(selectedClass.equals("category"))
						{
							oldResult = result;
							//							result= result + general.Connection.class.getName();
							ActualName=Category.class;
							result= result + "\""+selectedClass+"\"";
							textQuery.setText(result);
							cv1.setInput(results);
						}
						else
							//								if(selectedClass.equals(Container.class.getName().substring(selectedClass.indexOf(".")+1).toLowerCase()))
							if(selectedClass.equals("customer"))
							{
								oldResult = result;
								//								result= result + general.Container.class.getName();
								ActualName=Customer.class;
								result= result + "\""+selectedClass+"\"";
								textQuery.setText(result);
								cv1.setInput(results);
							}
							else
								//									if(selectedClass.equals(FileFunctionStatus.class.getName().substring(selectedClass.indexOf(".")+1).toLowerCase()))
								if(selectedClass.equals("order"))
								{
									oldResult = result;
									//									result= result + general.FileFunctionStatus.class.getName();
									ActualName=Order.class;
									result= result + "\""+selectedClass+"\"";
									textQuery.setText(result);
									cv1.setInput(results);
								}
								else
									//										if(selectedClass.equals(Function.class.getName().substring(selectedClass.indexOf(".")+1).toLowerCase()))
									if(selectedClass.equals("orderdetails"))
									{

										oldResult = result;
										//										result= result + general.Function.class.getName();
										ActualName=OrderDetails.class;
										result= result + "\""+selectedClass+"\"";
										textQuery.setText(result);
										cv1.setInput(results);

									}
									else
										//											if(selectedClass.equals(general.MS.class.getName().substring(selectedClass.indexOf(".")+1).toLowerCase()))
										if(selectedClass.equals("product"))
										{
											oldResult = result;
											//											result= result + general.MS.class.getName();
											ActualName=Product.class;
											result= result + "\""+selectedClass+"\"";
											textQuery.setText(result);
											cv1.setInput(results);
										}
										else
											//												if(selectedClass.equals(Release.class.getName().substring(selectedClass.indexOf(".")+1).toLowerCase()))
											if(selectedClass.equals("shipper"))
											{
												//													cv1.setInput();
												oldResult = result;
												//												result= result + general.Release.class.getName();
												ActualName=Shipper.class;
												result= result + "\""+selectedClass+"\"";
												textQuery.setText(result);
												cv1.setInput(results);
											}
											else
												//													if(selectedClass.equals(Snapshot.class.getName().substring(selectedClass.indexOf(".")+1).toLowerCase()))
												if(selectedClass.equals("supplier"))
												{
													oldResult = result;
													//													result= result + general.Snapshot.class.getName();
													ActualName=Supplier.class;
													result= result + "\""+selectedClass+"\"";
													textQuery.setText(result);
													//														cv1.setInput();
													cv1.setInput(results);
												}
												else
													//														if(selectedClass.equals(User.class.getName().substring(selectedClass.indexOf(".")+1).toLowerCase()))
													if(selectedClass.equals("user"))
													{
														//															cv1.setInput();
														oldResult = result;
														//														result= result + general.User.class.getName();
														ActualName=User.class;
														result= result + "\""+selectedClass+"\"";
														textQuery.setText(result);
														cv1.setInput(results);
													}

					}
				}
			}
		});

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(5, 91, 82, 15);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(255, 239, 213));
		lblNewLabel_1.setText("Attribute Name");


		cv1 = new ComboViewer(composite, SWT.NONE);
		cv1.setLabelProvider(new GenericNameLabelProvider());
		cv1.setContentProvider(new ArrayContentProvider() {

			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<String>)inputElement ) .toArray();
			}
		});
		Combo comboWhere = cv1.getCombo();
		comboWhere.setBounds(92, 87, 497, 23);
		cv1.addSelectionChangedListener(new ISelectionChangedListener() {

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void selectionChanged(SelectionChangedEvent event) {


				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;

				if ( !structuredSelection.isEmpty()) {

					if ( structuredSelection.getFirstElement() instanceof String) {


						selectedAttribute = (String) structuredSelection.getFirstElement();
						if(!selectedAttribute.equals("password"))
						{
							oldResult = result;
							result= result + " where " + "\""+selectedAttribute+"\"";


							Session session = gDao.getSession();
							session.beginTransaction();
							Query query = session.createSQLQuery("select data_type from information_schema.columns where table_name = '"+selectedClass+"' and column_name = '"+selectedAttribute+"'");
							//						Query query = session.createSQLQuery("select data_type from USER_TAB_COLUMNS where table_name = '"+selectedClass+"' and column_name = '"+selectedAttribute+"'"); oracle

							//						System.out.println("select data_type from USER_TAB_COLUMNS where table_name = '"+selectedClass+"' and column_name = '"+selectedAttribute+"'");
							List<?> results = query.list();
							System.out.println(results.size());
							System.out.println( results.get(0));


							query = session.createSQLQuery("select \""+selectedAttribute+"\" from \""+selectedClass+"\"");
							System.out.println("select \""+selectedAttribute+"\" from \""+selectedClass+"\"");
							List<?> results2 = query.list();
							System.out.println(results2.size());
							try
							{
								System.out.println( results2.get(0));
							}
							catch(IndexOutOfBoundsException e)
							{
								MessageDialog.openWarning(composite.getShell(), "Warning", "The database has no rows of this item yet");
							}

							List result3  =new ArrayList();
							for(Object o: results2)
							{
								System.out.println("object is : "+o);
								if(!((o==null)||(o.equals(""))))
								{
									result3.add(o);
								}
							}

							textValue.setInput(result3);
							if(results.get(0).equals("TIMESTAMP"))
							{
								System.out.println("in the timestamp");
								//							lblDate.setVisible(true);
								//							lblDate.setText("dd.mm.yy hh:mm");

							}

							textQuery.setText(result);
						}
						else
						{
							cv1.setSelection(null);
							MessageDialog.openWarning(composite.getShell(), "Access Not Allowed", "It is not allowed to view the list of passwords");
						}
					}

				}
			}
		});

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setBounds(31, 156, 29, 15);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 239, 213));
		lblNewLabel_2.setText("Value");

		textValue = new ComboViewer(composite, SWT.NONE);

		textValue1 = textValue.getCombo();
		textValue1.setBounds(92, 152, 426, 23);
		textValue1.addListener(SWT.Modify, this);
		// 

		textValue.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {



				objectSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) objectSelection;

				if ( !structuredSelection.isEmpty()) {

					if ( structuredSelection.getFirstElement() instanceof String) {


						enteredValue = (String) structuredSelection.getFirstElement();

						oldResult = result;
						result = result + " = '"+enteredValue+"'";
						textQuery.setText(result);

					}}}});

		textValue.setLabelProvider(new GenericNameLabelProvider());
		textValue.setContentProvider(new ArrayContentProvider() {

			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<String>)inputElement ) .toArray();
			}
		});




		textValue1.addKeyListener(new KeyAdapter() {
			@Override 
			public void keyPressed ( KeyEvent e) { 
				System.out.println("I'm in the key listener");
				if(e.keyCode==SWT.CR)
					if (textValue1.getText().length() > 0 )
					{
						enteredValue = textValue1.getText();
						oldResult = result;
						result = result + " = '"+enteredValue+"'";
						textQuery.setText(result);
					}
			} 
		});

		Button btnAddValue = new Button(composite, SWT.NONE);
		btnAddValue.setBounds(523, 151, 66, 25);
		btnAddValue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				System.out.println("I'm in the key listener");

				if (textValue1.getText().length() > 0 )
				{
					enteredValue = textValue1.getText();
					oldResult = result;


					if((result.substring(result.length()-5, result.length()-1)).equals(" Not"))
					{
						System.out.println("there is NOT");
						Session session = gDao.getSession();
						session.beginTransaction();
						Query query = session.createSQLQuery("select data_type from information_schema.columns where table_name = '"+selectedClass+"' and column_name = '"+selectedAttribute+"'");
						System.out.println("select data_type from information_schema.columns where table_name = '"+selectedClass+"' and column_name = '"+selectedAttribute+"'");
						List<?> results = query.list();
						System.out.println(results.size());
						System.out.println( results.get(0));

						if(results.get(0).equals("TIMESTAMP"))
						{
							System.out.println("in the timestamp");
							//									lblDate.setVisible(true);
							//									lblDate.setText("dd.mm.yy hh:mm");

							result = result + " '"+enteredValue+"'";
							textQuery.setText(result);
						}
						else
							if(results.get(0).equals("BIT"))
							{
								System.out.println("in the bit");
								//										lblDate.setVisible(false);
								//										lblDate.setText("");
								result = result + " "+enteredValue;
								textQuery.setText(result);
							}
							else
							{
								System.out.println("in the string");
								//										lblDate.setVisible(false);
								//										lblDate.setText("");
								result = result + " '"+enteredValue+"'";
								textQuery.setText(result);
							}




					}
					else
					{

						System.out.println("there is no NOT");
						Session session = gDao.getSession();
						session.beginTransaction();
						Query query = session.createSQLQuery("select data_type from information_schema.columns where table_name = '"+selectedClass+"' and column_name = '"+selectedAttribute+"'");
						System.out.println("select data_type from information_schema.columns where table_name = '"+selectedClass+"' and column_name = '"+selectedAttribute+"'");

						List<?> results = query.list();
						System.out.println(results.size());
						System.out.println( results.get(0));

						if(results.get(0).equals("TIMESTAMP"))
						{
							System.out.println("in the timestamp");
							//									lblDate.setVisible(true);
							//									lblDate.setText("dd.mm.yy hh:mm");
							result = result + " = '"+(enteredValue)+"'";
							textQuery.setText(result);
						}
						else
							if(results.get(0).equals("BIT"))
							{

								System.out.println("in the bit");
								//										lblDate.setVisible(false);
								//										lblDate.setText("");
								result = result + " is "+enteredValue;
								textQuery.setText(result);
							}
							else
							{

								System.out.println("in the string");
								//										lblDate.setVisible(false);
								//										lblDate.setText("");
								result = result + " = '"+enteredValue+"'";
								textQuery.setText(result);
							}


					}


				}
			} 
		});
		btnAddValue.setText("Add Value");

		Button btnLeftBraket = new Button(composite, SWT.NONE);
		btnLeftBraket.setBounds(92, 237, 111, 25);
		btnLeftBraket.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				oldResult = result;
				result = result +" ( ";
				textQuery.setText(result);
			}
		});
		btnLeftBraket.setText("(");

		Button btnAnd = new Button(composite, SWT.NONE);
		btnAnd.setBounds(208, 237, 53, 25);
		btnAnd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				oldResult = result;
				result = result +" And ";
				textQuery.setText(result);
			}
		});
		btnAnd.setText("And");

		Button btnOr = new Button(composite, SWT.NONE);
		btnOr.setBounds(266, 237, 44, 25);
		btnOr.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				oldResult = result;
				result = result +" Or ";
				textQuery.setText(result);
			}
		});
		btnOr.setText("Or");

		Button btnNot = new Button(composite, SWT.NONE);
		btnNot.setBounds(315, 237, 51, 25);
		btnNot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				oldResult = result;
				result = result +" is Not ";
				textQuery.setText(result);
			}
		});
		btnNot.setText("Not");

		Button btnRightBraket = new Button(composite, SWT.NONE);
		btnRightBraket.setBounds(371, 237, 60, 25);
		btnRightBraket.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				oldResult = result;
				result = result +" ) ";
				textQuery.setText(result);
			}
		});
		btnRightBraket.setText(")");

		Button btnUndoLast = new Button(composite, SWT.NONE);
		btnUndoLast.setBounds(436, 237, 82, 25);
		btnUndoLast.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textQuery.setText(oldResult);
				result = oldResult;
			}
		});
		btnUndoLast.setText("Undo Last");

		Button btnEvaluate = new Button(composite, SWT.NONE);
		btnEvaluate.setBounds(523, 237, 66, 25);
		btnEvaluate.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings("rawtypes")
			@Override
			public void widgetSelected(SelectionEvent e) {


				tableResult.removeAll();
				result = textQuery.getText();
				Session session = gDao.getSession();
				session.beginTransaction();
				SQLQuery query = session.createSQLQuery(textQuery.getText()); //.addEntity(general.FileFunctionStatus.class); 
				query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				System.out.println(textQuery.getText());


				List results = query.list();
				System.out.println(results.size());

				
				tv.setInput(results);

//				for(Object o : results)
//				{
//					System.out.println(o.toString());
//					String [] attr  = o.toString().split(",");
//					for(String s : attr)
//					{
//						
//						tableResult.append(s);
//						tableResult.append("\n");
//					}
//					
//
//					//					textResult.append(o.toString()+"\n");
//					tableResult.append("\n");
//
//
//				}
			}
		});
		btnEvaluate.setText("Evaluate");

		textQuery = new Text(composite, SWT.BORDER);
		textQuery.setBounds(92, 303, 497, 21);




		textQuery.addKeyListener(new KeyAdapter() {
			@Override 
			public void keyPressed ( KeyEvent e) { 
				System.out.println("I'm in the key listener of textQuery");
				//				if(e.keyCode==SWT.CR)
				if (textQuery.getText().length() > 0 )
				{
					result = textQuery.getText();
				}
			} 
		});

		

//		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
//		gd_table.heightHint = 588;


		//		GridData gd_textResult = new GridData(SWT.FILL, SWT.TOP, true, true, 8, 1);
		//		gd_textResult.heightHint = 204;
		//		gd_textResult.widthHint = 231;
		//tableResult.setLayoutData(gd_textResult);

	}

	@Override
	public void setFocus() {
		//

	}

	@Override
	public void handleEvent(Event event) {


	}
}
