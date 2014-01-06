package com.marbleArchPaint.softwareEngineering.dialogs;

import general.Category;
import general.Customer;
import general.GeneralFactory;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
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

public class AddCategoryDialog extends Dialog {
	private Text text;
	private Text text_1;

	public AddCategoryDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("Add New Category");
	}
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
					
		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setLayout(null);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 27, 113, 15);
		lblNewLabel.setText("Category Name");
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setBounds(10, 69, 113, 15);
		lblNewLabel_1.setText("Category Description");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(129, 27, 292, 21);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(129, 69, 292, 21);
	return container;
	}
	
	protected void okPressed()  {
//		CustomerDao ccDao = DaoFactory.eINSTANCE.createCustomerDao();
//		Customer cc = GeneralFactory.eINSTANCE.createCustomer();
//		cc.setFirstName("lolo");
//		cc.setLastName("soso");
//		ccDao.create(cc);
		if(!(text.getText().equals(""))){
		CategoryDao cDao =DaoFactory.eINSTANCE.createCategoryDao();
		Category category = GeneralFactory.eINSTANCE.createCategory();
		category.setCategoryName(text.getText());
		category.setDescription(text_1.getText());
		cDao.create(category);
		
		
		SessionSourceProvider.Category_List=cDao.getList(Category.class);
		Pos.tv.setInput(SessionSourceProvider.Category_List);
		super.okPressed();
		}
		else
		{
			MessageDialog.openError(getParentShell(), "Instruction", "Please insert at least the category name");
		}
	}
	
}
