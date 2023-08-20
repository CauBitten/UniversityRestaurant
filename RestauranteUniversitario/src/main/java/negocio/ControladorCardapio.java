package negocio;

import dados.IRepositorioCardapio;

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
}
