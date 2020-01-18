package GUIPracownik;

import DAOclasses.BookDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.hibernate.query.Query;


public class LibrarianMenuController {


    @FXML
    TextField bookId = new TextField();
    @FXML
    TextField pesel = new TextField();

    @FXML
    private void deleteBook(){

        BookDAO bookDAO = new BookDAO();
        bookDAO.openCurrentSessionWithTransaction();
        Query query = bookDAO.getCurrentSession().createSQLQuery("CALL removeBook(:bookid)").setParameter("bookid", bookId.getText());
        query.executeUpdate();
        bookDAO.closeCurrentSessionWithTransaction();

    }

    @FXML
    private void deleteReader(){
        BookDAO bookDAO = new BookDAO();
        bookDAO.openCurrentSessionWithTransaction();
        Query query = bookDAO.getCurrentSession().createSQLQuery("CALL removeReader(:pesel)").setParameter("pesel",pesel.getText());
        query.executeUpdate();
        bookDAO.closeCurrentSessionWithTransaction();
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

}
