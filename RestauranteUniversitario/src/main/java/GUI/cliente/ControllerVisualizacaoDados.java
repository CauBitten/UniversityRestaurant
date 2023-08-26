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

        int fAlmoco = contarQuantidadeDeFichasDoTipo(Fachada.getInstance().obterFichasDoCliente(usuario), "Almoco");
        int fJanta = contarQuantidadeDeFichasDoTipo(Fachada.getInstance().obterFichasDoCliente(usuario), "Janta");

        nomeLabel.setText("Nome: " + usuario.getNome());
        loginLabel.setText("Login: " + usuario.getLogin());
        emailLabel.setText("E-mail: " + usuario.getEmail());
        cpfLabel.setText("CPF: " + usuario.getCpf());
        almocoLabel.setText("Almoço: " + fAlmoco);
        jantarLabel.setText("Jantar: " + fJanta);
    }

    @FXML
    void bttnVoltarPaginaOn(ActionEvent event) {
        ScreenManager.getInstance().changeScreen(TelasEnum.PRINCIPAL_CLIENTE.name());
    }

    private int contarQuantidadeDeFichasDoTipo(List<Ficha> fichas, String tipo) {
        int qtd = 0;

        for (Ficha ficha : fichas) {
            if (ficha.getTipo().equals(tipo))
                qtd++;
        }

        return qtd;
    }
}

