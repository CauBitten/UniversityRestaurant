package negocio;

import dados.IRepositorioCardapio;
import negocio.beans.Cardapio;

public class ControladorCardapio {
    private IRepositorioCardapio repositorioCardapio;
    private static ControladorCardapio instance;

    private ControladorCardapio() {
        this.repositorioCardapio = instance.repositorioCardapio;
    }

    public static ControladorCardapio getInstance() {
        if (instance == null) {
            instance = new ControladorCardapio();
        }

        return instance;
    }

    public void cadastrarCardapio(Cardapio c) {
        if (c != null) {
            if (c.getId() >= 0 && c.getPrincipal() != null &&
                c.getGuarnicao() != null && c.getSalada() != null && c.getSuco() != null &&
                c.getVegetariano() != null) {
                this.repositorioCardapio.cadastrarCardapio(c);
            }
        }
    }

    public void removerCardapio(long id) {
        Cardapio c = repositorioCardapio.encontrarCardapioPorID(id);

        if (c != null) {
            repositorioCardapio.removerCardapio(c);
        }
    }

    public Cardapio obterCardapioDeID(long id) {
        //cadastrar exceçao se id < 0
        return this.repositorioCardapio.encontrarCardapioPorID(id);
    }
}
