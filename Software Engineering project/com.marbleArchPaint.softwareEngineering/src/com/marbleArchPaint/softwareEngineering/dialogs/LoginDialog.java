package com.marbleArchPaint.softwareEngineering.dialogs;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;


import general.GeneralFactory;
import general.User;


import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.marbleArchPaint.softwareEngineering.Application;
import com.marbleArchPaint.softwareEngineering.SessionSourceProvider;
import com.marbleArchPaint.softwareEngineering.listComparators.stringComparator;



import dao.DaoFactory;
import dao.GeneralQueries;
import dao.UserDao;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.wb.swt.SWTResourceManager;

@SuppressWarnings("unused")
public class LoginDialog extends Dialog {
	/**
	 * Manning JFace Page 231
	 */
	private Text text;
	private static final int RESET_ID = IDialogConstants.NO_TO_ALL_ID + 1;
	private GeneralQueries genericQueries;
	private boolean dbAlive = false;
	private Adapter adapter;
	//private Logger log;
	private User tempUser;
	private UserDao userDao;
	Button cancel_button; 
	Button ok_button; 
	Button reset_button; 
	private Text text_1;
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public LoginDialog(Shell parentShell) {
		super(parentShell);
		adapter = new AdapterImpl() {
			public void notifyChanged ( Notification notification ) {
				System.out.println("New database Status: " + 
						SessionSourceProvider.SESSION_STATUS.isDbStatus());
			}
		};

		
		/*
		 *  at login the database status is checked
		 */
		genericQueries = DaoFactory.eINSTANCE.createGeneralQueries();
		if ( genericQueries.dbAlive() ) {
			dbAlive = true;
			//log.info("Database is running#1");
		} else {
			//log.error("Database server is offline#1");
		}
	}
	
	@Override
	protected void configureShell(Shell shell) {
	      super.configureShell(shell);
	      shell.setText("Marble Arch Paint");
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(255, 239, 213));
					
		Composite container = (Composite) super.createDialogArea(parent);
		container.setBackground(SWTResourceManager.getColor(255, 239, 213));
		
//		parent.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if ( e.keyCode == SWT.ESC) {
//					buttonPressed(Window.CANCEL);
//				}
//			}
//		});
		
		container.setLayout(null);

		Label lblUserName = new Label(container, SWT.NONE);
		lblUserName.setBackground(SWTResourceManager.getColor(255, 239, 213));
		lblUserName.setBounds(10, 36, 100, 15);
		lblUserName.setText("User Name");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(116, 33, 167, 21);
		text.setText(System.getenv("username"));
		text.setEnabled(false);
		Button button = new Button(container, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			
			// simply allows to change the user name... 
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				text.setEnabled(true);
				
			}
		});
		button.setBounds(289, 30, 27, 25);
		button.setText("...");
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		if ( dbAlive )
			lblNewLabel.setImage(ResourceManager
					.getPluginImage("com.marbleArchPaint.softwareEngineering", 
							"icons/workbench/status/hypersql_on.png"));
		else 
			lblNewLabel.setImage(ResourceManager
					.getPluginImage("com.marbleArchPaint.softwareEngineering", 
							"icons/workbench/status/hypersql_off.png"));
		
		lblNewLabel.setBounds(116, 106, 16, 16);
		lblNewLabel.setVisible(false);
		Label lblDatabaseStatus = new Label(container, SWT.NONE);
		lblDatabaseStatus.setBounds(10, 106, 100, 15);
		lblDatabaseStatus.setText("Database Status");
		lblDatabaseStatus.setVisible(false);
		
		 cancel_button = new Button(container, SWT.NONE); 
         cancel_button.addSelectionListener(new SelectionAdapter() { 
                 @Override 
                 public void widgetSelected(SelectionEvent e) { 
                         buttonPressed(1); 
                 } 
         }); 
         cancel_button.setBounds(213,129, 70, 25); 
         cancel_button.setText("Cancel"); 
         
          ok_button = new Button(container, SWT.NONE); 
         ok_button.addSelectionListener(new SelectionAdapter() { 
                 @Override 
                 public void widgetSelected(SelectionEvent e) { 
                         
                         buttonPressed(0); 
                         
                 } 
         }); 
         
         ok_button.setBounds(134,129, 73, 25); 
         ok_button.setText("OK"); 
         
         Label lblPassword = new Label(container, SWT.NONE);
         lblPassword.setBackground(SWTResourceManager.getColor(255, 239, 213));
         lblPassword.setBounds(10, 63, 55, 15);
         lblPassword.setText("Password");
         
         text_1 = new Text(container, SWT.BORDER);
         text_1.setBounds(116, 60, 167, 21);
         
