package GUICzytelnik;

import DAOclasses.CzytelnikDAO;
import DBTableObjects.Czytelnik;
import GUIPracownik.GUIManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.List;


public class LogInWindowController {

    @FXML
    TextField loginField = new TextField();
    @FXML
    TextField PasswordField = new TextField();

    @FXML
    private void loginFunction(){

       CzytelnikDAO czytelnikDAO = new CzytelnikDAO();

       List<Czytelnik> czytelnicy = czytelnikDAO.findAll();

       for (Czytelnik c : czytelnicy){

           if (c.getLogin()==loginField.getText() && c.getHaslo()==PasswordField.getText() ){

               System.out.println("Witaj "+c.getLogin());
               //TODO tutaj jest miejsce na kod który przerzuci nas do menu głównego

           }
       }
    }

    @FXML
    private void goToCreateAccount() throws Exception {

        GUIManager.getInstance().showSingUpWindow();

    }
}
