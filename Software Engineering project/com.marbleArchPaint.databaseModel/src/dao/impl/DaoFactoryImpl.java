/**
 */
package dao.impl;

import dao.*;


import general.User;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("rawtypes")
public class DaoFactoryImpl extends EFactoryImpl implements DaoFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DaoFactory init() {
		try {
			DaoFactory theDaoFactory = (DaoFactory)EPackage.Registry.INSTANCE.getEFactory("http://dao/1.0"); 
			if (theDaoFactory != null) {
				return theDaoFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DaoFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DaoPackage.GENERIC_DAO: return createGenericDao();
			case DaoPackage.HIBERNATE_UTIL: return createHibernateUtil();
			case DaoPackage.USER_DAO: return createUserDao();
			case DaoPackage.GENERAL_QUERIES: return createGeneralQueries();
			case DaoPackage.CUSTOMER_DAO: return createCustomerDao();
			case DaoPackage.PRODUCT_DAO: return createProductDao();
			case DaoPackage.CATEGORY_DAO: return createCategoryDao();
			case DaoPackage.SUPPLIER_DAO: return createSupplierDao();
			case DaoPackage.DELIVERY_DAO: return createDeliveryDao();
			case DaoPackage.ORDER_DAO: return createOrderDao();
			case DaoPackage.SHIPPER_DAO: return createShipperDao();
			case DaoPackage.ORDER_DETAILS_DAO: return createOrderDetailsDao();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DaoPackage.LIST:
				return createListFromString(eDataType, initialValue);
			case DaoPackage.QUERY:
				return createQueryFromString(eDataType, initialValue);
			case DaoPackage.SESSION:
				return createSessionFromString(eDataType, initialValue);
			case DaoPackage.SESSION_FACTORY:
				return createSessionFactoryFromString(eDataType, initialValue);
			case DaoPackage.USER:
				return createUserFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DaoPackage.LIST:
				return convertListToString(eDataType, instanceValue);
			case DaoPackage.QUERY:
				return convertQueryToString(eDataType, instanceValue);
			case DaoPackage.SESSION:
				return convertSessionToString(eDataType, instanceValue);
			case DaoPackage.SESSION_FACTORY:
				return convertSessionFactoryToString(eDataType, instanceValue);
			case DaoPackage.USER:
				return convertUserToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericDao createGenericDao() {
		GenericDaoImpl genericDao = new GenericDaoImpl();
		return genericDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public HibernateUtil createHibernateUtil() {
		HibernateUtilImpl hibernateUtil = new HibernateUtilImpl();
		return hibernateUtil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDao createUserDao() {
		UserDaoImpl userDao = new UserDaoImpl();
		return userDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralQueries createGeneralQueries() {
		GeneralQueriesImpl generalQueries = new GeneralQueriesImpl();
		return generalQueries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerDao createCustomerDao() {
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		return customerDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductDao createProductDao() {
		ProductDaoImpl productDao = new ProductDaoImpl();
		return productDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryDao createCategoryDao() {
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		return categoryDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupplierDao createSupplierDao() {
		SupplierDaoImpl supplierDao = new SupplierDaoImpl();
		return supplierDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeliveryDao createDeliveryDao() {
		DeliveryDaoImpl deliveryDao = new DeliveryDaoImpl();
		return deliveryDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderDao createOrderDao() {
		OrderDaoImpl orderDao = new OrderDaoImpl();
		return orderDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShipperDao createShipperDao() {
		ShipperDaoImpl shipperDao = new ShipperDaoImpl();
		return shipperDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderDetailsDao createOrderDetailsDao() {
		OrderDetailsDaoImpl orderDetailsDao = new OrderDetailsDaoImpl();
		return orderDetailsDao;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List createListFromString(EDataType eDataType, String initialValue) {
		return (List)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQueryFromString(EDataType eDataType, String initialValue) {
		return (Query)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQueryToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Session createSessionFromString(EDataType eDataType, String initialValue) {
		return (Session)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSessionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SessionFactory createSessionFactoryFromString(EDataType eDataType, String initialValue) {
		return (SessionFactory)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSessionFactoryToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUserFromString(EDataType eDataType, String initialValue) {
		return (User)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUserToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoPackage getDaoPackage() {
		return (DaoPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DaoPackage getPackage() {
		return DaoPackage.eINSTANCE;
	}

	
	

} //DaoFactoryImpl