//         reset_button = new Button(container, SWT.NONE); 
//         reset_button.addSelectionListener(new SelectionAdapter() { 
//                 @Override 
//                 public void widgetSelected(SelectionEvent e) { 
//                         buttonPressed(RESET_ID ); 
//                 } 
//         }); 
//         reset_button.setBounds(225,105, 70, 25); 
//         reset_button.setText("Reset"); 
//         reset_button.setVisible(false);
		for ( int i = 0 ; i<  container.getChildren().length ; i++ ){ 
            System.out.println(container.getChildren()[i].toString()); 
    
            container.getChildren()[i].addKeyListener(new KeyAdapter() { 
            @Override 
            public void keyPressed ( KeyEvent e) { 
                    if (e.keyCode ==SWT.CR ) { 
                            System.out.println("ENTER pressed"); 
                            buttonPressed(0);
                            
                    } 
            } 
    }); 
    } 
    
    parent.addKeyListener(new KeyAdapter() { 
            @Override 
            public void keyPressed ( KeyEvent e) { 
           	 if (e.keyCode ==SWT.CR ) { 
                    System.out.println("ENTER pressed"); 
                    buttonPressed(0);
                    
            } 
            } 
    }); 
    container.addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
       	 if (e.keyCode ==SWT.CR ) { 
                System.out.println("ENTER pressed"); 
                buttonPressed(0);
                
        } 
        } 
}); 
    
    container.addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed (KeyEvent event ) { 
                if ( event.keyCode  == SWT.ESC ){ 
                        
                
                        System.out.println("ESC"); 
                    buttonPressed(1); 
                } 
        } 
}); 
for ( int i = 0 ; i<  container.getChildren().length ; i++ ){ 
        container.getChildren()[i].addKeyListener(new KeyAdapter() { 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == SWT.ESC) { 
                     buttonPressed(1); 
             } 
        } 
}); 
} 


for ( int i = 0 ; i<  container.getChildren().length ; i++ ){ 
        System.out.println(container.getChildren()[i].toString()); 

        container.getChildren()[i].addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == 111 && e.stateMask ==SWT.ALT ) { 
                        System.out.println("alt o pressed"); 
                        //button.setFocus(); 
                        //Button ok = ok_button;getButton(IDialogConstants.OK_ID); 
                        ok_button.setFocus(); 
                        
                } 
        } 
}); 
} 

parent.addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == 111 && e.stateMask ==SWT.ALT ) { 
                        System.out.println("alt o pressed"); 
                        //button.setFocus(); 
                        //Button ok = ok_button;getButton(IDialogConstants.OK_ID); 
                        ok_button.setFocus(); 
                        
                } 
        } 
}); 

container.addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == 111 && e.stateMask ==SWT.ALT ) { 
                        System.out.println("alt o pressed"); 
                        //button.setFocus(); 
                        //Button ok = ok_button;getButton(IDialogConstants.OK_ID); 
                        ok_button.setFocus(); 
                        
                } 
        } 
}); 

for ( int i = 0 ; i<  container.getChildren().length ; i++ ){ 
        System.out.println(container.getChildren()[i].toString()); 

        container.getChildren()[i].addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == 114 && e.stateMask ==SWT.ALT ) { 
                        System.out.println("alt r pressed"); 
                        //button.setFocus(); 
                        //Button ok = ok_button;getButton(IDialogConstants.OK_ID); 
                        reset_button.setFocus(); 
                        
                } 
        } 
}); 
} 

parent.addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == 114 && e.stateMask ==SWT.ALT ) { 
                        System.out.println("alt r pressed"); 
                        //button.setFocus(); 
                        //Button ok = ok_button;getButton(IDialogConstants.OK_ID); 
                        reset_button.setFocus(); 
                        
                } 
        } 
}); 

container.addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == 114 && e.stateMask ==SWT.ALT ) { 
                        System.out.println("alt r pressed"); 
                        //button.setFocus(); 
                        //Button ok = ok_button;getButton(IDialogConstants.OK_ID); 
                        reset_button.setFocus(); 
                        
                } 
        } 
}); 


for ( int i = 0 ; i<  container.getChildren().length ; i++ ){ 
        System.out.println(container.getChildren()[i].toString()); 

        container.getChildren()[i].addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == 99 && e.stateMask ==SWT.ALT ) { 
                        System.out.println("alt c pressed"); 
                        //button.setFocus(); 
                        //Button ok = ok_button;getButton(IDialogConstants.OK_ID); 
                    cancel_button.setFocus(); 
                        
                } 
        } 
}); 
} 

parent.addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == 99 && e.stateMask ==SWT.ALT ) { 
                        System.out.println("alt c pressed"); 
                        //button.setFocus(); 
                        //Button ok = ok_button;getButton(IDialogConstants.OK_ID); 
                        cancel_button.setFocus(); 
                        
                } 
        } 
}); 

