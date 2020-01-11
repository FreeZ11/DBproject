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
    private int PESEL;
    private String Login;
    private String Haslo;

    //TODO sprawić by ID było autoincrement
    @Id
    @Column(name = "ID_Czytelnika")
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "Imię")
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }

    @Column(name = "Nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Column(name = "PESEL")
    public int getPESEL() {
        return PESEL;
    }
    public void setPESEL(int PESEL) {
        this.PESEL = PESEL;
    }

    @Column(name = "Login")
    public String getLogin() {
        return Login;
    }
    public void setLogin(String login) {
        Login = login;
    }

    @Column(name = "Hasło")
    public String getHaslo() {
        return Haslo;
    }
    public void setHaslo(String haslo) {
        Haslo = haslo;
    }
}
