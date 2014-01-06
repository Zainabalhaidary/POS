package com.marbleArchPaint.softwareEngineering;


import general.Category;
import general.Customer;
import general.Order;
import general.OrderDetails;
import general.Product;
import general.SessionSatus;
import general.Supplier;
import general.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;



/**
 *
 * This class provides the session variables! 
 * All static and global 
 * Nice not the dirty way via activator class
 *
 */
public class SessionSourceProvider extends AbstractSourceProvider {
	
	public final static String SESSION_STATE = "com.amenity.workbench.sessionState"; 
	private final static String LOGGED_IN = "loggedIn"; 
    private final static String LOGGED_OUT = "loggedOut";
	
	
    // User Information
    public static String USERID = "-";
    public static User USER = null;
    public static Category CURRENT_CATEGORY = null;
    public static Order CURRENT_ORDER = null ;
    public static SessionSatus SESSION_STATUS = null;
    public static Product CURRENT_PRODUCT = null;
    public static Customer CURRENT_CUSTOMER = null;
    public static List<Category> Category_List = null;
    public static List<OrderDetails> OrderDetails_List = null;
    public static OrderDetails CURRENT_ORDERDETAILS = null;
    public static Supplier CURRENT_SUPPLIER =null;
 
    
    
//    public static SessionFactory HIBERNATE_SESSION_FACTORY = null;
//    public static Session HIBERNATE_SESSION = null;

    public static Properties LOG4J_PROPERTIES = null;
	

	
	
	
	
	
    boolean loggedIn;
    
    public void setLoggedIn ( boolean loggedIn ) {
    	if ( this.loggedIn == loggedIn )
    		return;
    	this.loggedIn = loggedIn;
    	String currentState = loggedIn?LOGGED_IN:LOGGED_OUT;
        fireSourceChanged(ISources.WORKBENCH, SESSION_STATE, currentState);
    }
    
	@Override
	public void dispose() {
	}

	@Override
	public Map<String, String> getCurrentState() {
		Map<String, String> currentState = new HashMap<String, String>(1);
        String currentState2 =  loggedIn?LOGGED_IN:LOGGED_OUT;
        currentState.put(SESSION_STATE, currentState2);
        return currentState;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] {SESSION_STATE};
	}

}
