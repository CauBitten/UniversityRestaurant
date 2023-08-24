package GUI.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import negocio.Fachada;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

public class ControllerVisualizacaoDados {

    @FXML
    public Label emailLabel;

    @FXML
    public Label cpfLabel;

    @FXML
    public Label fichaLabel;

    @FXML
    public Label loginLabel;

    @FXML
    public Label jantarLabel;

    @FXML
    public Label almocoLabel;

    @FXML
    private Label nomeLabel;

    @FXML
    private Button buttonVoltarPagina;



    @FXML
    public void exibirDados() {
        Usuario usuario = Fachada.getInstance().getUsuarioLogado();
        nomeLabel.setText("Nome: " + usuario.getNome());
        loginLabel.setText("Login: " + usuario.getLogin());
        emailLabel.setText("E-mail: " + usuario.getEmail());
        cpfLabel.setText("Cpf: " + usuario.getCpf());
        jantarLabel.setText("Jantar: " + 0);
        almocoLabel.setText("Al mosso: " + 0);
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
    }

}

