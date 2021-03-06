/**
 */
package dao.impl;


import dao.CategoryDao;
import dao.CustomerDao;
import dao.DaoFactory;
import dao.DaoPackage;

import dao.DeliveryDao;
import dao.GeneralQueries;
import dao.GenericDao;
import dao.HibernateUtil;

import dao.OrderDao;
import dao.OrderDetailsDao;
import dao.ProductDao;
import dao.ShipperDao;
import dao.SupplierDao;
import dao.UserDao;




import general.User;


import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DaoPackageImpl extends EPackageImpl implements DaoPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hibernateUtilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalQueriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass productDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supplierDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deliveryDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shipperDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderDetailsDaoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType queryEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sessionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sessionFactoryEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType userEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dao.DaoPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DaoPackageImpl() {
		super(eNS_URI, DaoFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DaoPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DaoPackage init() {
		if (isInited) return (DaoPackage)EPackage.Registry.INSTANCE.getEPackage(DaoPackage.eNS_URI);

		// Obtain or create and register package
		DaoPackageImpl theDaoPackage = (DaoPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DaoPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DaoPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDaoPackage.createPackageContents();

		// Initialize created meta-data
		theDaoPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDaoPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DaoPackage.eNS_URI, theDaoPackage);
		return theDaoPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericDao() {
		return genericDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericDao_PersistentClass() {
		return (EAttribute)genericDaoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenericDao_Session() {
		return (EAttribute)genericDaoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHibernateUtil() {
		return hibernateUtilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHibernateUtil_SessionFactory() {
		return (EAttribute)hibernateUtilEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDao() {
		return userDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralQueries() {
		return generalQueriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomerDao() {
		return customerDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProductDao() {
		return productDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategoryDao() {
		return categoryDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupplierDao() {
		return supplierDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeliveryDao() {
		return deliveryDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderDao() {
		return orderDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShipperDao() {
		return shipperDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderDetailsDao() {
		return orderDetailsDaoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getList() {
		return listEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getQuery() {
		return queryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSession() {
		return sessionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSessionFactory() {
		return sessionFactoryEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUser() {
		return userEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoFactory getDaoFactory() {
		return (DaoFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		genericDaoEClass = createEClass(GENERIC_DAO);
		createEAttribute(genericDaoEClass, GENERIC_DAO__PERSISTENT_CLASS);
		createEAttribute(genericDaoEClass, GENERIC_DAO__SESSION);

		hibernateUtilEClass = createEClass(HIBERNATE_UTIL);
		createEAttribute(hibernateUtilEClass, HIBERNATE_UTIL__SESSION_FACTORY);

		userDaoEClass = createEClass(USER_DAO);

		generalQueriesEClass = createEClass(GENERAL_QUERIES);

		customerDaoEClass = createEClass(CUSTOMER_DAO);

		productDaoEClass = createEClass(PRODUCT_DAO);

		categoryDaoEClass = createEClass(CATEGORY_DAO);

		supplierDaoEClass = createEClass(SUPPLIER_DAO);

		deliveryDaoEClass = createEClass(DELIVERY_DAO);

		orderDaoEClass = createEClass(ORDER_DAO);

		shipperDaoEClass = createEClass(SHIPPER_DAO);

		orderDetailsDaoEClass = createEClass(ORDER_DETAILS_DAO);

		// Create data types
		listEDataType = createEDataType(LIST);
		queryEDataType = createEDataType(QUERY);
		sessionEDataType = createEDataType(SESSION);
		sessionFactoryEDataType = createEDataType(SESSION_FACTORY);
		userEDataType = createEDataType(USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		userDaoEClass.getESuperTypes().add(this.getGenericDao());
		generalQueriesEClass.getESuperTypes().add(this.getGenericDao());
		customerDaoEClass.getESuperTypes().add(this.getGenericDao());
		productDaoEClass.getESuperTypes().add(this.getGenericDao());
		categoryDaoEClass.getESuperTypes().add(this.getGenericDao());
		supplierDaoEClass.getESuperTypes().add(this.getGenericDao());
		deliveryDaoEClass.getESuperTypes().add(this.getGenericDao());
		orderDaoEClass.getESuperTypes().add(this.getGenericDao());
		shipperDaoEClass.getESuperTypes().add(this.getGenericDao());
		orderDetailsDaoEClass.getESuperTypes().add(this.getGenericDao());

		// Initialize classes and features; add operations and parameters
		initEClass(genericDaoEClass, GenericDao.class, "GenericDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getGenericDao_PersistentClass(), g1, "persistentClass", null, 0, 1, GenericDao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenericDao_Session(), this.getSession(), "session", "", 0, 1, GenericDao.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(genericDaoEClass, null, "create", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, this.getList(), "read", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "class_", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, null, "delete", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, this.getList(), "getByQuery", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "query", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, ecorePackage.getEJavaObject(), "getById", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, this.getList(), "getList", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "class_", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, this.getList(), "getListByOwner", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "class_", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUser(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(genericDaoEClass, ecorePackage.getEBoolean(), "massInsert", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getList(), "list", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "class_", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hibernateUtilEClass, HibernateUtil.class, "HibernateUtil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHibernateUtil_SessionFactory(), this.getSessionFactory(), "sessionFactory", null, 0, 1, HibernateUtil.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDaoEClass, UserDao.class, "UserDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(userDaoEClass, this.getUser(), "findByUsername", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUser(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(generalQueriesEClass, GeneralQueries.class, "GeneralQueries", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(generalQueriesEClass, ecorePackage.getEBoolean(), "dbAlive", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(customerDaoEClass, CustomerDao.class, "CustomerDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(productDaoEClass, ProductDao.class, "ProductDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(categoryDaoEClass, CategoryDao.class, "CategoryDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(supplierDaoEClass, SupplierDao.class, "SupplierDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deliveryDaoEClass, DeliveryDao.class, "DeliveryDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orderDaoEClass, OrderDao.class, "OrderDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shipperDaoEClass, ShipperDao.class, "ShipperDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orderDetailsDaoEClass, OrderDetailsDao.class, "OrderDetailsDao", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(listEDataType, List.class, "List", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(queryEDataType, Query.class, "Query", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(sessionEDataType, Session.class, "Session", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(sessionFactoryEDataType, SessionFactory.class, "SessionFactory", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(userEDataType, User.class, "User", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DaoPackageImpl
