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
        Parent fxmlLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/login/telaDeLogin.fxml")));
        loginScene = new Scene(fxmlLogin);

        Parent fxmlGerente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gerente/telaPrincipalGerente.fxml")));
        principalGerenteScene = new Scene(fxmlGerente);

        Parent fxmlCliente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cliente/telaPrincipalCliente.fxml")));
        principalClienteScene = new Scene(fxmlCliente);

        Parent fxmlVendedor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/vendedor/telaPrincipalVendedor.fxml")));
        principalVendedorScene = new Scene(fxmlVendedor);
    }

    public static void changeScreen(String scr) {
        switch (scr) {
            case "LOGIN" -> stage.setScene(loginScene);

            case "PRINCIPAL_GERENTE" -> {
                stage.setScene(principalGerenteScene);
                stage.setTitle("RU | TELA PRINCIPAL GERENTE");
            }

            case "PRINCIPAL_CLIENTE" -> {
                stage.setScene(principalClienteScene);
                stage.setTitle("RU | TELA PRINCIPAL CLIENTE");
            }

            case "PRINCIPAL_VENDEDOR" -> {
                stage.setScene(principalVendedorScene);
                stage.setTitle("RU | TELA PRINCIPAL VENDEDOR");
            }
        }
    }

}
