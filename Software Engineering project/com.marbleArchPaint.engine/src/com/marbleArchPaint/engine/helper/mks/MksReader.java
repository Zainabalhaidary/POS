package com.marbleArchPaint.engine.helper.mks;

import general.CR;
import general.Connection;
import general.File;
import general.Folder;
import general.GeneralFactory;
import general.Snapshot;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.mks.api.CmdRunner;
import com.mks.api.Command;
import com.mks.api.IntegrationPoint;
import com.mks.api.IntegrationPointFactory;
import com.mks.api.Option;
import com.mks.api.Session;
import com.mks.api.response.APIException;
import com.mks.api.response.Field;
import com.mks.api.response.Response;
import com.mks.api.response.WorkItem;
import com.mks.api.response.WorkItemIterator;
import com.mks.api.util.ResponseUtil;

import dao.CRDao;
import dao.DaoFactory;
import dao.FileDao;
import dao.FolderDao;
//import java.util.logging.LogManager;

public class MksReader {

//	private int port ;//= 7001;
	private Session mySession = null;
	private static Snapshot snapshot;
	private Connection connection;
	private List<Folder> folders;
	private List<File> files;
	private List<CR> crs;
	private FolderDao folderDao;
	private FileDao fileDao;
	private CRDao crDao;
	double start1;
	double end1;
	double start2;
	double end2;
	double start3;
	double end3;
	CR crSpare ;
	int counter = 0;
	static String append;
	private boolean createRootObject;
//	private Logger log;
//	public static Properties LOG4J_PROPERTIES;
	double startFilesAndFolders;
	double endFilesAndFolders;
	double startCRsAndTasks;
	double endCRSandTasks;
//	public static ByteArrayOutputStream baos;
	////////////////////////////////////////////////////////////////////
//	ServerSocket providerSocket;
//	Socket connectionSocket = null;
//	ObjectOutputStream out;
//	ObjectInputStream in;
//	String message;
	///////////////////////////////////////////////////////////////////
	
	
	public MksReader () {
		//1. creating a server socket
//				try {
//					providerSocket = new ServerSocket(8080);
//				
//				//2. Wait for connection
//				System.out.println("Waiting for connection");
//				connectionSocket = providerSocket.accept();
//				System.out.println("Connection received from " + connectionSocket.getInetAddress().getHostName());
//				//3. get Input and Output streams
//				out = new ObjectOutputStream(connectionSocket.getOutputStream());
//				out.flush();
//				in = new ObjectInputStream(connectionSocket.getInputStream());
////				sendMessage("Connection successful");
//				} catch (IOException e) {
//					
//					e.printStackTrace();
//				}
	}
	
