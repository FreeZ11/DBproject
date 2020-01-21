package GUIPracownik;

import DAOclasses.BookDAO;
import DAOclasses.WypożyczeniaDAO;
import DBTableObjects.Wypożyczone;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.hibernate.query.Query;

import java.security.Guard;
import java.sql.Date;
import java.util.List;


public class LibrarianMenuController {


    @FXML
    TextField bookId = new TextField();
    @FXML
    TextField pesel = new TextField();
    @FXML
    DatePicker dataOddania = new DatePicker();
    @FXML
    Label MessageLable = new Label();


    @FXML
    private void deleteBook(){

        BookDAO bookDAO = new BookDAO();
        bookDAO.openCurrentSessionWithTransaction();
        Query query = bookDAO.getCurrentSession().createSQLQuery("CALL removeBook(:bookid)").setParameter("bookid", bookId.getText());
        query.executeUpdate();
        bookDAO.closeCurrentSessionWithTransaction();
        MessageLable.setTextFill(Color.GREEN);
        MessageLable.setText("Książka usunięta poprawnie");

    }

    @FXML
    private void deleteReader(){
        BookDAO bookDAO = new BookDAO();
        bookDAO.openCurrentSessionWithTransaction();
        Query query = bookDAO.getCurrentSession().createSQLQuery("CALL removeReader(:pesel)").setParameter("pesel",pesel.getText());
        query.executeUpdate();
        bookDAO.closeCurrentSessionWithTransaction();
        MessageLable.setTextFill(Color.GREEN);
        MessageLable.setText("Czytelnik usunięty poprawnie");
    }

    @FXML
    private void returnBook(){
        WypożyczeniaDAO wypożyczeniaDAO = new WypożyczeniaDAO();
        List<Wypożyczone> wyp = wypożyczeniaDAO.findAll();
        for(Wypożyczone w : wyp){
            if(w.getID() == Integer.parseInt(bookId.getText())){
                w.setData_odd(Date.valueOf(dataOddania.getValue()));
                wypożyczeniaDAO.update(w);
                MessageLable.setTextFill(Color.GREEN);
                MessageLable.setText("Oddanie zatwierdzone");
            }
        }

    }

    @FXML
    private void goToBorrow() throws Exception{
        GUIManager.getInstance().showBorrow2();
    }

    @FXML
    private void goToAddBook() throws Exception{
        GUIManager.getInstance().showAddBook();
    }

    @FXML
    private void goToBorrowed() throws Exception{
        GUIManager.getInstance().showBorrowedBooks();
    }

    @FXML
    private void goToReaders() throws Exception{
        GUIManager.getInstance().showViewReaders();
    }
    
    @FXML
    private void goToBooks() throws Exception{
        GUIManager.getInstance().showViewBooks();
    }
    
    @FXML
    private void logOut() throws Exception{
        GUIManager.getInstance().showLogInWindow();
    }
    @FXML
    private void backToAdmin() throws  Exception{
        GUIManager.getInstance().showAdminMenu();
    }

}
