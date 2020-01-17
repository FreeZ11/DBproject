package DBTableObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name ="Książki")
public class Book implements Serializable {

    private int ID;
    private int Isbn;
    private String tytul;
    private String autor;
    private int rok_wydania;
    private int Strony;
    private int egzemplarzy;

   public Book(){}

   public Book(int Isbn,String tytul,String autor, int rokwydania, int strony, int egzemplarzy){
       this.Isbn=Isbn;
       this.tytul=tytul;
       this.autor=autor;
       this.rok_wydania=rokwydania;
       this.Strony=strony;
       this.egzemplarzy=egzemplarzy;
   }

    @Id
    @Column(name = "ID_Książki")
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    @Column(name = "Isbn")
    public int getIsbn() {
        return Isbn;
    }
    public void setIsbn(int isbn) {
        Isbn = isbn;
    }

    @Column(name = "Tytuł")
    public String getTytul() {
        return tytul;
    }
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    @Column(name = "Autor")
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Column(name = "Rok_wydania")
    public int getRok_wydania() {
        return rok_wydania;
    }
    public void setRok_wydania(int rok_wydania) {
        this.rok_wydania = rok_wydania;
    }

    @Column( name = "Liczba_Stron")
    public int getStrony() {
        return Strony;
    }
    public void setStrony(int strony) {
        Strony = strony;
    }

    @Column(name = "Ilość_Egzemplarzy")
    public int getEgzemplarzy() {
        return egzemplarzy;
    }
    public void setEgzemplarzy(int egzemplarzy) {
        this.egzemplarzy = egzemplarzy;
    }

    @Override
    public String toString(){
        return this.ID + ", " + this.tytul + ", " + this.autor+", "+this.rok_wydania;
    }
}