	public MksReader ( Connection connection, Snapshot snapshot ) {
		this.connection = connection;
		MksReader.snapshot = snapshot;
		folders = new ArrayList<Folder>();
		files = new ArrayList<File>();
		crs = new ArrayList<CR>();
		createRootObject = true;
		crSpare = GeneralFactory.eINSTANCE.createCR();
//		baos = new ByteArrayOutputStream();
		
		
		
		

		
	}
	/**
	 * 
	 * @return
	 * si viewproject -- displays the contents of a project
		
		===========================================================================
		
		SYNOPSIS
		
		
		si viewproject [--fields=field1[:width1],field2[:width2]...]
		[--[no]filterSubs] [--height=value] [--width=value] [-x value] [-y value]
		[(-R|--[no|confirm]recurse)] [--filter=filteroptions] [(-P
		project|--project=project)] [--[no]failOnAmbiguousProject] [(-S
		sandbox|--sandbox=sandbox)] [--devpath=path] [--projectRevision=rev]
		[--lockRecordFormat=value] [(-F file|--selectionFile=file)]
		[--hostname=server] [--port=number] [--password=password] [--user=name]
		[(-?|--usage)] [(-N|--no)] [(-Y|--yes)] [--[no]batch] [--cwd =directory]
		[--forceConfirm=[yes|no]] [(-g|--gui)] [--[no]persist] [--quiet]
		[--settingsUI=[gui|default]] [--status=[none|gui|default]]
		member/subproject...
		
		===========================================================================
		
		
		DESCRIPTION
		
		
		si viewproject displays the contents of a project and some information
		about the members, for example:
		
		
		si viewproject c:/Aurora_Program/bin/Libra/project.pj
		
		displays
		
		connect.txt 1.4 archived
		source.txt 1.3 archived
		config.c 1.3 archived
		
		
		Note: Specifying si viewproject -S sandbox does not view the Sandbox; it
		redirects through the Sandbox to view the project. Use si viewsandbox to
		view a Sandbox.
		
		Options
		
		
		This command takes the universal options available to all si commands, as
		well as some general options. See the options reference page for
		descriptions.
		
		--fields=field1[:width1],field2[:width2]... 
		
		        allows you to select fields to be printed, specified in the
		        format field1[:width1],field2[:width2].... Specifying the column
		        [:width] (in pixels) for each field is optional. Widths are only
		        available with the -g or --gui options. Under the CLI the fields
		        are separated with a space.
		
		        The fields available for printing can be one or more of the
		        following:
		
		archiveshared 
		
		        displays indicators for members that share another member’s
		        archive. This column is valid only if you are using the database
		        repository.
		
		attributes 
		
		        displays member attributes.
		
		context 
		
		        When used with the MKS API, displays the name of the project, and
		        indicates if the project is a build or variant.
		
		        Note: This field is not valid for use with the CLI.
		
		cpid 
		
		        displays the change package associated with the operation that
		        set the member revision.
		
		creationcpid 
		
		        displays the change package that created the revision that is
		        currently the member revision. This revision may be different
		        from the Member CPID if an import, add member from archive, or
		        set member revision operation was used.
		
		frozen 
		
		        displays indicators for frozen members.
		
		indent 
		
		        indents a field. For example:
		
		
		
		si viewproject --fields=ident, name, type, memberrev
		
		
		        indents the name field, followed by type and memberrev fields,
		        indenting as you recurse into subprojects.
		
		        Note: This field is not valid for use with the MKS API.
		
		labels 
		
		        displays labels.
		
		lockrecord 
		
		        a comma separated list of locks on the member. The locker and
		        lock type are displayed by default for each lock. You can
		        customize the lock information that displays by using the
		        --lockRecordFormat option.
		
		memberarchive 
		
		        displays the name and path of the member archive.
		
		memberdescription 
		
		        displays the member description.
		
		memberrev 
		
		        displays the member revision.
		
		membertimestamp 
		
		        displays the member timestamp.
		
		name 
		
		        displays the member name.
		
		newrevdelta 
		
		        displays indicators for new revisions.
		
		pendingcpid 
		
		        displays the change package associated with a pending operation.
		
		state 
		
		        displays the member state.
		
		type 
		
		        displays the type of each item in the project: project,
		        subproject, shared-subproject, shared-variant-subproject,
		        shared-build-subproject, or member.
		
		--[no]filterSubs 
		
		        controls whether to display subprojects and directories that do
		        not contain members matching the current filter.
		
		--[no]persist 
		
		        controls whether this presentation of information should continue
		        to be updated as new information becomes available. --nopersist
		        forces a static "snapshot" of information, while --persist gives
		        real-time updates.
		
		--lockRecordFormat=value 
		
		        defines the format for displaying lock information in the
		        --lockrecord field. Specify a format string using keywords to
		        represent the information you want to display. You can specify
		        any of the following keywords:
		
		{revision} 
		
		        displays the revision that is locked.
		
		{locker} 
		
		        displays the user who locked the revision.
		
		{locktype} 
		
		        displays the type of lock on the revision (exclusive or
		        non-exclusive).
		
		{locktimestamp} 
		
		        displays the time when the revision was locked.
		
		{lockcpid} 
		
		        displays the change package associated with the lock on the
		        revision.
		
		{project} 
		
		        displays the name and path of the project where the member
		        revision was locked from. If the member revision was locked from
		        a shared subproject, it is the subproject name and path that are
		        displayed.
		
		{devpath} 
		
		        displays the name of the development path where the lock on the
		        revision was made from.
		
		{sandbox} 
		
		        displays the name of the Sandbox where the lock on the revision
		        was made. This is relevant when viewing the information from the
		        locker host.
		
		{hostname} 
		
		        displays the hostname of the computer that locked the the
		        revision.
		
		{hascpid} 
		
		        displays 1 if the lock has a change package associated with it, 0
		        if there is no associated change package.
		
		{hassandbox} 
		
		        displays 1 if there is Sandbox information available for the
		        lock, 0 if no Sandbox information is available.
		
		{hasdevpath} 
		
		        displays 1 if the lock was made from a development path, 0 if it
		        wasn't.
		
		{member} 
		
		        displays the name of the locked revision.
		
		member/subproject... 
		
		        identifies a specific member or subproject; use spaces to specify
		        more than one.
		
		===========================================================================
		
		
		DIAGNOSTICS
		
		
		See the diagnostics reference page for possible exit status values.
		
		===========================================================================
		
		
		PREFERENCES
		
		
		Using si setprefs or si viewprefs, you are able to set or view the
		preference keys for this command.
		
		===========================================================================
	 * 
	 * 
	 */
	public boolean getProjectFiles() {
		boolean noError = true;
		
		
		/////////////////////////////////////////////////////

		try {
			
			
//			Thread thread1 = new Thread () {
//				  String CurLine = " ";
//
//				public void run () {
//						while (!(CurLine.equals("quit"))){
//							 try {
//								 	/ Create a stream to hold the output
//								     baos = new ByteArrayOutputStream();
//								    PrintStream ps = new PrintStream(baos);
//								    // IMPORTANT: Save the old System.out!
//								    PrintStream old = System.out;
//								    // Tell Java to use your special stream
//								    System.setOut(ps);
//								    // Print some output: goes to your special stream
//								    System.out.println("Foofoofoo!");
//								    // Put things back
//								    System.out.flush();
								   
									
//									
//								} catch (Exception e) {
//									
//									e.printStackTrace();
//								}	
//							
//							
//						}
//					  
//					
//				  }
//				};
//		 thread1.start();
		 
			IntegrationPointFactory ipf = IntegrationPointFactory.getInstance();
			
			
			IntegrationPoint ip = ipf.createIntegrationPoint(connection.getDatabase(), 
					Integer.parseInt( connection.getPort() ), false , 4 , 10);
			
			
			mySession = ip.createSession(connection.getUsername(),connection.getPassword());
			
			CmdRunner myCmdRunner = mySession.createCmdRunner();
			
			myCmdRunner.setDefaultHostname(connection.getDatabase());
			
			myCmdRunner.setDefaultPort(Integer.parseInt( connection.getPort() ));
			myCmdRunner.setDefaultUsername(connection.getUsername());
			myCmdRunner.setDefaultPassword(connection.getPassword());

			Command myCmd = new Command ( Command.SI , "viewproject");
			myCmd.addOption(new Option ( "-R"));	// recursive
			myCmd.addOption(new Option ( "-Y"));	// say always yes
			myCmd.addOption(new Option("project",connection.getCM_project()));
			myCmd.addOption(new Option("fields=name,memberrev,membertimestamp," +
					"labels,state,type,attributes,context,attributes,cpid," +
					"creationcpid,memberarchive"));
			
			 startFilesAndFolders=System.currentTimeMillis()/1000;
			
			Response myResponse = myCmdRunner.execute(myCmd);
			WorkItemIterator wii = myResponse.getWorkItems();
			
			 endFilesAndFolders=System.currentTimeMillis()/1000;
			
			System.out.println("Time to get files and folders from project "+connection.getCM_project()+" is "+ (endFilesAndFolders-startFilesAndFolders));

			/////////////////////////////////////////
			try{
						Command myCmd2 = new Command (Command.IM , "issues");
			
						myCmd2.addOption(new Option("fields","ID,Type,Summary,Created Date,Assigned User,Project,State,Target Release,ReqID,CR_type,Severity,Document ID,CustomerRelevant,Impact"));
//						if(connection.getDatabase().equals("mks-bs-test"))
						try{
						if(!connection.getPort2().equals("")&&!connection.getPort().equals(connection.getPort2()))
						{
						myCmd2.addOption(new Option("port",connection.getPort2()));
//						myCmd2.addOption(new Option("fields","ID,Type,Summary,Created Date,Assigned User,Project,State"));
						}
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
						
						if(!connection.getDatabase().equals("mks-bs"))
						{
							myCmd2.addOption(new Option("fields","ID,Type,Summary,Created Date,Assigned User,Project,State"));
						}
						

						int i;
						ArrayList <Integer> al = new ArrayList<Integer>();
						for(i=0;i<connection.getCM_project().length();i++)
						{
							if(connection.getCM_project().charAt(i)=='/')//&& connection.getProject().substring(connection.getProject().length()-3,connection.getProject().length())!=".pj")
								al.add(i);
								
						}
						

						
						myCmd2.addOption(new Option("user",connection.getUsername()));
						myCmd2.addOption(new Option("password",connection.getPassword()));
						myCmd2.addOption(new Option("query", connection.getCM_project().substring(0, al.get(al.size()-1)))); //Quick Query ,All CRs not closed,All created by me
//						myCmd2.addOption(new Option("query", "SWQ_QUERY_AMENITY")); //Quick Query ,All CRs not closed,All created by me

						
						/////////////////////////////////////////

						startCRsAndTasks = System.currentTimeMillis()/1000;
						Response myResponse2=myCmdRunner.execute(myCmd2);
						WorkItemIterator wii2 = myResponse2.getWorkItems();
						
						 endCRSandTasks = System.currentTimeMillis()/1000;
			
//						System.out.println("Time to get CRs and Tasks from project "+connection.getProject()+" is "+ (endCRSandTasks-startCRsAndTasks));
						 System.out.println("Time to get CRs and Tasks from project "+connection.getCM_project()+" is "+ (endCRSandTasks-startCRsAndTasks));

						 
						while ( wii2.hasNext() ) {
							CR cr = GeneralFactory.eINSTANCE.createCR();
							WorkItem wi = wii2.next();
//							System.out.println("Do I get inside the loop");
								@SuppressWarnings("rawtypes")
								Iterator fields = wi.getFields();
								String s = "";
								String v = "";
								boolean doOnce = true;
								while ( fields.hasNext() ) {
									Field field = (Field) fields.next();

									if ( doOnce ) {
										s = s + "|getId";
										v = v + "|" + wi.getId();
										s = s + "|getDisplayId";
										v = v + "|" + wi.getDisplayId();
										s = s + "|getModelType";
										v = v + "|" + wi.getModelType();
										s = s + "|getContext";
										v = v + "|" + wi.getContext();
										cr.setPartOf(MksReader.snapshot);
										cr.setFullName("CR"+counter);
										cr.setLevel(0);
										cr.setName("CR"+counter);
										cr.setModfiedDate(null);
										doOnce = false;
									}
									s = s + "|" + field.getName();
									
									v = v + "|" + field.getValueAsString();
									
									if(field.getName().equals("Created Date"))
									{
										cr.setCreationDate(field.getDateTime());
									}
									
			
									if(field.getName().equals("Project"))
									{
									cr.setProject(field.getValueAsString());
									}
									if(field.getName().equals("Summary"))
									{
									cr.setSummary(field.getValueAsString());
									}
									if(field.getName().equals("Type")){
									cr.setType(field.getValueAsString());
									}
									cr.setObjectId(wi.getId());
									
									if(field.getName().equals("ID")){
									cr.setCRID(field.getValueAsString());
									}
									
									if(field.getName().equals("Assigned User")){
										cr.setAssignedUser(field.getValueAsString());
										}

									if(field.getName().equals("State")){
										cr.setState(field.getValueAsString());
										}
									if(field.getName().equals("Target Release")){
										cr.setRelease(field.getValueAsString());
										}
								
									if(field.getName().equals("CR_Type")){
										cr.setCR_Type(field.getValueAsString());
										}
									if(field.getName().equals("Severity")){
										cr.setSeverity(field.getValueAsString());
										}
									if(field.getName().equals("Document ID")){
										cr.setDocID(field.getValueAsString());
										}
									
									if(field.getName().equals("ReqID")){
										cr.setReqID(field.getValueAsString());
										}
									if(field.getName().equals("CustomerRelevant")){
										cr.setCustomerRelevant(field.getValueAsString());
										}
									if(field.getName().equals("Impact")){
										cr.setImpact(field.getValueAsString());
										}
									

								}
								doOnce = true;
								crSpare= cr;
//								System.out.println(crSpare.getCRID());
								 
//								    PrintStream ps = new PrintStream(baos);
//								    // IMPORTANT: Save the old System.out!
//								    PrintStream old = System.out;
//								    // Tell Java to use your special stream
//								    System.setOut(ps);
//								System.out.println(cr.toString());
//								
//								 System.setOut(old);
//								    // Show what happened
//								 System.out.println("Here: " + baos.toString());
									
//								out.writeObject(cr.toString());
//								out.flush();
//								
								crs.add(cr);
								cr = null;

							
//							

//								int i;
//								ArrayList <Integer> al = new ArrayList<Integer>();
//								for(i=0;i<connection.getProject().length();i++)
//								{
//									if(connection.getProject().charAt(i)=='/')//&& connection.getProject().substring(connection.getProject().length()-3,connection.getProject().length())!=".pj")
//										al.add(i);
//										
//								}
//								
//
//								if(v.contains(connection.getProject().substring(0, al.get(al.size()-1))))
//								{
//
//								}

						}
			
						
			}catch(Exception myException)
			{

				myException.printStackTrace();
			}
			
			folderDao = DaoFactory.eINSTANCE.createFolderDao();
			fileDao = DaoFactory.eINSTANCE.createFileDao();
			crDao = DaoFactory.eINSTANCE.createCRDao();

			
			while ( wii.hasNext() ) {
				WorkItem wi = wii.next();

				generateContentObject(wi);
				
			}
			
			

			
//				System.out.println("error occured with CRs");
			
//			end = System.currentTimeMillis()/1000;
//			System.out.println("--- Time to create objects --- " + 
//					(end- start ) + " seconds");
//			start = end;
			if ( doPersist() ) {
				
				return noError;
			}
			
			
//			thread1.stop();
		} catch (APIException ae) {
	        System.out.println("--[ Exception ]---------------------------");
	        ResponseUtil.printAPIException(ae, 1, System.out);
	        System.out.println("--[ Response In Which It Occured ]--------");
	        ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	        noError = false;
	    } finally {
	        try {
	            if(mySession!=null){
	                mySession.release();
	            }
	            
//	            in.close();
//				out.close();
//				providerSocket.close();
				
	        } catch (APIException ae){
	            System.out.println("--[ Exception ]---------------------------");
	            ResponseUtil.printAPIException(ae, 1, System.out);
	            System.out.println("--[ Response In Which It Occured ]--------");
	            ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	            noError = false;
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    }
		
		return noError;
		
	}
	
	
	
	public boolean getProjectFiles2() {
		boolean noError = true;

		try {
			IntegrationPointFactory ipf = IntegrationPointFactory.getInstance();
			
			
			IntegrationPoint ip = ipf.createIntegrationPoint(connection.getDatabase(), 
					Integer.parseInt( connection.getPort() ), false , 4 , 10);
			
			
			mySession = ip.createSession(connection.getUsername(),connection.getPassword());
			
			CmdRunner myCmdRunner = mySession.createCmdRunner();
			
			myCmdRunner.setDefaultHostname(connection.getDatabase());
			
			myCmdRunner.setDefaultPort(Integer.parseInt( connection.getPort() ));
			myCmdRunner.setDefaultUsername(connection.getUsername());
			myCmdRunner.setDefaultPassword(connection.getPassword());

			Command myCmd = new Command ( Command.SI , "viewproject");
			myCmd.addOption(new Option ( "-R"));	// recursive
			myCmd.addOption(new Option ( "-Y"));	// say always yes
			myCmd.addOption(new Option("project",connection.getCM_project()));
			myCmd.addOption(new Option("fields=name,memberrev,membertimestamp," +
					"labels,state,type,attributes,context,attributes,cpid," +
					"creationcpid,memberarchive"));
			
			 startFilesAndFolders=System.currentTimeMillis()/1000;
			
			Response myResponse = myCmdRunner.execute(myCmd);
			WorkItemIterator wii = myResponse.getWorkItems();
			
			 endFilesAndFolders=System.currentTimeMillis()/1000;
			
			System.out.println("Time to get files and folders from project "+connection.getCM_project()+" is "+ (endFilesAndFolders-startFilesAndFolders));

			/////////////////////////////////////////
//			try{
//						Command myCmd2 = new Command (Command.IM , "issues");
//			
//						myCmd2.addOption(new Option("fields","ID,Type,Summary,Created Date,Assigned User,Project,State,Target Release,ReqID,CR_type,Severity,Document ID,CustomerRelevant,Impact"));
//						if(connection.getDatabase().equals("mks-bs-test"))
//						{
//						myCmd2.addOption(new Option("port","8402"));
//						}
//						myCmd2.addOption(new Option("user",connection.getUsername()));
//						myCmd2.addOption(new Option("password",connection.getPassword()));
//						myCmd2.addOption(new Option("query", "SWQ_QUERY_AMENITY")); //Quick Query ,All CRs not closed,All created by me
						
						/////////////////////////////////////////

//						startCRsAndTasks = System.currentTimeMillis()/1000;
//						Response myResponse2=myCmdRunner.execute(myCmd2);
//						WorkItemIterator wii2 = myResponse2.getWorkItems();
//						 endCRSandTasks = System.currentTimeMillis()/1000;
//			
//						System.out.println("Time to get CRs and Tasks from project "+connection.getProject()+" is "+ (endCRSandTasks-startCRsAndTasks));
//
//						while ( wii2.hasNext() ) {
//							CR cr = GeneralFactory.eINSTANCE.createCR();
//							WorkItem wi = wii2.next();
//
//								@SuppressWarnings("rawtypes")
//								Iterator fields = wi.getFields();
//								String s = "";
//								String v = "";
//								boolean doOnce = true;
//								while ( fields.hasNext() ) {
//									Field field = (Field) fields.next();
//
//									if ( doOnce ) {
//										s = s + "|getId";
//										v = v + "|" + wi.getId();
//										s = s + "|getDisplayId";
//										v = v + "|" + wi.getDisplayId();
//										s = s + "|getModelType";
//										v = v + "|" + wi.getModelType();
//										s = s + "|getContext";
//										v = v + "|" + wi.getContext();
//										cr.setPartOf(MksReader.snapshot);
//										cr.setFullName("CR"+counter);
//										cr.setLevel(0);
//										cr.setName("CR"+counter);
//										cr.setModfiedDate(null);
//										doOnce = false;
//									}
//									s = s + "|" + field.getName();
//									
//									v = v + "|" + field.getValueAsString();
//									
//									if(field.getName().equals("Created Date"))
//									{
//										cr.setCreationDate(field.getDateTime());
//									}
//									
//			
//									if(field.getName().equals("Project"))
//									{
//									cr.setProject(field.getValueAsString());
//									}
//									if(field.getName().equals("Summary"))
//									{
//									cr.setSummary(field.getValueAsString());
//									}
//									if(field.getName().equals("Type")){
//									cr.setType(field.getValueAsString());
//									}
//									cr.setObjectId(wi.getId());
//									
//									if(field.getName().equals("ID")){
//									cr.setCRID(field.getValueAsString());
//									}
//									
//									if(field.getName().equals("Assigned User")){
//										cr.setAssignedUser(field.getValueAsString());
//										}
//
//									if(field.getName().equals("State")){
//										cr.setState(field.getValueAsString());
//										}
//									if(field.getName().equals("Target Release")){
//										cr.setRelease(field.getValueAsString());
//										}
//								
//									if(field.getName().equals("CR_Type")){
//										cr.setCR_Type(field.getValueAsString());
//										}
//									if(field.getName().equals("Severity")){
//										cr.setSeverity(field.getValueAsString());
//										}
//									if(field.getName().equals("Document ID")){
//										cr.setDocID(field.getValueAsString());
//										}
//									
//									if(field.getName().equals("ReqID")){
//										cr.setReqID(field.getValueAsString());
//										}
//									if(field.getName().equals("CustomerRelevant")){
//										cr.setCustomerRelevant(field.getValueAsString());
//										}
//									if(field.getName().equals("Impact")){
//										cr.setImpact(field.getValueAsString());
//										}
//									
//
//								}
//								doOnce = true;
//
//								crs.add(cr);
//								cr = null;
//
//								int i;
//								ArrayList <Integer> al = new ArrayList<Integer>();
//								for(i=0;i<connection.getProject().length();i++)
//								{
//									if(connection.getProject().charAt(i)=='/')//&& connection.getProject().substring(connection.getProject().length()-3,connection.getProject().length())!=".pj")
//										al.add(i);
//										
//								}
//								
//
//								if(v.contains(connection.getProject().substring(0, al.get(al.size()-1))))
//								{
//
//								}
//
//						}
//			
//						
//			}catch(Exception myException)
//			{
//
//				myException.printStackTrace();
//			}
			
			folderDao = DaoFactory.eINSTANCE.createFolderDao();
			fileDao = DaoFactory.eINSTANCE.createFileDao();
			crDao = DaoFactory.eINSTANCE.createCRDao();

			
			while ( wii.hasNext() ) {
				WorkItem wi = wii.next();

				generateContentObject(wi);
				
			}
			
			

			
//				System.out.println("error occured with CRs");
			
//			end = System.currentTimeMillis()/1000;
//			System.out.println("--- Time to create objects --- " + 
//					(end- start ) + " seconds");
//			start = end;
			if ( doPersist() ) {
				
				return noError;
			}
			
		} catch (APIException ae) {
	        System.out.println("--[ Exception ]---------------------------");
	        ResponseUtil.printAPIException(ae, 1, System.out);
	        System.out.println("--[ Response In Which It Occured ]--------");
	        ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	        noError = false;
	    } finally {
	        try {
	            if(mySession!=null){
	                mySession.release();
	            }
	        } catch (APIException ae){
	            System.out.println("--[ Exception ]---------------------------");
	            ResponseUtil.printAPIException(ae, 1, System.out);
	            System.out.println("--[ Response In Which It Occured ]--------");
	            ResponseUtil.printResponse(ae.getResponse(), 1, System.out);
	            noError = false;
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    }
		
		return noError;
	}
	
	

//	private void createRootDirectory(String project) {
//		Folder folder = GeneralFactory.eINSTANCE.createFolder();
//		folder.setName(project);
//		folder.setPartOf(snapshot);
//		folder.setRootDirectory(folder);
//		folder.setLevel(0);
//		folder.setModfiedDate(null);
//		folders.add(folder);
////		folderDao.create(folder);
//		folder = null;
//	}

	public boolean getSandboxFiles() {
		
		
		return false;
	}

	private boolean doPersist() {
		try {
//			System.out.println("---- there are " + folders.size() + " folders");
			start1 = System.currentTimeMillis()/1000;
			folderDao.massInsert(folders, Folder.class, snapshot);
			end1 = System.currentTimeMillis()/1000;
			System.out.println("--- Time to persist folder objects in the database--- " + 
					( end1- start1 ) + " seconds");
//			log.warn("--- Time to persist folder objects in the database--- " + ( end- start ) + " seconds");
			start2 = end1;

//			System.out.println("---- there are " + files.size() + " files");
			fileDao.massInsert(files, File.class, snapshot);
			end2 = System.currentTimeMillis()/1000;
			System.out.println("--- Time to persist file objects in the database--- " + ( end2- start2 ) + " seconds");
//			log.warn("--- Time to persist file objects in the database--- " + ( end- start ) + " seconds");
			start3 = end2;

			System.out.println("---- there are " + crs.size() + " crs");
			crDao.massInsert(crs, CR.class, snapshot);
			end3 = System.currentTimeMillis()/1000;
			System.out.println("--- Time to persist cr objects in the database --- " + ( end3- start3 ) + " seconds");
//			log.warn("--- Time to persist file objects in the database--- " + ( end- start ) + " seconds");
			
			
			
			return true;
		} catch ( Exception e ) {

			e.printStackTrace();
			return false;
		}
	}
	
	private void generateContentObject( WorkItem wi ) {
		
		String idOut = "";
		String stateOut = "";
		String nameOut = "";
		String memberrevOut = "";
		String labelsOut = "";
		String membertimestampOut = "";
		String typeOut = "";
		String parentOut ="";
//		String cpid = "";
		
		if ( true ) {
			idOut = wi.getId();
			if ( idOut.length() > 251 )
				idOut = idOut.substring(0, 250);
		}
		
//		if ( wi.contains("cpid") ) {
//			try{
//			cpid = wi.getField("cpid").getValue().toString();
//			if ( cpid.length() > 251 )
//				cpid = cpid.substring(0, 250);
//			System.out.println("there is cpid");
//			}catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		}
		
		// set object name
		if ( wi.contains("name") ) {
			nameOut = wi.getField("name").getValue().toString();
			if ( nameOut.length() > 251 )
				nameOut = nameOut.substring(0, 250);
		}
		// sets root directory
		if ( wi.contains("parent") ) {
			parentOut = wi.getField("parent").getValue().toString();
			if ( parentOut.length() > 251 )
				parentOut = parentOut.substring(0, 250);
		}
		// sets version
		if ( wi.contains("memberrev") ) {
			memberrevOut = wi.getField("memberrev").getItem().getId();
			if ( memberrevOut.length() > 251 )
				memberrevOut = memberrevOut.substring(0, 250);
		}
		// sets the modification date
		if ( wi.contains("membertimestamp") ) {
			membertimestampOut = wi.getField("membertimestamp").getValueAsString();
		}
		// sets the release
		if ( wi.contains("labels") ) {
			for ( int i = 0 ; i < wi.getField("labels").getList().size() ; i++ ) {
				labelsOut = labelsOut + wi.getField("labels").getList().get(i).toString();
			}
			if ( labelsOut.length() > 251 )
				labelsOut = labelsOut.substring(0, 250);
		}
		// sets the file status
		if ( wi.contains("state") ) {
			stateOut = wi.getField("state").getValue().toString();
			if ( stateOut.length() > 251 )
				stateOut = stateOut.substring(0, 250);
		}
		// sets the separator
		typeOut = wi.getModelType().toLowerCase();

		/*
		 * check if the content object is of type file or folder
		 */
		if ( typeOut.contains("project") ) {
			/*
			 *  its a folder! 
			 *  the following fields are being used hence available: 
			 *  Model Type, name, parent
			 */
//			System.err.println(
//			"|" + idOut + 
//			"|" + nameOut +
//			"|" + parentOut + 
//			"|" + typeOut + 
//			"|" + labelsOut + 
//			"|" + memberrevOut + 
//			"|" + membertimestampOut + 
//			"|" + stateOut
//			);
			Folder folder = GeneralFactory.eINSTANCE.createFolder();
			folder.setPartOf(MksReader.snapshot);
			Folder root = GeneralFactory.eINSTANCE.createFolder();
			root = getParentFolder(parentOut);
			
			folder.setRootDirectory(root);
			
			folder.setFullName(nameOut);
			if ( root == null ) {
				folder.setLevel( 1 );
				folder.setName(getFolderName(nameOut, null,1));
			} else {
				folder.setLevel( root.getLevel() + 1 );
				folder.setName(getFolderName(nameOut, root.getFullName(),root.getLevel() + 1));
			}
			folder.setModfiedDate(null);
			folders.add(folder);
//			folderDao.create(folder);
			folder = null;
		} else {
			// its a file!
			File file = GeneralFactory.eINSTANCE.createFile();
			file.setCreationDate(getFileDate(membertimestampOut));
			Folder root = GeneralFactory.eINSTANCE.createFolder();
			root = getParentFolder(parentOut);
			
			file.setRootDir(root);
			
			file.setPartOf(MksReader.snapshot);
			file.setLevel(root.getLevel() + 1);
			file.setModfiedDate(getFileDate(membertimestampOut));
			file.setName(idOut);
			file.setFullName(nameOut);
//			System.out.println("Url : "+file.getFullName());
			file.setRelease(labelsOut);
			file.setStatus(stateOut);
			file.setSuffix(getFileSuffix(idOut));
			file.setVersion(memberrevOut);
            file.setPath(nameOut);

			files.add(file);
			file = null;
		}
	}
	
	
//private void generateContentObject2( WorkItem wi ) {
//		
//		String getId = "";
//		String getType = "";
//		String getSummary = "";
//		Date getCreatedDate = null;
//		String getAssignedUser = "";
//		String getProject = "";
//		counter++;
//		
//		if ( true ) {
//			getId = wi.getId();
//			if ( getId.length() > 251 ){
//				getId = getId.substring(0, 250);
//				System.out.println("cr id number "+counter+" is "+getId);
//			}
//		}
//
//
//		
//		@SuppressWarnings("unchecked")
//		Iterator<FieldContainer> itr =  wi.getFields();
//		
////		while(itr.hasNext()) {
////
////		    FieldImpl element = (FieldImpl) itr.next(); 
////		    System.out.println(" my field is "+element.getName());
////		    System.out.println(" my dataType is  "+element.getDataType());
////		} 
//		
////		for(FieldContainer fc : wi.getFields())
//		if ( wi.contains("Summary") ) {
//			getSummary = wi.getField("Summary").getValue().toString();
//			if ( getSummary.length() > 251 ){
//				getSummary = getSummary.substring(0, 250);
//				System.out.println("summary is "+getSummary);
//			}
//				
//		}
//		// sets version
//		if ( wi.contains("Created") ) {
//			getCreatedDate = wi.getField("Created Date").getDateTime();
////			if ( getCreatedDate.length() > 251 )
////				getCreatedDate = getCreatedDate.substring(0, 250);
//		}
//		// sets the modification date
//		if ( wi.contains("Assigned") ) {
//			getAssignedUser = wi.getField("Assigned User").getValueAsString();
//		}
//		// sets the release
//		if ( wi.contains("Project") ) {
////			for ( int i = 0 ; i < wi.getField("Project").getList().size() ; i++ ) {
//				getProject = wi.getField("Project").getValueAsString();
////			}
////			if ( getProject.length() > 251 )
////				getProject = getProject.substring(0, 250);
//		}
//	
//		getType = wi.getModelType().toLowerCase();
//
//	
//			CR cr = GeneralFactory.eINSTANCE.createCR();
//			cr.setPartOf(MksReader.snapshot);
//			cr.setFullName("CR"+counter);
//			cr.setLevel(0);
//			cr.setName("CR"+counter);
//			cr.setModfiedDate(null);
//			cr.setCreationDate(getCreatedDate);
//			cr.setAssignedUser(getAssignedUser);
//			cr.setProject(getProject);
//			cr.setSummary(getSummary);
//			cr.setType(getType);
//			cr.setObjectId(getId);
//            System.out.println("printing my recultant crs "+cr.toString());
//
//			crs.add(cr);
//			cr = null;
//		
//	}
	

	private String getFileSuffix(String idOut) {
		int i = 0;
		int lastDotPosition = 0;
		for ( i = 0; i < idOut.length(); i++ ) {
			if ( idOut.charAt(i) == '.' ){
				lastDotPosition = i;
			}
		}
		if ( lastDotPosition < 1)
			return "-";
		return idOut.substring(lastDotPosition, idOut.length());
	}

//	private void updateRootObject(Folder root) {
//		for ( Folder f : folders ) {
//			if ( f.getFullName().equals(root.getFullName())) {
//				f = root;
//			}
//		}
//	}

	private String getFolderName(String projectName, String rootName, int level) {
		
		
//		System.out.println("rootName is "+rootName);
//		System.out.println("projName is "+projectName);
		
        if(level!=1)
        {
//          System.out.println("projectName.substring(rootName.length()-10,projectName.length()) : "+projectName.substring(rootName.length()-10,projectName.length()));
//          System.out.println("projectName.substring(rootName.length()-10,rootName.length()) : "+rootName.substring(rootName.length()-10,rootName.length()));
          if(rootName.substring(rootName.length()-10,rootName.length()).equals("project.pj")){
        	    
            	
            	projectName=projectName.substring(rootName.length()-10,projectName.length());
          }
            else
            	if(rootName.substring(rootName.length()-3,rootName.length()).equals(".pj"))
            	{
            	projectName=projectName.substring(rootName.length()-3,projectName.length());
            	}
        
        }

		
		
          return projectName;
	}

	private Folder getParentFolder ( String parent ) {
		if ( folders.size() > 0 ) {
			for ( Folder f : folders ) {
				if ( f.getFullName().equals(parent) ) {
					return f;
				}
			}
		} else if ( createRootObject ) {
			System.err.println("no parent Found for parent: " + parent);
			Folder root = GeneralFactory.eINSTANCE.createFolder();
			root.setFullName(parent);
			root.setRootDirectory(null);
			root.setName("root");
			root.setPartOf(snapshot);
			root.setLevel(0);
			folders.clear();
			folders.add(root);
			createRootObject = false;
			return root;
		} else {
			System.err.println("Looking for match for: " + parent);
		}
		return null;
	}
	
	private Date getFileDate ( String date ) {
		/**
		 * example input: 
		 * Tue Aug 05 16:20:20 CEST 2008
		 */
		if ( date.length() > 1 ) {
		
			Date returnDate = null;
			DateFormat df = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", 
					Locale.ENGLISH);
			
			try {
				returnDate = df.parse(date);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			
			return returnDate;
		}
//		return new Date();
		return null;
	}
	
	public double getCRsAndTasksTime()
	{
		return (endCRSandTasks-startCRsAndTasks);
	}
	
	public double getFilesAndFolderstime()
	{
		return endFilesAndFolders-startFilesAndFolders;
	}
	
	public double getFolderDaoPersisting()
	{
		return end1-start1;
	}
	public double getFileDaoPersisting()
	{
		return end2-start2;
	}
	public double getCRDaoPersisting()
	{
		return end3-start3;
	}
	
}
