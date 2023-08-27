package GUI.gerente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.Fachada;
import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerListarCardapios implements Initializable  {

    @FXML
    private Button buttonAlterar;

    @FXML
    private Button buttonCadastrar;

    @FXML
    private Button buttonRemover;

    @FXML
    private Button buttonVoltarPagina;

    @FXML
    private Button buttonFiltrar;

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
    private DatePicker dtpDia;

    @FXML
    void bttnAssociarAoDiaOn(ActionEvent event) {
        if (tvCardapios.getSelectionModel().getSelectedItem() != null) {
            try {
                CardapioPorEntrada ce = new CardapioPorEntrada(dtpDia.getValue(),
                        tvCardapios.getSelectionModel().getSelectedItem(), "Almoco");
                Fachada.getInstance().registrarCardapioDoDia(ce);
            }
            catch (NullPointerException e) {
                showErrorMessage("Erro: a data não pode ser vazia", "Corrija e tente novamente.");
            }
        }
        else {
            showErrorMessage("Erro: nenhum cardápio selecionado",
                    "Selecione um cardápio se quiser associa-lo.");
        }

        System.out.println(Fachada.getInstance().getCardapiosPorEntrada());
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_GERENTE.name());
    }

    @FXML
    void bttnFiltrarOn(ActionEvent event) {
        if (!Fachada.getInstance().obterCardapios().isEmpty()) {
            ScreenManager.getInstance().changeScreen(TelasEnum.FILTRAR_CARDAPIO.name());
        }
        else {
            showErrorMessage("Erro: não há cardápios para pesquisar",
                    "Para pesquisar cardápios, adicione pelo menos um.");
        }
    }

    @FXML
    void bttnRemoverOn(ActionEvent event) {
        if (tvCardapios.getSelectionModel().getSelectedItem() != null) {
            if (getConfirmation()) {
                Fachada.getInstance().removerCardapio(tvCardapios.getSelectionModel().getSelectedItem());
                atualizarApresentacao();
            }
        }
        else {
            showErrorMessage("Erro: nenhum cardápio selecionado",
                    "Selecione um cardápio se quiser removê-lo.");
        }
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

    public void configurarTv(List<Cardapio> cardapios) {
        ObservableList<Cardapio> cardapioList = FXCollections.observableArrayList();
        cardapioList.addAll(cardapios);
        tvCardapios.setItems(cardapioList);
    }

    public void atualizarApresentacao() {
        for (int i = 0; i < tvCardapios.getItems().size(); i++)
            tvCardapios.getItems().clear();

        configurarTv(Fachada.getInstance().obterCardapios());
    }

    private void showErrorMessage(String titulo, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

    private void showErrorMessage(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.show();
    }

    private boolean getConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remover cardápio");
        alert.setHeaderText("Tem certeza que gostaria de remover o cardápio selecionado?");
        alert.setContentText("Aviso: esta operação não pode ser desfeita.");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK) {
            showInfoMessage("Cardápio removido", "Cardápio removido com sucesso!", "A operação foi um sucesso!");
            return true;
        }
        else if (option.get() == ButtonType.CANCEL) {
            showInfoMessage("Operação cancelada", "A operação foi cancelada", "Nada foi modificado.");
            return false;
        }

        return false;
    }

    private void showInfoMessage(String titulo, String header, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setHeaderText(mensagem);
        alert.show();
    }

}
