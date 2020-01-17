package GUICzytelnik;

import GUIPracownik.GUIManager;
import javafx.fxml.FXML;

public class ReaderMenuController {

    @FXML
    private void yourBooks() throws Exception {
        GUIManager.getInstance().showYourBooks();
    }

    @FXML
    private void borrowBook() throws Exception{
        GUIManager.getInstance().showBorrow();
    }


    @FXML
    private void logOut() throws Exception {
        GUIManager.getInstance().showLogInWindow();
    }


}
