package com.marbleArchPaint.engine.helper.synergy;

import general.File;
import java.io.*;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.runtime.Platform;

//import com.amenity.workbench.SessionSourceProvider;

public class SynergyGetFile {


	//''''''''''''''''''''''''''''''''''''''''''''''testing

	private String cwini = System.getenv("userprofile").replace('\\', '/') + "\\cwright.ini" ;
	private String cwpst = System.getenv("userprofile").replace('\\', '/') + "\\cwright.pst" ;
	private String ccmEXEFolder = "M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\ccm";
	private String ccmHomeFolder = "M:\\pmtqtools\\Synergy71\\Synergy_client7105";
	public String sessionID;
	public String problem;

	private String ccmIniFile = System.getenv("userprofile")
			.replace('\\', '/') + "\\ccm71.ini" ;
	//''''''''''''''''''''''''''''''''''''''''''''''''''testing
	
//	private String ccmEXEFolder = "M:\\pmtqtools\\Synergy71\\Synergy_client7103\\bin\\ccm";
//	private String sessionID;

//	private String ccmEXEFolder = Platform.getPreferencesService().getString( 
//			"com.amenity.workbench" , 
//			"SGYCCM_EXE" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\ccm.exe" , null );
//	
//	private String ccmHomeFolder = Platform.getPreferencesService().getString( 
//			"com.amenity.workbench" , 
//			"SGYCCM_DIR" , "M:\\pmtqtools\\Synergy71\\Synergy_client7105" , null );
//	
//	private String ccmIniFile = Platform.getPreferencesService().getString( 
//			"com.amenity.workbench" , 
//			"SGYINI_FILE" , System.getenv("userprofile").replace('\\', '/') + "\\ccm71.ini" , null );
//	
	
	@SuppressWarnings("unused")
	private SynergyGetFile () {
	}
	
	public SynergyGetFile ( String sessionID ) {
		
		this.sessionID = sessionID;
//		openFile(file1);
	}

	public SynergyGetFile ( String sessionID, File file1, 
			File file2) throws IOException {
		
		this.sessionID = sessionID;
//		 openFile(file1);
//		 openFile(file2);
//		compareFiles(file1.getFullName(), file2.getFullName());
		
	}

