package com.marbleArchPaint.softwareEngineering.LabelProvider;

import general.*;

import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;



public class GenericNameLabelProvider extends LabelProvider  {
	
	@Override
	public String getText(Object element) {
		if (element instanceof Category) {
			return ((Category) element).getCategoryName();
		} else 
			if (element instanceof Customer) {
			return ((Customer) element).getFirstName();
		} else 
			if (element instanceof Order) {
			return ((Order) element).getOrderDate().toString();
		} else 
			if (element instanceof User) {
			return ((User) element).getUsername();
		} else 
			if (element instanceof OrderDetails) {
			return ((OrderDetails) element).getProductId().getProductName();
		} else 
			if (element instanceof Product) {
			return ((Product) element).getSKU()+" "+((Product) element).getProductName();
		} else 
			if (element instanceof Shipper) {
			return ((Shipper) element).getCompanyName();
		} else 
			if (element instanceof Supplier) {
			return ((Supplier) element).getCompanyName();
			}
						else 
							return element.toString();
		
	}
	
	@Override
	public Image getImage(Object element) {
//		if ( element instanceof Folder ) {
//
//			if ( ((Folder)element).isDummy() ) 
//				return PlatformUI.getWorkbench().getSharedImages()
//						.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
//			
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_FOLDER);
//			
//		}
//		else 
//			if ( element instanceof File ) {
//
//				if ( ((File)element).isDummy() ) 
//					return PlatformUI.getWorkbench().getSharedImages()
//							.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
//				
//				if(((File)element).getName().equals("Share Point File") )
//					return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_ADD);
//				
//				return PlatformUI.getWorkbench().getSharedImages()
//						.getImage(ISharedImages.IMG_OBJ_FILE);
//				
//		}
//		else if ( element instanceof Connection ) 
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_ELCL_SYNCED);
//		else if ( element instanceof Snapshot ) 
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
//		else if ( element instanceof Project ) 
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_ETOOL_DEF_PERSPECTIVE);
//		else if ( element instanceof DataSource ) 
//			return PlatformUI.getWorkbench().getSharedImages()
//					.getImage(ISharedImages.IMG_OBJ_ADD);
//		else if ( element instanceof Vcycle ) 
//			return ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/V.png");
//		else if ( element instanceof Release ) 
//			return ResourceManager.getPluginImage("com.amenity.workbench", ((Release)element).getImage());
//		else if ( element instanceof MS ) 
//			return ResourceManager.getPluginImage("com.amenity.workbench", "icons/workbench/general/G.png");
//		/*
//		 * TODO: implement DB link for icon store! 
//		 */
		return PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_OBJ_FILE);
	}

}
