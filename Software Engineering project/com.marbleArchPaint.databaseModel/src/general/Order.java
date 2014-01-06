/**
 */
package general;

import java.util.Date;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * @implements IAdaptable
 * A representation of the model object '<em><b>Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Order#getOrderId <em>Order Id</em>}</li>
 *   <li>{@link general.Order#getShipperId <em>Shipper Id</em>}</li>
 *   <li>{@link general.Order#getCustomerId <em>Customer Id</em>}</li>
 *   <li>{@link general.Order#getOrderDate <em>Order Date</em>}</li>
 *   <li>{@link general.Order#getTax <em>Tax</em>}</li>
 *   <li>{@link general.Order#isCompleted <em>Completed</em>}</li>
 *   <li>{@link general.Order#isDeleted <em>Deleted</em>}</li>
 *   <li>{@link general.Order#isPaid <em>Paid</em>}</li>
 *   <li>{@link general.Order#getPaymentDate <em>Payment Date</em>}</li>
 *   <li>{@link general.Order#getPayType <em>Pay Type</em>}</li>
 *   <li>{@link general.Order#getSalesPerson <em>Sales Person</em>}</li>
 *   <li>{@link general.Order#isOnHold <em>On Hold</em>}</li>
 *   <li>{@link general.Order#getTotalDiscount <em>Total Discount</em>}</li>
 *   <li>{@link general.Order#getTotalPrice <em>Total Price</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getOrder()
 * @model
 * @generated
 */
public interface Order extends EObject , IAdaptable{
	/**
	 * Returns the value of the '<em><b>Order Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order Id</em>' attribute.
	 * @see #setOrderId(String)
	 * @see general.GeneralPackage#getOrder_OrderId()
	 * @model id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\") @Column(length=36)'"
	 * @generated
	 */
	String getOrderId();

	/**
	 * Sets the value of the '{@link general.Order#getOrderId <em>Order Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order Id</em>' attribute.
	 * @see #getOrderId()
	 * @generated
	 */
	void setOrderId(String value);

	/**
	 * Returns the value of the '<em><b>Shipper Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shipper Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shipper Id</em>' reference.
	 * @see #setShipperId(Shipper)
	 * @see general.GeneralPackage#getOrder_ShipperId()
	 * @model
	 * @generated
	 */
	Shipper getShipperId();

	/**
	 * Sets the value of the '{@link general.Order#getShipperId <em>Shipper Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shipper Id</em>' reference.
	 * @see #getShipperId()
	 * @generated
	 */
	void setShipperId(Shipper value);

	/**
	 * Returns the value of the '<em><b>Customer Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customer Id</em>' reference.
	 * @see #setCustomerId(Customer)
	 * @see general.GeneralPackage#getOrder_CustomerId()
	 * @model
	 * @generated
	 */
	Customer getCustomerId();

	/**
	 * Sets the value of the '{@link general.Order#getCustomerId <em>Customer Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customer Id</em>' reference.
	 * @see #getCustomerId()
	 * @generated
	 */
	void setCustomerId(Customer value);

	/**
	 * Returns the value of the '<em><b>Order Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order Date</em>' attribute.
	 * @see #setOrderDate(Date)
	 * @see general.GeneralPackage#getOrder_OrderDate()
	 * @model dataType="general.Date"
	 * @generated
	 */
	Date getOrderDate();

	/**
	 * Sets the value of the '{@link general.Order#getOrderDate <em>Order Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order Date</em>' attribute.
	 * @see #getOrderDate()
	 * @generated
	 */
	void setOrderDate(Date value);

	/**
	 * Returns the value of the '<em><b>Tax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tax</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tax</em>' attribute.
	 * @see #setTax(double)
	 * @see general.GeneralPackage#getOrder_Tax()
	 * @model
	 * @generated
	 */
	double getTax();

	/**
	 * Sets the value of the '{@link general.Order#getTax <em>Tax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tax</em>' attribute.
	 * @see #getTax()
	 * @generated
	 */
	void setTax(double value);

	/**
	 * Returns the value of the '<em><b>Completed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completed</em>' attribute.
	 * @see #setCompleted(boolean)
	 * @see general.GeneralPackage#getOrder_Completed()
	 * @model
	 * @generated
	 */
	boolean isCompleted();

	/**
	 * Sets the value of the '{@link general.Order#isCompleted <em>Completed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completed</em>' attribute.
	 * @see #isCompleted()
	 * @generated
	 */
	void setCompleted(boolean value);

	/**
	 * Returns the value of the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted</em>' attribute.
	 * @see #setDeleted(boolean)
	 * @see general.GeneralPackage#getOrder_Deleted()
	 * @model
	 * @generated
	 */
	boolean isDeleted();

	/**
	 * Sets the value of the '{@link general.Order#isDeleted <em>Deleted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted</em>' attribute.
	 * @see #isDeleted()
	 * @generated
	 */
	void setDeleted(boolean value);

	/**
	 * Returns the value of the '<em><b>Paid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paid</em>' attribute.
	 * @see #setPaid(boolean)
	 * @see general.GeneralPackage#getOrder_Paid()
	 * @model
	 * @generated
	 */
	boolean isPaid();

	/**
	 * Sets the value of the '{@link general.Order#isPaid <em>Paid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paid</em>' attribute.
	 * @see #isPaid()
	 * @generated
	 */
	void setPaid(boolean value);

	/**
	 * Returns the value of the '<em><b>Payment Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payment Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payment Date</em>' attribute.
	 * @see #setPaymentDate(Date)
	 * @see general.GeneralPackage#getOrder_PaymentDate()
	 * @model dataType="general.Date"
	 * @generated
	 */
	Date getPaymentDate();

	/**
	 * Sets the value of the '{@link general.Order#getPaymentDate <em>Payment Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payment Date</em>' attribute.
	 * @see #getPaymentDate()
	 * @generated
	 */
	void setPaymentDate(Date value);

	/**
	 * Returns the value of the '<em><b>Pay Type</b></em>' attribute.
	 * The literals are from the enumeration {@link general.PaymentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pay Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pay Type</em>' attribute.
	 * @see general.PaymentType
	 * @see #setPayType(PaymentType)
	 * @see general.GeneralPackage#getOrder_PayType()
	 * @model
	 * @generated
	 */
	PaymentType getPayType();

	/**
	 * Sets the value of the '{@link general.Order#getPayType <em>Pay Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pay Type</em>' attribute.
	 * @see general.PaymentType
	 * @see #getPayType()
	 * @generated
	 */
	void setPayType(PaymentType value);

	/**
	 * Returns the value of the '<em><b>Sales Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sales Person</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sales Person</em>' reference.
	 * @see #setSalesPerson(User)
	 * @see general.GeneralPackage#getOrder_SalesPerson()
	 * @model required="true"
	 * @generated
	 */
	User getSalesPerson();

	/**
	 * Sets the value of the '{@link general.Order#getSalesPerson <em>Sales Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sales Person</em>' reference.
	 * @see #getSalesPerson()
	 * @generated
	 */
	void setSalesPerson(User value);

	/**
	 * Returns the value of the '<em><b>On Hold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Hold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Hold</em>' attribute.
	 * @see #setOnHold(boolean)
	 * @see general.GeneralPackage#getOrder_OnHold()
	 * @model
	 * @generated
	 */
	boolean isOnHold();

	/**
	 * Sets the value of the '{@link general.Order#isOnHold <em>On Hold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Hold</em>' attribute.
	 * @see #isOnHold()
	 * @generated
	 */
	void setOnHold(boolean value);

	/**
	 * Returns the value of the '<em><b>Total Discount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Discount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Discount</em>' attribute.
	 * @see #setTotalDiscount(double)
	 * @see general.GeneralPackage#getOrder_TotalDiscount()
	 * @model
	 * @generated
	 */
	double getTotalDiscount();

	/**
	 * Sets the value of the '{@link general.Order#getTotalDiscount <em>Total Discount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Discount</em>' attribute.
	 * @see #getTotalDiscount()
	 * @generated
	 */
	void setTotalDiscount(double value);

	/**
	 * Returns the value of the '<em><b>Total Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Price</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Price</em>' attribute.
	 * @see #setTotalPrice(double)
	 * @see general.GeneralPackage#getOrder_TotalPrice()
	 * @model
	 * @generated
	 */
	double getTotalPrice();

	/**
	 * Sets the value of the '{@link general.Order#getTotalPrice <em>Total Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Price</em>' attribute.
	 * @see #getTotalPrice()
	 * @generated
	 */
	void setTotalPrice(double value);

} // Order
