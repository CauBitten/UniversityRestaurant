package GUI.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import negocio.beans.Cardapio;
import view.ScreenManager;
import view.TelasEnum;

import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerCardapiosDoDia implements Initializable {

    private final Calendar calendar = Calendar.getInstance();
    private final Date data = calendar.getTime();

    @FXML
    private Label labelDate;

    @FXML
    private TableView<Cardapio> tvCardapiosDoDia;

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        labelDate.setText(dateFormat.format(data));
    }
}
