package GUI.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalGerente {

    @FXML
    private Button buttonListarCardapios;

    @FXML
    private Button buttonListarEntradas;

    @FXML
    private Button buttonListarRegistros;

    @FXML
    private Button buttonListarUsuarios;

    @FXML
    private Hyperlink hlSair;

    @FXML
    void bttnListarCardapiosOn(ActionEvent event) {
        ScreenManager.getInstance().getControllerListarCardapios().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.VISUALIZAR_CARDAPIOS.name());
    }

    @FXML
    void bttnListarRegistrosCompraOn(ActionEvent event) {
        ScreenManager.getInstance().getControllerListarRegistroCompra().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_REGISTRO_COMPRA.name());
    }
    @FXML
    void bttnCalendario(ActionEvent event) {
        ScreenManager.getInstance().getControllerCalendario().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.CALENDARIO.name());
    }

    @FXML
    void bttnListarUsuariosOn(ActionEvent event) {
        ScreenManager.getInstance().getControllerListarUsuarios().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

    @FXML
    void hlSairOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.LOGIN.name());
    }

    @FXML
    void bttnListarEntradasOn(ActionEvent event) {
        ScreenManager.getInstance().getControllerListarEntradas().atualizarApresentacao();
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_ENTRADAS.name());
    }

}
