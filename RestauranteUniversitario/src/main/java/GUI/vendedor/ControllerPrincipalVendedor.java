package GUI.vendedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalVendedor {

    @FXML
    private Button buttonVenderACliente;

    @FXML
    private Button buttonVenderAvulso;

    @FXML
    void bttnRefeicoes(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.LISTAR_REFEICOES.name());
    }

    @FXML
    void bttnVenderAvulsoOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.VENDA.name());
    }

    @FXML
    void bttnVenderAClienteOn(ActionEvent event) {

    }

    @FXML
    void hlSairOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.LOGIN.name());
    }

}
