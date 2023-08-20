package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(ScreenManager.getInstance().getLoginScene());
        primaryStage.setTitle("Bem-Vindo ao RU");

        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.setResizable(false);

        ScreenManager.getInstance().setPrimaryStage(primaryStage);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
