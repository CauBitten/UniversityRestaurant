package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    protected static Stage stage;
    protected static Scene loginScene;
    protected static Scene principalGerenteScene;
    protected static Scene principalClienteScene;
    protected static Scene principalVendedorScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        ScreenManager screenManager = ScreenManager.getInstance();

        screenManager.criarCenas();

        stage.setTitle("RU | LOGIN");

        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
