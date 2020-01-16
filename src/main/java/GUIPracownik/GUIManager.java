package GUIPracownik;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIManager {

    private static GUIManager obj;
    private static Stage window = new Stage();
    private Parent root;

    private GUIManager() {}

    //This class is used to switch between scenes
    public static GUIManager getInstance()
    {
        if (obj==null)
            obj = new GUIManager();
        return obj;
    }

    public void showSingUpWindow() throws Exception {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("SingUpWindow.fxml"));
        window.setScene(new Scene(root, 662, 410));
        window.show();

    }

    public void showLogInWindow() throws Exception {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("LogInWindow.fxml"));
        window.setScene(new Scene(root, 662, 410));
        window.setResizable(false);
        window.show();
    }

    public void showReaderMenu() throws Exception{
        root = FXMLLoader.load(getClass().getClassLoader().getResource("ReaderMenu.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void showAddBook() throws Exception{
        root = FXMLLoader.load(getClass().getClassLoader().getResource("AddBook.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void showBorrow() throws Exception{
        root = FXMLLoader.load(getClass().getClassLoader().getResource("Borrow.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void showBorrowedBooks() throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("CheckBorrowedBooks.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void showYourBooks() throws Exception{
        root = FXMLLoader.load(getClass().getClassLoader().getResource("CheckYourBooks.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void showLibrarianMenu() throws Exception{
        root = FXMLLoader.load(getClass().getClassLoader().getResource("LibrarianMenu.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    public void showViewReaders() throws Exception{
        root = FXMLLoader.load(getClass().getClassLoader().getResource("ViewReaders.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

}
