package GUI.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPagamento {

    @FXML
    private Label labelTCompra;

    @FXML
    private Label labelTFichasAlmoco;

    @FXML
    private Label labelTFichasJantar;

    @FXML
    void bttnComprarOn(ActionEvent event) {

    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.COMPRA_FICHAS.name());
    }

    @FXML
    void cbBoletoOn(ActionEvent event) {

    }

    @FXML
    void cbCartaoOn(ActionEvent event) {

    }

    @FXML
    void cbPixOn(ActionEvent event) {

    }

    public void inicializarValores() {
        double tFAlmoco = ScreenManager.getInstance().getControllerCompraFichas().getContadorAlmoco() * 3.5;

        int tFJantar = ScreenManager.getInstance().getControllerCompraFichas().getContadorJantar() * 3;

        double totalCompra = tFAlmoco + tFJantar;

        labelTFichasAlmoco.setText(Double.toString(tFAlmoco));
        labelTFichasJantar.setText(Integer.toString(tFJantar));
        labelTCompra.setText(Double.toString(totalCompra));
    }
}
