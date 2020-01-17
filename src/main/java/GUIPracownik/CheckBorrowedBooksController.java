package GUIPracownik;

import DAOclasses.WypożyczeniaDAO;
import DBTableObjects.Book;
import DBTableObjects.Wypożyczone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class CheckBorrowedBooksController {

    @FXML
    ListView<Wypożyczone> borrowedList = new ListView<>();
    ArrayList<Wypożyczone> borrowed;

    @FXML
    private void showBorrowed(){
        WypożyczeniaDAO wypożyczeniaDAO = new WypożyczeniaDAO();
        borrowed = (ArrayList<Wypożyczone>) wypożyczeniaDAO.findAll();
        ObservableList<Wypożyczone> borrowedOB = FXCollections.observableArrayList(borrowed);
        borrowedList.setItems(borrowedOB);
    }

	@FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showLibrarianMenu();
    }
}
