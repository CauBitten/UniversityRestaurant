package gui.gerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import negocio.beans.Cardapio;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerListarCardapios {

    @FXML
    private Button buttonAlterar;

    @FXML
    private Button buttonCadastrar;

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

    }

    @FXML
    void bttnCadastrarCardapioOn(ActionEvent event) {
        ScreenManager.changeScreen(TelasEnum.CADASTRAR_CARDAPIO.name());
    }

}
