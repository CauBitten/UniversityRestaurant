package gui.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalCliente {

    @FXML
    void bttnComprarFichas(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.COMPRA_FICHAS.name());
    }

    @FXML
    void bttnVisualizarDados(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.VISUALIZAR_DADOS.name());
    }

    @FXML
    void hlSairOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.LOGIN.name());
    }
}
