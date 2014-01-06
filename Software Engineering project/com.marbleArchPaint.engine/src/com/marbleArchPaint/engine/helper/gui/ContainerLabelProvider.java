package com.marbleArchPaint.engine.helper.gui;


import general.Project;
import general.Snapshot;

import org.eclipse.jface.viewers.*;

public class ContainerLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof Project) {
			Project container = (Project) element;
			return container.getName();
		}
		return ((Snapshot) element).getCreated().toString();
	}
}
