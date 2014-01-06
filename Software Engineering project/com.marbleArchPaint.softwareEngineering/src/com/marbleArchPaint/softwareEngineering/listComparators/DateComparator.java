//package com.marbleArchPaint.softwareEngineering.listComparators;
//
//import general.OrderDetails;
//
//import java.util.Comparator;
//
//@SuppressWarnings("rawtypes")
//public class DateComparator implements Comparator{
//
//	
//	@Override
//	public int compare(Object s1, Object s2) {
//		//System.out.println("I was called");
//		OrderDetails od1= (OrderDetails) s1;
//		//stem.out.println(od1);
//		
//		OrderDetails od2= (OrderDetails) s2;
//
//			if(((od1.getProductId().getProductName()).compareTo((od2.getProductId().getProductName())))<0){
////				System.out.println("((od1.getProductId().getProductName()).compareTo((od2.getProductId().getProductName())))<0");
////				System.out.println(((od1.getProductId().getProductName()).compareTo((od2.getProductId().getProductName())))<0);
////				System.out.println("od1"+((od1.getProductId().getProductName())));
////				System.out.println("od2"+((od2.getProductId().getProductName())));
//				return -1;    
//			}else if(((od1.getProductId().getProductName()).compareTo((od2.getProductId().getProductName())))==0){
////				System.out.println("((od1.getProductId().getProductName()).compareTo((od2.getProductId().getProductName())))==0");
////				System.out.println(((od1.getProductId().getProductName()).compareTo((od2.getProductId().getProductName())))==0);
////				System.out.println("od1"+((od1.getProductId().getProductName())));
////				System.out.println("od2"+((od2.getProductId().getProductName())));
//				return 0;
//			}else if(((od1.getProductId().getProductName()).compareTo((od2.getProductId().getProductName())))>0){
////				System.out.println("((od1.getProductId().getProductName()).compareTo((od2.getProductId().getProductName())))>0");
////				System.out.println(((od1.getProductId().getProductName()).compareTo((od2.getProductId().getProductName())))>0);
////				System.out.println("od1"+((od1.getProductId().getProductName())));
////				System.out.println("od2"+((od2.getProductId().getProductName())));
//				return 1;
//			}
//			return 0;
//	}
//
//
//}
//
//
//
//
//
//

package com.marbleArchPaint.softwareEngineering.listComparators;

import general.Order;
import general.OrderDetails;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class DateComparator implements Comparator{

	
	@Override
	public int compare(Object s1, Object s2) {
		
		if(s1 instanceof OrderDetails){

		OrderDetails od1= (OrderDetails) s1;
		
		OrderDetails od2= (OrderDetails) s2;

			if(od1.getDate().before(od2.getDate()))
				
				return 1;    
			else if(od1.getDate().equals(od2.getDate()))

				return 0;
			else if(od1.getDate().after(od2.getDate()))

				return -1;
			
			return 0;
		}
		else if(s1 instanceof Order)
		{
			Order od1= (Order) s1;
			
			Order od2= (Order) s2;

				if(od1.getOrderDate().before(od2.getOrderDate()))
					
					return 1;    
				else if(od1.getOrderDate().equals(od2.getOrderDate()))

					return 0;
				else if(od1.getOrderDate().after(od2.getOrderDate()))

					return -1;
				
				return 0;
		}
		
		return 0;
	}


}






