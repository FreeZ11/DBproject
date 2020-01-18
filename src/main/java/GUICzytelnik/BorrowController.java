package GUICzytelnik;

import DAOclasses.WypożyczeniaDAO;
import DBTableObjects.Czytelnik;
import DBTableObjects.Wypożyczone;
import GUIPracownik.GUIManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BorrowController {

    //TODO zmienic gui tak by pokazywala sie lista ksiazek które czytelnik może sobie wypozyczyc
    @FXML
    TextField idKsiazki = new TextField();
    @FXML
    TextField dataWyp = new TextField();

    @FXML
    private void borrowBook(){
        Wypożyczone wypozyczenie = new Wypożyczone();
        wypozyczenie.setIDbook(Integer.parseInt(idKsiazki.getText()));
        wypozyczenie.setIDCzytelnik(LogInWindowController.current.getID());
        wypozyczenie.setData_wyp(dataWyp.getText());
        WypożyczeniaDAO wyp = new WypożyczeniaDAO();
        wyp.persist(wypozyczenie);
    }

    @FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showReaderMenu();
    }
}
