package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // Stage e Login Scene
    protected static Stage stage;
    protected static Scene loginScene;
    // -----

    // Clientes Scenes
    protected static Scene principalClienteScene;
    protected static Scene compraFichasScene;
    protected static Scene visualizarDados;
    // -----

    // Vendedor Scenes
    protected static Scene principalVendedorScene;
    protected static Scene vendaScene;
    protected static Scene listarRefeicoesScene;
    // -----

    // Gerentes Scenes
    protected static Scene principalGerenteScene;
    protected static Scene listarRegistroCompraScene;
    protected static Scene listarUsuarioScene;
    protected static Scene cadastrarUsuarioScene;
    protected static Scene alterarUsuarioScene;
    // -----

    // Refeições Scenes
    protected static Scene visualizarRefeicoesScene;
    protected static Scene cadastrarRefeicoesScene;
    protected static Scene alterarRefeicoesScene;
    // -----


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
