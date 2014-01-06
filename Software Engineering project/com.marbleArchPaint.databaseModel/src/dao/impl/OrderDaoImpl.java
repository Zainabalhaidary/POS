/**
 */
package dao.impl;

import general.Order;
import general.OrderDetails;
import general.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dao.DaoPackage;
import dao.OrderDao;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Order Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrderDaoImpl extends GenericDaoImpl implements OrderDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.ORDER_DAO;
	}
	
	public List <OrderDetails> getListOfOrderDetails(Order o){
		session = getSession();
		session.beginTransaction();
		
		String string;

		
		string = "from " + OrderDetails.class.getName().toString() + 
				" where orderId = '"+o.getOrderId()+"'";
		Query queryRes = session.createQuery(string);
		
		@SuppressWarnings("unchecked")
		List<OrderDetails> resultList = queryRes.list();
		
		session.close();
		return resultList;
	}
	
	public List<Order> unhold(){
		session = getSession();
		session.beginTransaction();
		
		String string;

		
		string = "from " + Order.class.getName().toString() + 
				" where onHold =:true";
		Query queryRes = session.createQuery(string).setBoolean( "true", true );
		
		@SuppressWarnings("unchecked")
		List<Order> resultList = queryRes.list();
		
		session.close();
		return resultList;
	}
	
	public Order getLastReceipt(){
		session = getSession();
		session.beginTransaction();
		
		String string;

		
		string = "from " + Order.class.getName().toString();
		Query queryRes = session.createQuery(string);
		
		@SuppressWarnings("unchecked")
		List<Order> resultList = queryRes.list();
		Collections.sort(resultList, new Comparator<Order>() {

		
			@Override
			public int compare(Order o1, Order o2) {
				if(o1.getOrderDate().after(o2.getOrderDate()))
					
					return 1;    
				else if(o1.getOrderDate().equals(o2.getOrderDate()))

					return 0;
				else if(o1.getOrderDate().before(o2.getOrderDate()))

					return -1;
				
				return 0;
			}
		});
		session.close();
		System.out.println(resultList.get(resultList.size()-1).getOrderDate().toString());
		return resultList.get(resultList.size()-1);
	}
	
	public boolean findOrderDetails(Order o, Product p)
	{
		session = getSession();
		session.beginTransaction();
		
		String string;

		
		string = "from " + OrderDetails.class.getName().toString() + 
				" where orderId = '"+o.getOrderId()+"'";
		Query queryRes = session.createQuery(string);
		
		@SuppressWarnings("unchecked")
		List<OrderDetails> resultList = queryRes.list();
		for(int i =0; i<resultList.size();i++)
		{	
			//System.out.println("inside loop");
			OrderDetails od = resultList.get(i);
//			System.out.println("p is "+od.getProductId() );
//			System.out.println("p is "+p);
			//if(od.getProductId().getProductId().equals(p.getProductId()))
			if(od.getProductId().getSKU().equals(p.getSKU()))
			{
				System.out.println("order was found");
				return true;
			}
		}
		System.out.println("order was not found");
		return false;
	}

} //OrderDaoImpl
