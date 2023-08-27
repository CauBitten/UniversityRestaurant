package GUI.vendedor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerPagamentoVendaACliente {

    private double valorAlmoco = 3.5;
    private int valorJantar = 3;

    @FXML
    private CheckBox cbBoleto;

    @FXML
    private CheckBox cbCartao;

    @FXML
    private CheckBox cbPix;

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
        ScreenManager.getInstance().changeScreen(TelasEnum.VENDA_CLIENTE.name());
    }

    @FXML
    void cbBoletoOn(ActionEvent event) {
        if (cbCartao.isSelected()) {
            cbCartao.setSelected(false);
        }
        if (cbPix.isSelected()) {
            cbPix.setSelected(false);
        }
    }

    @FXML
    void cbCartaoOn(ActionEvent event) {
        if (cbPix.isSelected())
            cbPix.setSelected(false);

        if (cbBoleto.isSelected())
            cbBoleto.setSelected(false);

    }

    @FXML
    void cbPixOn(ActionEvent event) {
        if (cbBoleto.isSelected())
            cbBoleto.setSelected(false);

        if (cbCartao.isSelected())
            cbCartao.setSelected(false);

    }

    public void inicializarValores() {
        double tFAlmoco = ScreenManager.getInstance().getControllerVenderACliente().getContadorAlmoco() * valorAlmoco;

        int tFJantar = ScreenManager.getInstance().getControllerVenderACliente().getContadorJantar() * valorJantar;

        double totalCompra = tFAlmoco + tFJantar;

        labelTFichasAlmoco.setText(Double.toString(tFAlmoco));
        labelTFichasJantar.setText(Integer.toString(tFJantar));
        labelTCompra.setText(Double.toString(totalCompra));
    }

    private void clearFields(){
        cbBoleto.setSelected(false);
        cbCartao.setSelected(false);
        cbPix.setSelected(false);
        labelTFichasAlmoco.setText("");
        labelTFichasJantar.setText("");
        labelTCompra.setText("");
    }

}
