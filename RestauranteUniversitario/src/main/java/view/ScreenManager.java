package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

import static view.Main.*;

public class ScreenManager {
    private static ScreenManager instance;

    public static ScreenManager getInstance() {
        if (instance == null) instance = new ScreenManager();

        return instance;
    }

    public void criarCenas () throws IOException {
        // FXML Login
        Parent fxmlLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/login/telaDeLogin.fxml")));
        loginScene = new Scene(fxmlLogin);
        // -----

        // FXMLs Gerente
        Parent fxmlGerente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gerente/telaPrincipalGerente.fxml")));
        principalGerenteScene = new Scene(fxmlGerente);
        // -----

        // FXMLs Clientes
        Parent fxmlPrincipalCliente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cliente/telaPrincipalCliente.fxml")));
        principalClienteScene = new Scene(fxmlPrincipalCliente);

        Parent fxmlCompraFichasCliente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cliente/telaCompraFichas.fxml")));
        compraFichasScene = new Scene(fxmlCompraFichasCliente);

        Parent fxmlVisualizarDadosCliente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cliente/telaVisualizacaoDados.fxml")));
        visualizacaoDados = new Scene(fxmlVisualizarDadosCliente);
        // -----

        // FXMLs Vendedor
        Parent fxmlVendedor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/vendedor/telaPrincipalVendedor.fxml")));
        principalVendedorScene = new Scene(fxmlVendedor);
        // -----
    }

    public static void changeScreen(String scr) {
        switch (scr) {
            case "LOGIN" -> stage.setScene(loginScene);

            // Gerente
            case "PRINCIPAL_GERENTE" -> {
                stage.setScene(principalGerenteScene);
                stage.setTitle("RU | TELA PRINCIPAL GERENTE");
            }
            // -----

            // Cliente
            case "PRINCIPAL_CLIENTE" -> {
                stage.setScene(principalClienteScene);
                stage.setTitle("RU | TELA PRINCIPAL CLIENTE");
            }

            case "VISUALIZACAO_DADOS" -> {
                stage.setScene(visualizacaoDados);
                stage.setTitle("RU | TELA VISUALIZAÇÃO DE DADOS");
            }

            case "COMPRA_FICHAS" -> {
                stage.setScene(compraFichasScene);
                stage.setTitle("RU | TELA COMPRA FICHAS");
            }
            // -----

            // Vendedor
            case "PRINCIPAL_VENDEDOR" -> {
                stage.setScene(principalVendedorScene);
                stage.setTitle("RU | TELA PRINCIPAL VENDEDOR");
            }
            // -----
        }
    }

}
