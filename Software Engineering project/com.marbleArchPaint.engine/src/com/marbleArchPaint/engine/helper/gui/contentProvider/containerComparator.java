package com.marbleArchPaint.engine.helper.gui.contentProvider;

import general.Connection;
import general.Project;
import general.Function;
import general.Snapshot;

import java.util.Comparator;



@SuppressWarnings("rawtypes")
public class containerComparator implements Comparator {


	@Override
	public int compare(Object s1, Object s2) {

		if(s1 instanceof Project)
		{
			Project sp1 = (Project) s1;
			Project sp2 = (Project) s2;
			//	System.out.println("I'm in the comparator");
			//	byte[] bytes = vc1.getMilestone().getName().getBytes("US-ASCII");
			//	vc1.getMilestone().getName().compareTo(vc2.getMilestone().getName());
			//	if(((vc1.getMilestone().getName()+" "+vc1.getName()).compareTo(vc2.getMilestone().getName()+" "+vc2.getName()))>0){
			if(((sp1.getCreated()).compareTo(sp2.getCreated()))>0){
				//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
				//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
				return 1;    
			}else if(((sp1.getCreated()).compareTo(sp2.getCreated()))==0){
				//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
				//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
				return 0;
			}else if(((sp1.getCreated()).compareTo(sp2.getCreated()))<0){
				//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
				//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
				return -1;
			}
		}
		else
			if(s1 instanceof Snapshot)
			{
				Snapshot sp1 = (Snapshot) s1;
				Snapshot sp2 = (Snapshot) s2;
				//	System.out.println("I'm in the comparator");
				//	byte[] bytes = vc1.getMilestone().getName().getBytes("US-ASCII");
				//	vc1.getMilestone().getName().compareTo(vc2.getMilestone().getName());
				//	if(((vc1.getMilestone().getName()+" "+vc1.getName()).compareTo(vc2.getMilestone().getName()+" "+vc2.getName()))>0){
				if(((sp1.getCreated()).compareTo(sp2.getCreated()))>0){
					//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
					//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
					return 1;    
				}else if(((sp1.getCreated()).compareTo(sp2.getCreated()))==0){
					//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
					//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
					return 0;
				}else if(((sp1.getCreated()).compareTo(sp2.getCreated()))<0){
					//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
					//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
					return -1;
				}
			}
		
			else
				if(s1 instanceof Function)
				{
					Function sp1 = (Function) s1;
					Function sp2 = (Function) s2;
					//	System.out.println("I'm in the comparator");
					//	byte[] bytes = vc1.getMilestone().getName().getBytes("US-ASCII");
					//	vc1.getMilestone().getName().compareTo(vc2.getMilestone().getName());
					//	if(((vc1.getMilestone().getName()+" "+vc1.getName()).compareTo(vc2.getMilestone().getName()+" "+vc2.getName()))>0){
					if(((sp1.getCreated()).compareTo(sp2.getCreated()))>0){
						//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
						//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
						return 1;    
					}else if(((sp1.getCreated()).compareTo(sp2.getCreated()))==0){
						//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
						//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
						return 0;
					}else if(((sp1.getCreated()).compareTo(sp2.getCreated()))<0){
						//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
						//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
						return -1;
					}
				}
				else
					if(s1 instanceof Connection)
					{
						Connection sp1 = (Connection) s1;
						Connection sp2 = (Connection) s2;
						//	System.out.println("I'm in the comparator");
						//	byte[] bytes = vc1.getMilestone().getName().getBytes("US-ASCII");
						//	vc1.getMilestone().getName().compareTo(vc2.getMilestone().getName());
						//	if(((vc1.getMilestone().getName()+" "+vc1.getName()).compareTo(vc2.getMilestone().getName()+" "+vc2.getName()))>0){
						if(((sp1.getCreated()).compareTo(sp2.getCreated()))>0){
							//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
							//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
							return 1;    
						}else if(((sp1.getCreated()).compareTo(sp2.getCreated()))==0){
							//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
							//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
							return 0;
						}else if(((sp1.getCreated()).compareTo(sp2.getCreated()))<0){
							//		System.out.println(((vc1.getCreated()+" "+vc1.getName()).compareTo(vc2.getCreated()+" "+vc2.getName())));
							//		System.out.println(((vc1.getCreated()+" "+vc1.getName())+" compareTo "+(vc2.getCreated()+" "+vc2.getName())));
							return -1;
						}
					}
		
		return 0;
	}





}
