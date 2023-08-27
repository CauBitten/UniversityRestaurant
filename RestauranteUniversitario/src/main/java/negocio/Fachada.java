package negocio;

import exception.*;
import negocio.beans.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Fachada {
    private static Fachada instance;

    public ControladorUsuario controladorUsuario;
    private ControladorEntrada controladorEntrada;
    private ControladorCardapio controladorCardapio;
    private ControladorFicha controladorFicha;
    private ControladorRegistroCompra controladorRegistroCompra;
    private ControladorCardapioPorDia controladorCardapioPorDia;
    private Usuario usuarioLogado;

    private Fachada() {
        this.controladorUsuario = ControladorUsuario.getInstance();
        this.controladorEntrada = ControladorEntrada.getInstance();
        this.controladorCardapio = ControladorCardapio.getInstance();
        this.controladorFicha = ControladorFicha.getInstance();
        this.controladorRegistroCompra = ControladorRegistroCompra.getInstance();
        this.controladorCardapioPorDia = ControladorCardapioPorDia.getInstance();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }

        return instance;
    }

    public void cadastrarUsuario(Usuario u) throws CpfJaCadastradoException, LoginJaCadastradoException,
            EmailJaCadastradoException, CPFInvalidoException{
        if (u != null) {
            this.controladorUsuario.cadastrarUsuario(u);
        }
    }

    public void cadastrarCardapio(Cardapio c) throws CardapioJaCadastradoException {
        if (c != null) {
            controladorCardapio.cadastrarCardapio(c);
        }
    }

    public void registrarEntrada(Entrada e) throws EntradaJaRealizadaNesteTurnoException {
        this.controladorEntrada.registrarEntrada(e);
        this.controladorFicha.removerFicha(e.getFicha());
    }

    public List<Entrada> getListaEntrada() {
        return controladorEntrada.getListaEntrada();
    }

    public void cadastrarRegistroCompra(RegistroCompra rc) {
        controladorRegistroCompra.cadastrarRegistroCompra(rc);
    }

    public void adicionarFicha(Ficha f) {
        controladorFicha.adicionarFicha(f);
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

    public Usuario validarCredenciais(String login, String senha) throws SenhaIncorretaException,
            LoginNaoExisteException, UsuarioDesativadoException {
        return this.controladorUsuario.getUsuarioDeCredenciais(login, senha);
    }

    public void alterarUsuario(Usuario user, Usuario editado) throws LoginJaCadastradoException, CpfJaCadastradoException,
            EmailJaCadastradoException, CPFInvalidoException {
        this.controladorUsuario.alterarUsuario(user, editado);
    }

    public void removerUsuario(Usuario u) {
        if (u != null)
            this.controladorUsuario.removerUsuario(u);
    }

    public void alterarCardapio(Cardapio c, Cardapio editado) throws CardapioJaCadastradoException {
        if (c != null && editado != null)
            this.controladorCardapio.alterarCardapio(c, editado);
    }

    public void removerCardapio(Cardapio c) {
        if (c != null)
            this.controladorCardapio.removerCardapio(c);
    }
    public Usuario getAvulso(){
        return controladorUsuario.getAvulso();
    }

    public List<RegistroCompra> getRegistrosCompra(){
        return controladorRegistroCompra.getListaRegistroCompra();
    }

    public List<Cardapio> obterCardapiosComPratosIguaisA(Cardapio modelo) {
        return this.controladorCardapio.obterCardapioComOsPratosContidosEm(modelo);
    }

    public List<Usuario> obterUsuariosComInformacoesContidasEm(Usuario modelo) {
        return this.controladorUsuario.obterUsuariosComInformacoesContidasEm(modelo);
    }

    public List<RegistroCompra> obterRegistrosContidosEm(RegistroCompra modelo, int almoco, int janta) {
        return this.controladorRegistroCompra.obterRegistrosContidosEm(modelo, almoco, janta);
    }

    public Usuario getUsuarioPorLogin(String login) {
        return this.controladorUsuario.getUsuarioPorLogin(login);
    }

    public Usuario validarUsuarioParaCompra(String login) throws UsuarioDesativadoException,
            UsuarioNaoEClienteException, LoginNaoExisteException {
        return this.controladorUsuario.validarUsuarioParaCompra(login);
    }

    public List<RegistroCompra> obterRegistrosDoUsuario(Usuario u) {
        return this.controladorRegistroCompra.obterRegistrosDoUsuario(u);
    }

    public Ficha obterFichaDoClienteDoTipo(Usuario u, String tipo) throws ClienteNaoPossuiFichasException {
        return this.controladorFicha.obterFichaDoClienteDoTipo(u, tipo);
    }

    public void registrarCardapioDoDia(CardapioPorEntrada ce) {
        this.controladorCardapioPorDia.registrarCardapioDoDia(ce);
    }

    public CardapioPorEntrada obterCardapioPorDiaETipo(LocalDate data, String tipo) {
        return this.controladorCardapioPorDia.obterCardapioDoDia(data, tipo);
    }

    public List<CardapioPorEntrada> getCardapiosPorEntrada() {
        return this.controladorCardapioPorDia.getCardapiosPorEntrada();
    }
    public CardapioPorEntrada obterCardapioDoDia(LocalDate data, String tipo) {
        return this.controladorCardapioPorDia.obterCardapioDoDia(data, tipo);
    }

    public void alterarCardapioDoDia(LocalDate data, Cardapio c, String tipo) {
        this.controladorCardapioPorDia.alterarCardapioDoDiaETipo(data, c, tipo);
    }

}