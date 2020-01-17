package DBTableObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name ="ksiazka")
public class Book implements Serializable {

    private int ID;
    private String Isbn;
    private String tytul;
    private String autor;
    private String rok_wydania;
    private int Strony;
    private int wydanie;

   public Book(){}

   public Book(String Isbn, String tytul, String autor, String rokwydania, int strony, int wydanie){
       this.Isbn=Isbn;
       this.tytul=tytul;
       this.autor=autor;
       this.rok_wydania=rokwydania;
       this.Strony=strony;
       this.wydanie=wydanie;
   }

    @Id
    @Column(name = "id_ksiazki")
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "isbn")
    public String  getIsbn() {
        return Isbn;
    }
    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    @Column(name = "tytul")
    public String getTytul() {
        return tytul;
    }
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    @Column(name = "autor")
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Column(name = "data_wydania")
    public String getRok_wydania() {
        return rok_wydania;
    }
    public void setRok_wydania(String rok_wydania) {
        this.rok_wydania = rok_wydania;
    }

    @Column( name = "ilosc_stron")
    public int getStrony() {
        return Strony;
    }
    public void setStrony(int strony) {
        Strony = strony;
    }

    @Column(name = "wydanie")
    public int getWydanie() {
        return wydanie;
    }
    public void setWydanie(int wydanie) {
        this.wydanie = wydanie;
    }

    @Override
    public String toString(){
        return this.ID + ", " + this.tytul + ", " + this.autor+", "+this.rok_wydania+", "+this.wydanie;
    }
}

