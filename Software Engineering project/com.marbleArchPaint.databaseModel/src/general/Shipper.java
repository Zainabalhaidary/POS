/**
 */
package general;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shipper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Shipper#getShipperId <em>Shipper Id</em>}</li>
 *   <li>{@link general.Shipper#getCompanyName <em>Company Name</em>}</li>
 *   <li>{@link general.Shipper#getPhone <em>Phone</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getShipper()
 * @model
 * @generated
 */
public interface Shipper extends EObject {
	/**
	 * Returns the value of the '<em><b>Shipper Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shipper Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shipper Id</em>' attribute.
	 * @see #setShipperId(String)
	 * @see general.GeneralPackage#getShipper_ShipperId()
	 * @model id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\") @Column(length=36)'"
	 * @generated
	 */
	String getShipperId();

	/**
	 * Sets the value of the '{@link general.Shipper#getShipperId <em>Shipper Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shipper Id</em>' attribute.
	 * @see #getShipperId()
	 * @generated
	 */
	void setShipperId(String value);

	/**
	 * Returns the value of the '<em><b>Company Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Company Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Company Name</em>' attribute.
	 * @see #setCompanyName(String)
	 * @see general.GeneralPackage#getShipper_CompanyName()
	 * @model required="true"
	 * @generated
	 */
	String getCompanyName();

	/**
	 * Sets the value of the '{@link general.Shipper#getCompanyName <em>Company Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Company Name</em>' attribute.
	 * @see #getCompanyName()
	 * @generated
	 */
	void setCompanyName(String value);

	/**
	 * Returns the value of the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone</em>' attribute.
	 * @see #setPhone(String)
	 * @see general.GeneralPackage#getShipper_Phone()
	 * @model required="true"
	 * @generated
	 */
	String getPhone();

	/**
	 * Sets the value of the '{@link general.Shipper#getPhone <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phone</em>' attribute.
	 * @see #getPhone()
	 * @generated
	 */
	void setPhone(String value);

} // Shipper
