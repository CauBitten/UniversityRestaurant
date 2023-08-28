package GUI.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import negocio.Fachada;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalCliente {

    @FXML
    void bttnCardapiosDiaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.CARDAPIOS_DO_DIA.name());
    }

    @FXML
    void bttnHistoricoComprasOn(ActionEvent event) {
        if (!Fachada.getInstance().obterRegistrosDoUsuario(Fachada.getInstance().getUsuarioLogado()).isEmpty()) {
            ScreenManager.getInstance().getControllerHistoricoCompras().atualizarApresentacao();
            ScreenManager.getInstance().changeScreen(TelasEnum.HISTORICO_COMPRAS.name());
        }
        else {
            showErrorMessage("Erro: nada a apresentar", "Para visualizar o histórico, realize pelo menos uma compra",
                    "Realize uma compra.");
        }
    }
    @FXML
    void bttnComprarFichas(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.COMPRA_FICHAS.name());
    }

    @FXML
    void bttnVisualizarDados(ActionEvent event) {
        ScreenManager.getInstance().getControllerVisualizacaoDados().exibirDados();
        ScreenManager.getInstance().changeScreen(TelasEnum.VISUALIZAR_DADOS.name());
    }

    @FXML
    void hlSairOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.LOGIN.name());
    }

    private void showErrorMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
