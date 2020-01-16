package GUIPracownik;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIManager {

    private static GUIManager obj;
    private static Stage window = new Stage();
    private Parent root;

    private GUIManager() {}

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

    public void showReaderMenuController() throws Exception{
        root = FXMLLoader.load(getClass().getClassLoader().getResource("ReaderMenu.fxml"));
        window.setScene(new Scene(root));
        window.show();

    }

}
