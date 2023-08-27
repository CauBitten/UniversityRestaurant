package view;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        while (escolha != 1 && escolha != 2) {

            System.out.println("Você deseja ir para o app(1) ou simular a catraca(2)?");
            escolha = scanner.nextInt();

            System.out.println("Opção inválida! Tente novamente!\n");

        }

        if (escolha == 1) {

            primaryStage.setScene(ScreenManager.getInstance().getLoginScene());
            primaryStage.setTitle("RU | LOGIN");
            primaryStage.setResizable(false);

            ScreenManager.getInstance().setPrimaryStage(primaryStage);

            primaryStage.show();

        } else if (escolha == 2) {

            Stage secondStage = new Stage();

            secondStage.setScene(ScreenManager.getInstance().getCatracaScene());
            secondStage.setTitle("RU | CATRACA");
            secondStage.setResizable(false);

            ScreenManager.getInstance().setSecondStage(secondStage);

            secondStage.show();

        }
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}
