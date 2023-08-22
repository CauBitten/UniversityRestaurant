package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ScreenManager {
    private static ScreenManager instance;

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
    protected static Scene listarCardapiosScene;
    protected static Scene cadastrarCardapioScene;
    // -----

    // Refeições Scenes
    protected static Scene visualizarRefeicoesScene;
    protected static Scene cadastrarRefeicoesScene;
    protected static Scene alterarRefeicoesScene;
    // -----

    public static ScreenManager getInstance() {
        if (instance == null) instance = new ScreenManager();

        return instance;
    }

    public void criarCenas () throws IOException {
        // FXML Login
        Parent fxmlLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/login/telaDeLogin.fxml")));
        loginScene = new Scene(fxmlLogin);
        // -----

        // FXMLs Clientes
        Parent fxmlPrincipalCliente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cliente/telaPrincipalCliente.fxml")));
        principalClienteScene = new Scene(fxmlPrincipalCliente);

        Parent fxmlCompraFichasCliente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cliente/telaCompraFichas.fxml")));
        compraFichasScene = new Scene(fxmlCompraFichasCliente);

        Parent fxmlVisualizarDadosCliente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cliente/telaVisualizacaoDados.fxml")));
        visualizarDados = new Scene(fxmlVisualizarDadosCliente);
        // -----

        // FXMLs Vendedor
        Parent fxmlVendedor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/vendedor/telaPrincipalVendedor.fxml")));
        principalVendedorScene = new Scene(fxmlVendedor);

        Parent fxmlVenda = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/vendedor/telaDeVenda.fxml")));
        vendaScene = new Scene(fxmlVenda);

        Parent fxmlListarRefeicoes = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/vendedor/telaListarRefeicoes.fxml")));
        listarRefeicoesScene = new Scene(fxmlListarRefeicoes);
        // -----

        // FXMLs Gerente
        Parent fxmlGerente = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gerente/telaPrincipalGerente.fxml")));
        principalGerenteScene = new Scene(fxmlGerente);

        Parent fxmlListarUsuarios = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gerente/telaListarUsuarios.fxml")));
        listarUsuarioScene = new Scene(fxmlListarUsuarios);

        Parent fxmlCadastrarUsuarios = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gerente/telaCadastroUsuario.fxml")));
        cadastrarUsuarioScene = new Scene(fxmlCadastrarUsuarios);

        Parent fxmlAlterarUsuario = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gerente/telaAlterarUsuarios.fxml")));
        alterarUsuarioScene = new Scene(fxmlAlterarUsuario);

        Parent fxmlListarRegistroCompra = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gerente/telaListarRegistroCompra.fxml")));
        listarRegistroCompraScene = new Scene(fxmlListarRegistroCompra);

        Parent fxmlListarCardapios = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gerente/telaListarCardapios.fxml")));
        listarCardapiosScene = new Scene(fxmlListarCardapios);

        Parent fxmlCadastrarCardapios = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gerente/telaCadastroCardapio.fxml")));
        cadastrarCardapioScene = new Scene(fxmlCadastrarCardapios);
        // -----

        // FXMLs Refeições
        Parent fxmlVisualizarRefeicoes = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/refeicoes/telaVisualizarRefeicoes.fxml")));
        visualizarRefeicoesScene = new Scene(fxmlVisualizarRefeicoes);

        Parent fxmlCadastrarRefeicoes = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/refeicoes/telaCadastroRefeicao.fxml")));
        cadastrarRefeicoesScene = new Scene(fxmlCadastrarRefeicoes);

        Parent fxmlAlterarRefeicoes = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/refeicoes/telaAlterarRefeicao.fxml")));
        alterarRefeicoesScene = new Scene(fxmlAlterarRefeicoes);
        // -----
    }

    public static void changeScreen(String scr) {
        switch (scr) {
            case "LOGIN" -> stage.setScene(loginScene);

            // Cliente
            case "PRINCIPAL_CLIENTE" -> {
                stage.setScene(principalClienteScene);
                stage.setTitle("RU | TELA PRINCIPAL CLIENTE");
            }

            case "VISUALIZAR_DADOS" -> {
                stage.setScene(visualizarDados);
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

            case "VENDA" -> {
                stage.setScene(vendaScene);
                stage.setTitle("RU | TELA DE VENDA");
            }

            case "LISTAR_REFEICOES" -> {
                stage.setScene(listarRefeicoesScene);
                stage.setTitle("RU | TELA LISTAR REFEIÇÕES");
            }
            // -----

            // Gerente
            case "PRINCIPAL_GERENTE" -> {
                stage.setScene(principalGerenteScene);
                stage.setTitle("RU | TELA PRINCIPAL GERENTE");
            }

            case "LISTAR_USUARIO" -> {
                stage.setScene(listarUsuarioScene);
                stage.setTitle("RU | TELA LISTAR USUÁRIO");
            }

            case "CADASTRAR_USUARIO" -> {
                stage.setScene(cadastrarUsuarioScene);
                stage.setTitle("RU | TELA CADASTRAR USUÁRIO");
            }

            case "ALTERAR_USUARIO" -> {
                stage.setScene(alterarUsuarioScene);
                stage.setTitle("RU | TELA ALTERAR USUÁRIO");
            }

            case "LISTAR_REGISTRO_COMPRA" -> {
                stage.setScene(listarRegistroCompraScene);
                stage.setTitle("RU | TELA LISTAR REGISTRO COMPRA");
            }
            // -----

            // Refeições
            case "VISUALIZAR_REFEICOES" -> {
                stage.setScene(visualizarRefeicoesScene);
                stage.setTitle("RU | TELA VISUALIZAR REFEIÇÕES");
            }

            case "CADASTRAR_REFEICOES" -> {
                stage.setScene(cadastrarRefeicoesScene);
                stage.setTitle("RU | TELA CADASTRO REFEIÇÕES");
            }

            case "ALTERAR_REFEICOES" -> {
                stage.setScene(alterarRefeicoesScene);
                stage.setTitle("RU | TELA ALTERAR REFEIÇÕES");
            }

            case "VISUALIZAR_CARDAPIOS" -> {
                stage.setScene(listarCardapiosScene);
                stage.setTitle("RU | TELA LISTA DE CARDÁPIOS");
            }

            case "CADASTRAR_CARDAPIO" -> {
                stage.setScene(cadastrarCardapioScene);
                stage.setTitle("RU | TELA DE CADASTRO DE CARDÁPIOS");
            }
            // -----
        }
    }

}
