package gui.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalGerente {

    @FXML
    private Button listarCardapiosButton;

    @FXML
    private Button listarRegistrosCompra;

    @FXML
    private Button listarUsuariosButton;

    @FXML
    void bttnListarCardapios(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.VISUALIZAR_CARDAPIOS.name());
    }

    @FXML
    void bttnListarRegistrosCompra(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.LISTAR_REGISTRO_COMPRA.name());
    }

    @FXML
    void bttnListarUsuarios(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.LISTAR_USUARIO.name());
    }

}
