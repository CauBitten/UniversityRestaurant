package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenManager.stage = primaryStage;

        ScreenManager screenManager = ScreenManager.getInstance();

        screenManager.criarCenas();

        ScreenManager.stage.setTitle("RU | LOGIN");

        ScreenManager.stage.setScene(ScreenManager.loginScene);
        ScreenManager.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
