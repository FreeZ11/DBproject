package GUICzytelnik;

import DAOclasses.CzytelnikDAO;
import DBTableObjects.Czytelnik;
import GUIPracownik.GUIManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.List;


public class LogInWindowController {

    @FXML
    TextField loginField = new TextField();
    @FXML
    TextField PasswordField = new TextField();
    @FXML
    Label ErrorMessage = new Label();

    @FXML
    private void loginFunction() throws Exception {

       CzytelnikDAO czytelnikDAO = new CzytelnikDAO();

        if(loginField.getText().equals("Bibliotekarz") && PasswordField.getText().equals("librarian") ){
            GUIManager.getInstance().showLibrarianMenu();}

       List<Czytelnik> czytelnicy = czytelnikDAO.findAll();

       for (Czytelnik c : czytelnicy){

           if(c.getLogin().equals(loginField.getText()) && c.getHaslo().equals(PasswordField.getText()) ){
               System.out.println("Witaj"+ c.getImie());
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
