package view;

import GUI.catraca.ControllerCatraca;
import GUI.cliente.*;
import GUI.gerente.*;
import GUI.login.ControllerLoginPage;
import GUI.refeicao.ControllerAlterarRefeicao;
import GUI.refeicao.ControllerCadastroRefeicao;
import GUI.refeicao.ControllerVisualizarRefeicoes;
import GUI.vendedor.*;
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
    private Stage secondStage;
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

    private Scene historicoComprasScene;
    private ControllerHistoricoCompras controllerHistoricoCompras;

    private Scene filtrarHistoricoComprasScene;
    private ControllerFiltroHistorico controllerFiltroHistorico;
    // -----

    // Vendedor Scenes
    private Scene principalVendedorScene;
    private ControllerPrincipalVendedor controllerPrincipalVendedor;

    private Scene vendaScene;
    private ControllerVenda controllerVenda;

    private Scene listarRefeicoesScene;
    private ControllerListarRefeicoes controllerListarRefeicoes;
    private Scene pagamentoVendedorScene;
    private ControllerPagamentoVendedor controllerPagamentoVendedor;

    private Scene venderAClienteScene;
    private ControllerVenderACliente controllerVenderACliente;

    private Scene pagamentoVendaClienteScene;
    private ControllerPagamentoVendaACliente controllerPagamentoVendaACliente;

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

    private Scene filtrarUsuarioScene;
    private ControllerFiltrarUsuarios controllerFiltrarUsuarios;

    private Scene filtrarCardapioScene;
    private ControllerFiltrarCardapio controllerFiltrarCardapio;

    private Scene filtrarRegistrosScene;
    private ControllerFiltrarRegistroCompra controllerFiltrarRegistroCompra;

    private Scene listarEntradasScene;
    private ControllerListarEntradas controllerListarEntradas;

    private Scene mostrarCalendarioScene;
    private ControllerCalendario controllerCalendario;

    private Scene filtroCalendarioScene;
    private ControllerFiltroCalendario controllerFiltroCalendario;
    // -----

    // Refeições Scenes
    private Scene visualizarRefeicoesScene;
    private ControllerVisualizarRefeicoes controllerVisualizarRefeicoes;

    private Scene cadastrarRefeicoesScene;
    private ControllerCadastroRefeicao controllerCadastroRefeicao;

    private Scene alterarRefeicoesScene;
    private ControllerAlterarRefeicao controllerAlterarRefeicao;
    // -----

    private Scene catracaScene;
    private ControllerCatraca controllerCatraca;

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }

        return instance;
    }

    public void setSecondStage(Stage secondStage) {
        this.secondStage = secondStage;
    }

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

    public Scene getPagamentoVendedorScene(){return pagamentoVendedorScene; }
    public ControllerPagamentoVendedor getControllerPagamentoVendedor(){return controllerPagamentoVendedor;}

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

    public Scene getFiltrarUsuarioScene() {
        return filtrarUsuarioScene;
    }

    public ControllerFiltrarUsuarios getControllerFiltrarUsuarios() {
        return controllerFiltrarUsuarios;
    }

    public Scene getFiltrarCardapioScene() {
        return filtrarCardapioScene;
    }

    public ControllerFiltrarCardapio getControllerFiltrarCardapio() {
        return controllerFiltrarCardapio;
    }

    public Scene getFiltrarRegistrosScene() {
        return filtrarRegistrosScene;
    }

    public ControllerFiltrarRegistroCompra getControllerFiltrarRegistroCompra() {
        return controllerFiltrarRegistroCompra;
    }

    public Scene getListarEntradasScene() { return listarEntradasScene; }

    public ControllerListarEntradas getControllerListarEntradas(){return controllerListarEntradas;}

    public Scene getVenderAClienteScene() { return venderAClienteScene; }

    public ControllerVenderACliente getControllerVenderACliente() {
        return controllerVenderACliente;
    }

    public Scene getPagamentoVendaClienteScene() {
        return pagamentoVendaClienteScene;
    }

    public ControllerPagamentoVendaACliente getControllerPagamentoVendaACliente() {
        return controllerPagamentoVendaACliente;
    }

    public Scene getHistoricoComprasScene() {
        return historicoComprasScene;
    }

    public ControllerHistoricoCompras getControllerHistoricoCompras() {
        return controllerHistoricoCompras;
    }

    public Stage getSecondStage() {
        return secondStage;
    }

    public Scene getFiltrarHistoricoComprasScene() {
        return filtrarHistoricoComprasScene;
    }

    public ControllerFiltroHistorico getControllerFiltroHistorico() {
        return controllerFiltroHistorico;
    }

    public Scene getCatracaScene() {
        return catracaScene;
    }

    public ControllerCatraca getControllerCatraca() {
        return controllerCatraca;
    }

    public Scene getMostrarCalendarioScene() {
        return mostrarCalendarioScene;
    }

    public ControllerCalendario getControllerCalendario() {
        return controllerCalendario;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private ScreenManager() {
        this.initialize();
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
            AnchorPane vendaVendedor = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/vendedor/telaDeVendaAvulsa.fxml")).openStream());
            this.vendaScene = new Scene(vendaVendedor);
            this.controllerVenda = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane pagamentoVendedor = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/vendedor/telaPagamentoVendedor.fxml")).openStream());
            this.pagamentoVendedorScene = new Scene(pagamentoVendedor);
            this.controllerPagamentoVendedor = fxmlLoader.getController();

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

            fxmlLoader = new FXMLLoader();
            AnchorPane filtrarUsuarioPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaFiltroUsuarios.fxml")).openStream());
            this.filtrarUsuarioScene = new Scene(filtrarUsuarioPane);
            this.controllerFiltrarUsuarios = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane filtrarCardapioPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaFiltroCardapio.fxml")).openStream());
            this.filtrarCardapioScene = new Scene(filtrarCardapioPane);
            this.controllerFiltrarCardapio = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane filtrarRegistrosPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaFiltroRegistroCompra.fxml")).openStream());
            this.filtrarRegistrosScene = new Scene(filtrarRegistrosPane);
            this.controllerFiltrarRegistroCompra = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane listarEntradasPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaListarEntradas.fxml")).openStream());
            this.listarEntradasScene = new Scene(listarEntradasPane);
            this.controllerListarEntradas = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane vendaAClientePane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/vendedor/telaVenderACliente.fxml")).openStream());
            this.venderAClienteScene = new Scene(vendaAClientePane);
            this.controllerVenderACliente = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane pagamentoVendaAClientePane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/vendedor/telaPagamentoVendaACliente.fxml")).openStream());
            this.pagamentoVendaClienteScene = new Scene(pagamentoVendaAClientePane);
            this.controllerPagamentoVendaACliente = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane historicoComprasPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/cliente/telaHistoricoCompras.fxml")).openStream());
            this.historicoComprasScene = new Scene(historicoComprasPane);
            this.controllerHistoricoCompras = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane filtroHistoricoComprasPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/cliente/telaFiltroHistoricoCompras.fxml")).openStream());
            this.filtrarHistoricoComprasScene = new Scene(filtroHistoricoComprasPane);
            this.controllerFiltroHistorico = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane catracaPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/catraca/telaCatraca.fxml")).openStream());
            this.catracaScene = new Scene(catracaPane);
            this.controllerCatraca = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane calendarioPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaCalendario.fxml")).openStream());
            this.mostrarCalendarioScene = new Scene(calendarioPane);
            this.controllerCalendario = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader();
            AnchorPane filtroCalendarioPane = fxmlLoader.load(Objects.requireNonNull(getClass()
                    .getResource("/gerente/telaFiltroCalendario.fxml")).openStream());
            this.filtroCalendarioScene = new Scene(filtroCalendarioPane);
            this.controllerFiltroCalendario = fxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeScreen(String scr) {
        switch (scr) {
            case "LOGIN" -> {
                primaryStage.setScene(loginScene);
            }

            // Cliente
            case "PRINCIPAL_CLIENTE" -> {
                primaryStage.setScene(principalClienteScene);
                primaryStage.setTitle("RU | TELA PRINCIPAL CLIENTE");
            }

            case "VISUALIZAR_DADOS" -> {
                primaryStage.setScene(visualizarDadosScene);
                primaryStage.setTitle("RU | VISUALIZAÇÃO DE DADOS");
            }

            case "COMPRA_FICHAS" -> {
                primaryStage.setScene(compraFichasScene);
                primaryStage.setTitle("RU | COMPRAR FICHAS");
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

            case "PAGAMENTOVENDEDOR" -> {
                primaryStage.setScene(pagamentoVendedorScene);
                primaryStage.setTitle("RU | TELA DE PAGAMENTO");
            }

            case "LISTAR_REFEICOES" -> {
                primaryStage.setScene(listarRefeicoesScene);
                primaryStage.setTitle("RU | LISTAR REFEIÇÕES");
            }

            case "VENDA_CLIENTE" -> {
                primaryStage.setScene(venderAClienteScene);
                primaryStage.setTitle("RU | VENDER A CLIENTE");
            }

            case "PAGAMENTO_VENDA_CLIENTE" -> {
                primaryStage.setScene(pagamentoVendaClienteScene);
                primaryStage.setTitle("RU | PAGAMENTO");
            }
            // -----

            // Gerente
            case "PRINCIPAL_GERENTE" -> {
                primaryStage.setScene(principalGerenteScene);
                primaryStage.setTitle("RU | TELA PRINCIPAL GERENTE");
            }

            case "LISTAR_USUARIO" -> {
                primaryStage.setScene(listarUsuarioScene);
                primaryStage.setTitle("RU | LISTA DE USUÁRIOS");
            }

            case "CADASTRAR_USUARIO" -> {
                primaryStage.setScene(cadastrarUsuarioScene);
                primaryStage.setTitle("RU | CADASTRAR USUÁRIO");
            }

            case "ALTERAR_USUARIO" -> {
                primaryStage.setScene(alterarUsuarioScene);
                primaryStage.setTitle("RU | ALTERAR USUÁRIO");
            }

            case "LISTAR_REGISTRO_COMPRA" -> {
                primaryStage.setScene(listarRegistroCompraScene);
                primaryStage.setTitle("RU | LISTA DE REGISTROS DE COMPRA");
            }

            case "LISTAR_ENTRADAS" -> {
                primaryStage.setScene(listarEntradasScene);
                primaryStage.setTitle("RU | LISTA DE ENTRADAS");
            }
            // -----

            // Refeições
            case "VISUALIZAR_REFEICOES" -> {
                primaryStage.setScene(visualizarRefeicoesScene);
                primaryStage.setTitle("RU | VISUALIZAR REFEIÇÕES");
            }

            case "CADASTRAR_REFEICOES" -> {
                primaryStage.setScene(cadastrarRefeicoesScene);
                primaryStage.setTitle("RU | CADASTRO REFEIÇÕES");
            }

            case "ALTERAR_REFEICOES" -> {
                primaryStage.setScene(alterarRefeicoesScene);
                primaryStage.setTitle("RU | ALTERAR REFEIÇÕES");
            }

            case "VISUALIZAR_CARDAPIOS" -> {
                primaryStage.setScene(listarCardapiosScene);
                primaryStage.setTitle("RU | LISTA DE CARDÁPIOS");
            }

            case "CADASTRAR_CARDAPIO" -> {
                primaryStage.setScene(cadastrarCardapioScene);
                primaryStage.setTitle("RU | CADASTRO DE CARDÁPIOS");
            }

            case "LISTAR_CARDAPIOS" -> {
                primaryStage.setScene(listarCardapiosScene);
                primaryStage.setTitle("RU | LISTA DE CARDÁPIOS");
            }

            case "ALTERAR_CARDAPIO" -> {
                primaryStage.setScene(alterarCardapioScene);
                primaryStage.setTitle("RU | ALTERAR CARDÁPIO");
            }

            case "FILTRAR_USUARIO" -> {
                primaryStage.setScene(filtrarUsuarioScene);
                primaryStage.setTitle("RU | FILTRO DE USUÁRIOS");
            }

            case "FILTRAR_CARDAPIO" -> {
                primaryStage.setScene(filtrarCardapioScene);
                primaryStage.setTitle("RU | FILTRO DE CARDÁPIOS");
            }

            case "FILTRAR_REGISTRO" -> {
                primaryStage.setScene(filtrarRegistrosScene);
                primaryStage.setTitle("RU | FILTRO DE REGISTROS");
            }

            case "HISTORICO_COMPRAS" -> {
                primaryStage.setScene(historicoComprasScene);
                primaryStage.setTitle("RU | HISTÓRICO DE COMPRAS");
            }

            case "FILTRO_HISTORICO" -> {
                primaryStage.setScene(filtrarHistoricoComprasScene);
                primaryStage.setTitle("RU | FILTRO DE HISTÓRICO");
            }

            case "CATRACA" -> {
                primaryStage.setScene(catracaScene);
                primaryStage.setTitle("RU | CATRACA");
            }

            case "CALENDARIO" -> {
                primaryStage.setScene(mostrarCalendarioScene);
                primaryStage.setTitle("RU | CALENDARIO");
            }

            case "FILTRO_CALENDARIO" -> {
                primaryStage.setScene(filtroCalendarioScene);
                primaryStage.setTitle("RU | FILTRO DE CALENDÁRIO");
            }

            // -----
        }
    }

}
