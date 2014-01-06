/**
 */
package dao;

import general.Product;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order Details Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getOrderDetailsDao()
 * @model
 * @generated
 */
public interface OrderDetailsDao extends GenericDao {
	Product getById(Product p );
} // OrderDetailsDao
