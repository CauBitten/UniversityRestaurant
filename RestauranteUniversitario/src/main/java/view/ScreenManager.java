package view;

import gui.gerente.ControllerPrincipalGerente;
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

    private Scene principalGerenteScene;
    private ControllerPrincipalGerente principalGerenteController;

//    private FXMLLoader fxmlLoader;
//
//    private final String caminhoLogin = "/login/telaDeLogin.fxml";
//    private final String caminhoPrincipalGerente = "/gerente/telaPrincipalGerente.fxml";
//    private final String caminhoPrincipalCliente = "/cliente/telaPrincipalCliente.fxml";
//    private final String caminhoPrincipalVendedor = "/vendedor/telaPrincipalVendedor.fxml";
//    private Scene loginScene;
//    private Scene principalGerenteScene;
//    private Scene principalClienteScene;
//    private Scene principalVendedorScene;

//    private ControllerLoginPage controllerLoginPage;

    public static ScreenManager getInstance() {
        if (instance == null) instance = new ScreenManager();

        return instance;
    }

//    public void teste (Stage mainStage) throws IOException {
//        fxmlLoader = new FXMLLoader(Main.class.getResource(caminhoLogin));
//
//        loginScene = fxmlLoader.load();
//        mainStage.setScene(loginScene);
//
//        controllerLoginPage = ControllerLoginPage.getInstance();
//
//        controllerLoginPage.entrarButtonClicked(mainStage, fxmlLoader);
//    }

        private ScreenManager() {
        this.initialize();
    }

    private void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();

            AnchorPane loginPane = fxmlLoader.load(getClass()
                    .getResource("/login/telaDeLogin.fxml").openStream());
            this.loginScene = new Scene(loginPane);
            this.loginController = (ControllerLoginPage) fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane principalGerentePane = fxmlLoader.load(getClass()
                    .getResource("/gerente/telaPrincipalGerente.fxml").openStream());
            this.principalGerenteScene = new Scene(principalGerentePane);
            this.principalGerenteController = (ControllerPrincipalGerente) fxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public ControllerLoginPage getLoginController() {
        return loginController;
    }

    public Scene getPrincipalGerenteScene() {
        return principalGerenteScene;
    }

    public ControllerPrincipalGerente getPrincipalGerenteController() {
        return principalGerenteController;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
