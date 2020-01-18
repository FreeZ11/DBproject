package GUICzytelnik;

import DAOclasses.CzytelnikDAO;
import DBTableObjects.Czytelnik;
import GUIPracownik.GUIManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.List;


public class LogInWindowController {

    @FXML
    TextField loginField = new TextField();
    @FXML
    PasswordField passwordField = new PasswordField();
    @FXML
    Label ErrorMessage = new Label();
    public Czytelnik current;

    @FXML
    private void loginFunction() throws Exception {

       CzytelnikDAO czytelnikDAO = new CzytelnikDAO();
       
       
        if(loginField.getText().equals("Bibliotekarz") && passwordField.getText().equals("librarian") ){
            GUIManager.getInstance().showLibrarianMenu();}
        else if(loginField.getText().equals("Administrator") && passwordField.getText().equals("admin") ){
            GUIManager.getInstance().showAdminMenu();}

       List<Czytelnik> czytelnicy = czytelnikDAO.findAll();

       for (Czytelnik c : czytelnicy){

           if(c.getLogin().equals(loginField.getText()) && c.getHaslo().equals(passwordField.getText()) ){
               System.out.println("Witaj"+ c.getImie());
               current=c;
               GUIManager.getInstance().showReaderMenu();

           }
           else{
               ErrorMessage.setText("Błędny login lub hasło");
           }
       }
    }

    @FXML
    private void goToCreateAccount() throws Exception {
        GUIManager.getInstance().showSingUpWindow();
    }
}
