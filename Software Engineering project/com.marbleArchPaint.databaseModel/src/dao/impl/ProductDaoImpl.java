/**
 */
package dao.impl;

import java.util.List;

import general.Product;
import dao.DaoPackage;
import dao.ProductDao;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Product Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ProductDaoImpl extends GenericDaoImpl implements ProductDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProductDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.PRODUCT_DAO;
	}
	
	public Product getByName(String name) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + Product.class.getName()+" where productName = '"+name+ "'";
		Query queryRes = session.createQuery(string);
		List<?> resultList = queryRes.list();
		session.close();
		return (Product)resultList.get(0);
		
	}
	
	public List <Product> getBySKU(String sku){
		session = getSession();
		session.beginTransaction();
		//String string = "from " + Product.class.getName()+" where SKU = '"+sku+"'";
		String string = "from " + Product.class.getName()+" where SKU LIKE CONCAT('%', "+sku+", '%')";
		//CONCAT('%', :firstName, '%'))";
		Query queryRes = session.createQuery(string);
		List<Product> resultList = queryRes.list();
		System.out.println("result size is "+resultList.size());
		session.close();
		return resultList;
	}
	
	public List<Product> getBySKU2(String sku){
		session = getSession();
		session.beginTransaction();
		String string = "from " + Product.class.getName()+" where SKU = '"+sku+"'";
		//String string = "from " + Product.class.getName()+" where SKU LIKE CONCAT('%', "+sku+", '%')";
		//CONCAT('%', :firstName, '%'))";
		Query queryRes = session.createQuery(string);
		List<Product> resultList = queryRes.list();
		System.out.println("result size is "+resultList.size());
		session.close();
		return resultList;
	}

} //ProductDaoImpl
