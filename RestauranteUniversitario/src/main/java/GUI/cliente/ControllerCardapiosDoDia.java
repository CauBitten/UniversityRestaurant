package GUI.cliente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.Fachada;
import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerCardapiosDoDia implements Initializable {

    private final LocalDate data = LocalDate.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

    @FXML
    private Label labelDate;

    @FXML
    private TableView<Cardapio> tvCardapiosDoDia;

    @FXML
    private TableColumn<Cardapio, String> tcGuarnicao;

    @FXML
    private TableColumn<Cardapio, String> tcPrincipal;

    @FXML
    private TableColumn<Cardapio, String> tcSalada;

    @FXML
    private TableColumn<Cardapio, String> tcSobremesa;

    @FXML
    private TableColumn<Cardapio, String> tcSuco;

    @FXML
    private TableColumn<Cardapio, String> tcVegetariano;

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelDate.setText(data.format(formatter));

        tcPrincipal.setCellValueFactory(new PropertyValueFactory<>("principal"));
        tcGuarnicao.setCellValueFactory(new PropertyValueFactory<>("guarnicao"));
        tcVegetariano.setCellValueFactory(new PropertyValueFactory<>("vegetariano"));
        tcSalada.setCellValueFactory(new PropertyValueFactory<>("salada"));
        tcSobremesa.setCellValueFactory(new PropertyValueFactory<>("sobremesa"));
        tcSuco.setCellValueFactory(new PropertyValueFactory<>("suco"));
    }

    public void configurarTv(List<CardapioPorEntrada> cardapios) {
        ObservableList<Cardapio> cardapiosList = FXCollections.observableArrayList();

        for (CardapioPorEntrada cardapio : cardapios) {
            if (Objects.equals(cardapio.getDataFormatada(), data.format(formatter))) {
                cardapiosList.add(cardapio.getCardapio());
            }
        }

        tvCardapiosDoDia.setItems(cardapiosList);
    }

    public void atualizarApresentacao() {
        configurarTv(Fachada.getInstance().getCardapiosPorEntrada());
    }
}
