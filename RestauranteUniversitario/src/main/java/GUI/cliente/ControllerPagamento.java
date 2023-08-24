package GUI.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import negocio.Fachada;
import negocio.beans.Ficha;
import negocio.beans.RegistroCompra;
import view.ScreenManager;
import view.TelasEnum;

import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControllerPagamento {

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
        List<Ficha> fichasCompradas = new ArrayList<>();
        for (int i = 0; i < ScreenManager.getInstance().getControllerCompraFichas().getContadorAlmoco();i++){
            Ficha f = new Ficha("Almoco", Fachada.getInstance().getUsuarioLogado());
            fichasCompradas.add(f);
        }
        for (int i = 0; i < ScreenManager.getInstance().getControllerCompraFichas().getContadorJantar();i++){
            Ficha f = new Ficha("Janta", Fachada.getInstance().getUsuarioLogado());
            fichasCompradas.add(f);
        }
        RegistroCompra rc = new RegistroCompra(fichasCompradas,
                Fachada.getInstance().getUsuarioLogado(), "zezo");
        Fachada.getInstance().controladorRegistroCompra.cadastrarRegistroCompra(rc);
        showInfoAlert("Compra", "", "Compra Efetuada Com Sucesso!");
        System.out.println(Fachada.getInstance().controladorRegistroCompra.getListaRegistroCompra());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.COMPRA_FICHAS.name());
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
        if (cbPix.isSelected()) {
            cbPix.setSelected(false);
        }
        if (cbBoleto.isSelected()) {
            cbBoleto.setSelected(false);
        }
    }

    @FXML
    void cbPixOn(ActionEvent event) {
        if (cbBoleto.isSelected()) {
            cbBoleto.setSelected(false);
        }
        if (cbCartao.isSelected()) {
            cbCartao.setSelected(false);
        }
    }

    public void inicializarValores() {
        double tFAlmoco = ScreenManager.getInstance().getControllerCompraFichas().getContadorAlmoco() * 3.5;

        int tFJantar = ScreenManager.getInstance().getControllerCompraFichas().getContadorJantar() * 3;

        double totalCompra = tFAlmoco + tFJantar;

        labelTFichasAlmoco.setText(Double.toString(tFAlmoco));
        labelTFichasJantar.setText(Integer.toString(tFJantar));
        labelTCompra.setText(Double.toString(totalCompra));
    }

    private void showInfoAlert(String titulo, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
