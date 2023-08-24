package view;

import GUI.cliente.ControllerCompraFichas;
import GUI.cliente.ControllerPagamento;
import GUI.cliente.ControllerPrincipalCliente;
import GUI.cliente.ControllerVisualizacaoDados;
import GUI.gerente.*;
import GUI.login.ControllerLoginPage;
import GUI.refeicao.ControllerAlterarRefeicao;
import GUI.refeicao.ControllerCadastroRefeicao;
import GUI.refeicao.ControllerVisualizarRefeicoes;
import GUI.vendedor.ControllerListarRefeicoes;
import GUI.vendedor.ControllerPrincipalVendedor;
import GUI.vendedor.ControllerVenda;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ScreenManager {
    private static ScreenManager instance;

    // Stage e Login Scene
    private Stage primaryStage;
    private Scene loginScene;
    private ControllerLoginPage controllerLoginPage;
    // -----

    // Clientes Scenes
    private Scene principalClienteScene;
    private ControllerPrincipalCliente controllerPrincipalCliente;

    private Scene compraFichasScene;
    private ControllerCompraFichas controllerCompraFichas;

    private Scene visualizarDadosScene;
    private ControllerVisualizacaoDados controllerVisualizacaoDados;

    private Scene pagamentoScene;
    private ControllerPagamento controllerPagamento;
    // -----

    // Vendedor Scenes
    private Scene principalVendedorScene;
    private ControllerPrincipalVendedor controllerPrincipalVendedor;

    private Scene vendaScene;
    private ControllerVenda controllerVenda;

    private Scene listarRefeicoesScene;
    private ControllerListarRefeicoes controllerListarRefeicoes;
    // -----

    // Gerentes Scenes
    private Scene principalGerenteScene;
    private ControllerPrincipalGerente controllerPrincipalGerente;

    private Scene listarRegistroCompraScene;
    private ControllerListarRegistroCompra controllerListarRegistroCompra;

    private Scene listarUsuarioScene;
    private ControllerListarUsuarios controllerListarUsuarios;

    private Scene cadastrarUsuarioScene;
    private ControllerCadastroUsuario controllerCadastroUsuario;

    private Scene alterarUsuarioScene;
    private ControllerAlterarUsuarios controllerAlterarUsuarios;

    private Scene listarCardapiosScene;
    private ControllerListarCardapios controllerListarCardapios;

    private Scene cadastrarCardapioScene;
    private ControllerCadastroCardapio controllerCadastroCardapio;

    private Scene alterarCardapioScene;
    private ControllerAlterarCardapio controllerAlterarCardapio;
    // -----

    // Refeições Scenes
    private Scene visualizarRefeicoesScene;
    private ControllerVisualizarRefeicoes controllerVisualizarRefeicoes;

    private Scene cadastrarRefeicoesScene;
    private ControllerCadastroRefeicao controllerCadastroRefeicao;

    private Scene alterarRefeicoesScene;
    private ControllerAlterarRefeicao controllerAlterarRefeicao;
    // -----


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public ControllerLoginPage getControllerLoginPage() {
        return controllerLoginPage;
    }

    public Scene getPrincipalClienteScene() {
        return principalClienteScene;
    }

    public ControllerPrincipalCliente getControllerPrincipalCliente() {
        return controllerPrincipalCliente;
    }

    public Scene getCompraFichasScene() {
        return compraFichasScene;
    }

    public ControllerCompraFichas getControllerCompraFichas() {
        return controllerCompraFichas;
    }

    public Scene getVisualizarDadosScene() {
        return visualizarDadosScene;
    }

    public ControllerVisualizacaoDados getControllerVisualizacaoDados() {
        return controllerVisualizacaoDados;
    }

    public Scene getPagamentoScene() { return pagamentoScene; }

    public ControllerPagamento getControllerPagamento() { return controllerPagamento; }

    public Scene getPrincipalVendedorScene() {
        return principalVendedorScene;
    }

    public ControllerPrincipalVendedor getControllerPrincipalVendedor() {
        return controllerPrincipalVendedor;
    }

    public Scene getVendaScene() {
        return vendaScene;
    }

    public ControllerVenda getControllerVenda() {
        return controllerVenda;
    }

    public Scene getListarRefeicoesScene() {
        return listarRefeicoesScene;
    }

    public ControllerListarRefeicoes getControllerListarRefeicoes() {
        return controllerListarRefeicoes;
    }

    public Scene getPrincipalGerenteScene() {
        return principalGerenteScene;
    }

    public ControllerPrincipalGerente getControllerPrincipalGerente() {
        return controllerPrincipalGerente;
    }

    public Scene getListarRegistroCompraScene() {
        return listarRegistroCompraScene;
    }

    public ControllerListarRegistroCompra getControllerListarRegistroCompra() {
        return controllerListarRegistroCompra;
    }

    public Scene getListarUsuarioScene() {
        return listarUsuarioScene;
    }

    public ControllerListarUsuarios getControllerListarUsuarios() {
        return controllerListarUsuarios;
    }

    public Scene getCadastrarUsuarioScene() {
        return cadastrarUsuarioScene;
    }

    public ControllerCadastroUsuario getControllerCadastroUsuario() {
        return controllerCadastroUsuario;
    }

    public Scene getAlterarUsuarioScene() {
        return alterarUsuarioScene;
    }

    public ControllerAlterarUsuarios getControllerAlterarUsuarios() {
        return controllerAlterarUsuarios;
    }

    public Scene getListarCardapiosScene() {
        return listarCardapiosScene;
    }

    public ControllerListarCardapios getControllerListarCardapios() {
        return controllerListarCardapios;
    }

    public Scene getCadastrarCardapioScene() {
        return cadastrarCardapioScene;
    }

    public ControllerCadastroCardapio getControllerCadastroCardapio() {
        return controllerCadastroCardapio;
    }

    public Scene getVisualizarRefeicoesScene() {
        return visualizarRefeicoesScene;
    }

    public ControllerVisualizarRefeicoes getControllerVisualizarRefeicoes() {
        return controllerVisualizarRefeicoes;
    }

    public Scene getCadastrarRefeicoesScene() {
        return cadastrarRefeicoesScene;
    }

    public ControllerCadastroRefeicao getControllerCadastroRefeicao() {
        return controllerCadastroRefeicao;
    }

    public Scene getAlterarRefeicoesScene() {
        return alterarRefeicoesScene;
    }

    public ControllerAlterarRefeicao getControllerAlterarRefeicao() {
        return controllerAlterarRefeicao;
    }

    public Scene getAlterarCardapioScene() {
        return alterarCardapioScene;
    }

    public ControllerAlterarCardapio getControllerAlterarCardapio() {
        return controllerAlterarCardapio;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private ScreenManager() {
        this.initialize();
    }

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }

        return instance;
    }

    private void initialize() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();

            AnchorPane loginPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/login/telaDeLogin.fxml")).openStream());
            this.loginScene = new Scene(loginPane);
            this.controllerLoginPage = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane principalClientePane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/cliente/telaPrincipalCliente.fxml")).openStream());
            this.principalClienteScene = new Scene(principalClientePane);
            this.controllerPrincipalCliente = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane compraFichasPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/cliente/telaCompraFichas.fxml")).openStream());
            this.compraFichasScene = new Scene(compraFichasPane);
            this.controllerCompraFichas = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane visualizarDadosPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/cliente/telaVisualizacaoDados.fxml")).openStream());
            this.visualizarDadosScene = new Scene(visualizarDadosPane);
            this.controllerVisualizacaoDados = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane pagamento = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/cliente/telaPagamento.fxml")).openStream());
            this.pagamentoScene = new Scene(pagamento);
            this.controllerPagamento = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane principalVendedorPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/vendedor/telaPrincipalVendedor.fxml")).openStream());
            this.principalVendedorScene = new Scene(principalVendedorPane);
            this.controllerPrincipalVendedor = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane vendaPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/vendedor/telaDeVenda.fxml")).openStream());
            this.vendaScene = new Scene(vendaPane);
            this.controllerVenda = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane listarRefeicoesPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/vendedor/telaListarRefeicoes.fxml")).openStream());
            this.listarRefeicoesScene = new Scene(listarRefeicoesPane);
            this.controllerListarRefeicoes = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane principalGerentePane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaPrincipalGerente.fxml")).openStream());
            this.principalGerenteScene = new Scene(principalGerentePane);
            this.controllerPrincipalGerente = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane listarRegistroCompraPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaListarRegistroCompra.fxml")).openStream());
            this.listarRegistroCompraScene = new Scene(listarRegistroCompraPane);
            this.controllerListarRegistroCompra = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane listarUsuariosPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaListarUsuarios.fxml")).openStream());
            this.listarUsuarioScene = new Scene(listarUsuariosPane);
            this.controllerListarUsuarios = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane cadastrarUsuarioPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaCadastroUsuario.fxml")).openStream());
            this.cadastrarUsuarioScene = new Scene(cadastrarUsuarioPane);
            this.controllerCadastroUsuario = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane alterarUsuarioPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaAlterarUsuarios.fxml")).openStream());
            this.alterarUsuarioScene = new Scene(alterarUsuarioPane);
            this.controllerAlterarUsuarios = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane listarCardapiosPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaListarCardapios.fxml")).openStream());
            this.listarCardapiosScene = new Scene(listarCardapiosPane);
            this.controllerListarCardapios = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane cadastrarCardapioPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaCadastroCardapio.fxml")).openStream());
            this.cadastrarCardapioScene = new Scene(cadastrarCardapioPane);
            this.controllerCadastroCardapio = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane visualizarRefeicoesPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/refeicoes/telaVisualizarRefeicoes.fxml")).openStream());
            this.visualizarRefeicoesScene = new Scene(visualizarRefeicoesPane);
            this.controllerVisualizarRefeicoes = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane cadastrarRefeicoesPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/refeicoes/telaCadastroRefeicao.fxml")).openStream());
            this.cadastrarRefeicoesScene = new Scene(cadastrarRefeicoesPane);
            this.controllerCadastroRefeicao = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane alterarRefeicoesPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/refeicoes/telaAlterarRefeicao.fxml")).openStream());
            this.alterarRefeicoesScene = new Scene(alterarRefeicoesPane);
            this.controllerAlterarRefeicao = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane alterarCardapioPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaAlterarCardapio.fxml")).openStream());
            this.alterarCardapioScene = new Scene(alterarCardapioPane);
            this.controllerAlterarCardapio = fxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeScreen(String scr) {
        switch (scr) {
            case "LOGIN" -> primaryStage.setScene(loginScene);

            // Cliente
            case "PRINCIPAL_CLIENTE" -> {
                primaryStage.setScene(principalClienteScene);
                primaryStage.setTitle("RU | TELA PRINCIPAL CLIENTE");
            }

            case "VISUALIZAR_DADOS" -> {
                primaryStage.setScene(visualizarDadosScene);
                primaryStage.setTitle("RU | TELA VISUALIZAÇÃO DE DADOS");
            }

            case "COMPRA_FICHAS" -> {
                primaryStage.setScene(compraFichasScene);
                primaryStage.setTitle("RU | TELA COMPRA FICHAS");
            }

            case "PAGAMENTO" -> {
                primaryStage.setScene(pagamentoScene);
                primaryStage.setTitle("RU | TELA DE PAGAMENTO");
            }
            // -----

            // Vendedor
            case "PRINCIPAL_VENDEDOR" -> {
                primaryStage.setScene(principalVendedorScene);
                primaryStage.setTitle("RU | TELA PRINCIPAL VENDEDOR");
            }

            case "VENDA" -> {
                primaryStage.setScene(vendaScene);
                primaryStage.setTitle("RU | TELA DE VENDA");
            }

            case "LISTAR_REFEICOES" -> {
                primaryStage.setScene(listarRefeicoesScene);
                primaryStage.setTitle("RU | TELA LISTAR REFEIÇÕES");
            }
            // -----

            // Gerente
            case "PRINCIPAL_GERENTE" -> {
                primaryStage.setScene(principalGerenteScene);
                primaryStage.setTitle("RU | TELA PRINCIPAL GERENTE");
            }

            case "LISTAR_USUARIO" -> {
                primaryStage.setScene(listarUsuarioScene);
                primaryStage.setTitle("RU | TELA LISTAR USUÁRIO");
            }

            case "CADASTRAR_USUARIO" -> {
                primaryStage.setScene(cadastrarUsuarioScene);
                primaryStage.setTitle("RU | TELA CADASTRAR USUÁRIO");
            }

            case "ALTERAR_USUARIO" -> {
                primaryStage.setScene(alterarUsuarioScene);
                primaryStage.setTitle("RU | TELA ALTERAR USUÁRIO");
            }

            case "LISTAR_REGISTRO_COMPRA" -> {
                primaryStage.setScene(listarRegistroCompraScene);
                primaryStage.setTitle("RU | TELA LISTAR REGISTRO COMPRA");
            }
            // -----

            // Refeições
            case "VISUALIZAR_REFEICOES" -> {
                primaryStage.setScene(visualizarRefeicoesScene);
                primaryStage.setTitle("RU | TELA VISUALIZAR REFEIÇÕES");
            }

            case "CADASTRAR_REFEICOES" -> {
                primaryStage.setScene(cadastrarRefeicoesScene);
                primaryStage.setTitle("RU | TELA CADASTRO REFEIÇÕES");
            }

            case "ALTERAR_REFEICOES" -> {
                primaryStage.setScene(alterarRefeicoesScene);
                primaryStage.setTitle("RU | TELA ALTERAR REFEIÇÕES");
            }

            case "VISUALIZAR_CARDAPIOS" -> {
                primaryStage.setScene(listarCardapiosScene);
                primaryStage.setTitle("RU | TELA LISTA DE CARDÁPIOS");
            }

            case "CADASTRAR_CARDAPIO" -> {
                primaryStage.setScene(cadastrarCardapioScene);
                primaryStage.setTitle("RU | TELA DE CADASTRO DE CARDÁPIOS");
            }

            case "LISTAR_CARDAPIOS" -> {
                primaryStage.setScene(listarCardapiosScene);
                primaryStage.setTitle("RU | TELA DE LISTA DE CARDÁPIOS");
            }

            case "ALTERAR_CARDAPIO" -> {
                primaryStage.setScene(alterarCardapioScene);
                primaryStage.setTitle("RU | TELA DE ALTERAR CARDÁPIO");
            }
            // -----
        }
    }

}
