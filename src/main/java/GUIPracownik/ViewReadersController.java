package GUIPracownik;

import DAOclasses.CzytelnikDAO;
import DBTableObjects.Book;
import DBTableObjects.Czytelnik;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class ViewReadersController {
    @FXML
    ListView<Czytelnik> readersList = new ListView<>();
    ArrayList<Czytelnik> readers;

    @FXML
    private void showReaders(){
        CzytelnikDAO czytelnikDAO = new CzytelnikDAO();
        readers = (ArrayList<Czytelnik>) czytelnikDAO.findAll();
        ObservableList<Czytelnik> readersOB =FXCollections.observableArrayList(readers);
        readersList.setItems(readersOB);
    }

	@FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showLibrarianMenu();
        
    }
}
