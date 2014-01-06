/**
 */
package general.impl;

import general.GeneralPackage;
import general.Order;
import general.OrderDetails;
import general.Product;

import java.util.Date;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ui.views.properties.IPropertySource;

import properties.ElementProperties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Order Details</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.OrderDetailsImpl#getOrderDetailId <em>Order Detail Id</em>}</li>
 *   <li>{@link general.impl.OrderDetailsImpl#getOrderId <em>Order Id</em>}</li>
 *   <li>{@link general.impl.OrderDetailsImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link general.impl.OrderDetailsImpl#getPrice <em>Price</em>}</li>
 *   <li>{@link general.impl.OrderDetailsImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link general.impl.OrderDetailsImpl#getDiscount <em>Discount</em>}</li>
 *   <li>{@link general.impl.OrderDetailsImpl#getTotal <em>Total</em>}</li>
 *   <li>{@link general.impl.OrderDetailsImpl#getSize <em>Size</em>}</li>
 *   <li>{@link general.impl.OrderDetailsImpl#getColor <em>Color</em>}</li>
 *   <li>{@link general.impl.OrderDetailsImpl#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrderDetailsImpl extends EObjectImpl implements OrderDetails {
	/**
	 * The default value of the '{@link #getOrderDetailId() <em>Order Detail Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderDetailId()
	 * @generated
	 * @ordered
	 */
	protected static final String ORDER_DETAIL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrderDetailId() <em>Order Detail Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderDetailId()
	 * @generated
	 * @ordered
	 */
	protected String orderDetailId = ORDER_DETAIL_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOrderId() <em>Order Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderId()
	 * @generated
	 * @ordered
	 */
	protected Order orderId;

	/**
	 * The cached value of the '{@link #getProductId() <em>Product Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductId()
	 * @generated
	 * @ordered
	 */
	protected Product productId;

	/**
	 * The default value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected static final double PRICE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected double price = PRICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final int QUANTITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected int quantity = QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiscount() <em>Discount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscount()
	 * @generated
	 * @ordered
	 */
	protected static final double DISCOUNT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDiscount() <em>Discount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscount()
	 * @generated
	 * @ordered
	 */
	protected double discount = DISCOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotal() <em>Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotal()
	 * @generated
	 * @ordered
	 */
	protected double total = TOTAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final double SIZE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected double size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final String COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected String color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderDetailsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.ORDER_DETAILS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrderDetailId() {
		return orderDetailId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderDetailId(String newOrderDetailId) {
		String oldOrderDetailId = orderDetailId;
		orderDetailId = newOrderDetailId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__ORDER_DETAIL_ID, oldOrderDetailId, orderDetailId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Order getOrderId() {
		if (orderId != null && orderId.eIsProxy()) {
			InternalEObject oldOrderId = (InternalEObject)orderId;
			orderId = (Order)eResolveProxy(oldOrderId);
			if (orderId != oldOrderId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.ORDER_DETAILS__ORDER_ID, oldOrderId, orderId));
			}
		}
		return orderId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Order basicGetOrderId() {
		return orderId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderId(Order newOrderId) {
		Order oldOrderId = orderId;
		orderId = newOrderId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__ORDER_ID, oldOrderId, orderId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product getProductId() {
		if (productId != null && productId.eIsProxy()) {
			InternalEObject oldProductId = (InternalEObject)productId;
			productId = (Product)eResolveProxy(oldProductId);
			if (productId != oldProductId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.ORDER_DETAILS__PRODUCT_ID, oldProductId, productId));
			}
		}
		return productId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product basicGetProductId() {
		return productId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductId(Product newProductId) {
		Product oldProductId = productId;
		productId = newProductId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__PRODUCT_ID, oldProductId, productId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrice(double newPrice) {
		double oldPrice = price;
		price = newPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__PRICE, oldPrice, price));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantity(int newQuantity) {
		int oldQuantity = quantity;
		quantity = newQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__QUANTITY, oldQuantity, quantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiscount(double newDiscount) {
		double oldDiscount = discount;
		discount = newDiscount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__DISCOUNT, oldDiscount, discount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotal(double newTotal) {
		double oldTotal = total;
		total = newTotal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__TOTAL, oldTotal, total));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(double newSize) {
		double oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(String newColor) {
		String oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER_DETAILS__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.ORDER_DETAILS__ORDER_DETAIL_ID:
				return getOrderDetailId();
			case GeneralPackage.ORDER_DETAILS__ORDER_ID:
				if (resolve) return getOrderId();
				return basicGetOrderId();
			case GeneralPackage.ORDER_DETAILS__PRODUCT_ID:
				if (resolve) return getProductId();
				return basicGetProductId();
			case GeneralPackage.ORDER_DETAILS__PRICE:
				return getPrice();
			case GeneralPackage.ORDER_DETAILS__QUANTITY:
				return getQuantity();
			case GeneralPackage.ORDER_DETAILS__DISCOUNT:
				return getDiscount();
			case GeneralPackage.ORDER_DETAILS__TOTAL:
				return getTotal();
			case GeneralPackage.ORDER_DETAILS__SIZE:
				return getSize();
			case GeneralPackage.ORDER_DETAILS__COLOR:
				return getColor();
			case GeneralPackage.ORDER_DETAILS__DATE:
				return getDate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneralPackage.ORDER_DETAILS__ORDER_DETAIL_ID:
				setOrderDetailId((String)newValue);
				return;
			case GeneralPackage.ORDER_DETAILS__ORDER_ID:
				setOrderId((Order)newValue);
				return;
			case GeneralPackage.ORDER_DETAILS__PRODUCT_ID:
				setProductId((Product)newValue);
				return;
			case GeneralPackage.ORDER_DETAILS__PRICE:
				setPrice((Double)newValue);
				return;
			case GeneralPackage.ORDER_DETAILS__QUANTITY:
				setQuantity((Integer)newValue);
				return;
			case GeneralPackage.ORDER_DETAILS__DISCOUNT:
				setDiscount((Double)newValue);
				return;
			case GeneralPackage.ORDER_DETAILS__TOTAL:
				setTotal((Double)newValue);
				return;
			case GeneralPackage.ORDER_DETAILS__SIZE:
				setSize((Double)newValue);
				return;
			case GeneralPackage.ORDER_DETAILS__COLOR:
				setColor((String)newValue);
				return;
			case GeneralPackage.ORDER_DETAILS__DATE:
				setDate((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneralPackage.ORDER_DETAILS__ORDER_DETAIL_ID:
				setOrderDetailId(ORDER_DETAIL_ID_EDEFAULT);
				return;
			case GeneralPackage.ORDER_DETAILS__ORDER_ID:
				setOrderId((Order)null);
				return;
			case GeneralPackage.ORDER_DETAILS__PRODUCT_ID:
				setProductId((Product)null);
				return;
			case GeneralPackage.ORDER_DETAILS__PRICE:
				setPrice(PRICE_EDEFAULT);
				return;
			case GeneralPackage.ORDER_DETAILS__QUANTITY:
				setQuantity(QUANTITY_EDEFAULT);
				return;
			case GeneralPackage.ORDER_DETAILS__DISCOUNT:
				setDiscount(DISCOUNT_EDEFAULT);
				return;
			case GeneralPackage.ORDER_DETAILS__TOTAL:
				setTotal(TOTAL_EDEFAULT);
				return;
			case GeneralPackage.ORDER_DETAILS__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case GeneralPackage.ORDER_DETAILS__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case GeneralPackage.ORDER_DETAILS__DATE:
				setDate(DATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneralPackage.ORDER_DETAILS__ORDER_DETAIL_ID:
				return ORDER_DETAIL_ID_EDEFAULT == null ? orderDetailId != null : !ORDER_DETAIL_ID_EDEFAULT.equals(orderDetailId);
			case GeneralPackage.ORDER_DETAILS__ORDER_ID:
				return orderId != null;
			case GeneralPackage.ORDER_DETAILS__PRODUCT_ID:
				return productId != null;
			case GeneralPackage.ORDER_DETAILS__PRICE:
				return price != PRICE_EDEFAULT;
			case GeneralPackage.ORDER_DETAILS__QUANTITY:
				return quantity != QUANTITY_EDEFAULT;
			case GeneralPackage.ORDER_DETAILS__DISCOUNT:
				return discount != DISCOUNT_EDEFAULT;
			case GeneralPackage.ORDER_DETAILS__TOTAL:
				return total != TOTAL_EDEFAULT;
			case GeneralPackage.ORDER_DETAILS__SIZE:
				return size != SIZE_EDEFAULT;
			case GeneralPackage.ORDER_DETAILS__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case GeneralPackage.ORDER_DETAILS__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (orderDetailId: ");
		result.append(orderDetailId);
		result.append(", price: ");
		result.append(price);
		result.append(", Quantity: ");
		result.append(quantity);
		result.append(", Discount: ");
		result.append(discount);
		result.append(", Total: ");
		result.append(total);
		result.append(", size: ");
		result.append(size);
		result.append(", color: ");
		result.append(color);
		result.append(", date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if ( adapter == IPropertySource.class ) {
			return new ElementProperties(this);
		}
		return null;
	}

} //OrderDetailsImpl
