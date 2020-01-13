package GUIPracownik;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIManager {

    public GUIManager(){

    }
    public final Stage primaryStage = new Stage();

    public void showSingUpWindow() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SingUpWindow.fxml"));
        primaryStage.setScene(new Scene(root, 662, 410));
        primaryStage.show();

    }

    public void showLogInWindow() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LogInWindow.fxml"));
        primaryStage.setScene(new Scene(root, 662, 410));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
