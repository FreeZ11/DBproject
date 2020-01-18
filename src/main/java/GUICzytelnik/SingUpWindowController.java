package GUICzytelnik;

import DAOclasses.CzytelnikDAO;
import DBTableObjects.Czytelnik;
import GUIPracownik.GUIManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class SingUpWindowController {

    ObservableList<String> plecList = FXCollections.observableArrayList("m","k");
    int duplikatloginu=0;
    String pes,im,naz,log,has;
    @FXML
    TextField imie = new TextField();
    @FXML
    TextField nazwisko = new TextField();
    @FXML
    TextField pesel = new TextField();
    @FXML
    TextField login = new TextField();
    @FXML
    PasswordField haslo = new PasswordField();
    @FXML
    ComboBox<String> plec = new ComboBox<String>();
    @FXML
    Label ErrorMessage2 = new Label();
    
    @FXML
    private void initialize(){

        plec.setValue("m");
        plec.setItems(plecList);
        plec.setValue("k");
        plec.setItems(plecList);
        
    }

    @FXML
    private void createAccount(){
    	
     CzytelnikDAO czytelnikDAO = new CzytelnikDAO();
     List<Czytelnik> czytelnicy = czytelnikDAO.findAll();
    	 for (Czytelnik c : czytelnicy){
    		 

             if(c.getLogin().equals(login.getText()) ){
                duplikatloginu=1;
                break;
             }
         }
        Czytelnik nowyCzytelnik = new Czytelnik(imie.getText(),nazwisko.getText(),plec.getValue(),pesel.getText(),login.getText(),haslo.getText());

        
        pes=pesel.getText();
        im=imie.getText();
        naz=nazwisko.getText();
        log=login.getText();
        has=haslo.getText();
        
		if(!(pes.length()==11 && pes.charAt(0)<='9' && pes.charAt(0)>='0' && pes.charAt(1)<='9' && pes.charAt(1)>='0' && pes.charAt(2)<='9' && pes.charAt(2)>='0' && pes.charAt(3)<='9' && pes.charAt(3)>='0' && pes.charAt(4)<='9' && pes.charAt(4)>='0' && pes.charAt(5)<='9' && pes.charAt(5)>='0' && pes.charAt(6)<='9' && pes.charAt(6)>='0' && pes.charAt(7)<='9' && pes.charAt(7)>='0' && pes.charAt(8)<='9' && pes.charAt(8)>='0' && pes.charAt(9)<='9' && pes.charAt(9)>='0' && pes.charAt(10)<='9')) {
		
			ErrorMessage2.setText("Błędny pesel");	
		}	
		else if(duplikatloginu==1) {
			
			ErrorMessage2.setText("Ten login jest już zajęty");
		}
		else if(im.length()<1 || im.length()>30 || naz.length()<1 || naz.length()>40 || log.length()<1 || log.length()>30 || has.length()<1 || has.length()>60 ) {
			
			ErrorMessage2.setText("Wprowadzono za krótkie lub za długie dane");
		}
		else {
        czytelnikDAO.persist(nowyCzytelnik);
		}
		duplikatloginu=0;

    }

    @FXML
    private void goBackToLogInWindow() throws Exception {

        GUIManager.getInstance().showLogInWindow();

    }


}