	public void openFile(File file) {

		
//	           
//		sessionID = null;
//		
//		
//		
//		ProcessBuilder pb = new ProcessBuilder ( "cmd","/c","ccm start -q -m -nogui");
//		
//		
//		Map<String, String> env = pb.environment();
//      
//		Process pr;
//		try {
//			
//			env.put("CCM_HOME", ccmHomeFolder);
//			env.put("CCM_INI_FILE", ccmIniFile );
//			env.put("PATH", "D:\\ts_mirr\\etoolset\\cw70d;" +
//					"M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin;" +
//					"M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\util;" +
//					"M:\\pmtqtools\\ccmscripts1015;" +
//					"M:\\pmtqtools\\ccmscripts1015\\perl\\bin;" +
//					"M:\\pmtqtools\\ccmscripts1015\\cygwin\\bin;" +
//					"C:\\Program Files\\Microsoft Office\\Office12;" +
//					"M:\\pmtqtools\\ts_ref\\STM_RiMC\\STMTS\\v8.5;%PATH%");
//
//			env.put("TS_LOCAL", "d:\\ts_mirr");
//			env.put("TS_CTL", "M:\\pmtqtools\\ts_ref\\comptab");  
//			env.put("CWL", "d:\\ts_mirr\\etoolset\\cw70d"); 
//			env.put("SHELL", "d:\\ts_mirretoolset\\cyg132d/bin");
//			env.put("GHS_LMHOST", "@ls_rb_ghs_rb_1.conti.de");
//			env.put("GHS_LMWHICH", "ghs");
//			env.put("CWINI",cwini );
//			env.put("CWPST", cwpst);
//		
//            pr= pb.start();
//			
//			pr.waitFor();
//			
		

//		SessionSourceProvider.SYNERGY_SID = sgyLogin.getSynergySessionId();
		
//			sessionID = new BufferedReader(new InputStreamReader(pr.getInputStream())).readLine();
			try{
			SynergyLogin sgyLogin = new SynergyLogin();
			sessionID =sgyLogin.getSynergySessionId();
			String batchLocation = "d:\\z.bat";
	 
	        java.io.File reading = new java.io.File(batchLocation);
	        if ( !reading.exists()) {
	        	reading.createNewFile();
	        	Writer output = new BufferedWriter(new FileWriter(reading) ); 
                
//                String s=" echo off \n" +
	        	String s =
                "SET CCM_HOME=M:\\pmtqtools\\Synergy71\\Synergy_client7105\n" +
				"SET PATH=D:\\ts_mirr\\etoolset\\cw70d;M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin;M:\\pmtqtools\\Synergy71\\Synergy_client7105\\bin\\util;M:\\pmtqtools\\ccmscripts1015;M:\\pmtqtools\\ccmscripts1015\\perl\\bin;M:\\pmtqtools\\ccmscripts1015\\cygwin\\bin;C:\\Program Files\\Microsoft Office\\Office;M:\\pmtqtools\\ts_ref\\STM_RiMC\\STMTS\\v8.5;%PATH%\n"+
				"SET TS_LOCAL=d:\\ts_mirr\n"+
				"SET TS_CTL=M:\\pmtqtools\\ts_ref\\comptab\n"+
				"SET CWL=d:/ts_mirr/etoolset/cw70d\n"+
				"SET SHELL=d:/ts_mirr/etoolset/cyg132d/bin\n"+
				"SET GHS_LMHOST=@ls_rb_ghs_rb_1.conti.de\n"+
				"SET GHS_LMWHICH=ghs\n"+
				"SET CWINI=%USERPROFILE%\\cwright.ini\n"+
				"SET CWPST=%USERPROFILE%\\cwright.pst\n"+
				"SET CCM_INI_FILE=%USERPROFILE%\\ccm71.ini\n"+
				"set CCM_ADDR= %1\n"+
				"ccm view %2\n"+
				"EXIT";
                
                output.write(s); 
                output.close(); 
	        }

                       Process process= Runtime.getRuntime().exec("cmd /c start /min " + batchLocation + 
                    		   " " + sessionID + " " + file.getObjectName());
//                       System.err.println("file name is :"+"cmd /c start /min " + batchLocation + 
//                    		   " "+sessionID+" "+file.getObjectName());
                       process.waitFor();
                        
		
		}
                        catch (Exception  e1) { 
                            // TODO Auto-generated catch block 
                            e1.printStackTrace();
                            System.out.println("error creating the batch file");
                    }                   
		
		/*ProcessBuilder pb = new ProcessBuilder ("cmd", "/c", 
				ccmEXEFolder,
				"view",
				file.getObjectName() );
		
		Map<String, String> env = pb.environment();

		env.put("CCM_HOME", ccmHomeFolder);
		env.put("CCM_INI_FILE", ccmIniFile);
		env.put("CCM_ADDR", sessionID);
		
		Process pr;
		try {
			pr = pb.start();
			pr.waitFor();

			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String resultset = null;
			
			while (( resultset = br.readLine()) != null ){
				
				System.out.println("> " + resultset);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}

//	@SuppressWarnings("unused")
//	private void compareFile(File file1, File file2) {
//	}
	
	public void compareFiles( String file1, String file2) {
		// M:\pmtqtools\Admin\BeyondCompare\Beyond Compare 3\BCompare.exe file1 file2
		try {
			ProcessBuilder builder = new ProcessBuilder (
					"M:\\pmtqtools\\Admin\\Beyond" +
					"Compare\\Beyond Compare 3\\BCompare.exe", file1, file2);
			Process p = builder.start(); 
			System.err.println(p.exitValue());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}