package view;

import gui.login.ControllerLoginPage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenManager {
    private static ScreenManager instance;
    private Stage primaryStage;

    private Scene loginScene;
    private ControllerLoginPage loginController;

    private ScreenManager() {
        this.initialize();
    }

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }

        return instance;
    }

    private void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();

            AnchorPane loginPane = fxmlLoader.load(getClass()
                    .getResource("/login/telaDeLogin.fxml").openStream());
            this.loginScene = new Scene(loginPane);
            this.loginController = (ControllerLoginPage) fxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
