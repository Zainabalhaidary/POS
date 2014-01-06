/**
 */
package dao;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dao.DaoPackage
 * @generated
 */
public interface DaoFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DaoFactory eINSTANCE = dao.impl.DaoFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Generic Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic Dao</em>'.
	 * @generated
	 */
	GenericDao createGenericDao();

	/**
	 * Returns a new object of class '<em>Hibernate Util</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hibernate Util</em>'.
	 * @generated
	 */
	HibernateUtil createHibernateUtil();

	/**
	 * Returns a new object of class '<em>User Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Dao</em>'.
	 * @generated
	 */
	UserDao createUserDao();

	/**
	 * Returns a new object of class '<em>General Queries</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>General Queries</em>'.
	 * @generated
	 */
	GeneralQueries createGeneralQueries();

	/**
	 * Returns a new object of class '<em>Customer Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer Dao</em>'.
	 * @generated
	 */
	CustomerDao createCustomerDao();

	/**
	 * Returns a new object of class '<em>Product Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Product Dao</em>'.
	 * @generated
	 */
	ProductDao createProductDao();

	/**
	 * Returns a new object of class '<em>Category Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category Dao</em>'.
	 * @generated
	 */
	CategoryDao createCategoryDao();

	/**
	 * Returns a new object of class '<em>Supplier Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Supplier Dao</em>'.
	 * @generated
	 */
	SupplierDao createSupplierDao();

	/**
	 * Returns a new object of class '<em>Delivery Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delivery Dao</em>'.
	 * @generated
	 */
	DeliveryDao createDeliveryDao();

	/**
	 * Returns a new object of class '<em>Order Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Order Dao</em>'.
	 * @generated
	 */
	OrderDao createOrderDao();

	/**
	 * Returns a new object of class '<em>Shipper Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shipper Dao</em>'.
	 * @generated
	 */
	ShipperDao createShipperDao();

	/**
	 * Returns a new object of class '<em>Order Details Dao</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Order Details Dao</em>'.
	 * @generated
	 */
	OrderDetailsDao createOrderDetailsDao();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DaoPackage getDaoPackage();

} //DaoFactory
