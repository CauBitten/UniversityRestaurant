package negocio;

import negocio.beans.*;

import java.util.List;

public class Fachada {
    private static Fachada instance;

    public ControladorUsuario controladorUsuario;
    private ControladorEntrada controladorEntrada;
    private ControladorCardapio controladorCardapio;
    private ControladorFicha controladorFicha;
    public ControladorRegistroCompra controladorRegistroCompra;
    private Usuario usuarioLogado;

    private Fachada() {
        this.controladorUsuario = ControladorUsuario.getInstance();
        //this.controladorEntrada = ControladorEntrada.getInstance();
        this.controladorCardapio = ControladorCardapio.getInstance();
        this.controladorFicha = ControladorFicha.getInstance();
        this.controladorRegistroCompra = ControladorRegistroCompra.getInstance();
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

    public List<Ficha> obterFichasDoTipo(String tipo) {
        return controladorFicha.obterFichasDoTipo(tipo);
    }

    public void cadastrarRegistroCompra(RegistroCompra rc) {
        controladorRegistroCompra.cadastrarRegistroCompra(rc);
    }

    public void adicionarFicha(Ficha f) {
        controladorFicha.adicionarFicha(f);
    }

    public void removerFicha(Ficha f) {
        controladorFicha.removerFicha(f);
    }

    public List<Ficha> obterFichasDoCliente(Usuario u) {
        return controladorFicha.obterFichasDoCliente(u);
    }

    public List<Usuario> obterUsuarios() {
        return controladorUsuario.listarUsuarios();
    }

    public List<Cardapio> obterCardapios() {
        return controladorCardapio.getCardapios();
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
    }
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public Usuario validarCredenciais(String login, String senha) {
        return this.controladorUsuario.getUsuarioDeCredenciais(login, senha);
    }

    public void alterarUsuario(Usuario user, Usuario editado) {
        this.controladorUsuario.alterarUsuario(user, editado);
    }

    public void removerUsuario(Usuario u) {
        if (u != null)
            this.controladorUsuario.removerUsuario(u);
    }

    public void alterarCardapio(Cardapio c, Cardapio editado) {
        if (c != null && editado != null)
            this.controladorCardapio.alterarCardapio(c, editado);
    }

    public void removerCardapio(Cardapio c) {
        if (c != null)
            this.controladorCardapio.removerCardapio(c);
    }

}
