package GUIPracownik;

import javafx.fxml.FXML;

public class ViewReadersController {
	
	@FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showLibrarianMenu();
        
    }
}
