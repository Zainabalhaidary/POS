/**
 */
package dao.impl;

import general.Customer;
import general.Product;

import java.util.List;

import dao.CustomerDao;
import dao.DaoPackage;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customer Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CustomerDaoImpl extends GenericDaoImpl implements CustomerDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.CUSTOMER_DAO;
	}
	@Override
	public Customer getById(String id) {

		session = getSession();
		session.beginTransaction();
		String string = "from " + Customer.class.getName()+" where  = '"+id+ "'";
		Query queryRes = session.createQuery(string);
		List<?> resultList = queryRes.list();
		session.close();
		return (Customer)resultList.get(0);
	}

} //CustomerDaoImpl
