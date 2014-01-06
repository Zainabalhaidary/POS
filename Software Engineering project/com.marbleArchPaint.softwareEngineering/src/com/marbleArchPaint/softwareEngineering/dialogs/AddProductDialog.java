package com.marbleArchPaint.softwareEngineering.dialogs;

import java.util.List;

import general.Category;
import general.Customer;
import general.GeneralFactory;
import general.Order;
import general.Product;
import general.Supplier;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.marbleArchPaint.softwareEngineering.SessionSourceProvider;
import com.marbleArchPaint.softwareEngineering.LabelProvider.GenericNameLabelProvider;
import com.marbleArchPaint.softwareEngineering.views.Pos;

import dao.CategoryDao;
import dao.CustomerDao;
import dao.DaoFactory;
import dao.OrderDao;
import dao.ProductDao;
import dao.SupplierDao;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

public class AddProductDialog extends Dialog {
	private Text textSku;
	private Text textProdName;
	private Text textDesc;
	private Text textQty_Unit;
	private Text textUnitPrice;
	private Text textColor;
	private Text textDis;
	private Text textUnit_Stock;
	protected Object jfaceSelection;
	ComboViewer cv;
	Combo combo;
	protected IStructuredSelection structuredSelection;
	public AddProductDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Add New Product");
	}
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setLayout(null);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(23, 31, 102, 15);
		lblNewLabel.setText("*SKU");

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setBounds(23, 60, 102, 15);
		lblNewLabel_1.setText("*Product name");

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setBounds(23, 93, 102, 15);
		lblNewLabel_2.setText("Description");

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setBounds(23, 126, 102, 15);
		lblNewLabel_3.setText("Quantity Per Unit");

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setBounds(23, 158, 102, 15);
		lblNewLabel_4.setText(" *Unit Price");

		textSku = new Text(container, SWT.BORDER);
		textSku.setBounds(131, 21, 303, 21);

		textProdName = new Text(container, SWT.BORDER);
		textProdName.setBounds(131, 54, 303, 21);

		textDesc = new Text(container, SWT.BORDER);
		textDesc.setBounds(131, 87, 303, 21);

		textQty_Unit = new Text(container, SWT.BORDER);
		textQty_Unit.setBounds(131, 120, 303, 21);

		textUnitPrice = new Text(container, SWT.BORDER);
		textUnitPrice.setBounds(131, 152, 303, 21);

		Label lblPhone = new Label(container, SWT.NONE);
		lblPhone.setBounds(23, 193, 102, 15);
		lblPhone.setText("Color");

		textColor = new Text(container, SWT.BORDER);
		textColor.setBounds(131, 187, 303, 21);

		Label lblNewLabel_5 = new Label(container, SWT.NONE);
		lblNewLabel_5.setBounds(22, 225, 55, 15);
		lblNewLabel_5.setText("Discount");

		textDis = new Text(container, SWT.BORDER);
		textDis.setBounds(131, 222, 303, 21);

		Label lblUnitInStock = new Label(container, SWT.NONE);
		lblUnitInStock.setText("Unit In Stock");
		lblUnitInStock.setBounds(22, 256, 82, 15);

		textUnit_Stock = new Text(container, SWT.BORDER);
		textUnit_Stock.setBounds(131, 253, 303, 21);

		Label lblCategory = new Label(container, SWT.NONE);
		lblCategory.setText("*Category");
		lblCategory.setBounds(22, 291, 82, 15);

		Label lblSupplier = new Label(container, SWT.NONE);
		lblSupplier.setText("Supplier");
		lblSupplier.setBounds(22, 324, 82, 15);

		cv = new ComboViewer(container, SWT.NONE);
		Combo combo = cv.getCombo();
		combo.setBounds(131, 288, 303, 23);
		cv.setLabelProvider(new GenericNameLabelProvider());
		cv.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Category>)inputElement ) .toArray();
			}
		});
		CategoryDao cDao = DaoFactory.eINSTANCE.createCategoryDao();
		SessionSourceProvider.Category_List = cDao.getList(Category.class);
		cv.setInput(SessionSourceProvider.Category_List);

		cv.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Order o = GeneralFactory.eINSTANCE.createOrder();
				OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;

				if ( !structuredSelection.isEmpty()) {

					if ( structuredSelection.getFirstElement() instanceof Category) {
						SessionSourceProvider.CURRENT_CATEGORY =  (Category)structuredSelection.getFirstElement(); 
					}
				}
			}
		});
		ComboViewer cv2 = new ComboViewer(container, SWT.NONE);
		Combo combo_1 = cv2.getCombo();
		combo_1.setBounds(131, 321, 303, 23);
		cv2.setLabelProvider(new GenericNameLabelProvider());
		cv2.setContentProvider(new ArrayContentProvider() {
			@SuppressWarnings("unchecked")
			@Override
			public Object[] getElements(Object inputElement) {
				return ((java.util.List<Supplier>)inputElement ) .toArray();
			}
		});
		SupplierDao sDao = DaoFactory.eINSTANCE.createSupplierDao();
		List<Supplier> sList = sDao.getList(Supplier.class);
		cv2.setInput(sList);
		cv2.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Order o = GeneralFactory.eINSTANCE.createOrder();
				OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();


				jfaceSelection = event.getSelection();
				structuredSelection = (IStructuredSelection) jfaceSelection;

				if ( !structuredSelection.isEmpty()) {

					if ( structuredSelection.getFirstElement() instanceof Supplier) {
						SessionSourceProvider.CURRENT_SUPPLIER=  (Supplier)structuredSelection.getFirstElement(); 
					}
				}
			}
		});
		return container;
	}

	protected void okPressed()  {
		if(!(textSku.getText().equals("")||textProdName.getText().equals("")||textUnitPrice.getText().equals("")||(cv.getSelection().toString()).equals("<empty selection>"))){
			ProductDao pDao = DaoFactory.eINSTANCE.createProductDao();
			Product p = GeneralFactory.eINSTANCE.createProduct();
			System.out.println("selection is "+cv.getSelection());

			p.setCatergoryId(SessionSourceProvider.CURRENT_CATEGORY);
			p.setSupplierId(SessionSourceProvider.CURRENT_SUPPLIER);

			p.setProductName(textProdName.getText());
			p.setSKU(textSku.getText());

			try{
				if(Double.parseDouble(textUnitPrice.getText())>0)
				{
					p.setUnitPrice(Double.parseDouble(textUnitPrice.getText()));
				}
				else
				{
					MessageDialog.openError(getParentShell(), "instruction", "price is invalid");
					return;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			try{
				p.setQuantityPerUnit(Integer.parseInt(textQty_Unit.getText()));
			}
			catch(java.lang.NumberFormatException e)
			{
				p.setQuantityPerUnit(1);
			}
			try
			{
				p.setUnitsInStock(Integer.parseInt(textUnit_Stock.getText()));
			}
			catch(java.lang.NumberFormatException e){
				p.setUnitsInStock(1);
			}

			p.setTotalQuantity(p.getUnitsInStock()*p.getQuantityPerUnit());
			try{

				p.setDiscount(Double.parseDouble(textDis.getText()));
			}
			catch(Exception e)
			{

			}

			if(p.getTotalQuantity()>1 &&p.getTotalQuantity()<5 )
			{
				p.setImage("icons/workbench/general/R Yellow.png");

			}
			else if(p.getTotalQuantity()<=1 )
			{
				p.setImage("icons/workbench/general/R Red.png");
			}
			else
			{
				p.setImage("icons/workbench/general/R White.png");
			}
			if((pDao.getBySKU2(p.getSKU())).size()==0){


				pDao.create(p);
				SessionSourceProvider.CURRENT_PRODUCT =p;
			}
			else
			{
				MessageDialog.openError(getParentShell(), "Insruction", "This product's sku already exist in the database, you can search for it");
				return;
			}
		}
		else
		{
			MessageDialog.openError(getParentShell(),"instruction","Please fill the mandatory fields");
			return;
		}


		super.okPressed();
	}
}
