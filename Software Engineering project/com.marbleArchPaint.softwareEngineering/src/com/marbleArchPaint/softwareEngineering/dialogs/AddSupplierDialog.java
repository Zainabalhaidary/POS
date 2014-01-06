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

public class AddSupplierDialog extends Dialog {
	private Text textCompanyName;
	private Text textAddress;
	private Text textPhone;
	private Text textEmail;
	protected Object jfaceSelection;
	protected IStructuredSelection structuredSelection;
	public AddSupplierDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Add New Supplier");
	}
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setLayout(null);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(23, 31, 102, 15);
		lblNewLabel.setText("*Company Name");

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setBounds(23, 60, 102, 15);
		lblNewLabel_1.setText("Address");

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setBounds(23, 93, 102, 15);
		lblNewLabel_2.setText("*Phone");

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setBounds(23, 126, 102, 15);
		lblNewLabel_3.setText("*Email");

		textCompanyName = new Text(container, SWT.BORDER);
		textCompanyName.setBounds(131, 21, 303, 21);

		textAddress = new Text(container, SWT.BORDER);
		textAddress.setBounds(131, 54, 303, 21);

		textPhone = new Text(container, SWT.BORDER);
		textPhone.setBounds(131, 87, 303, 21);

		textEmail = new Text(container, SWT.BORDER);
		textEmail.setBounds(131, 120, 303, 21);
		
		
		return container;
	}

	protected void okPressed()  {
		if(!(textCompanyName.getText().equals("")||textPhone.getText().equals("")||textEmail.getText().equals(""))){
			Supplier s = GeneralFactory.eINSTANCE.createSupplier();
			SupplierDao sDao = DaoFactory.eINSTANCE.createSupplierDao();
			s.setCompanyName(textCompanyName.getText());
			s.setAddress(textAddress.getText());
			s.setEmail(textEmail.getText());
			s.setPhone(textPhone.getText());
			sDao.create(s);
			
		}
		else
		{
			MessageDialog.openError(getParentShell(),"instruction","Please fill in all the mandatory fields");
			return;
			
		}


		super.okPressed();
	}
}
