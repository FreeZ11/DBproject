package DBTableObjects;

import javax.persistence.*;

@Entity
@Table(name = "Wypozyczenia")
public class Wypożyczone {

    private int ID;
    private int IDbook;
    private int IDCzytelnik;
    private String Data_wyp;
    private String Data_odd;
    public Wypożyczone(){};

    @Id
    @Column(name = "id_Wypozyczenia")
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "id_ksiazki")
    public int getIDbook() {
        return IDbook;
    }
    public void setIDbook(int IDbook) {
        this.IDbook = IDbook;
    }


    @Column(name = "id_czytelnika")
    public int getIDCzytelnik() {
        return IDCzytelnik;
    }
    public void setIDCzytelnik(int IDCzytelnik) {
        this.IDCzytelnik = IDCzytelnik;
    }

    @Column(name = "Data_Wypozyczenia")
    public String getData_wyp() {
        return Data_wyp;
    }
    public void setData_wyp(String data_wyp) {
        Data_wyp = data_wyp;
    }

    @Column(name = "Data_Oddania")
    public String getData_odd() {
        return Data_odd;
    }
    public void setData_odd(String data_odd) {
        Data_odd = data_odd;
    }

    @Override
    public String toString(){
        return this.ID + ", " + this.IDbook + ", " + this.IDCzytelnik;
    }
}


