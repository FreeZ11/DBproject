package GUIPracownik;

import javafx.fxml.FXML;

public class ViewBooksController {

	@FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showLibrarianMenu();
    }
	
}
