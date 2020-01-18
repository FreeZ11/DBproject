package GUICzytelnik;

import DAOclasses.BookDAO;
import DAOclasses.CzytelnikDAO;
import DAOclasses.WypożyczeniaDAO;
import DBTableObjects.Book;
import DBTableObjects.Czytelnik;
import DBTableObjects.Wypożyczone;
import GUIPracownik.GUIManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.hibernate.query.Query;

import java.util.ArrayList;


public class CheckYourBooksController {

    @FXML
    ListView<Book> booksList = new ListView<>();
    ArrayList<Book> books;

    //TODO nie wiem czy działa jeszcze
    @FXML
    private void showBooks(){
        WypożyczeniaDAO wypożyczeniaDAO = new WypożyczeniaDAO();
        wypożyczeniaDAO.openCurrentSessionWithTransaction();
        Query query = wypożyczeniaDAO.getCurrentSession().createSQLQuery("CALL checkYourBooks(:yourId)").setParameter("yourId", LogInWindowController.current.getID());
        books = (ArrayList<Book>) query.list();
        wypożyczeniaDAO.closeCurrentSessionWithTransaction();

        ObservableList<Book> wypOB = FXCollections.observableArrayList(books);
        booksList.setItems(wypOB);


    }


    @FXML
    private void goBack() throws Exception {
        GUIManager.getInstance().showReaderMenu();
    }

}
