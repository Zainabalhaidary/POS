/**
 */
package dao;

import java.util.List;

import general.Product;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Product Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getProductDao()
 * @model
 * @generated
 */
public interface ProductDao extends GenericDao {
	public Product getByName(String name);
	public List <Product> getBySKU(String sku);
	public List <Product>getBySKU2(String sku);
} // ProductDao
