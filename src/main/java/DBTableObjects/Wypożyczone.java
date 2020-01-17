package DBTableObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Wypożyczenia")
public class Wypożyczone {

    //TODO sprawdzić klucze obce i autoincrement id
    private int ID;
    private int IDbook;
    private int IDCzytelnik;
    //TODO sprawdzić czy da się ustawić date w java
    private int Data_wyp;
    private int Data_odd;
    public Wypożyczone(){};

    @Id
    @Column(name = "id_Wypozyczenia")
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "id_Ksiazki")
    public int getIDbook() {
        return IDbook;
    }
    public void setIDbook(int IDbook) {
        this.IDbook = IDbook;
    }

    @Column(name = "id_Czytelnika")
    public int getIDCzytelnik() {
        return IDCzytelnik;
    }
    public void setIDCzytelnik(int IDCzytelnik) {
        this.IDCzytelnik = IDCzytelnik;
    }

    @Column(name = "Data_Wypożyczenia")
    public int getData_wyp() {
        return Data_wyp;
    }
    public void setData_wyp(int data_wyp) {
        Data_wyp = data_wyp;
    }

    @Column(name = "Data_Oddania")
    public int getData_odd() {
        return Data_odd;
    }
    public void setData_odd(int data_odd) {
        Data_odd = data_odd;
    }
}
