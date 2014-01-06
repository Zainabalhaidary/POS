/**
 */
package general.impl;

import general.Category;
import general.GeneralPackage;
import general.Product;
import general.Supplier;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.swt.graphics.Image;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Product</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link general.impl.ProductImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getSKU <em>SKU</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getSupplierId <em>Supplier Id</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getCatergoryId <em>Catergory Id</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getProductName <em>Product Name</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getProductDescription <em>Product Description</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getQuantityPerUnit <em>Quantity Per Unit</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getUnitPrice <em>Unit Price</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getSize <em>Size</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getColor <em>Color</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getDiscount <em>Discount</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getUnitsInStock <em>Units In Stock</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getTotalQuantity <em>Total Quantity</em>}</li>
 *   <li>{@link general.impl.ProductImpl#getImage <em>Image</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProductImpl extends EObjectImpl implements Product {
	/**
	 * The default value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductId()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductId()
	 * @generated
	 * @ordered
	 */
	protected String productId = PRODUCT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSKU() <em>SKU</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSKU()
	 * @generated
	 * @ordered
	 */
	protected static final String SKU_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSKU() <em>SKU</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSKU()
	 * @generated
	 * @ordered
	 */
	protected String sku = SKU_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupplierId() <em>Supplier Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupplierId()
	 * @generated
	 * @ordered
	 */
	protected Supplier supplierId;

	/**
	 * The cached value of the '{@link #getCatergoryId() <em>Catergory Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatergoryId()
	 * @generated
	 * @ordered
	 */
	protected Category catergoryId;

	/**
	 * The default value of the '{@link #getProductName() <em>Product Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductName() <em>Product Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductName()
	 * @generated
	 * @ordered
	 */
	protected String productName = PRODUCT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProductDescription() <em>Product Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductDescription() <em>Product Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductDescription()
	 * @generated
	 * @ordered
	 */
	protected String productDescription = PRODUCT_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuantityPerUnit() <em>Quantity Per Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantityPerUnit()
	 * @generated
	 * @ordered
	 */
	protected static final int QUANTITY_PER_UNIT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getQuantityPerUnit() <em>Quantity Per Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantityPerUnit()
	 * @generated
	 * @ordered
	 */
	protected int quantityPerUnit = QUANTITY_PER_UNIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnitPrice() <em>Unit Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitPrice()
	 * @generated
	 * @ordered
	 */
	protected static final double UNIT_PRICE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getUnitPrice() <em>Unit Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitPrice()
	 * @generated
	 * @ordered
	 */
	protected double unitPrice = UNIT_PRICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final String SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected String size = SIZE_EDEFAULT;

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
	 * The default value of the '{@link #getUnitsInStock() <em>Units In Stock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitsInStock()
	 * @generated
	 * @ordered
	 */
	protected static final int UNITS_IN_STOCK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUnitsInStock() <em>Units In Stock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitsInStock()
	 * @generated
	 * @ordered
	 */
	protected int unitsInStock = UNITS_IN_STOCK_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalQuantity() <em>Total Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_QUANTITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalQuantity() <em>Total Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalQuantity()
	 * @generated
	 * @ordered
	 */
	protected int totalQuantity = TOTAL_QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected String image = IMAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProductImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.PRODUCT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductId(String newProductId) {
		String oldProductId = productId;
		productId = newProductId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__PRODUCT_ID, oldProductId, productId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSKU() {
		return sku;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSKU(String newSKU) {
		String oldSKU = sku;
		sku = newSKU;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__SKU, oldSKU, sku));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Supplier getSupplierId() {
		if (supplierId != null && supplierId.eIsProxy()) {
			InternalEObject oldSupplierId = (InternalEObject)supplierId;
			supplierId = (Supplier)eResolveProxy(oldSupplierId);
			if (supplierId != oldSupplierId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.PRODUCT__SUPPLIER_ID, oldSupplierId, supplierId));
			}
		}
		return supplierId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Supplier basicGetSupplierId() {
		return supplierId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupplierId(Supplier newSupplierId) {
		Supplier oldSupplierId = supplierId;
		supplierId = newSupplierId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__SUPPLIER_ID, oldSupplierId, supplierId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category getCatergoryId() {
		if (catergoryId != null && catergoryId.eIsProxy()) {
			InternalEObject oldCatergoryId = (InternalEObject)catergoryId;
			catergoryId = (Category)eResolveProxy(oldCatergoryId);
			if (catergoryId != oldCatergoryId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.PRODUCT__CATERGORY_ID, oldCatergoryId, catergoryId));
			}
		}
		return catergoryId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category basicGetCatergoryId() {
		return catergoryId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCatergoryId(Category newCatergoryId) {
		Category oldCatergoryId = catergoryId;
		catergoryId = newCatergoryId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__CATERGORY_ID, oldCatergoryId, catergoryId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductName(String newProductName) {
		String oldProductName = productName;
		productName = newProductName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__PRODUCT_NAME, oldProductName, productName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductDescription(String newProductDescription) {
		String oldProductDescription = productDescription;
		productDescription = newProductDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__PRODUCT_DESCRIPTION, oldProductDescription, productDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getQuantityPerUnit() {
		return quantityPerUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantityPerUnit(int newQuantityPerUnit) {
		int oldQuantityPerUnit = quantityPerUnit;
		quantityPerUnit = newQuantityPerUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__QUANTITY_PER_UNIT, oldQuantityPerUnit, quantityPerUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitPrice(double newUnitPrice) {
		double oldUnitPrice = unitPrice;
		unitPrice = newUnitPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__UNIT_PRICE, oldUnitPrice, unitPrice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(String newSize) {
		String oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__SIZE, oldSize, size));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__COLOR, oldColor, color));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__DISCOUNT, oldDiscount, discount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUnitsInStock() {
		return unitsInStock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitsInStock(int newUnitsInStock) {
		int oldUnitsInStock = unitsInStock;
		unitsInStock = newUnitsInStock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__UNITS_IN_STOCK, oldUnitsInStock, unitsInStock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTotalQuantity() {
		return totalQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalQuantity(int newTotalQuantity) {
		int oldTotalQuantity = totalQuantity;
		totalQuantity = newTotalQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__TOTAL_QUANTITY, oldTotalQuantity, totalQuantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(String newImage) {
		String oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.PRODUCT__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.PRODUCT__PRODUCT_ID:
				return getProductId();
			case GeneralPackage.PRODUCT__SKU:
				return getSKU();
			case GeneralPackage.PRODUCT__SUPPLIER_ID:
				if (resolve) return getSupplierId();
				return basicGetSupplierId();
			case GeneralPackage.PRODUCT__CATERGORY_ID:
				if (resolve) return getCatergoryId();
				return basicGetCatergoryId();
			case GeneralPackage.PRODUCT__PRODUCT_NAME:
				return getProductName();
			case GeneralPackage.PRODUCT__PRODUCT_DESCRIPTION:
				return getProductDescription();
			case GeneralPackage.PRODUCT__QUANTITY_PER_UNIT:
				return getQuantityPerUnit();
			case GeneralPackage.PRODUCT__UNIT_PRICE:
				return getUnitPrice();
			case GeneralPackage.PRODUCT__SIZE:
				return getSize();
			case GeneralPackage.PRODUCT__COLOR:
				return getColor();
			case GeneralPackage.PRODUCT__DISCOUNT:
				return getDiscount();
			case GeneralPackage.PRODUCT__UNITS_IN_STOCK:
				return getUnitsInStock();
			case GeneralPackage.PRODUCT__TOTAL_QUANTITY:
				return getTotalQuantity();
			case GeneralPackage.PRODUCT__IMAGE:
				return getImage();
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
			case GeneralPackage.PRODUCT__PRODUCT_ID:
				setProductId((String)newValue);
				return;
			case GeneralPackage.PRODUCT__SKU:
				setSKU((String)newValue);
				return;
			case GeneralPackage.PRODUCT__SUPPLIER_ID:
				setSupplierId((Supplier)newValue);
				return;
			case GeneralPackage.PRODUCT__CATERGORY_ID:
				setCatergoryId((Category)newValue);
				return;
			case GeneralPackage.PRODUCT__PRODUCT_NAME:
				setProductName((String)newValue);
				return;
			case GeneralPackage.PRODUCT__PRODUCT_DESCRIPTION:
				setProductDescription((String)newValue);
				return;
			case GeneralPackage.PRODUCT__QUANTITY_PER_UNIT:
				setQuantityPerUnit((Integer)newValue);
				return;
			case GeneralPackage.PRODUCT__UNIT_PRICE:
				setUnitPrice((Double)newValue);
				return;
			case GeneralPackage.PRODUCT__SIZE:
				setSize((String)newValue);
				return;
			case GeneralPackage.PRODUCT__COLOR:
				setColor((String)newValue);
				return;
			case GeneralPackage.PRODUCT__DISCOUNT:
				setDiscount((Double)newValue);
				return;
			case GeneralPackage.PRODUCT__UNITS_IN_STOCK:
				setUnitsInStock((Integer)newValue);
				return;
			case GeneralPackage.PRODUCT__TOTAL_QUANTITY:
				setTotalQuantity((Integer)newValue);
				return;
			case GeneralPackage.PRODUCT__IMAGE:
				setImage((String)newValue);
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
			case GeneralPackage.PRODUCT__PRODUCT_ID:
				setProductId(PRODUCT_ID_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__SKU:
				setSKU(SKU_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__SUPPLIER_ID:
				setSupplierId((Supplier)null);
				return;
			case GeneralPackage.PRODUCT__CATERGORY_ID:
				setCatergoryId((Category)null);
				return;
			case GeneralPackage.PRODUCT__PRODUCT_NAME:
				setProductName(PRODUCT_NAME_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__PRODUCT_DESCRIPTION:
				setProductDescription(PRODUCT_DESCRIPTION_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__QUANTITY_PER_UNIT:
				setQuantityPerUnit(QUANTITY_PER_UNIT_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__UNIT_PRICE:
				setUnitPrice(UNIT_PRICE_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__DISCOUNT:
				setDiscount(DISCOUNT_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__UNITS_IN_STOCK:
				setUnitsInStock(UNITS_IN_STOCK_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__TOTAL_QUANTITY:
				setTotalQuantity(TOTAL_QUANTITY_EDEFAULT);
				return;
			case GeneralPackage.PRODUCT__IMAGE:
				setImage(IMAGE_EDEFAULT);
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
			case GeneralPackage.PRODUCT__PRODUCT_ID:
				return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
			case GeneralPackage.PRODUCT__SKU:
				return SKU_EDEFAULT == null ? sku != null : !SKU_EDEFAULT.equals(sku);
			case GeneralPackage.PRODUCT__SUPPLIER_ID:
				return supplierId != null;
			case GeneralPackage.PRODUCT__CATERGORY_ID:
				return catergoryId != null;
			case GeneralPackage.PRODUCT__PRODUCT_NAME:
				return PRODUCT_NAME_EDEFAULT == null ? productName != null : !PRODUCT_NAME_EDEFAULT.equals(productName);
			case GeneralPackage.PRODUCT__PRODUCT_DESCRIPTION:
				return PRODUCT_DESCRIPTION_EDEFAULT == null ? productDescription != null : !PRODUCT_DESCRIPTION_EDEFAULT.equals(productDescription);
			case GeneralPackage.PRODUCT__QUANTITY_PER_UNIT:
				return quantityPerUnit != QUANTITY_PER_UNIT_EDEFAULT;
			case GeneralPackage.PRODUCT__UNIT_PRICE:
				return unitPrice != UNIT_PRICE_EDEFAULT;
			case GeneralPackage.PRODUCT__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case GeneralPackage.PRODUCT__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case GeneralPackage.PRODUCT__DISCOUNT:
				return discount != DISCOUNT_EDEFAULT;
			case GeneralPackage.PRODUCT__UNITS_IN_STOCK:
				return unitsInStock != UNITS_IN_STOCK_EDEFAULT;
			case GeneralPackage.PRODUCT__TOTAL_QUANTITY:
				return totalQuantity != TOTAL_QUANTITY_EDEFAULT;
			case GeneralPackage.PRODUCT__IMAGE:
				return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
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
		result.append(" (productId: ");
		result.append(productId);
		result.append(", SKU: ");
		result.append(sku);
		result.append(", productName: ");
		result.append(productName);
		result.append(", productDescription: ");
		result.append(productDescription);
		result.append(", QuantityPerUnit: ");
		result.append(quantityPerUnit);
		result.append(", unitPrice: ");
		result.append(unitPrice);
		result.append(", size: ");
		result.append(size);
		result.append(", color: ");
		result.append(color);
		result.append(", discount: ");
		result.append(discount);
		result.append(", UnitsInStock: ");
		result.append(unitsInStock);
		result.append(", TotalQuantity: ");
		result.append(totalQuantity);
		result.append(", Image: ");
		result.append(image);
		result.append(')');
		return result.toString();
	}

} //ProductImpl
