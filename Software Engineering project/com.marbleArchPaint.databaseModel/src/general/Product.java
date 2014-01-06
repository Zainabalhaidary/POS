/**
 */
package general;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Product</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link general.Product#getProductId <em>Product Id</em>}</li>
 *   <li>{@link general.Product#getSKU <em>SKU</em>}</li>
 *   <li>{@link general.Product#getSupplierId <em>Supplier Id</em>}</li>
 *   <li>{@link general.Product#getCatergoryId <em>Catergory Id</em>}</li>
 *   <li>{@link general.Product#getProductName <em>Product Name</em>}</li>
 *   <li>{@link general.Product#getProductDescription <em>Product Description</em>}</li>
 *   <li>{@link general.Product#getQuantityPerUnit <em>Quantity Per Unit</em>}</li>
 *   <li>{@link general.Product#getUnitPrice <em>Unit Price</em>}</li>
 *   <li>{@link general.Product#getSize <em>Size</em>}</li>
 *   <li>{@link general.Product#getColor <em>Color</em>}</li>
 *   <li>{@link general.Product#getDiscount <em>Discount</em>}</li>
 *   <li>{@link general.Product#getUnitsInStock <em>Units In Stock</em>}</li>
 *   <li>{@link general.Product#getTotalQuantity <em>Total Quantity</em>}</li>
 *   <li>{@link general.Product#getImage <em>Image</em>}</li>
 * </ul>
 * </p>
 *
 * @see general.GeneralPackage#getProduct()
 * @model
 * @generated
 */
public interface Product extends EObject {
	/**
	 * Returns the value of the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Id</em>' attribute.
	 * @see #setProductId(String)
	 * @see general.GeneralPackage#getProduct_ProductId()
	 * @model id="true" required="true"
	 *        annotation="teneo.jpa value='@Id @GeneratedValue(generator=\"system-uuid\") @Column(length=36)'"
	 * @generated
	 */
	String getProductId();

	/**
	 * Sets the value of the '{@link general.Product#getProductId <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Id</em>' attribute.
	 * @see #getProductId()
	 * @generated
	 */
	void setProductId(String value);

	/**
	 * Returns the value of the '<em><b>SKU</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SKU</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SKU</em>' attribute.
	 * @see #setSKU(String)
	 * @see general.GeneralPackage#getProduct_SKU()
	 * @model required="true"
	 * @generated
	 */
	String getSKU();

	/**
	 * Sets the value of the '{@link general.Product#getSKU <em>SKU</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SKU</em>' attribute.
	 * @see #getSKU()
	 * @generated
	 */
	void setSKU(String value);

	/**
	 * Returns the value of the '<em><b>Supplier Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supplier Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supplier Id</em>' reference.
	 * @see #setSupplierId(Supplier)
	 * @see general.GeneralPackage#getProduct_SupplierId()
	 * @model
	 * @generated
	 */
	Supplier getSupplierId();

	/**
	 * Sets the value of the '{@link general.Product#getSupplierId <em>Supplier Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supplier Id</em>' reference.
	 * @see #getSupplierId()
	 * @generated
	 */
	void setSupplierId(Supplier value);

	/**
	 * Returns the value of the '<em><b>Catergory Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catergory Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catergory Id</em>' reference.
	 * @see #setCatergoryId(Category)
	 * @see general.GeneralPackage#getProduct_CatergoryId()
	 * @model required="true"
	 * @generated
	 */
	Category getCatergoryId();

	/**
	 * Sets the value of the '{@link general.Product#getCatergoryId <em>Catergory Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catergory Id</em>' reference.
	 * @see #getCatergoryId()
	 * @generated
	 */
	void setCatergoryId(Category value);

	/**
	 * Returns the value of the '<em><b>Product Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Name</em>' attribute.
	 * @see #setProductName(String)
	 * @see general.GeneralPackage#getProduct_ProductName()
	 * @model required="true"
	 * @generated
	 */
	String getProductName();

	/**
	 * Sets the value of the '{@link general.Product#getProductName <em>Product Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Name</em>' attribute.
	 * @see #getProductName()
	 * @generated
	 */
	void setProductName(String value);

	/**
	 * Returns the value of the '<em><b>Product Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Description</em>' attribute.
	 * @see #setProductDescription(String)
	 * @see general.GeneralPackage#getProduct_ProductDescription()
	 * @model
	 * @generated
	 */
	String getProductDescription();

	/**
	 * Sets the value of the '{@link general.Product#getProductDescription <em>Product Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Description</em>' attribute.
	 * @see #getProductDescription()
	 * @generated
	 */
	void setProductDescription(String value);

	/**
	 * Returns the value of the '<em><b>Quantity Per Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity Per Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity Per Unit</em>' attribute.
	 * @see #setQuantityPerUnit(int)
	 * @see general.GeneralPackage#getProduct_QuantityPerUnit()
	 * @model required="true"
	 * @generated
	 */
	int getQuantityPerUnit();

	/**
	 * Sets the value of the '{@link general.Product#getQuantityPerUnit <em>Quantity Per Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity Per Unit</em>' attribute.
	 * @see #getQuantityPerUnit()
	 * @generated
	 */
	void setQuantityPerUnit(int value);

	/**
	 * Returns the value of the '<em><b>Unit Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Price</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Price</em>' attribute.
	 * @see #setUnitPrice(double)
	 * @see general.GeneralPackage#getProduct_UnitPrice()
	 * @model required="true"
	 * @generated
	 */
	double getUnitPrice();

	/**
	 * Sets the value of the '{@link general.Product#getUnitPrice <em>Unit Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Price</em>' attribute.
	 * @see #getUnitPrice()
	 * @generated
	 */
	void setUnitPrice(double value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(String)
	 * @see general.GeneralPackage#getProduct_Size()
	 * @model
	 * @generated
	 */
	String getSize();

	/**
	 * Sets the value of the '{@link general.Product#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(String value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(String)
	 * @see general.GeneralPackage#getProduct_Color()
	 * @model
	 * @generated
	 */
	String getColor();

	/**
	 * Sets the value of the '{@link general.Product#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(String value);

	/**
	 * Returns the value of the '<em><b>Discount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discount</em>' attribute.
	 * @see #setDiscount(double)
	 * @see general.GeneralPackage#getProduct_Discount()
	 * @model
	 * @generated
	 */
	double getDiscount();

	/**
	 * Sets the value of the '{@link general.Product#getDiscount <em>Discount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discount</em>' attribute.
	 * @see #getDiscount()
	 * @generated
	 */
	void setDiscount(double value);

	/**
	 * Returns the value of the '<em><b>Units In Stock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units In Stock</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units In Stock</em>' attribute.
	 * @see #setUnitsInStock(int)
	 * @see general.GeneralPackage#getProduct_UnitsInStock()
	 * @model required="true"
	 * @generated
	 */
	int getUnitsInStock();

	/**
	 * Sets the value of the '{@link general.Product#getUnitsInStock <em>Units In Stock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Units In Stock</em>' attribute.
	 * @see #getUnitsInStock()
	 * @generated
	 */
	void setUnitsInStock(int value);

	/**
	 * Returns the value of the '<em><b>Total Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Quantity</em>' attribute.
	 * @see #setTotalQuantity(int)
	 * @see general.GeneralPackage#getProduct_TotalQuantity()
	 * @model
	 * @generated
	 */
	int getTotalQuantity();

	/**
	 * Sets the value of the '{@link general.Product#getTotalQuantity <em>Total Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Quantity</em>' attribute.
	 * @see #getTotalQuantity()
	 * @generated
	 */
	void setTotalQuantity(int value);

	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(String)
	 * @see general.GeneralPackage#getProduct_Image()
	 * @model
	 * @generated
	 */
	String getImage();

	/**
	 * Sets the value of the '{@link general.Product#getImage <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(String value);

} // Product
