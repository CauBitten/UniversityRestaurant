package negocio;

import negocio.beans.Usuario;

public class Fachada {
    private static Fachada instance;

    public ControladorUsuario controladorUsuario;
    private  ControladorEntrada controladorEntrada;
    private ControladorCardapio controladorCardapio;
    private ControladorFicha controladorFicha;
    private ControladorRegistroCompra controladorRegistroCompra;

    private Fachada() {
        this.controladorUsuario = ControladorUsuario.getInstance();
        /*this.controladorEntrada = ControladorEntrada.getInstance();
        this.controladorCardapio = ControladorCardapio.getInstance();
        this.controladorFicha = ControladorFicha.getInstance();
        this.controladorRegistroCompra = ControladorRegistroCompra.getInstance();*/
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

    public Usuario obterUsuario() {
        return controladorUsuario.getUsuarioPorCPF(123);
    }
}
