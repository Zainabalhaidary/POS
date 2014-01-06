package com.marbleArchPaint.engine.helper.gui.contentProvider;

import general.Connection;

import general.Project;
import general.Snapshot;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.marbleArchPaint.engine.helper.gui.snapshotComparator;

import dao.ConnectionDao;
import dao.DaoFactory;
import dao.SnapshotDao;

public class ConnectionTreeContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		System.out.println("Input changed");
	}

	// only accept container as input
	@Override
	public Object[] getElements(Object inputElement) {
		if ( inputElement instanceof Project ) {
			ConnectionDao connectionDao = DaoFactory.eINSTANCE.createConnectionDao();
//			List x = new ArrayList<Container>();
//			x.add(inputElement);
			List <Connection >cList =connectionDao.getListByContainer((Project)inputElement);
			Collections.sort(cList, new containerComparator());
//			return connectionDao.getListByContainer((Container)inputElement).toArray();
			return cList.toArray();
//			return x.toArray();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getChildren(Object parentElement) {
		if ( parentElement instanceof Connection ) {
			Connection connection = (Connection) parentElement;
			SnapshotDao snapshotDao = DaoFactory.eINSTANCE.createSnapshotDao();

			List<Snapshot> snapshots = (List<Snapshot>) 
					snapshotDao.getByQuery("from " + Snapshot.class.getName().toString() + 
							" where via = '" + connection.getConnectionId() + "' and deleted = false" );
			
			List <Snapshot> sList =snapshots;
			Collections.sort(sList, new snapshotComparator());
			return sList.toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if ( element instanceof Connection ) {
			return true;
		}
		return false;
	}

}