container.addKeyListener(new KeyAdapter() { 
        @Override 
        public void keyPressed ( KeyEvent e) { 
                if (e.keyCode == 99 && e.stateMask ==SWT.ALT ) { 
                        System.out.println("alt c pressed"); 
                        //button.setFocus(); 
                        //Button ok = ok_button;getButton(IDialogConstants.OK_ID); 
                        cancel_button.setFocus(); 
                        
                } 
        } 
}); 

		
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(255, 239, 213));
//		super.createButtonsForButtonBar(parent);
//		createButton(parent, RESET_ID, "Reset All", false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(332, 219);
	}
	
	@SuppressWarnings("unchecked")
	protected void buttonPressed ( int buttonId ) {
		/*
		 * ID 0 : OK
		 * ID 1 : Cancel
		 */
		if ( buttonId == RESET_ID ) {
			text.setText(System.getenv("username"));
			text.setEnabled(false);
			text_1.setText("");
//			btnRememberMyPassword.setSelection(false);
//			
		} else if ( buttonId == 0 ){	// on OK

			
			SessionSourceProvider sessionSourceProvider = new SessionSourceProvider();
			sessionSourceProvider.setLoggedIn(true);
			SessionSourceProvider.SESSION_STATUS = GeneralFactory.eINSTANCE.createSessionSatus();
			SessionSourceProvider.SESSION_STATUS.eAdapters().add(adapter);
			SessionSourceProvider.SESSION_STATUS.setDbStatus(dbAlive);
			if ( dbAlive ) {
				try {
					int result = userExists();
					if ( result == 1) {	// User does not exist in Database! 
						// create new user
						tempUser = GeneralFactory.eINSTANCE.createUser();
//						tempUser.setUsername(System.getenv("username"));
						tempUser.setUsername(text.getText());
						tempUser.setPassword(text_1.getText());
						tempUser.setLastUsed( new Date() );
						tempUser.setTimesUsed(0);
						userDao.create(tempUser);
						//log.info("user created...#1");
					}
					else if (result == -1)
					{
						text_1.setText("");
						//super.buttonPressed(1); 
						return;
					}
					
					if(result == 0 || result == 1)
					{
					// counter up
					tempUser.setTimesUsed(tempUser.getTimesUsed() + 1);
					tempUser.setLastUsed(new Date());
					userDao.update(tempUser);
					// set session variables
					sessionSourceProvider.setLoggedIn(true);
					SessionSourceProvider.USERID = tempUser.getUserId();
					SessionSourceProvider.USER = tempUser;
					

					//PropertyConfigurator.configure(SessionSourceProvider.LOG4J_PROPERTIES);
					//MDC.put("userid", SessionSourceProvider.USER.getUserId());
				//	Logger log = LogManager.getLogger(LoginDialog.class);
					//MDC.put("uuid",UUID.randomUUID().toString());
					//log.info("user logged in");
					
					super.buttonPressed(buttonId);
					}
				} catch ( Exception ex ) {
					//log.error("Problem with Database Connection#1");
					ErrorDialog errorDialog = new ErrorDialog(this.getShell(),
							"Database Connection Error",
							"There is a problem with the database connection! ",
							createStatus(),
							IStatus.ERROR | IStatus.INFO );
					errorDialog.open();
					ex.printStackTrace();
					
				}
			} else {
				MessageDialog.openError(null, "Error", "DB Server not running");

				//log.error("DB Server not running#1");
			}
			
		} else { //cancel and stuff
			super.buttonPressed(buttonId);
		}
	}

	private IStatus createStatus() {
		final String dummyPlugin = "some plugin";
		IStatus[] statuses = new IStatus[1];
		
		statuses[0] = new Status(IStatus.ERROR, dummyPlugin, 
				IStatus.OK, "Oh no! An error occurred!", new Exception());
		
//		statuses[1] = new Status(IStatus.INFO, dummyPlugin, 
//				IStatus.OK, "More errors!?!?", new Exception() );
		
//		MultiStatus multiStatus = new MultiStatus(dummyPlugin, IStatus.OK,
//				statuses, "Several errors have occurred.", new Exception() );
		
//		return multiStatus;
		return new Status(IStatus.ERROR, dummyPlugin, 
				IStatus.OK, "Please confirm your username!", new Exception());
		
	}
	
	private int userExists() {
		
		tempUser = GeneralFactory.eINSTANCE.createUser();
		tempUser.setUsername( text.getText() );
		userDao = DaoFactory.eINSTANCE.createUserDao();
		tempUser = userDao.findByUsername(tempUser);
		//		System.out.println(tempUser.getUsername());
		if (tempUser == null) {
			//			log.error("User does not exist in database#1");
			return 1;
		}
		else if(tempUser != null && !tempUser.getPassword().equals(text_1.getText()))
		{
			MessageDialog.openError(getParentShell(), "Error", "incorrect password");
			return -1;
		}

		else {
			//log.info("User with ID: " + tempUser.getUserId() + " found#1");
			return 0;
		}

	}
}
