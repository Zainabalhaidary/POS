/**
 */
package dao.util;

import dao.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dao.DaoPackage
 * @generated
 */
public class DaoAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DaoPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DaoAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DaoPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DaoSwitch<Adapter> modelSwitch =
		new DaoSwitch<Adapter>() {
			@Override
			public Adapter caseGenericDao(GenericDao object) {
				return createGenericDaoAdapter();
			}
			@Override
			public Adapter caseHibernateUtil(HibernateUtil object) {
				return createHibernateUtilAdapter();
			}
			@Override
			public Adapter caseUserDao(UserDao object) {
				return createUserDaoAdapter();
			}
			@Override
			public Adapter caseGeneralQueries(GeneralQueries object) {
				return createGeneralQueriesAdapter();
			}
			@Override
			public Adapter caseCustomerDao(CustomerDao object) {
				return createCustomerDaoAdapter();
			}
			@Override
			public Adapter caseProductDao(ProductDao object) {
				return createProductDaoAdapter();
			}
			@Override
			public Adapter caseCategoryDao(CategoryDao object) {
				return createCategoryDaoAdapter();
			}
			@Override
			public Adapter caseSupplierDao(SupplierDao object) {
				return createSupplierDaoAdapter();
			}
			@Override
			public Adapter caseDeliveryDao(DeliveryDao object) {
				return createDeliveryDaoAdapter();
			}
			@Override
			public Adapter caseOrderDao(OrderDao object) {
				return createOrderDaoAdapter();
			}
			@Override
			public Adapter caseShipperDao(ShipperDao object) {
				return createShipperDaoAdapter();
			}
			@Override
			public Adapter caseOrderDetailsDao(OrderDetailsDao object) {
				return createOrderDetailsDaoAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link dao.GenericDao <em>Generic Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.GenericDao
	 * @generated
	 */
	public Adapter createGenericDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.HibernateUtil <em>Hibernate Util</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.HibernateUtil
	 * @generated
	 */
	public Adapter createHibernateUtilAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.UserDao <em>User Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.UserDao
	 * @generated
	 */
	public Adapter createUserDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.GeneralQueries <em>General Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.GeneralQueries
	 * @generated
	 */
	public Adapter createGeneralQueriesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.CustomerDao <em>Customer Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.CustomerDao
	 * @generated
	 */
	public Adapter createCustomerDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.ProductDao <em>Product Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.ProductDao
	 * @generated
	 */
	public Adapter createProductDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.CategoryDao <em>Category Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.CategoryDao
	 * @generated
	 */
	public Adapter createCategoryDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.SupplierDao <em>Supplier Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.SupplierDao
	 * @generated
	 */
	public Adapter createSupplierDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.DeliveryDao <em>Delivery Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.DeliveryDao
	 * @generated
	 */
	public Adapter createDeliveryDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.OrderDao <em>Order Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.OrderDao
	 * @generated
	 */
	public Adapter createOrderDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.ShipperDao <em>Shipper Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.ShipperDao
	 * @generated
	 */
	public Adapter createShipperDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dao.OrderDetailsDao <em>Order Details Dao</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dao.OrderDetailsDao
	 * @generated
	 */
	public Adapter createOrderDetailsDaoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DaoAdapterFactory
