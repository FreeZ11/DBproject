package GUICzytelnik;

import DAOclasses.CzytelnikDAO;
import DBTableObjects.Czytelnik;
import GUIPracownik.GUIManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SingUpWindowController {

    ObservableList<String> plecList = FXCollections.observableArrayList("m","k");

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
    private void initialize(){

        plec.setValue("m");
        plec.setItems(plecList);
        plec.setValue("k");
        plec.setItems(plecList);
        
    }

    @FXML
    private void createAccount() throws SQLException {

        Czytelnik nowyCzytelnik = new Czytelnik(imie.getText(),nazwisko.getText(),plec.getValue(),pesel.getText(),login.getText(),haslo.getText());

        CzytelnikDAO czytelnikDAO = new CzytelnikDAO();
        czytelnikDAO.persist(nowyCzytelnik);

    }

    @FXML
    private void goBackToLogInWindow() throws Exception {

        GUIManager.getInstance().showLogInWindow();

    }


}
