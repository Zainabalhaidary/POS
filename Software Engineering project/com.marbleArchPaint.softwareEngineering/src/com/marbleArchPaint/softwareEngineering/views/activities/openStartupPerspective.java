package com.marbleArchPaint.softwareEngineering.views.activities;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.PlatformUI;

public class openStartupPerspective extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IPerspectiveRegistry reg = PlatformUI.getWorkbench().getPerspectiveRegistry();
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0]
					.setPerspective(reg
							.findPerspectiveWithId("com.marbleArchPaint.softwareEngineering.StartupPerspective"));
			
		return null;
	}
}
