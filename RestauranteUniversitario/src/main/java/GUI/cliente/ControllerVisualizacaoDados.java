package GUI.cliente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import negocio.Fachada;
import negocio.beans.Ficha;
import negocio.beans.Usuario;
import view.ScreenManager;
import view.TelasEnum;

import java.util.List;

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
        List<Ficha> fichasUsuario = Fachada.getInstance().obterFichasDoCliente(usuario);
        int Fjanta = Fachada.getInstance().obterFichasDoTipo("Janta").size();
        int FAlmoco = Fachada.getInstance().obterFichasDoTipo("Almoco").size();;
        nomeLabel.setText("Nome: " + usuario.getNome());
        loginLabel.setText("Login: " + usuario.getLogin());
        emailLabel.setText("E-mail: " + usuario.getEmail());
        cpfLabel.setText("Cpf: " + usuario.getCpf());
        jantarLabel.setText("Jantar: " + Fjanta);
        almocoLabel.setText("Al mosso: " + FAlmoco);
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
    }

}

