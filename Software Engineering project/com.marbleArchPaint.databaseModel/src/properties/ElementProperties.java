package properties;


import general.Customer;
import general.Order;
import general.Product;
import general.Shipper;
import general.User;

import java.text.DateFormat;
import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;

import dao.CustomerDao;
import dao.DaoFactory;
import dao.GenericDao;

public class ElementProperties implements IPropertySource {

	final protected EObject element; 

	private IPropertyDescriptor[] propertyDescriptors;
	//	private String[] literals;

	//	private String[] aQualityCriteria;
	//	private String[] aDocumentType;
	private String[] aOther;
	//	private String[] aConnectionType;

	public ElementProperties ( EObject element) {
		super();
		this.element = element;
		initProperties();
	}

	private void initProperties() {	}

	@Override
	public Object getEditableValue() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 * Descriptors for property view are created here
	 * differentiation between:
	 * - String
	 * - Date
	 * - Boolean
	 * - ENUM
	 */

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		java.util.List<IPropertyDescriptor> descriptors = new java.util.ArrayList<IPropertyDescriptor>();

		for ( EAttribute attribute : element.eClass().getEAllAttributes() ) {
			System.err.println("in getPropertyDescriptor attribute.getEType() is "+ attribute.getEType());
			if ( attribute.getEType().getName().equals("EString") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add( (IPropertyDescriptor)desc );

				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}
					});
					descriptors.add( (IPropertyDescriptor)desc );
				}

			} 
			else if (attribute.getEType().getName().equals("Date")) {
				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {

						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );

				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {

						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}
			}



			else if ( attribute.getEType().getName().equals("EBoolean") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : element.toString()
									.equals("1") ? "false" : "true";//$NON-NLS-1$
						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new ComboBoxPropertyDescriptor ( 
							attribute, attribute.getName(),  new String[] { "true", "false" } );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : element.toString()
									.equals("1") ? "false" : "true";//$NON-NLS-1$
						}
						public Image getImage(Object element) {
							return getGroupReadWriteImage ();
						}
					});
					descriptors.add(desc);
				}

			}
			else if ( attribute.getEType().getName().equals("EDouble") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : Double.toString((Double)element);

						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {

						public String getText(Object element) {
							return Double.toString((Double)element);
						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("EInt") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : Integer.toString((Integer)element);

						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {

						public String getText(Object element) {
							return element == null ? "" : Integer.toString((Integer)element);

						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("Customer") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : ((Customer)element).getFirstName()+" "+((Customer)element).getLastName();

						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {

						public String getText(Object element) {
							return element == null ? "" : ((Customer)element).getFirstName()+" "+((Customer)element).getLastName();

						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("Shipper") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : ((Shipper)element).getCompanyName();

						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : ((Shipper)element).getCompanyName();

						}

						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("User") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : ((User)element).getUsername();

						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {

						public String getText(Object element) {
							return element == null ? "" : ((User)element).getUsername();

						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("Product") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : ((Product)element).getProductName();
						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : ((Product)element).getProductName();
						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("Order") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : ((Order)element).getOrderId();
						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : ((Order)element).getOrderId();
						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}
		}
//		System.err.println("size is "+element.eClass().getEAllReferences().size());

		for(EReference attribute : element.eClass().getEAllReferences())
		{
			System.err.println("in getPropertyDescriptor yaaaaa raaaab is "+ attribute.getEType());

			if ( attribute.getEType().getName().equals("Customer") ) {

				if ( attribute.isUnsettable()  ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : (String)element;//((Customer)element).getFirstName()+" "+((Customer)element).getLastName();

						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {

						public String getText(Object element) {
							return element == null ? "" : (String)element;//((Customer)element).getFirstName()+" "+((Customer)element).getLastName();

						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("Shipper") ) {

				if ( attribute.isUnsettable()  ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : (String)element;//((Shipper)element).getCompanyName();

						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" :(String)element; //((Shipper)element).getCompanyName();

						}

						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("User") ) {

				if ( attribute.isUnsettable() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" :(String)element; //((User)element).getUsername();

						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {

						public String getText(Object element) {
							return element == null ? "" : (String)element;//(String)element; //((User)element).getUsername();

						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("Product") ) {

				if ( attribute.isUnsettable() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : (String)element;//((Product)element).getProductName();
						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : (String)element;//((Product)element).getProductName();
						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

			else if ( attribute.getEType().getName().equals("Order") ) {

				if ( attribute.isUnsettable()  ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : (String)element;//((Order)element).getOrderId();
						}
						public Image getImage(Object element) {
							return getReadOnlyImage ();
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );

					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : (String)element;//((Order)element).getOrderId();
						}
						public Image getImage(Object element) {
							return getReadWriteImage ();
						}

					});

					descriptors.add( (IPropertyDescriptor)desc );
				}

			}

		}

		propertyDescriptors = new IPropertyDescriptor[ descriptors.size() ];

		for ( int i = 0 ; i < descriptors.size(); i++ ) {
			propertyDescriptors[i] = descriptors.get(i);
		}

		return  propertyDescriptors;
	}

	// responsible for filling the value column
	@Override
	public Object getPropertyValue(Object id) {

		/*
		 * iterate through every attribute available for the element
		 * differentiation required for String, Date, Boolean, Enum
		 */
		
		for ( EAttribute a : element.eClass().getEAllAttributes() ) {
			System.err.println("in getpropertyvalue a.getName is "+a.getName());
			try{
			// first we check if its the correct attribute
			if ( a.getName().equals(((EAttribute)id).getName()) ) {


				if ( a.getEType().getName().equals("EBoolean") ) {

					// its a boolean

					return (element.eGet(a).toString().equals("true")) ? new Integer(0) : new Integer(1);

				} 
				else if ( a.getEType().getInstanceClassName().equals("java.util.Date") ) {

					// its a date

					if (element.eGet(a) == null ) {
						return "-";
					} else
						return DateFormat.getDateTimeInstance( DateFormat.SHORT, 
								DateFormat.SHORT).format((Date)element.eGet(a));
				}
				else if ( a.equals(id)) {
					// its a String or something else entirely
					if ( a.getName().equals("password") ) {
						// hiding passwords from properties by entering a hashcode
						return element.eGet(a) == null ? "" : "-hidden-";
					}

					return element.eGet(a) == null ? "" : element.eGet(a);

				}
				else if ( a.getEType().getName().equals("EDouble") ) {

					// its a boolean
					//System.ee.println();
					return element.eGet(a) == null ? "" : element.eGet(a);

				} 
				else if ( a.getEType().getName().equals("EInt") ) {

					// its a boolean
					//System.ee.println();
					return element.eGet(a) == null ? "" : element.eGet(a);

				} 
		

			}
			}catch(Exception e)
			{
				//e.printStackTrace();
			}

		}

		for ( EReference a : element.eClass().getEAllReferences() ) {
			System.err.println("in getpropertyvalue a.getName is "+a.getEType());
			if ( a.getEType().getName().equals("Customer") ) {

				// its a boolean
				//System.ee.println();
//				CustomerDao cDao = DaoFactory.eINSTANCE.createCustomerDao();
//				Customer c = cDao.getById(element.eGet(a).toString());
//				return element.eGet(a) == null ? "" : c.getFirstName() + " "+ c.getLastName();//element.eGet(a);
//				System.out.println(((Customer)element.eGet(a)).getFirstName());
				return element.eGet(a) == null ? "" : ((Customer)element.eGet(a)).getCustomerId();
			}
			else if ( a.getEType().getName().equals("Shipper") ) {

				// its a boolean
				//System.ee.println();
				return element.eGet(a) == null ? "" : element.eGet(a);

			}
			else if ( a.getEType().getName().equals("User") ) {

				// its a boolean
				//System.ee.println();
				return element.eGet(a) == null ? "" : element.eGet(a);

			}
			else if ( a.getEType().getName().equals("Product") ) {

				// its a boolean
				//System.ee.println();
				return element.eGet(a) == null ? "" : element.eGet(a);

			}
			else if ( a.getEType().getName().equals("Order") ) {

				// its a boolean
				//System.ee.println();
				return element.eGet(a) == null ? "" : ((Order)element.eGet(a)).getOrderId();

			}



		}

//		System.out.println("I should never get here");
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
	 * 
	 */
	@Override
	public void setPropertyValue(Object id, Object value) {

		for ( EAttribute a : element.eClass().getEAllAttributes() ) {

//			System.err.println("in set property value a.getName is "+a.getName());

			// first we check if its the correct attribute
			if ( a.getName().equals(((EAttribute)id).getName()) ) {

				if ( a.getEType().getName().equals("EBoolean") ) {
					element.eSet(a, (Integer)value == 0 ? true : false );
				} 

				else if ( a.getEType() instanceof EEnum) {

					EEnum eenum = (EEnum) a.getEType();


					// its of type 'other'
					element.eSet(a, aOther[(Integer) value]);


				}
				else if ( a.getEType().getInstanceClassName().equals("java.util.Date") ) {

					// its a date
					if ( value instanceof Date )
						element.eSet(a, value);

				}

				else if ( a.equals(id)) {

					element.eSet(a, value);

				}

			}

		}
		GenericDao sDao = DaoFactory.eINSTANCE.createGenericDao();
		sDao.update(element);
	}

	private Image getReadOnlyImage () {
		return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_OBJS_INFO_TSK);
	}

	private Image getReadWriteImage () {
		return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_DEF_VIEW);
	}

	private Image getGroupReadWriteImage () {
		return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}

	@SuppressWarnings("unused")
	private Image getFFSStatusImage () {
		return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_TOOL_FORWARD);
	}

}
