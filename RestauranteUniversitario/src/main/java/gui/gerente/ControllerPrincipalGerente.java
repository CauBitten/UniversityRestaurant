package gui.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPrincipalGerente {

    @FXML
    private Button listarRefeicoesButton;

    @FXML
    private Button listarRegistrosCompra;

    @FXML
    private Button listarUsuariosButton;

    @FXML
    void bttnListarRefeicoes(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.VISUALIZAR_REFEICOES.name());
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
