/**
 */
package dao.impl;

import general.Category;
import general.Product;

import java.util.List;

import dao.CategoryDao;
import dao.DaoPackage;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CategoryDaoImpl extends GenericDaoImpl implements CategoryDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategoryDaoImpl() {
		super();
	}
	
	public Category getByName(String name) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + Category.class.getName()+" where categoryName =:"+name;
		Query queryRes = session.createQuery(string);
		List<?> resultList = queryRes.list();
		session.close();
		return (Category)resultList.get(0);
		
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.CATEGORY_DAO;
	}

} //CategoryDaoImpl
