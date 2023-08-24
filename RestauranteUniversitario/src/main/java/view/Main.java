package view;

import javafx.application.Application;
import javafx.stage.Stage;
import negocio.Fachada;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(ScreenManager.getInstance().getLoginScene());
        primaryStage.setTitle("RU | LOGIN");
        primaryStage.setResizable(false);

        ScreenManager.getInstance().setPrimaryStage(primaryStage);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}
