package GUIPracownik;

import DAOclasses.BookDAO;
import DBTableObjects.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class ViewBooksController {

    @FXML
    ListView<Book> booksList = new ListView<>();
    ArrayList<Book> books;

    @FXML
    private void showAllBooks(){
        BookDAO bookDAO = new BookDAO();
        books = (ArrayList<Book>) bookDAO.findAll();
        ObservableList<Book> booksOB = FXCollections.observableArrayList(books);
        booksList.setItems(booksOB);

    }

	@FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showLibrarianMenu();
    }
	
}
