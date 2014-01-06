/**
 */
package general;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Payment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Payment#getPaymentId <em>Payment Id</em>}</li>
 *   <li>{@link general.Payment#getPaymentType <em>Payment Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getPayment()
 * @model
 * @generated
 */
public interface Payment extends EObject {
	/**
	 * Returns the value of the '<em><b>Payment Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payment Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payment Id</em>' attribute.
	 * @see #setPaymentId(String)
	 * @see general.GeneralPackage#getPayment_PaymentId()
	 * @model id="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\") @Column(length=36)'"
	 * @generated
	 */
	String getPaymentId();

	/**
	 * Sets the value of the '{@link general.Payment#getPaymentId <em>Payment Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payment Id</em>' attribute.
	 * @see #getPaymentId()
	 * @generated
	 */
	void setPaymentId(String value);

	/**
	 * Returns the value of the '<em><b>Payment Type</b></em>' attribute.
	 * The literals are from the enumeration {@link general.PaymentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payment Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payment Type</em>' attribute.
	 * @see general.PaymentType
	 * @see #setPaymentType(PaymentType)
	 * @see general.GeneralPackage#getPayment_PaymentType()
	 * @model
	 * @generated
	 */
	PaymentType getPaymentType();

	/**
	 * Sets the value of the '{@link general.Payment#getPaymentType <em>Payment Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payment Type</em>' attribute.
	 * @see general.PaymentType
	 * @see #getPaymentType()
	 * @generated
	 */
	void setPaymentType(PaymentType value);

} // Payment
