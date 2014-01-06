/**
 */
package general.impl;

import general.Customer;
import general.GeneralPackage;
import general.Order;
import general.PaymentType;
import general.Shipper;
import general.User;

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
 * An implementation of the model object '<em><b>Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.OrderImpl#getOrderId <em>Order Id</em>}</li>
 *   <li>{@link general.impl.OrderImpl#getShipperId <em>Shipper Id</em>}</li>
 *   <li>{@link general.impl.OrderImpl#getCustomerId <em>Customer Id</em>}</li>
 *   <li>{@link general.impl.OrderImpl#getOrderDate <em>Order Date</em>}</li>
 *   <li>{@link general.impl.OrderImpl#getTax <em>Tax</em>}</li>
 *   <li>{@link general.impl.OrderImpl#isCompleted <em>Completed</em>}</li>
 *   <li>{@link general.impl.OrderImpl#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.impl.OrderImpl#isPaid <em>Paid</em>}</li>
 *   <li>{@link general.impl.OrderImpl#getPaymentDate <em>Payment Date</em>}</li>
 *   <li>{@link general.impl.OrderImpl#getPayType <em>Pay Type</em>}</li>
 *   <li>{@link general.impl.OrderImpl#getSalesPerson <em>Sales Person</em>}</li>
 *   <li>{@link general.impl.OrderImpl#isOnHold <em>On Hold</em>}</li>
 *   <li>{@link general.impl.OrderImpl#getTotalDiscount <em>Total Discount</em>}</li>
 *   <li>{@link general.impl.OrderImpl#getTotalPrice <em>Total Price</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrderImpl extends EObjectImpl implements Order {
	/**
	 * The default value of the '{@link #getOrderId() <em>Order Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderId()
	 * @generated
	 * @ordered
	 */
	protected static final String ORDER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrderId() <em>Order Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderId()
	 * @generated
	 * @ordered
	 */
	protected String orderId = ORDER_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getShipperId() <em>Shipper Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShipperId()
	 * @generated
	 * @ordered
	 */
	protected Shipper shipperId;

	/**
	 * The cached value of the '{@link #getCustomerId() <em>Customer Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomerId()
	 * @generated
	 * @ordered
	 */
	protected Customer customerId;

	/**
	 * The default value of the '{@link #getOrderDate() <em>Order Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date ORDER_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrderDate() <em>Order Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderDate()
	 * @generated
	 * @ordered
	 */
	protected Date orderDate = ORDER_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTax() <em>Tax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTax()
	 * @generated
	 * @ordered
	 */
	protected static final double TAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTax() <em>Tax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTax()
	 * @generated
	 * @ordered
	 */
	protected double tax = TAX_EDEFAULT;

	/**
	 * The default value of the '{@link #isCompleted() <em>Completed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompleted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLETED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCompleted() <em>Completed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompleted()
	 * @generated
	 * @ordered
	 */
	protected boolean completed = COMPLETED_EDEFAULT;

	/**
	 * The default value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleted()
	 * @generated
	 * @ordered
	 */
	protected boolean deleted = DELETED_EDEFAULT;

	/**
	 * The default value of the '{@link #isPaid() <em>Paid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPaid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PAID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPaid() <em>Paid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPaid()
	 * @generated
	 * @ordered
	 */
	protected boolean paid = PAID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPaymentDate() <em>Payment Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaymentDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date PAYMENT_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPaymentDate() <em>Payment Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaymentDate()
	 * @generated
	 * @ordered
	 */
	protected Date paymentDate = PAYMENT_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPayType() <em>Pay Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayType()
	 * @generated
	 * @ordered
	 */
	protected static final PaymentType PAY_TYPE_EDEFAULT = PaymentType.CASH;

	/**
	 * The cached value of the '{@link #getPayType() <em>Pay Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayType()
	 * @generated
	 * @ordered
	 */
	protected PaymentType payType = PAY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSalesPerson() <em>Sales Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalesPerson()
	 * @generated
	 * @ordered
	 */
	protected User salesPerson;

	/**
	 * The default value of the '{@link #isOnHold() <em>On Hold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnHold()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ON_HOLD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnHold() <em>On Hold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnHold()
	 * @generated
	 * @ordered
	 */
	protected boolean onHold = ON_HOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalDiscount() <em>Total Discount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDiscount()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_DISCOUNT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalDiscount() <em>Total Discount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDiscount()
	 * @generated
	 * @ordered
	 */
	protected double totalDiscount = TOTAL_DISCOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalPrice() <em>Total Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalPrice()
	 * @generated
	 * @ordered
	 */
	protected static final double TOTAL_PRICE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTotalPrice() <em>Total Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalPrice()
	 * @generated
	 * @ordered
	 */
	protected double totalPrice = TOTAL_PRICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.ORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderId(String newOrderId) {
		String oldOrderId = orderId;
		orderId = newOrderId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__ORDER_ID, oldOrderId, orderId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shipper getShipperId() {
		if (shipperId != null && shipperId.eIsProxy()) {
			InternalEObject oldShipperId = (InternalEObject)shipperId;
			shipperId = (Shipper)eResolveProxy(oldShipperId);
			if (shipperId != oldShipperId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.ORDER__SHIPPER_ID, oldShipperId, shipperId));
			}
		}
		return shipperId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shipper basicGetShipperId() {
		return shipperId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShipperId(Shipper newShipperId) {
		Shipper oldShipperId = shipperId;
		shipperId = newShipperId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__SHIPPER_ID, oldShipperId, shipperId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getCustomerId() {
		if (customerId != null && customerId.eIsProxy()) {
			InternalEObject oldCustomerId = (InternalEObject)customerId;
			customerId = (Customer)eResolveProxy(oldCustomerId);
			if (customerId != oldCustomerId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.ORDER__CUSTOMER_ID, oldCustomerId, customerId));
			}
		}
		return customerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer basicGetCustomerId() {
		return customerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomerId(Customer newCustomerId) {
		Customer oldCustomerId = customerId;
		customerId = newCustomerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__CUSTOMER_ID, oldCustomerId, customerId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderDate(Date newOrderDate) {
		Date oldOrderDate = orderDate;
		orderDate = newOrderDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__ORDER_DATE, oldOrderDate, orderDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTax(double newTax) {
		double oldTax = tax;
		tax = newTax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__TAX, oldTax, tax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompleted(boolean newCompleted) {
		boolean oldCompleted = completed;
		completed = newCompleted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__COMPLETED, oldCompleted, completed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeleted(boolean newDeleted) {
		boolean oldDeleted = deleted;
		deleted = newDeleted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__DELETED, oldDeleted, deleted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPaid() {
		return paid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaid(boolean newPaid) {
		boolean oldPaid = paid;
		paid = newPaid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__PAID, oldPaid, paid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaymentDate(Date newPaymentDate) {
		Date oldPaymentDate = paymentDate;
		paymentDate = newPaymentDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__PAYMENT_DATE, oldPaymentDate, paymentDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PaymentType getPayType() {
		return payType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayType(PaymentType newPayType) {
		PaymentType oldPayType = payType;
		payType = newPayType == null ? PAY_TYPE_EDEFAULT : newPayType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__PAY_TYPE, oldPayType, payType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getSalesPerson() {
		if (salesPerson != null && salesPerson.eIsProxy()) {
			InternalEObject oldSalesPerson = (InternalEObject)salesPerson;
			salesPerson = (User)eResolveProxy(oldSalesPerson);
			if (salesPerson != oldSalesPerson) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.ORDER__SALES_PERSON, oldSalesPerson, salesPerson));
			}
		}
		return salesPerson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetSalesPerson() {
		return salesPerson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalesPerson(User newSalesPerson) {
		User oldSalesPerson = salesPerson;
		salesPerson = newSalesPerson;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__SALES_PERSON, oldSalesPerson, salesPerson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOnHold() {
		return onHold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnHold(boolean newOnHold) {
		boolean oldOnHold = onHold;
		onHold = newOnHold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__ON_HOLD, oldOnHold, onHold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalDiscount() {
		return totalDiscount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalDiscount(double newTotalDiscount) {
		double oldTotalDiscount = totalDiscount;
		totalDiscount = newTotalDiscount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__TOTAL_DISCOUNT, oldTotalDiscount, totalDiscount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalPrice(double newTotalPrice) {
		double oldTotalPrice = totalPrice;
		totalPrice = newTotalPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ORDER__TOTAL_PRICE, oldTotalPrice, totalPrice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.ORDER__ORDER_ID:
				return getOrderId();
			case GeneralPackage.ORDER__SHIPPER_ID:
				if (resolve) return getShipperId();
				return basicGetShipperId();
			case GeneralPackage.ORDER__CUSTOMER_ID:
				if (resolve) return getCustomerId();
				return basicGetCustomerId();
			case GeneralPackage.ORDER__ORDER_DATE:
				return getOrderDate();
			case GeneralPackage.ORDER__TAX:
				return getTax();
			case GeneralPackage.ORDER__COMPLETED:
				return isCompleted();
			case GeneralPackage.ORDER__DELETED:
				return isDeleted();
			case GeneralPackage.ORDER__PAID:
				return isPaid();
			case GeneralPackage.ORDER__PAYMENT_DATE:
				return getPaymentDate();
			case GeneralPackage.ORDER__PAY_TYPE:
				return getPayType();
			case GeneralPackage.ORDER__SALES_PERSON:
				if (resolve) return getSalesPerson();
				return basicGetSalesPerson();
			case GeneralPackage.ORDER__ON_HOLD:
				return isOnHold();
			case GeneralPackage.ORDER__TOTAL_DISCOUNT:
				return getTotalDiscount();
			case GeneralPackage.ORDER__TOTAL_PRICE:
				return getTotalPrice();
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
			case GeneralPackage.ORDER__ORDER_ID:
				setOrderId((String)newValue);
				return;
			case GeneralPackage.ORDER__SHIPPER_ID:
				setShipperId((Shipper)newValue);
				return;
			case GeneralPackage.ORDER__CUSTOMER_ID:
				setCustomerId((Customer)newValue);
				return;
			case GeneralPackage.ORDER__ORDER_DATE:
				setOrderDate((Date)newValue);
				return;
			case GeneralPackage.ORDER__TAX:
				setTax((Double)newValue);
				return;
			case GeneralPackage.ORDER__COMPLETED:
				setCompleted((Boolean)newValue);
				return;
			case GeneralPackage.ORDER__DELETED:
				setDeleted((Boolean)newValue);
				return;
			case GeneralPackage.ORDER__PAID:
				setPaid((Boolean)newValue);
				return;
			case GeneralPackage.ORDER__PAYMENT_DATE:
				setPaymentDate((Date)newValue);
				return;
			case GeneralPackage.ORDER__PAY_TYPE:
				setPayType((PaymentType)newValue);
				return;
			case GeneralPackage.ORDER__SALES_PERSON:
				setSalesPerson((User)newValue);
				return;
			case GeneralPackage.ORDER__ON_HOLD:
				setOnHold((Boolean)newValue);
				return;
			case GeneralPackage.ORDER__TOTAL_DISCOUNT:
				setTotalDiscount((Double)newValue);
				return;
			case GeneralPackage.ORDER__TOTAL_PRICE:
				setTotalPrice((Double)newValue);
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
			case GeneralPackage.ORDER__ORDER_ID:
				setOrderId(ORDER_ID_EDEFAULT);
				return;
			case GeneralPackage.ORDER__SHIPPER_ID:
				setShipperId((Shipper)null);
				return;
			case GeneralPackage.ORDER__CUSTOMER_ID:
				setCustomerId((Customer)null);
				return;
			case GeneralPackage.ORDER__ORDER_DATE:
				setOrderDate(ORDER_DATE_EDEFAULT);
				return;
			case GeneralPackage.ORDER__TAX:
				setTax(TAX_EDEFAULT);
				return;
			case GeneralPackage.ORDER__COMPLETED:
				setCompleted(COMPLETED_EDEFAULT);
				return;
			case GeneralPackage.ORDER__DELETED:
				setDeleted(DELETED_EDEFAULT);
				return;
			case GeneralPackage.ORDER__PAID:
				setPaid(PAID_EDEFAULT);
				return;
			case GeneralPackage.ORDER__PAYMENT_DATE:
				setPaymentDate(PAYMENT_DATE_EDEFAULT);
				return;
			case GeneralPackage.ORDER__PAY_TYPE:
				setPayType(PAY_TYPE_EDEFAULT);
				return;
			case GeneralPackage.ORDER__SALES_PERSON:
				setSalesPerson((User)null);
				return;
			case GeneralPackage.ORDER__ON_HOLD:
				setOnHold(ON_HOLD_EDEFAULT);
				return;
			case GeneralPackage.ORDER__TOTAL_DISCOUNT:
				setTotalDiscount(TOTAL_DISCOUNT_EDEFAULT);
				return;
			case GeneralPackage.ORDER__TOTAL_PRICE:
				setTotalPrice(TOTAL_PRICE_EDEFAULT);
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
			case GeneralPackage.ORDER__ORDER_ID:
				return ORDER_ID_EDEFAULT == null ? orderId != null : !ORDER_ID_EDEFAULT.equals(orderId);
			case GeneralPackage.ORDER__SHIPPER_ID:
				return shipperId != null;
			case GeneralPackage.ORDER__CUSTOMER_ID:
				return customerId != null;
			case GeneralPackage.ORDER__ORDER_DATE:
				return ORDER_DATE_EDEFAULT == null ? orderDate != null : !ORDER_DATE_EDEFAULT.equals(orderDate);
			case GeneralPackage.ORDER__TAX:
				return tax != TAX_EDEFAULT;
			case GeneralPackage.ORDER__COMPLETED:
				return completed != COMPLETED_EDEFAULT;
			case GeneralPackage.ORDER__DELETED:
				return deleted != DELETED_EDEFAULT;
			case GeneralPackage.ORDER__PAID:
				return paid != PAID_EDEFAULT;
			case GeneralPackage.ORDER__PAYMENT_DATE:
				return PAYMENT_DATE_EDEFAULT == null ? paymentDate != null : !PAYMENT_DATE_EDEFAULT.equals(paymentDate);
			case GeneralPackage.ORDER__PAY_TYPE:
				return payType != PAY_TYPE_EDEFAULT;
			case GeneralPackage.ORDER__SALES_PERSON:
				return salesPerson != null;
			case GeneralPackage.ORDER__ON_HOLD:
				return onHold != ON_HOLD_EDEFAULT;
			case GeneralPackage.ORDER__TOTAL_DISCOUNT:
				return totalDiscount != TOTAL_DISCOUNT_EDEFAULT;
			case GeneralPackage.ORDER__TOTAL_PRICE:
				return totalPrice != TOTAL_PRICE_EDEFAULT;
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
		result.append(" (orderId: ");
		result.append(orderId);
		result.append(", orderDate: ");
		result.append(orderDate);
		result.append(", tax: ");
		result.append(tax);
		result.append(", completed: ");
		result.append(completed);
		result.append(", deleted: ");
		result.append(deleted);
		result.append(", paid: ");
		result.append(paid);
		result.append(", paymentDate: ");
		result.append(paymentDate);
		result.append(", payType: ");
		result.append(payType);
		result.append(", onHold: ");
		result.append(onHold);
		result.append(", totalDiscount: ");
		result.append(totalDiscount);
		result.append(", totalPrice: ");
		result.append(totalPrice);
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
} //OrderImpl
