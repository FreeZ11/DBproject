package GUIPracownik;
import GUIPracownik.GUIManager;
import javafx.fxml.FXML;


public class BorrowBookController {

    @FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showLibrarianMenu();
    }
}