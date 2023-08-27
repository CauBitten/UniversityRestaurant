package GUI.gerente;

import exception.NaoHaCardapioDeIdException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import negocio.Fachada;
import negocio.beans.CardapioPorEntrada;
import view.ScreenManager;
import view.TelasEnum;

import java.util.ArrayList;
import java.util.List;

public class ControllerFiltroCalendario {

    @FXML
    private DatePicker dtpData;

    @FXML
    private TextField tfId;

    @FXML
    private ChoiceBox<String> cbTipo;

    @FXML
    void bttnFiltrarOn(ActionEvent event) {
        List<CardapioPorEntrada> cardapioPorEntradas = filtrar();
        ScreenManager.getInstance().getControllerCalendario().limparItens();
        System.out.println(cardapioPorEntradas);

        if (cardapioPorEntradas.isEmpty()) {
            showErrorMessage("Erro: nada encontrado", "A busca não retornou resultados",
                    "Tente novamente com outro filtro");
        }
        else {
            ScreenManager.getInstance().getControllerCalendario().configurarTv(cardapioPorEntradas);
        }

        clearFields();
        ScreenManager.getInstance().changeScreen(TelasEnum.CALENDARIO.name());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        clearFields();
        ScreenManager.getInstance().changeScreen(TelasEnum.CALENDARIO.name());
    }

    private void clearFields() {
        tfId.setText("");
        cbTipo.setValue(null);
        dtpData.getEditor().clear();
    }

    private List<CardapioPorEntrada> filtrar() {
        List<CardapioPorEntrada> cardapioPorEntradas = new ArrayList<>();

        if (validarCampos()) {
            cardapioPorEntradas = Fachada.getInstance().getCardapiosPorEntrada();
        }
        else {
            CardapioPorEntrada modelo;

            if (dtpData.getValue() != null) {
                try {
                    if (cbTipo.getValue() == null) {
                        modelo = new CardapioPorEntrada(dtpData.getValue(),
                                Fachada.getInstance().obterCardapioComId(Long.parseLong(tfId.getText())), "");
                    }
                    else {
                        System.out.println("1");
                        modelo = new CardapioPorEntrada(dtpData.getValue(),
                                Fachada.getInstance().obterCardapioComId(Long.parseLong(tfId.getText())), cbTipo.getValue());
                    }

                    cardapioPorEntradas.addAll(Fachada.getInstance().obterCardapiosComInformacoesContidasEm(modelo));
                }
                catch (NumberFormatException e) {
                    showErrorMessage("Erro: ID deve ser numérico", e.getMessage(), "Tente novamente");
                }
                catch (NaoHaCardapioDeIdException e) {
                    showErrorMessage("Erro: não há cardápios com o ID informado", e.getMessage(), "Tente outro id");
                }
            }
            else {
                showErrorMessage("Erro: data inválida", "A data não pode ser nula", "Tente novamente");
            }
        }

        return cardapioPorEntradas;
    }

    private boolean validarCampos() {
        return cbTipo.getValue() == null && tfId.getText().isBlank() && dtpData.getValue() == null;
    }

    public void initialize() {
        cbTipo.getItems().addAll("Almoco", "Janta");
    }

    private void showErrorMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

}
