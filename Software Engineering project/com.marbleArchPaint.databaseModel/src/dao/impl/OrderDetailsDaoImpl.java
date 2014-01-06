/**
 */
package dao.impl;

import java.util.List;

import general.Order;
import general.Product;
import dao.DaoPackage;
import dao.OrderDetailsDao;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Order Details Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrderDetailsDaoImpl extends GenericDaoImpl implements OrderDetailsDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderDetailsDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.ORDER_DETAILS_DAO;
	}
	
	public Product getById(Product p ){
		session = getSession();
		session.beginTransaction();
		
		String string;

		
		string = "from " + Product.class.getName().toString() + 
				" where productId = '" +p.getProductId()+"'";
		Query queryRes = session.createQuery(string);
		
		@SuppressWarnings("unchecked")
		List<Product> resultList = queryRes.list();
		
		session.close();
		return resultList.get(0);
	}

} //OrderDetailsDaoImpl
