package com.marbleArchPaint.softwareEngineering.dialogs;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Shell;

public class CalendarDialog extends Dialog {
	
	

	public static Date date;
	public DateTime calendar ;
	public CalendarDialog(Shell parentShell) {
		super(parentShell);
		
		
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		calendar = new DateTime(container, SWT.CALENDAR | SWT.BORDER);
		
			

		return null;	
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void okPressed()  {
		//System.out.println((calendar.getMonth () + 1) + "/" + calendar.getDay () + "/" + calendar.getYear());

		//Date d = new Date((calendar.getMonth () + 1) + "/" + calendar.getDay () + "/" + calendar.getYear ());

		DateFormat df = new SimpleDateFormat("mm/dd/yy hh:hh");
		Date d = null;
		
		try {
		d = df.parse((calendar.getMonth () + 1) + "/" + calendar.getDay () + "/" + calendar.getYear ()+" "+"00:00");
		System.out.println(d.toString());
		 CreateReportDialog.text.setText((calendar.getMonth () + 1) + "/" + calendar.getDay () + "/" + calendar.getYear ());

		//df.parse( calendar.getDay()+ "/" + (calendar.getMonth() + 1) + "/" + calendar.getYear ()).toString());//= df.parse( calendar.getDay()+ "/" + (calendar.getMonth() + 1) + "/" + calendar.getYear ()).toString();
//		 Date d = df.parse((calendar.getMonth () + 1) + "/" + calendar.getDay () + "/" + calendar.getYear()+" "+"00:00");
//		System.out.println("date is "+d);
		} catch (Exception e1) {
			// 
			e1.printStackTrace();
		}
		super.okPressed();
	}
	
	
	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("CalendarDialog");
	}
}
