package negocio;

import negocio.beans.Cardapio;
import negocio.beans.Usuario;
import java.util.List;

public class Fachada {
    private static Fachada instance;

    public ControladorUsuario controladorUsuario;
    private  ControladorEntrada controladorEntrada;
    private ControladorCardapio controladorCardapio;
    private ControladorFicha controladorFicha;
    private ControladorRegistroCompra controladorRegistroCompra;

    private Fachada() {
        this.controladorUsuario = ControladorUsuario.getInstance();
        //this.controladorEntrada = ControladorEntrada.getInstance();
        this.controladorCardapio = ControladorCardapio.getInstance();
        //this.controladorFicha = ControladorFicha.getInstance();
        //this.controladorRegistroCompra = ControladorRegistroCompra.getInstance();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }

        return instance;
    }

    public void cadastrarUsuario(Usuario u) {
        if (u != null) {
            this.controladorUsuario.cadastrarUsuario(u);
        }
    }

    public void cadastrarCardapio(Cardapio c) {
        if (c != null) {
            controladorCardapio.cadastrarCardapio(c);
        }
    }

    public List<Usuario> obterUsuarios() {
        return controladorUsuario.listarUsuarios();
    }

    public List<Cardapio> obterCardapios() {
        return controladorCardapio.getCardapios();
    }
}
