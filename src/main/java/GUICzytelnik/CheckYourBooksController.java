package GUICzytelnik;

import DAOclasses.BookDAO;
import DAOclasses.CzytelnikDAO;
import DAOclasses.WypożyczeniaDAO;
import DBTableObjects.Book;
import DBTableObjects.Czytelnik;
import GUIPracownik.GUIManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;


public class CheckYourBooksController {

    @FXML
    ListView<Book> booksList = new ListView<>();
    ArrayList<Book> books;
    LogInWindowController lgw = new LogInWindowController(); // to będzie potrzebne do załadowania obecnego usera


    @FXML
    private void showBooks(){
        //TODO W tej metodzie będziemy używać procedury do znalezienia książek czytelnika
        WypożyczeniaDAO wypożyczeniaDAO = new WypożyczeniaDAO();
        books= (ArrayList<Book>) wypożyczeniaDAO.findAll(); // TODO prawdopodobnie zamiast tej linijki będzie procedura
        ObservableList<Book> booksOb = FXCollections.observableArrayList(books);
        booksList.setItems(booksOb);
    }


    @FXML
    private void goBack() throws Exception {
        GUIManager.getInstance().showReaderMenu();
    }

}
