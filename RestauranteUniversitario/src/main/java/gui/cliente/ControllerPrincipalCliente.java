package gui.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalCliente {

    @FXML
    private Button comprarFichasButton;

    @FXML
    private Button visualizarDadosButton;

    @FXML
    void bttnComprarFichas(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.COMPRA_FICHAS.name());
    }

    @FXML
    void bttnVisualizarDados(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.VISUALIZAR_DADOS.name());
    }

}
