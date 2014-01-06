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
import org.eclipse.wb.swt.ResourceManager;
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
import org.eclipse.swt.events.SelectionAdapter;

public class CreateReportDialog extends Dialog {
	protected Object jfaceSelection;
	protected IStructuredSelection structuredSelection;
	public static Text text;
	public static Text text_1;
	public CreateReportDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Create Orders Report");
	}
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setLayout(null);
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(70, 20, 311, 21);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(70, 60, 311, 21);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 23, 55, 15);
		lblNewLabel.setText("From");
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setBounds(9, 60, 55, 15);
		lblNewLabel_1.setText("To");
		
		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalendarDialog cd = new CalendarDialog(getParentShell());
				if(cd.open()==0)
				{
					
				}
			}
		});
		btnNewButton.setBounds(384, 16, 24, 25);
		btnNewButton.setImage(ResourceManager.getPluginImage("com.marbleArchPaint.softwareEngineering", "icons/workbench/general/layout_edit.png"));
		Button btnNewButton_1 = new Button(container, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalendarDialog2 cd2 = new CalendarDialog2(getParentShell());
				if(cd2.open()==0)
				{
					
				}
			}
		});
		btnNewButton_1.setBounds(384, 56, 24, 25);
		btnNewButton_1.setImage(ResourceManager.getPluginImage("com.marbleArchPaint.softwareEngineering", "icons/workbench/general/layout_edit.png"));
		
		
		
		return container;
	}

	protected void okPressed()  {
		

		super.okPressed();
	}
}
