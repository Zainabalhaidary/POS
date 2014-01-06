package com.marbleArchPaint.softwareEngineering.dialogs;

import general.Category;
import general.Customer;
import general.GeneralFactory;
import general.Order;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
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
import com.marbleArchPaint.softwareEngineering.views.Pos;

import dao.CategoryDao;
import dao.CustomerDao;
import dao.DaoFactory;
import dao.OrderDao;

import org.eclipse.swt.widgets.Button;

public class AddCustomerDialog extends Dialog {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	public Button btnRadioButton;
	public Button btnRadioButton_1;
	public AddCustomerDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Add New Customer");
	}
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setLayout(null);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(23, 31, 102, 15);
		lblNewLabel.setText("*First Name");

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setBounds(23, 60, 102, 15);
		lblNewLabel_1.setText("Last Name");

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setBounds(23, 93, 102, 15);
		lblNewLabel_2.setText("*Address");

		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setBounds(23, 126, 102, 15);
		lblNewLabel_3.setText("Shipping Address");

		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setBounds(23, 158, 102, 15);
		lblNewLabel_4.setText("Billing Address");

		text = new Text(container, SWT.BORDER);
		text.setBounds(131, 21, 303, 21);

		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(131, 54, 303, 21);

		text_2 = new Text(container, SWT.BORDER);
		text_2.setBounds(131, 87, 303, 21);

		text_3 = new Text(container, SWT.BORDER);
		text_3.setBounds(131, 120, 303, 21);

		text_4 = new Text(container, SWT.BORDER);
		text_4.setBounds(131, 152, 303, 21);

		btnRadioButton = new Button(container, SWT.RADIO);
		btnRadioButton.setBounds(23, 257, 158, 16);
		btnRadioButton.setText("Add Only To Database");
		btnRadioButton.setSelection(true);
		btnRadioButton_1 = new Button(container, SWT.RADIO);
		btnRadioButton_1.setBounds(212, 257, 180, 16);
		btnRadioButton_1.setText("Add To The Current Order");

		Label lblPhone = new Label(container, SWT.NONE);
		lblPhone.setBounds(23, 193, 102, 15);
		lblPhone.setText("*Phone");

		text_5 = new Text(container, SWT.BORDER);
		text_5.setBounds(131, 187, 303, 21);

		Label lblNewLabel_5 = new Label(container, SWT.NONE);
		lblNewLabel_5.setBounds(22, 225, 55, 15);
		lblNewLabel_5.setText("*Email");

		text_6 = new Text(container, SWT.BORDER);
		text_6.setBounds(131, 225, 303, 21);

		btnRadioButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				btnRadioButton_1.setSelection(false);
				btnRadioButton.setSelection(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnRadioButton_1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				btnRadioButton.setSelection(false);
				btnRadioButton_1.setSelection(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		return container;
	}

	protected void okPressed()  {
		if(!(text.getText().equals("")||text_2.getText().equals("")||text_5.getText().equals("")||text_6.getText().equals(""))){
			CustomerDao cDao = DaoFactory.eINSTANCE.createCustomerDao();
			Customer c = GeneralFactory.eINSTANCE.createCustomer();
			c.setFirstName(text.getText());
			c.setLastName(text_1.getText());
			c.setAddress(text_2.getText());
			c.setShippingAddress(text_3.getText());
			c.setBillingAddress(text_4.getText());
			c.setPhone(text_5.getText());
			c.setEmail(text_6.getText());
			cDao.create(c);
			//SessionSourceProvider.CURRENT_CUSTOMER = c;
			//		Pos.lblNewLabel_14.setText(SessionSourceProvider.CURRENT_CUSTOMER.getFirstName()+" "+SessionSourceProvider.CURRENT_CUSTOMER.getLastName());
			//		
			if(btnRadioButton_1.getSelection()==true)
			{
				SessionSourceProvider.CURRENT_CUSTOMER = c;
				Order o = SessionSourceProvider.CURRENT_ORDER;
				OrderDao oDao = DaoFactory.eINSTANCE.createOrderDao();
				o.setCustomerId(SessionSourceProvider.CURRENT_CUSTOMER);
				Pos.lblNewLabel_14.setText(SessionSourceProvider.CURRENT_CUSTOMER.getFirstName()+" "+SessionSourceProvider.CURRENT_CUSTOMER.getLastName());

				oDao.update(o);
			}
		}
		else
		{
			MessageDialog.openError(getParentShell(),"instruction","please fill in all the mandatory fields");
		}


		super.okPressed();
	}
}
