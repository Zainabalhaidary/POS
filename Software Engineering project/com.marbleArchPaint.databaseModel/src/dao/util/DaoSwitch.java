/**
 */
package dao.util;

import dao.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see dao.DaoPackage
 * @generated
 */
public class DaoSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DaoPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoSwitch() {
		if (modelPackage == null) {
			modelPackage = DaoPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DaoPackage.GENERIC_DAO: {
				GenericDao genericDao = (GenericDao)theEObject;
				T result = caseGenericDao(genericDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.HIBERNATE_UTIL: {
				HibernateUtil hibernateUtil = (HibernateUtil)theEObject;
				T result = caseHibernateUtil(hibernateUtil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.USER_DAO: {
				UserDao userDao = (UserDao)theEObject;
				T result = caseUserDao(userDao);
				if (result == null) result = caseGenericDao(userDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.GENERAL_QUERIES: {
				GeneralQueries generalQueries = (GeneralQueries)theEObject;
				T result = caseGeneralQueries(generalQueries);
				if (result == null) result = caseGenericDao(generalQueries);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.CUSTOMER_DAO: {
				CustomerDao customerDao = (CustomerDao)theEObject;
				T result = caseCustomerDao(customerDao);
				if (result == null) result = caseGenericDao(customerDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.PRODUCT_DAO: {
				ProductDao productDao = (ProductDao)theEObject;
				T result = caseProductDao(productDao);
				if (result == null) result = caseGenericDao(productDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.CATEGORY_DAO: {
				CategoryDao categoryDao = (CategoryDao)theEObject;
				T result = caseCategoryDao(categoryDao);
				if (result == null) result = caseGenericDao(categoryDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.SUPPLIER_DAO: {
				SupplierDao supplierDao = (SupplierDao)theEObject;
				T result = caseSupplierDao(supplierDao);
				if (result == null) result = caseGenericDao(supplierDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.DELIVERY_DAO: {
				DeliveryDao deliveryDao = (DeliveryDao)theEObject;
				T result = caseDeliveryDao(deliveryDao);
				if (result == null) result = caseGenericDao(deliveryDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.ORDER_DAO: {
				OrderDao orderDao = (OrderDao)theEObject;
				T result = caseOrderDao(orderDao);
				if (result == null) result = caseGenericDao(orderDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.SHIPPER_DAO: {
				ShipperDao shipperDao = (ShipperDao)theEObject;
				T result = caseShipperDao(shipperDao);
				if (result == null) result = caseGenericDao(shipperDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DaoPackage.ORDER_DETAILS_DAO: {
				OrderDetailsDao orderDetailsDao = (OrderDetailsDao)theEObject;
				T result = caseOrderDetailsDao(orderDetailsDao);
				if (result == null) result = caseGenericDao(orderDetailsDao);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericDao(GenericDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hibernate Util</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hibernate Util</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHibernateUtil(HibernateUtil object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserDao(UserDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>General Queries</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>General Queries</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralQueries(GeneralQueries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Customer Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Customer Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomerDao(CustomerDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProductDao(ProductDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategoryDao(CategoryDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Supplier Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Supplier Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSupplierDao(SupplierDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delivery Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delivery Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeliveryDao(DeliveryDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Order Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Order Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderDao(OrderDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shipper Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shipper Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShipperDao(ShipperDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Order Details Dao</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Order Details Dao</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderDetailsDao(OrderDetailsDao object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DaoSwitch
