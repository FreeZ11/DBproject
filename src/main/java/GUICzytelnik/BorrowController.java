package GUICzytelnik;

import DAOclasses.WypożyczeniaDAO;
import DBTableObjects.Wypożyczone;
import GUIPracownik.GUIManager;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.hibernate.query.Query;

import java.sql.Date;

public class BorrowController {

    @FXML
    TextField idKsiazki = new TextField();
    @FXML
    DatePicker date = new DatePicker();
    Date currDate;
    @FXML
    Label ErrorMessage = new Label();
    int ifBorrowed;

    @FXML
    private void borrowBook(){

        WypożyczeniaDAO wyp = new WypożyczeniaDAO();

        wyp.openCurrentSessionWithTransaction();
        Query query = wyp.getCurrentSession().createSQLQuery("CALL checkIfBorrowed(:id)").setParameter("id",Integer.parseInt(idKsiazki.getText()));
        if(query.getResultList().contains(null)) {
            ifBorrowed = 0;
        }
        else{
            ifBorrowed=1;
        }
        wyp.closeCurrentSessionWithTransaction();

        if(ifBorrowed==0){
            Wypożyczone wypozyczenie = new Wypożyczone();
            wypozyczenie.setIDbook(Integer.parseInt(idKsiazki.getText()));
            wypozyczenie.setIDCzytelnik(LogInWindowController.current.getID());
            currDate = Date.valueOf(date.getValue());
            wypozyczenie.setData_wyp(currDate);
            wyp.persist(wypozyczenie);
            ErrorMessage.setTextFill(Color.GREEN);
            ErrorMessage.setText("Udało się wypożyczyć");
        }
        else{
            ErrorMessage.setTextFill(Color.RED);
            ErrorMessage.setText("Ta książka już jest wypożyczona");
        }


    }

    @FXML
    public void goBack() throws Exception {
        GUIManager.getInstance().showReaderMenu();
    }
}
