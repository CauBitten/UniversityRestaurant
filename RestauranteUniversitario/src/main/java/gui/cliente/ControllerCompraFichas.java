package gui.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerCompraFichas {

    private int contador = 0;

    @FXML
    private Button buttonDecrementar;

    @FXML
    private Button buttonIncrementar;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private CheckBox checkBoxFAlmoco;

    @FXML
    private CheckBox checkBoxFJantar;

    @FXML
    private Label labelQuantidade;

    @FXML
    void bttnDecrementarOn(ActionEvent event) {
        if (contador > 0) {
            contador--;
            atualizarLabelNum(labelQuantidade);
        }
    }

    @FXML
    void bttnIncrementarOn(ActionEvent event) {
        contador++;
        atualizarLabelNum(labelQuantidade);
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
    }

    @FXML
    void checkBoxFAlmocoOn(ActionEvent event) {

    }

    @FXML
    void checkBoxFJantarOn(ActionEvent event) {

    }

    private void atualizarLabelNum (Label label) {
        label.setText(Integer.toString(contador));
    }
}
