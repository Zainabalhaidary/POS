package com.marbleArchPaint.softwareEngineering.listComparators;


import java.util.Comparator;



@SuppressWarnings("rawtypes")
public class stringComparator implements Comparator {


	@Override
	public int compare(Object s1, Object s2) {

		

			if((((String)s1).compareTo(((String)s2)))>0){

				return 1;    
			}else if((((String)s1).compareTo(((String)s2)))==0){

				return 0;
			}else if((((String)s1).compareTo(((String)s2)))<0){

				return -1;
			}
			return 0;
	}



}
