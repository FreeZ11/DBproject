package GUICzytelnik;

import DAOclasses.CzytelnikDAO;
import DBTableObjects.Czytelnik;
import GUIPracownik.GUIManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SingUpWindowController {

    @FXML
    TextField imie = new TextField();
    @FXML
    TextField nazwisko = new TextField();
    @FXML
    TextField plec = new TextField();
    @FXML
    TextField pesel = new TextField();
    @FXML
    TextField login = new TextField();
    @FXML
    TextField haslo = new TextField();

    @FXML
    private void createAccount(){

        Czytelnik nowyCzytelnik = new Czytelnik(imie.getText(),nazwisko.getText(),plec.getText(),pesel.getText(),login.getText(),haslo.getText());

        CzytelnikDAO czytelnikDAO = new CzytelnikDAO();
        czytelnikDAO.persist(nowyCzytelnik);
    }

    @FXML
    private void goBackToLogInWindow() throws Exception {

        GUIManager.getInstance().showLogInWindow();

    }


}
