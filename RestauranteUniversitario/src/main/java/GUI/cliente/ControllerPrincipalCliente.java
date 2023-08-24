package GUI.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalCliente {

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
}
