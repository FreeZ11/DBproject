package GUIPracownik;

import javafx.fxml.FXML;

public class LibrarianMenuController {

    @FXML
    private void goToBorrow() throws Exception{
        GUIManager.getInstance().showBorrow();
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
    private void logOut() throws Exception{
        GUIManager.getInstance().showLogInWindow();
    }

}
