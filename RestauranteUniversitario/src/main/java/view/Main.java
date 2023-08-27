package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage secondStage = new Stage();

        primaryStage.setScene(ScreenManager.getInstance().getLoginScene());
        primaryStage.setTitle("RU | LOGIN");
        primaryStage.setResizable(false);

        secondStage.setScene(ScreenManager.getInstance().getCatracaScene());
        secondStage.setTitle("RU | CATRACA");
        secondStage.setResizable(false);

        ScreenManager.getInstance().setPrimaryStage(primaryStage);
        ScreenManager.getInstance().setSecondStage(secondStage);

        primaryStage.show();
        secondStage.show();
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}
