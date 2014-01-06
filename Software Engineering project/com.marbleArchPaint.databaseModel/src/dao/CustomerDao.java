/**
 */
package dao;

import general.Customer;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getCustomerDao()
 * @model
 * @generated
 */
public interface CustomerDao extends GenericDao {
	
	@Override
	public Customer getById(String id);
} // CustomerDao
