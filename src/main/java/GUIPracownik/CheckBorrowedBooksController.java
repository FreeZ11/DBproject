package GUIPracownik;

import javafx.fxml.FXML;

public class CheckBorrowedBooksController {
	
	@FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showLibrarianMenu();
    }
}
