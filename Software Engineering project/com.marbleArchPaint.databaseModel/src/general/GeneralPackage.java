/**
 */
package general;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see general.GeneralFactory
 * @model kind="package"
 *        annotation="teneo.jpa value='@GenericGenerator(name = \"system-uuid\", strategy = \"uuid2\")'"
 * @generated
 */
public interface GeneralPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "general";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://general/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "general";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneralPackage eINSTANCE = general.impl.GeneralPackageImpl.init();

	/**
	 * The meta object id for the '{@link general.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.UserImpl
	 * @see general.impl.GeneralPackageImpl#getUser()
	 * @generated
	 */
	int USER = 0;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USER_ID = 0;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USERNAME = 1;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PASSWORD = 2;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__EMAIL = 3;

	/**
	 * The feature id for the '<em><b>Last Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LAST_USED = 4;

	/**
	 * The feature id for the '<em><b>Times Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__TIMES_USED = 5;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__DELETED = 6;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link general.impl.SessionSatusImpl <em>Session Satus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.SessionSatusImpl
	 * @see general.impl.GeneralPackageImpl#getSessionSatus()
	 * @generated
	 */
	int SESSION_SATUS = 1;

	/**
	 * The feature id for the '<em><b>Mks Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SATUS__MKS_STATUS = 0;

	/**
	 * The feature id for the '<em><b>Db Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SATUS__DB_STATUS = 1;

	/**
	 * The feature id for the '<em><b>Synergy Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SATUS__SYNERGY_SESSION = 2;

	/**
	 * The number of structural features of the '<em>Session Satus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_SATUS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link general.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.CustomerImpl
	 * @see general.impl.GeneralPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 2;

	/**
	 * The feature id for the '<em><b>Customer Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__CUSTOMER_ID = 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__FIRST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__LAST_NAME = 2;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__ADDRESS = 3;

	/**
	 * The feature id for the '<em><b>Shipping Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__SHIPPING_ADDRESS = 4;

	/**
	 * The feature id for the '<em><b>Billing Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__BILLING_ADDRESS = 5;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__PHONE = 6;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__EMAIL = 7;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link general.impl.OrderImpl <em>Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.OrderImpl
	 * @see general.impl.GeneralPackageImpl#getOrder()
	 * @generated
	 */
	int ORDER = 3;

	/**
	 * The feature id for the '<em><b>Order Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__ORDER_ID = 0;

	/**
	 * The feature id for the '<em><b>Shipper Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__SHIPPER_ID = 1;

	/**
	 * The feature id for the '<em><b>Customer Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__CUSTOMER_ID = 2;

	/**
	 * The feature id for the '<em><b>Order Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__ORDER_DATE = 3;

	/**
	 * The feature id for the '<em><b>Tax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__TAX = 4;

	/**
	 * The feature id for the '<em><b>Completed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__COMPLETED = 5;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__DELETED = 6;

	/**
	 * The feature id for the '<em><b>Paid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__PAID = 7;

	/**
	 * The feature id for the '<em><b>Payment Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__PAYMENT_DATE = 8;

	/**
	 * The feature id for the '<em><b>Pay Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__PAY_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Sales Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__SALES_PERSON = 10;

	/**
	 * The feature id for the '<em><b>On Hold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__ON_HOLD = 11;

	/**
	 * The feature id for the '<em><b>Total Discount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__TOTAL_DISCOUNT = 12;

	/**
	 * The feature id for the '<em><b>Total Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__TOTAL_PRICE = 13;

	/**
	 * The number of structural features of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link general.impl.ShipperImpl <em>Shipper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.ShipperImpl
	 * @see general.impl.GeneralPackageImpl#getShipper()
	 * @generated
	 */
	int SHIPPER = 4;

	/**
	 * The feature id for the '<em><b>Shipper Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIPPER__SHIPPER_ID = 0;

	/**
	 * The feature id for the '<em><b>Company Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIPPER__COMPANY_NAME = 1;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIPPER__PHONE = 2;

	/**
	 * The number of structural features of the '<em>Shipper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIPPER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link general.impl.PaymentImpl <em>Payment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.PaymentImpl
	 * @see general.impl.GeneralPackageImpl#getPayment()
	 * @generated
	 */
	int PAYMENT = 5;

	/**
	 * The feature id for the '<em><b>Payment Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYMENT__PAYMENT_ID = 0;

	/**
	 * The feature id for the '<em><b>Payment Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYMENT__PAYMENT_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Payment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link general.impl.OrderDetailsImpl <em>Order Details</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.OrderDetailsImpl
	 * @see general.impl.GeneralPackageImpl#getOrderDetails()
	 * @generated
	 */
	int ORDER_DETAILS = 6;

	/**
	 * The feature id for the '<em><b>Order Detail Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__ORDER_DETAIL_ID = 0;

	/**
	 * The feature id for the '<em><b>Order Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__ORDER_ID = 1;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__PRODUCT_ID = 2;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__PRICE = 3;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__QUANTITY = 4;

	/**
	 * The feature id for the '<em><b>Discount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__DISCOUNT = 5;

	/**
	 * The feature id for the '<em><b>Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__TOTAL = 6;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__SIZE = 7;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__COLOR = 8;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS__DATE = 9;

	/**
	 * The number of structural features of the '<em>Order Details</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_DETAILS_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link general.impl.ProductImpl <em>Product</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.ProductImpl
	 * @see general.impl.GeneralPackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 7;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__PRODUCT_ID = 0;

	/**
	 * The feature id for the '<em><b>SKU</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__SKU = 1;

	/**
	 * The feature id for the '<em><b>Supplier Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__SUPPLIER_ID = 2;

	/**
	 * The feature id for the '<em><b>Catergory Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__CATERGORY_ID = 3;

	/**
	 * The feature id for the '<em><b>Product Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__PRODUCT_NAME = 4;

	/**
	 * The feature id for the '<em><b>Product Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__PRODUCT_DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Quantity Per Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__QUANTITY_PER_UNIT = 6;

	/**
	 * The feature id for the '<em><b>Unit Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__UNIT_PRICE = 7;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__SIZE = 8;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__COLOR = 9;

	/**
	 * The feature id for the '<em><b>Discount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__DISCOUNT = 10;

	/**
	 * The feature id for the '<em><b>Units In Stock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__UNITS_IN_STOCK = 11;

	/**
	 * The feature id for the '<em><b>Total Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__TOTAL_QUANTITY = 12;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__IMAGE = 13;

	/**
	 * The number of structural features of the '<em>Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link general.impl.SupplierImpl <em>Supplier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.SupplierImpl
	 * @see general.impl.GeneralPackageImpl#getSupplier()
	 * @generated
	 */
	int SUPPLIER = 8;

	/**
	 * The feature id for the '<em><b>Supplier Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__SUPPLIER_ID = 0;

	/**
	 * The feature id for the '<em><b>Company Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__COMPANY_NAME = 1;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__ADDRESS = 2;

	/**
	 * The feature id for the '<em><b>Phone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__PHONE = 3;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER__EMAIL = 4;

	/**
	 * The number of structural features of the '<em>Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPLIER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link general.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.impl.CategoryImpl
	 * @see general.impl.GeneralPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 9;

	/**
	 * The feature id for the '<em><b>Category Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__CATEGORY_ID = 0;

	/**
	 * The feature id for the '<em><b>Category Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__CATEGORY_NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link general.PaymentType <em>Payment Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see general.PaymentType
	 * @see general.impl.GeneralPackageImpl#getPaymentType()
	 * @generated
	 */
	int PAYMENT_TYPE = 10;

	/**
	 * The meta object id for the '<em>Date</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Date
	 * @see general.impl.GeneralPackageImpl#getDate()
	 * @generated
	 */
	int DATE = 11;

	/**
	 * The meta object id for the '<em>Image</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.graphics.Image
	 * @see general.impl.GeneralPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 12;

	/**
	 * Returns the meta object for class '{@link general.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see general.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see general.User#getUserId()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_UserId();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see general.User#getUsername()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Username();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see general.User#getPassword()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Password();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see general.User#getEmail()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Email();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getLastUsed <em>Last Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Used</em>'.
	 * @see general.User#getLastUsed()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_LastUsed();

	/**
	 * Returns the meta object for the attribute '{@link general.User#getTimesUsed <em>Times Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Times Used</em>'.
	 * @see general.User#getTimesUsed()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_TimesUsed();

	/**
	 * Returns the meta object for the attribute '{@link general.User#isDeleted <em>Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deleted</em>'.
	 * @see general.User#isDeleted()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Deleted();

	/**
	 * Returns the meta object for class '{@link general.SessionSatus <em>Session Satus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Session Satus</em>'.
	 * @see general.SessionSatus
	 * @generated
	 */
	EClass getSessionSatus();

	/**
	 * Returns the meta object for the attribute '{@link general.SessionSatus#isMksStatus <em>Mks Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mks Status</em>'.
	 * @see general.SessionSatus#isMksStatus()
	 * @see #getSessionSatus()
	 * @generated
	 */
	EAttribute getSessionSatus_MksStatus();

	/**
	 * Returns the meta object for the attribute '{@link general.SessionSatus#isDbStatus <em>Db Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Db Status</em>'.
	 * @see general.SessionSatus#isDbStatus()
	 * @see #getSessionSatus()
	 * @generated
	 */
	EAttribute getSessionSatus_DbStatus();

	/**
	 * Returns the meta object for the attribute '{@link general.SessionSatus#getSynergySession <em>Synergy Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synergy Session</em>'.
	 * @see general.SessionSatus#getSynergySession()
	 * @see #getSessionSatus()
	 * @generated
	 */
	EAttribute getSessionSatus_SynergySession();

	/**
	 * Returns the meta object for class '{@link general.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see general.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the attribute '{@link general.Customer#getCustomerId <em>Customer Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Customer Id</em>'.
	 * @see general.Customer#getCustomerId()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_CustomerId();

	/**
	 * Returns the meta object for the attribute '{@link general.Customer#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see general.Customer#getFirstName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link general.Customer#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see general.Customer#getLastName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_LastName();

	/**
	 * Returns the meta object for the attribute '{@link general.Customer#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see general.Customer#getAddress()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Address();

	/**
	 * Returns the meta object for the attribute '{@link general.Customer#getShippingAddress <em>Shipping Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shipping Address</em>'.
	 * @see general.Customer#getShippingAddress()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_ShippingAddress();

	/**
	 * Returns the meta object for the attribute '{@link general.Customer#getBillingAddress <em>Billing Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Billing Address</em>'.
	 * @see general.Customer#getBillingAddress()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_BillingAddress();

	/**
	 * Returns the meta object for the attribute '{@link general.Customer#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone</em>'.
	 * @see general.Customer#getPhone()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Phone();

	/**
	 * Returns the meta object for the attribute '{@link general.Customer#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see general.Customer#getEmail()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Email();

	/**
	 * Returns the meta object for class '{@link general.Order <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order</em>'.
	 * @see general.Order
	 * @generated
	 */
	EClass getOrder();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#getOrderId <em>Order Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Id</em>'.
	 * @see general.Order#getOrderId()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_OrderId();

	/**
	 * Returns the meta object for the reference '{@link general.Order#getShipperId <em>Shipper Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shipper Id</em>'.
	 * @see general.Order#getShipperId()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_ShipperId();

	/**
	 * Returns the meta object for the reference '{@link general.Order#getCustomerId <em>Customer Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Customer Id</em>'.
	 * @see general.Order#getCustomerId()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_CustomerId();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#getOrderDate <em>Order Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Date</em>'.
	 * @see general.Order#getOrderDate()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_OrderDate();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#getTax <em>Tax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tax</em>'.
	 * @see general.Order#getTax()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Tax();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#isCompleted <em>Completed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completed</em>'.
	 * @see general.Order#isCompleted()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Completed();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#isDeleted <em>Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deleted</em>'.
	 * @see general.Order#isDeleted()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Deleted();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#isPaid <em>Paid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paid</em>'.
	 * @see general.Order#isPaid()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Paid();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#getPaymentDate <em>Payment Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Payment Date</em>'.
	 * @see general.Order#getPaymentDate()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_PaymentDate();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#getPayType <em>Pay Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pay Type</em>'.
	 * @see general.Order#getPayType()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_PayType();

	/**
	 * Returns the meta object for the reference '{@link general.Order#getSalesPerson <em>Sales Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sales Person</em>'.
	 * @see general.Order#getSalesPerson()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_SalesPerson();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#isOnHold <em>On Hold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>On Hold</em>'.
	 * @see general.Order#isOnHold()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_OnHold();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#getTotalDiscount <em>Total Discount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Discount</em>'.
	 * @see general.Order#getTotalDiscount()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_TotalDiscount();

	/**
	 * Returns the meta object for the attribute '{@link general.Order#getTotalPrice <em>Total Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Price</em>'.
	 * @see general.Order#getTotalPrice()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_TotalPrice();

	/**
	 * Returns the meta object for class '{@link general.Shipper <em>Shipper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shipper</em>'.
	 * @see general.Shipper
	 * @generated
	 */
	EClass getShipper();

	/**
	 * Returns the meta object for the attribute '{@link general.Shipper#getShipperId <em>Shipper Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shipper Id</em>'.
	 * @see general.Shipper#getShipperId()
	 * @see #getShipper()
	 * @generated
	 */
	EAttribute getShipper_ShipperId();

	/**
	 * Returns the meta object for the attribute '{@link general.Shipper#getCompanyName <em>Company Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Company Name</em>'.
	 * @see general.Shipper#getCompanyName()
	 * @see #getShipper()
	 * @generated
	 */
	EAttribute getShipper_CompanyName();

	/**
	 * Returns the meta object for the attribute '{@link general.Shipper#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone</em>'.
	 * @see general.Shipper#getPhone()
	 * @see #getShipper()
	 * @generated
	 */
	EAttribute getShipper_Phone();

	/**
	 * Returns the meta object for class '{@link general.Payment <em>Payment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Payment</em>'.
	 * @see general.Payment
	 * @generated
	 */
	EClass getPayment();

	/**
	 * Returns the meta object for the attribute '{@link general.Payment#getPaymentId <em>Payment Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Payment Id</em>'.
	 * @see general.Payment#getPaymentId()
	 * @see #getPayment()
	 * @generated
	 */
	EAttribute getPayment_PaymentId();

	/**
	 * Returns the meta object for the attribute '{@link general.Payment#getPaymentType <em>Payment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Payment Type</em>'.
	 * @see general.Payment#getPaymentType()
	 * @see #getPayment()
	 * @generated
	 */
	EAttribute getPayment_PaymentType();

	/**
	 * Returns the meta object for class '{@link general.OrderDetails <em>Order Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order Details</em>'.
	 * @see general.OrderDetails
	 * @generated
	 */
	EClass getOrderDetails();

	/**
	 * Returns the meta object for the attribute '{@link general.OrderDetails#getOrderDetailId <em>Order Detail Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Detail Id</em>'.
	 * @see general.OrderDetails#getOrderDetailId()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EAttribute getOrderDetails_OrderDetailId();

	/**
	 * Returns the meta object for the reference '{@link general.OrderDetails#getOrderId <em>Order Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Order Id</em>'.
	 * @see general.OrderDetails#getOrderId()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EReference getOrderDetails_OrderId();

	/**
	 * Returns the meta object for the reference '{@link general.OrderDetails#getProductId <em>Product Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Product Id</em>'.
	 * @see general.OrderDetails#getProductId()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EReference getOrderDetails_ProductId();

	/**
	 * Returns the meta object for the attribute '{@link general.OrderDetails#getPrice <em>Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Price</em>'.
	 * @see general.OrderDetails#getPrice()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EAttribute getOrderDetails_Price();

	/**
	 * Returns the meta object for the attribute '{@link general.OrderDetails#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see general.OrderDetails#getQuantity()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EAttribute getOrderDetails_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link general.OrderDetails#getDiscount <em>Discount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discount</em>'.
	 * @see general.OrderDetails#getDiscount()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EAttribute getOrderDetails_Discount();

	/**
	 * Returns the meta object for the attribute '{@link general.OrderDetails#getTotal <em>Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total</em>'.
	 * @see general.OrderDetails#getTotal()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EAttribute getOrderDetails_Total();

	/**
	 * Returns the meta object for the attribute '{@link general.OrderDetails#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see general.OrderDetails#getSize()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EAttribute getOrderDetails_Size();

	/**
	 * Returns the meta object for the attribute '{@link general.OrderDetails#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see general.OrderDetails#getColor()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EAttribute getOrderDetails_Color();

	/**
	 * Returns the meta object for the attribute '{@link general.OrderDetails#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see general.OrderDetails#getDate()
	 * @see #getOrderDetails()
	 * @generated
	 */
	EAttribute getOrderDetails_Date();

	/**
	 * Returns the meta object for class '{@link general.Product <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product</em>'.
	 * @see general.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getProductId <em>Product Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Id</em>'.
	 * @see general.Product#getProductId()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_ProductId();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getSKU <em>SKU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SKU</em>'.
	 * @see general.Product#getSKU()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_SKU();

	/**
	 * Returns the meta object for the reference '{@link general.Product#getSupplierId <em>Supplier Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supplier Id</em>'.
	 * @see general.Product#getSupplierId()
	 * @see #getProduct()
	 * @generated
	 */
	EReference getProduct_SupplierId();

	/**
	 * Returns the meta object for the reference '{@link general.Product#getCatergoryId <em>Catergory Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Catergory Id</em>'.
	 * @see general.Product#getCatergoryId()
	 * @see #getProduct()
	 * @generated
	 */
	EReference getProduct_CatergoryId();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getProductName <em>Product Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Name</em>'.
	 * @see general.Product#getProductName()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_ProductName();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getProductDescription <em>Product Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Description</em>'.
	 * @see general.Product#getProductDescription()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_ProductDescription();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getQuantityPerUnit <em>Quantity Per Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity Per Unit</em>'.
	 * @see general.Product#getQuantityPerUnit()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_QuantityPerUnit();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getUnitPrice <em>Unit Price</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit Price</em>'.
	 * @see general.Product#getUnitPrice()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_UnitPrice();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see general.Product#getSize()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_Size();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see general.Product#getColor()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_Color();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getDiscount <em>Discount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Discount</em>'.
	 * @see general.Product#getDiscount()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_Discount();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getUnitsInStock <em>Units In Stock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Units In Stock</em>'.
	 * @see general.Product#getUnitsInStock()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_UnitsInStock();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getTotalQuantity <em>Total Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Quantity</em>'.
	 * @see general.Product#getTotalQuantity()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_TotalQuantity();

	/**
	 * Returns the meta object for the attribute '{@link general.Product#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see general.Product#getImage()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_Image();

	/**
	 * Returns the meta object for class '{@link general.Supplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supplier</em>'.
	 * @see general.Supplier
	 * @generated
	 */
	EClass getSupplier();

	/**
	 * Returns the meta object for the attribute '{@link general.Supplier#getSupplierId <em>Supplier Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Supplier Id</em>'.
	 * @see general.Supplier#getSupplierId()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_SupplierId();

	/**
	 * Returns the meta object for the attribute '{@link general.Supplier#getCompanyName <em>Company Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Company Name</em>'.
	 * @see general.Supplier#getCompanyName()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_CompanyName();

	/**
	 * Returns the meta object for the attribute '{@link general.Supplier#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see general.Supplier#getAddress()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Address();

	/**
	 * Returns the meta object for the attribute '{@link general.Supplier#getPhone <em>Phone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phone</em>'.
	 * @see general.Supplier#getPhone()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Phone();

	/**
	 * Returns the meta object for the attribute '{@link general.Supplier#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see general.Supplier#getEmail()
	 * @see #getSupplier()
	 * @generated
	 */
	EAttribute getSupplier_Email();

	/**
	 * Returns the meta object for class '{@link general.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see general.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link general.Category#getCategoryId <em>Category Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category Id</em>'.
	 * @see general.Category#getCategoryId()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_CategoryId();

	/**
	 * Returns the meta object for the attribute '{@link general.Category#getCategoryName <em>Category Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category Name</em>'.
	 * @see general.Category#getCategoryName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_CategoryName();

	/**
	 * Returns the meta object for the attribute '{@link general.Category#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see general.Category#getDescription()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Description();

	/**
	 * Returns the meta object for enum '{@link general.PaymentType <em>Payment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Payment Type</em>'.
	 * @see general.PaymentType
	 * @generated
	 */
	EEnum getPaymentType();

	/**
	 * Returns the meta object for data type '{@link java.util.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Date</em>'.
	 * @see java.util.Date
	 * @model instanceClass="java.util.Date"
	 * @generated
	 */
	EDataType getDate();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image</em>'.
	 * @see org.eclipse.swt.graphics.Image
	 * @model instanceClass="org.eclipse.swt.graphics.Image"
	 * @generated
	 */
	EDataType getImage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneralFactory getGeneralFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link general.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.UserImpl
		 * @see general.impl.GeneralPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__USER_ID = eINSTANCE.getUser_UserId();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__USERNAME = eINSTANCE.getUser_Username();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PASSWORD = eINSTANCE.getUser_Password();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__EMAIL = eINSTANCE.getUser_Email();

		/**
		 * The meta object literal for the '<em><b>Last Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__LAST_USED = eINSTANCE.getUser_LastUsed();

		/**
		 * The meta object literal for the '<em><b>Times Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__TIMES_USED = eINSTANCE.getUser_TimesUsed();

		/**
		 * The meta object literal for the '<em><b>Deleted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__DELETED = eINSTANCE.getUser_Deleted();

		/**
		 * The meta object literal for the '{@link general.impl.SessionSatusImpl <em>Session Satus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.SessionSatusImpl
		 * @see general.impl.GeneralPackageImpl#getSessionSatus()
		 * @generated
		 */
		EClass SESSION_SATUS = eINSTANCE.getSessionSatus();

		/**
		 * The meta object literal for the '<em><b>Mks Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SESSION_SATUS__MKS_STATUS = eINSTANCE.getSessionSatus_MksStatus();

		/**
		 * The meta object literal for the '<em><b>Db Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SESSION_SATUS__DB_STATUS = eINSTANCE.getSessionSatus_DbStatus();

		/**
		 * The meta object literal for the '<em><b>Synergy Session</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SESSION_SATUS__SYNERGY_SESSION = eINSTANCE.getSessionSatus_SynergySession();

		/**
		 * The meta object literal for the '{@link general.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.CustomerImpl
		 * @see general.impl.GeneralPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>Customer Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__CUSTOMER_ID = eINSTANCE.getCustomer_CustomerId();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__FIRST_NAME = eINSTANCE.getCustomer_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__LAST_NAME = eINSTANCE.getCustomer_LastName();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__ADDRESS = eINSTANCE.getCustomer_Address();

		/**
		 * The meta object literal for the '<em><b>Shipping Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__SHIPPING_ADDRESS = eINSTANCE.getCustomer_ShippingAddress();

		/**
		 * The meta object literal for the '<em><b>Billing Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__BILLING_ADDRESS = eINSTANCE.getCustomer_BillingAddress();

		/**
		 * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__PHONE = eINSTANCE.getCustomer_Phone();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__EMAIL = eINSTANCE.getCustomer_Email();

		/**
		 * The meta object literal for the '{@link general.impl.OrderImpl <em>Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.OrderImpl
		 * @see general.impl.GeneralPackageImpl#getOrder()
		 * @generated
		 */
		EClass ORDER = eINSTANCE.getOrder();

		/**
		 * The meta object literal for the '<em><b>Order Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__ORDER_ID = eINSTANCE.getOrder_OrderId();

		/**
		 * The meta object literal for the '<em><b>Shipper Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER__SHIPPER_ID = eINSTANCE.getOrder_ShipperId();

		/**
		 * The meta object literal for the '<em><b>Customer Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER__CUSTOMER_ID = eINSTANCE.getOrder_CustomerId();

		/**
		 * The meta object literal for the '<em><b>Order Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__ORDER_DATE = eINSTANCE.getOrder_OrderDate();

		/**
		 * The meta object literal for the '<em><b>Tax</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__TAX = eINSTANCE.getOrder_Tax();

		/**
		 * The meta object literal for the '<em><b>Completed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__COMPLETED = eINSTANCE.getOrder_Completed();

		/**
		 * The meta object literal for the '<em><b>Deleted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__DELETED = eINSTANCE.getOrder_Deleted();

		/**
		 * The meta object literal for the '<em><b>Paid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__PAID = eINSTANCE.getOrder_Paid();

		/**
		 * The meta object literal for the '<em><b>Payment Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__PAYMENT_DATE = eINSTANCE.getOrder_PaymentDate();

		/**
		 * The meta object literal for the '<em><b>Pay Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__PAY_TYPE = eINSTANCE.getOrder_PayType();

		/**
		 * The meta object literal for the '<em><b>Sales Person</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER__SALES_PERSON = eINSTANCE.getOrder_SalesPerson();

		/**
		 * The meta object literal for the '<em><b>On Hold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__ON_HOLD = eINSTANCE.getOrder_OnHold();

		/**
		 * The meta object literal for the '<em><b>Total Discount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__TOTAL_DISCOUNT = eINSTANCE.getOrder_TotalDiscount();

		/**
		 * The meta object literal for the '<em><b>Total Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__TOTAL_PRICE = eINSTANCE.getOrder_TotalPrice();

		/**
		 * The meta object literal for the '{@link general.impl.ShipperImpl <em>Shipper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.ShipperImpl
		 * @see general.impl.GeneralPackageImpl#getShipper()
		 * @generated
		 */
		EClass SHIPPER = eINSTANCE.getShipper();

		/**
		 * The meta object literal for the '<em><b>Shipper Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHIPPER__SHIPPER_ID = eINSTANCE.getShipper_ShipperId();

		/**
		 * The meta object literal for the '<em><b>Company Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHIPPER__COMPANY_NAME = eINSTANCE.getShipper_CompanyName();

		/**
		 * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHIPPER__PHONE = eINSTANCE.getShipper_Phone();

		/**
		 * The meta object literal for the '{@link general.impl.PaymentImpl <em>Payment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.PaymentImpl
		 * @see general.impl.GeneralPackageImpl#getPayment()
		 * @generated
		 */
		EClass PAYMENT = eINSTANCE.getPayment();

		/**
		 * The meta object literal for the '<em><b>Payment Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAYMENT__PAYMENT_ID = eINSTANCE.getPayment_PaymentId();

		/**
		 * The meta object literal for the '<em><b>Payment Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAYMENT__PAYMENT_TYPE = eINSTANCE.getPayment_PaymentType();

		/**
		 * The meta object literal for the '{@link general.impl.OrderDetailsImpl <em>Order Details</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.OrderDetailsImpl
		 * @see general.impl.GeneralPackageImpl#getOrderDetails()
		 * @generated
		 */
		EClass ORDER_DETAILS = eINSTANCE.getOrderDetails();

		/**
		 * The meta object literal for the '<em><b>Order Detail Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_DETAILS__ORDER_DETAIL_ID = eINSTANCE.getOrderDetails_OrderDetailId();

		/**
		 * The meta object literal for the '<em><b>Order Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER_DETAILS__ORDER_ID = eINSTANCE.getOrderDetails_OrderId();

		/**
		 * The meta object literal for the '<em><b>Product Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER_DETAILS__PRODUCT_ID = eINSTANCE.getOrderDetails_ProductId();

		/**
		 * The meta object literal for the '<em><b>Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_DETAILS__PRICE = eINSTANCE.getOrderDetails_Price();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_DETAILS__QUANTITY = eINSTANCE.getOrderDetails_Quantity();

		/**
		 * The meta object literal for the '<em><b>Discount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_DETAILS__DISCOUNT = eINSTANCE.getOrderDetails_Discount();

		/**
		 * The meta object literal for the '<em><b>Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_DETAILS__TOTAL = eINSTANCE.getOrderDetails_Total();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_DETAILS__SIZE = eINSTANCE.getOrderDetails_Size();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_DETAILS__COLOR = eINSTANCE.getOrderDetails_Color();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER_DETAILS__DATE = eINSTANCE.getOrderDetails_Date();

		/**
		 * The meta object literal for the '{@link general.impl.ProductImpl <em>Product</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.ProductImpl
		 * @see general.impl.GeneralPackageImpl#getProduct()
		 * @generated
		 */
		EClass PRODUCT = eINSTANCE.getProduct();

		/**
		 * The meta object literal for the '<em><b>Product Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__PRODUCT_ID = eINSTANCE.getProduct_ProductId();

		/**
		 * The meta object literal for the '<em><b>SKU</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__SKU = eINSTANCE.getProduct_SKU();

		/**
		 * The meta object literal for the '<em><b>Supplier Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT__SUPPLIER_ID = eINSTANCE.getProduct_SupplierId();

		/**
		 * The meta object literal for the '<em><b>Catergory Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT__CATERGORY_ID = eINSTANCE.getProduct_CatergoryId();

		/**
		 * The meta object literal for the '<em><b>Product Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__PRODUCT_NAME = eINSTANCE.getProduct_ProductName();

		/**
		 * The meta object literal for the '<em><b>Product Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__PRODUCT_DESCRIPTION = eINSTANCE.getProduct_ProductDescription();

		/**
		 * The meta object literal for the '<em><b>Quantity Per Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__QUANTITY_PER_UNIT = eINSTANCE.getProduct_QuantityPerUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Price</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__UNIT_PRICE = eINSTANCE.getProduct_UnitPrice();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__SIZE = eINSTANCE.getProduct_Size();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__COLOR = eINSTANCE.getProduct_Color();

		/**
		 * The meta object literal for the '<em><b>Discount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__DISCOUNT = eINSTANCE.getProduct_Discount();

		/**
		 * The meta object literal for the '<em><b>Units In Stock</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__UNITS_IN_STOCK = eINSTANCE.getProduct_UnitsInStock();

		/**
		 * The meta object literal for the '<em><b>Total Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__TOTAL_QUANTITY = eINSTANCE.getProduct_TotalQuantity();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__IMAGE = eINSTANCE.getProduct_Image();

		/**
		 * The meta object literal for the '{@link general.impl.SupplierImpl <em>Supplier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.SupplierImpl
		 * @see general.impl.GeneralPackageImpl#getSupplier()
		 * @generated
		 */
		EClass SUPPLIER = eINSTANCE.getSupplier();

		/**
		 * The meta object literal for the '<em><b>Supplier Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__SUPPLIER_ID = eINSTANCE.getSupplier_SupplierId();

		/**
		 * The meta object literal for the '<em><b>Company Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__COMPANY_NAME = eINSTANCE.getSupplier_CompanyName();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__ADDRESS = eINSTANCE.getSupplier_Address();

		/**
		 * The meta object literal for the '<em><b>Phone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__PHONE = eINSTANCE.getSupplier_Phone();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPPLIER__EMAIL = eINSTANCE.getSupplier_Email();

		/**
		 * The meta object literal for the '{@link general.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.impl.CategoryImpl
		 * @see general.impl.GeneralPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Category Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__CATEGORY_ID = eINSTANCE.getCategory_CategoryId();

		/**
		 * The meta object literal for the '<em><b>Category Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__CATEGORY_NAME = eINSTANCE.getCategory_CategoryName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__DESCRIPTION = eINSTANCE.getCategory_Description();

		/**
		 * The meta object literal for the '{@link general.PaymentType <em>Payment Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see general.PaymentType
		 * @see general.impl.GeneralPackageImpl#getPaymentType()
		 * @generated
		 */
		EEnum PAYMENT_TYPE = eINSTANCE.getPaymentType();

		/**
		 * The meta object literal for the '<em>Date</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Date
		 * @see general.impl.GeneralPackageImpl#getDate()
		 * @generated
		 */
		EDataType DATE = eINSTANCE.getDate();

		/**
		 * The meta object literal for the '<em>Image</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.graphics.Image
		 * @see general.impl.GeneralPackageImpl#getImage()
		 * @generated
		 */
		EDataType IMAGE = eINSTANCE.getImage();

	}

} //GeneralPackage
