package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/login/telaDeLogin.fxml"));
        Scene loginScene = new Scene(fxmlLoader.load());

        stage.setScene(loginScene);
        stage.setTitle("RU");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
