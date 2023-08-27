package negocio;

import dados.IRepositorioCardapio;
import dados.RepositorioCardapio;
import exception.CardapioJaCadastradoException;
import exception.NaoHaCardapioDeIdException;
import negocio.beans.Cardapio;

import java.util.List;

public class ControladorCardapio {
    private IRepositorioCardapio repositorioCardapio;
    private static ControladorCardapio instance;

    private ControladorCardapio() {
        this.repositorioCardapio = RepositorioCardapio.getInstance();
    }

    public static ControladorCardapio getInstance() {
        if (instance == null) {
            instance = new ControladorCardapio();
        }

        return instance;
    }

    public void cadastrarCardapio(Cardapio c) throws CardapioJaCadastradoException {
        if (c != null) {
            if (c.getId() >= 0 && c.getPrincipal() != null &&
                c.getGuarnicao() != null && c.getSalada() != null && c.getSuco() != null &&
                c.getVegetariano() != null) {
                this.repositorioCardapio.cadastrarCardapio(c);
            }
        }
    }

    public void removerCardapio(Cardapio c) {
        if (c != null) {
            repositorioCardapio.removerCardapio(c);
        }
    }

    public Cardapio obterCardapioDeID(long id) throws NaoHaCardapioDeIdException {
        return this.repositorioCardapio.encontrarCardapioPorID(id);
    }

    public List<Cardapio> getCardapios() {
        return this.repositorioCardapio.getCardapios();
    }

    public void alterarCardapio(Cardapio c, Cardapio editado) throws CardapioJaCadastradoException {
        if (c != null && editado != null)
            this.repositorioCardapio.alterarCardapio(c, editado);
    }

    public List<Cardapio> obterCardapioComOsPratosContidosEm(Cardapio modelo) {
        return this.repositorioCardapio.obterCardapiosComOsPratosIguaisA(modelo);
    }
}
