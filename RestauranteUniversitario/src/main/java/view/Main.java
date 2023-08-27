package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(ScreenManager.getInstance().getLoginScene());
        primaryStage.setTitle("RU | LOGIN");
        primaryStage.setResizable(false);

        ScreenManager.getInstance().setPrimaryStage(primaryStage);

        primaryStage.show();

        Stage secondStage = new Stage();

        secondStage.setScene(ScreenManager.getInstance().getCatracaScene());
        secondStage.setTitle("RU | CATRACA");
        secondStage.setResizable(false);

        ScreenManager.getInstance().setSecondStage(secondStage);

        secondStage.show();
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}
