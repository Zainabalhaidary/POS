/**
 */
package dao;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dao.DaoFactory
 * @model kind="package"
 * @generated
 */
public interface DaoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dao";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://dao/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dao";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DaoPackage eINSTANCE = dao.impl.DaoPackageImpl.init();

	/**
	 * The meta object id for the '{@link dao.impl.GenericDaoImpl <em>Generic Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.GenericDaoImpl
	 * @see dao.impl.DaoPackageImpl#getGenericDao()
	 * @generated
	 */
	int GENERIC_DAO = 0;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DAO__PERSISTENT_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DAO__SESSION = 1;

	/**
	 * The number of structural features of the '<em>Generic Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_DAO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dao.impl.HibernateUtilImpl <em>Hibernate Util</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.HibernateUtilImpl
	 * @see dao.impl.DaoPackageImpl#getHibernateUtil()
	 * @generated
	 */
	int HIBERNATE_UTIL = 1;

	/**
	 * The feature id for the '<em><b>Session Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIBERNATE_UTIL__SESSION_FACTORY = 0;

	/**
	 * The number of structural features of the '<em>Hibernate Util</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIBERNATE_UTIL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dao.impl.UserDaoImpl <em>User Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.UserDaoImpl
	 * @see dao.impl.DaoPackageImpl#getUserDao()
	 * @generated
	 */
	int USER_DAO = 2;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>User Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.GeneralQueriesImpl <em>General Queries</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.GeneralQueriesImpl
	 * @see dao.impl.DaoPackageImpl#getGeneralQueries()
	 * @generated
	 */
	int GENERAL_QUERIES = 3;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_QUERIES__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_QUERIES__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>General Queries</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_QUERIES_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.CustomerDaoImpl <em>Customer Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.CustomerDaoImpl
	 * @see dao.impl.DaoPackageImpl#getCustomerDao()
	 * @generated
	 */
	int CUSTOMER_DAO = 4;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Customer Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.ProductDaoImpl <em>Product Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.ProductDaoImpl
	 * @see dao.impl.DaoPackageImpl#getProductDao()
	 * @generated
	 */
	int PRODUCT_DAO = 5;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Product Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.CategoryDaoImpl <em>Category Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.CategoryDaoImpl
	 * @see dao.impl.DaoPackageImpl#getCategoryDao()
	 * @generated
	 */
	int CATEGORY_DAO = 6;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Category Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.SupplierDaoImpl <em>Supplier Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.SupplierDaoImpl
	 * @see dao.impl.DaoPackageImpl#getSupplierDao()
	 * @generated
	 */
	int SUPPLIER_DAO = 7;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Supplier Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.DeliveryDaoImpl <em>Delivery Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.DeliveryDaoImpl
	 * @see dao.impl.DaoPackageImpl#getDeliveryDao()
	 * @generated
	 */
	int DELIVERY_DAO = 8;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Delivery Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.OrderDaoImpl <em>Order Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.OrderDaoImpl
	 * @see dao.impl.DaoPackageImpl#getOrderDao()
	 * @generated
	 */
	int ORDER_DAO = 9;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Order Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.ShipperDaoImpl <em>Shipper Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.ShipperDaoImpl
	 * @see dao.impl.DaoPackageImpl#getShipperDao()
	 * @generated
	 */
	int SHIPPER_DAO = 10;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIPPER_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIPPER_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Shipper Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIPPER_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dao.impl.OrderDetailsDaoImpl <em>Order Details Dao</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dao.impl.OrderDetailsDaoImpl
	 * @see dao.impl.DaoPackageImpl#getOrderDetailsDao()
	 * @generated
	 */
	int ORDER_DETAILS_DAO = 11;

	/**
	 * The feature id for the '<em><b>Persistent Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS_DAO__PERSISTENT_CLASS = GENERIC_DAO__PERSISTENT_CLASS;

	/**
	 * The feature id for the '<em><b>Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS_DAO__SESSION = GENERIC_DAO__SESSION;

	/**
	 * The number of structural features of the '<em>Order Details Dao</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS_DAO_FEATURE_COUNT = GENERIC_DAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see dao.impl.DaoPackageImpl#getList()
	 * @generated
	 */
	int LIST = 12;

	/**
	 * The meta object id for the '<em>Query</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hibernate.Query
	 * @see dao.impl.DaoPackageImpl#getQuery()
	 * @generated
	 */
	int QUERY = 13;

	/**
	 * The meta object id for the '<em>Session</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hibernate.Session
	 * @see dao.impl.DaoPackageImpl#getSession()
	 * @generated
	 */
	int SESSION = 14;

	/**
	 * The meta object id for the '<em>Session Factory</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hibernate.SessionFactory
	 * @see dao.impl.DaoPackageImpl#getSessionFactory()
	 * @generated
	 */
	int SESSION_FACTORY = 15;

	/**
	 * The meta object id for the '<em>User</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.User
	 * @see dao.impl.DaoPackageImpl#getUser()
	 * @generated
	 */
	int USER = 16;


	/**
	 * Returns the meta object for class '{@link dao.GenericDao <em>Generic Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Dao</em>'.
	 * @see dao.GenericDao
	 * @generated
	 */
	EClass getGenericDao();

	/**
	 * Returns the meta object for the attribute '{@link dao.GenericDao#getPersistentClass <em>Persistent Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistent Class</em>'.
	 * @see dao.GenericDao#getPersistentClass()
	 * @see #getGenericDao()
	 * @generated
	 */
	EAttribute getGenericDao_PersistentClass();

	/**
	 * Returns the meta object for the attribute '{@link dao.GenericDao#getSession <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Session</em>'.
	 * @see dao.GenericDao#getSession()
	 * @see #getGenericDao()
	 * @generated
	 */
	EAttribute getGenericDao_Session();

	/**
	 * Returns the meta object for class '{@link dao.HibernateUtil <em>Hibernate Util</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hibernate Util</em>'.
	 * @see dao.HibernateUtil
	 * @generated
	 */
	EClass getHibernateUtil();

	/**
	 * Returns the meta object for the attribute '{@link dao.HibernateUtil#getSessionFactory <em>Session Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Session Factory</em>'.
	 * @see dao.HibernateUtil#getSessionFactory()
	 * @see #getHibernateUtil()
	 * @generated
	 */
	EAttribute getHibernateUtil_SessionFactory();

	/**
	 * Returns the meta object for class '{@link dao.UserDao <em>User Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Dao</em>'.
	 * @see dao.UserDao
	 * @generated
	 */
	EClass getUserDao();

	/**
	 * Returns the meta object for class '{@link dao.GeneralQueries <em>General Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>General Queries</em>'.
	 * @see dao.GeneralQueries
	 * @generated
	 */
	EClass getGeneralQueries();

	/**
	 * Returns the meta object for class '{@link dao.CustomerDao <em>Customer Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer Dao</em>'.
	 * @see dao.CustomerDao
	 * @generated
	 */
	EClass getCustomerDao();

	/**
	 * Returns the meta object for class '{@link dao.ProductDao <em>Product Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product Dao</em>'.
	 * @see dao.ProductDao
	 * @generated
	 */
	EClass getProductDao();

	/**
	 * Returns the meta object for class '{@link dao.CategoryDao <em>Category Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category Dao</em>'.
	 * @see dao.CategoryDao
	 * @generated
	 */
	EClass getCategoryDao();

	/**
	 * Returns the meta object for class '{@link dao.SupplierDao <em>Supplier Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supplier Dao</em>'.
	 * @see dao.SupplierDao
	 * @generated
	 */
	EClass getSupplierDao();

	/**
	 * Returns the meta object for class '{@link dao.DeliveryDao <em>Delivery Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delivery Dao</em>'.
	 * @see dao.DeliveryDao
	 * @generated
	 */
	EClass getDeliveryDao();

	/**
	 * Returns the meta object for class '{@link dao.OrderDao <em>Order Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order Dao</em>'.
	 * @see dao.OrderDao
	 * @generated
	 */
	EClass getOrderDao();

	/**
	 * Returns the meta object for class '{@link dao.ShipperDao <em>Shipper Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shipper Dao</em>'.
	 * @see dao.ShipperDao
	 * @generated
	 */
	EClass getShipperDao();

	/**
	 * Returns the meta object for class '{@link dao.OrderDetailsDao <em>Order Details Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order Details Dao</em>'.
	 * @see dao.OrderDetailsDao
	 * @generated
	 */
	EClass getOrderDetailsDao();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 * @generated
	 */
	EDataType getList();

	/**
	 * Returns the meta object for data type '{@link org.hibernate.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Query</em>'.
	 * @see org.hibernate.Query
	 * @model instanceClass="org.hibernate.Query"
	 * @generated
	 */
	EDataType getQuery();

	/**
	 * Returns the meta object for data type '{@link org.hibernate.Session <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Session</em>'.
	 * @see org.hibernate.Session
	 * @model instanceClass="org.hibernate.Session"
	 * @generated
	 */
	EDataType getSession();

	/**
	 * Returns the meta object for data type '{@link org.hibernate.SessionFactory <em>Session Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Session Factory</em>'.
	 * @see org.hibernate.SessionFactory
	 * @model instanceClass="org.hibernate.SessionFactory"
	 * @generated
	 */
	EDataType getSessionFactory();

	/**
	 * Returns the meta object for data type '{@link general.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>User</em>'.
	 * @see general.User
	 * @model instanceClass="general.User"
	 * @generated
	 */
	EDataType getUser();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DaoFactory getDaoFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dao.impl.GenericDaoImpl <em>Generic Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.GenericDaoImpl
		 * @see dao.impl.DaoPackageImpl#getGenericDao()
		 * @generated
		 */
		EClass GENERIC_DAO = eINSTANCE.getGenericDao();

		/**
		 * The meta object literal for the '<em><b>Persistent Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_DAO__PERSISTENT_CLASS = eINSTANCE.getGenericDao_PersistentClass();

		/**
		 * The meta object literal for the '<em><b>Session</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERIC_DAO__SESSION = eINSTANCE.getGenericDao_Session();

		/**
		 * The meta object literal for the '{@link dao.impl.HibernateUtilImpl <em>Hibernate Util</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.HibernateUtilImpl
		 * @see dao.impl.DaoPackageImpl#getHibernateUtil()
		 * @generated
		 */
		EClass HIBERNATE_UTIL = eINSTANCE.getHibernateUtil();

		/**
		 * The meta object literal for the '<em><b>Session Factory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HIBERNATE_UTIL__SESSION_FACTORY = eINSTANCE.getHibernateUtil_SessionFactory();

		/**
		 * The meta object literal for the '{@link dao.impl.UserDaoImpl <em>User Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.UserDaoImpl
		 * @see dao.impl.DaoPackageImpl#getUserDao()
		 * @generated
		 */
		EClass USER_DAO = eINSTANCE.getUserDao();

		/**
		 * The meta object literal for the '{@link dao.impl.GeneralQueriesImpl <em>General Queries</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.GeneralQueriesImpl
		 * @see dao.impl.DaoPackageImpl#getGeneralQueries()
		 * @generated
		 */
		EClass GENERAL_QUERIES = eINSTANCE.getGeneralQueries();

		/**
		 * The meta object literal for the '{@link dao.impl.CustomerDaoImpl <em>Customer Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.CustomerDaoImpl
		 * @see dao.impl.DaoPackageImpl#getCustomerDao()
		 * @generated
		 */
		EClass CUSTOMER_DAO = eINSTANCE.getCustomerDao();

		/**
		 * The meta object literal for the '{@link dao.impl.ProductDaoImpl <em>Product Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.ProductDaoImpl
		 * @see dao.impl.DaoPackageImpl#getProductDao()
		 * @generated
		 */
		EClass PRODUCT_DAO = eINSTANCE.getProductDao();

		/**
		 * The meta object literal for the '{@link dao.impl.CategoryDaoImpl <em>Category Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.CategoryDaoImpl
		 * @see dao.impl.DaoPackageImpl#getCategoryDao()
		 * @generated
		 */
		EClass CATEGORY_DAO = eINSTANCE.getCategoryDao();

		/**
		 * The meta object literal for the '{@link dao.impl.SupplierDaoImpl <em>Supplier Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.SupplierDaoImpl
		 * @see dao.impl.DaoPackageImpl#getSupplierDao()
		 * @generated
		 */
		EClass SUPPLIER_DAO = eINSTANCE.getSupplierDao();

		/**
		 * The meta object literal for the '{@link dao.impl.DeliveryDaoImpl <em>Delivery Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.DeliveryDaoImpl
		 * @see dao.impl.DaoPackageImpl#getDeliveryDao()
		 * @generated
		 */
		EClass DELIVERY_DAO = eINSTANCE.getDeliveryDao();

		/**
		 * The meta object literal for the '{@link dao.impl.OrderDaoImpl <em>Order Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.OrderDaoImpl
		 * @see dao.impl.DaoPackageImpl#getOrderDao()
		 * @generated
		 */
		EClass ORDER_DAO = eINSTANCE.getOrderDao();

		/**
		 * The meta object literal for the '{@link dao.impl.ShipperDaoImpl <em>Shipper Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.ShipperDaoImpl
		 * @see dao.impl.DaoPackageImpl#getShipperDao()
		 * @generated
		 */
		EClass SHIPPER_DAO = eINSTANCE.getShipperDao();

		/**
		 * The meta object literal for the '{@link dao.impl.OrderDetailsDaoImpl <em>Order Details Dao</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dao.impl.OrderDetailsDaoImpl
		 * @see dao.impl.DaoPackageImpl#getOrderDetailsDao()
		 * @generated
		 */
		EClass ORDER_DETAILS_DAO = eINSTANCE.getOrderDetailsDao();

		/**
		 * The meta object literal for the '<em>List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see dao.impl.DaoPackageImpl#getList()
		 * @generated
		 */
		EDataType LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '<em>Query</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hibernate.Query
		 * @see dao.impl.DaoPackageImpl#getQuery()
		 * @generated
		 */
		EDataType QUERY = eINSTANCE.getQuery();

		/**
		 * The meta object literal for the '<em>Session</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hibernate.Session
		 * @see dao.impl.DaoPackageImpl#getSession()
		 * @generated
		 */
		EDataType SESSION = eINSTANCE.getSession();

		/**
		 * The meta object literal for the '<em>Session Factory</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hibernate.SessionFactory
		 * @see dao.impl.DaoPackageImpl#getSessionFactory()
		 * @generated
		 */
		EDataType SESSION_FACTORY = eINSTANCE.getSessionFactory();

		/**
		 * The meta object literal for the '<em>User</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.User
		 * @see dao.impl.DaoPackageImpl#getUser()
		 * @generated
		 */
		EDataType USER = eINSTANCE.getUser();

	}

} //DaoPackage
