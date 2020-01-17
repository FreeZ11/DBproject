package GUIPracownik;

import DAOclasses.BookDAO;
import DBTableObjects.Book;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AddBookController {

    @FXML
    TextField isbnField = new TextField();
    @FXML
    TextField autorField = new TextField();
    @FXML
    TextField tytulField = new TextField();
    @FXML
    TextField DataWydaniaField = new TextField();
    @FXML
    TextField wydanieField = new TextField();
    @FXML
    TextField iloscStronField = new TextField();

    @FXML
    private void createBook(){

        Book newBook = new Book(isbnField.getText(),tytulField.getText(),autorField.getText(),DataWydaniaField.getText(),Integer.parseInt(iloscStronField.getText()),Integer.parseInt(wydanieField.getText()));

        BookDAO bookDAO = new BookDAO();
        bookDAO.persist(newBook);

    }

    @FXML
    private void goBack() throws Exception {
        GUIManager.getInstance().showLibrarianMenu();
    }

}
