/**
 */
package dao;

import java.util.List;

import general.Order;
import general.OrderDetails;
import general.Product;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order Dao</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see dao.DaoPackage#getOrderDao()
 * @model
 * @generated
 */
public interface OrderDao extends GenericDao {
	
	public List <OrderDetails> getListOfOrderDetails(Order o);
	public List<Order> unhold ();
	public Order getLastReceipt();
	public boolean findOrderDetails(Order o, Product p);
} // OrderDao
