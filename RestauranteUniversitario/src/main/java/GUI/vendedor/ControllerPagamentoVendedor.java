package GUI.vendedor;

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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControllerPagamentoVendedor {
    private int valorJantar = 13;
    private double valorAlmoco = 13.5;

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

        if (cbPix.isSelected() || cbCartao.isSelected() || cbBoleto.isSelected()) {
            for (int i = 0; i < ScreenManager.getInstance().getControllerVenda().getContadorAlmoco(); i++) {
                Ficha f = new Ficha("Almoco", Fachada.getInstance().getAvulso());
                fichasCompradas.add(f);
                Fachada.getInstance().adicionarFicha(f);
            }

            for (int i = 0; i < ScreenManager.getInstance().getControllerVenda().getContadorJantar(); i++) {
                Ficha f = new Ficha("Janta", Fachada.getInstance().getAvulso());
                fichasCompradas.add(f);
                Fachada.getInstance().adicionarFicha(f);
            }

            String pagamento;

            if (cbBoleto.isSelected())
                pagamento = "Boleto";
            else if(cbPix.isSelected())
                pagamento = "Pix";
            else
                pagamento = "Cartão";

            RegistroCompra rc = new RegistroCompra(fichasCompradas,
                    Fachada.getInstance().getAvulso().getLogin(), Fachada.getInstance().getUsuarioLogado().getLogin(), pagamento, LocalDateTime.now());

            Fachada.getInstance().cadastrarRegistroCompra(rc);
            showInfoAlert("Compra realizada", "A operação foi um sucesso", "Compra Efetuada Com Sucesso!");
            ScreenManager.getInstance().getControllerVenda().clearFields();
            clearFields();
            ScreenManager.getInstance().changeScreen(TelasEnum.VENDA.name());
        }
        else {
            showErrorAlert("Erro: pagamento não selecionado", "Método de pagamento não selecionado",
                    "Você deve selecionar um método de pagamento para efetuar a compra");
        }
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.VENDA.name());
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
        double tFAlmoco = ScreenManager.getInstance().getControllerVenda().getContadorAlmoco() * valorAlmoco;

        int tFJantar = ScreenManager.getInstance().getControllerVenda().getContadorJantar() * valorJantar;

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

    private void showErrorAlert(String titulo, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
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
