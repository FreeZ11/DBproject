package GUICzytelnik;

import GUIPracownik.GUIManager;
import javafx.fxml.FXML;

public class BorrowController {

    @FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showReaderMenu();
    }
}
