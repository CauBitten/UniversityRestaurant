package GUI.vendedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalVendedor {

    @FXML
    void bttnVenderAvulsoOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.VENDA.name());
    }

    @FXML
    void bttnVenderAClienteOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.VENDA_CLIENTE.name());
    }

    @FXML
    void hlSairOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.LOGIN.name());
    }

}
