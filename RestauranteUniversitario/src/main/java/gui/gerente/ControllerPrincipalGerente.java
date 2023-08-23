package gui.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalGerente {

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

    @FXML
    void hlSairOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.LOGIN.name());
    }

}
