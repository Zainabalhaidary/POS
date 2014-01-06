/**
 */
package dao;

import general.Category;
import general.Product;

import java.util.List;

import org.hibernate.Query;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getCategoryDao()
 * @model
 * @generated
 */
public interface CategoryDao extends GenericDao {
	public Category getByName(String name);
		

} // CategoryDao
