package GUIPracownik;

import java.io.InputStream;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminMenuController {

	String hasloroota = "Krak3rs11";
	@FXML
    Label ErrorMessage3 = new Label();
	
	
	
    @FXML
    private void doBackup() throws Exception {
     
    	Process exec = Runtime.getRuntime().exec("cmd.exe /c mysqldump.exe -uroot -p" + hasloroota + " ebooks --result-file=C:\\ebooks_backup.sql");//");//+" -u root -p interdamianopole ebooks"+" > C:\\"+"ebooks_backup"+".sql;"});
    		

    	//Wait for the command to complete, and check if the exit value was 0 (success)
    	if(exec.waitFor()==0)
    	{
    	    //normally terminated, a way to read the output
    	    InputStream inputStream = exec.getInputStream();
    	    byte[] buffer = new byte[inputStream.available()];
    	    inputStream.read(buffer);

    	    String str = new String(buffer);
    	    System.out.println(str);
    	    ErrorMessage3.setText("Zrobiono backup");
    	}
    	else
    	{
    	    // abnormally terminated, there was some problem
    	                //a way to read the error during the execution of the command
    	    InputStream errorStream = exec.getErrorStream();
    	    byte[] buffer = new byte[errorStream.available()];
    	    errorStream.read(buffer);

    	    String str = new String(buffer);
    	    System.out.println(str);
    	    ErrorMessage3.setText("Nie Zrobiono backupu");
    	}
    	
    }

    @FXML
    private void loadBackup() throws Exception{
    	String source = "C://ebooks_backup.sql" ;
    	String[] executeCmd = new String[]{"mysql", "--user=" + "root", "--password=" + hasloroota, "ebooks","-e", " source "+source};  
    	
    	
    	Process exec = Runtime.getRuntime().exec(executeCmd);
    	
    	//Wait for the command to complete, and check if the exit value was 0 (success)
    	if(exec.waitFor()==0)
    	{
    	    //normally terminated, a way to read the output
    	    InputStream inputStream = exec.getInputStream();
    	    byte[] buffer = new byte[inputStream.available()];
    	    inputStream.read(buffer);

    	    String str = new String(buffer);
    	    System.out.println(str);
    	    ErrorMessage3.setText("Załadowano backup");
    	    
    	}
    	else
    	{
    	    // abnormally terminated, there was some problem
    	                //a way to read the error during the execution of the command
    	    InputStream errorStream = exec.getErrorStream();
    	    byte[] buffer = new byte[errorStream.available()];
    	    errorStream.read(buffer);

    	    String str = new String(buffer);
    	    System.out.println(str);
    	    ErrorMessage3.setText("Nie załadowano backupu");

    	}
        
    }


    @FXML
    private void logOut() throws Exception {
        GUIManager.getInstance().showLogInWindow();
    }

    @FXML
	private  void goToDBEditor() throws Exception {
		GUIManager.getInstance().showDBEditor();
	}




}
