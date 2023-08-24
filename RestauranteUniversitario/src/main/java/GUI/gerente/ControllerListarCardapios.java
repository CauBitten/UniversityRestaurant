package GUI.gerente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.Fachada;
import negocio.beans.Cardapio;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerListarCardapios implements Initializable  {

    @FXML
    private Button buttonAlterar;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonAtualizar;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private TableColumn<Cardapio, String> tblColGuarnicao;

    @FXML
    private TableColumn<Cardapio, Long> tblColId;

    @FXML
    private TableColumn<Cardapio, String> tblColPrincipal;

    @FXML
    private TableColumn<Cardapio, String> tblColSalada;

    @FXML
    private TableColumn<Cardapio, String> tblColSobremesa;

    @FXML
    private TableColumn<Cardapio, String> tblColSuco;

    @FXML
    private TableColumn<Cardapio, String> tblColVegetariano;

    @FXML
    private TableView<Cardapio> tvCardapios;

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

    @FXML
    void bttnAtualizarOn(ActionEvent event) {
        atualizarApresentacao();
    }

    @FXML
    void bttnCadastrarCardapioOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.CADASTRAR_CARDAPIO.name());
    }

    @FXML
    void buttonAlterarOn(ActionEvent event) {
        if (tvCardapios.getSelectionModel().getSelectedItem() != null) {
            ScreenManager.getInstance().getControllerAlterarCardapio().setCardapio(tvCardapios.getSelectionModel().getSelectedItem());
            ScreenManager.getInstance().getControllerAlterarCardapio().initialize();
            ScreenManager.getInstance().changeScreen(TelasEnum.ALTERAR_CARDAPIO.name());
        }
        else {
            showErrorMessage("Erro: Nenhum cardápio selecionado", "Selecione um cardápio para alterar",
                    "Tente novamente.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblColGuarnicao.setCellValueFactory(new PropertyValueFactory<>("guarnicao"));
        tblColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblColPrincipal.setCellValueFactory(new PropertyValueFactory<>("principal"));
        tblColSalada.setCellValueFactory(new PropertyValueFactory<>("salada"));
        tblColSuco.setCellValueFactory(new PropertyValueFactory<>("suco"));
        tblColVegetariano.setCellValueFactory(new PropertyValueFactory<>("vegetariano"));
        tblColSobremesa.setCellValueFactory(new PropertyValueFactory<>("sobremesa"));
    }

    private void configurarTv(List<Cardapio> cardapios) {
        ObservableList<Cardapio> cardapioList = FXCollections.observableArrayList();
        cardapioList.addAll(cardapios);
        tvCardapios.setItems(cardapioList);
    }

    public void atualizarApresentacao() {
        configurarTv(Fachada.getInstance().obterCardapios());
    }

    private void showErrorMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

}
