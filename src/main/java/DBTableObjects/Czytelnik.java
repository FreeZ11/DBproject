package DBTableObjects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Czytelnik")
public class Czytelnik implements Serializable {

    private int ID;
    private String imie;
    private String nazwisko;
    private String plec;
    private String PESEL;
    private String Login;
    private String Haslo;

    public Czytelnik(){}

    public Czytelnik(String imie, String nazwisko, String plec, String PESEL, String login, String haslo){

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.PESEL = PESEL;
        this.Login = login;
        this.Haslo = haslo;

    }

    //TODO sprawić by ID było autoincrement
    @Id
    @Column(name = "ID_Czytelnika")
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "imie")
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }

    @Column(name = "nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Column(name = "plec")
    public String getPlec() {
        return plec;
    }
    public void setPlec(String plec) {
        this.plec = plec;
    }

    @Column(name = "PESEL")
    public String getPESEL() {
        return PESEL;
    }
    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    @Column(name = "Login")
    public String getLogin() {
        return Login;
    }
    public void setLogin(String login) {
        Login = login;
    }

    @Column(name = "Haslo")
    public String getHaslo() {
        return Haslo;
    }
    public void setHaslo(String haslo) {
        Haslo = haslo;
    }

    @Override
    public String toString(){
        return "czytelnik: " + this.ID + ", " + this.imie + ", " + this.nazwisko+", "+this.PESEL;
    }
}
