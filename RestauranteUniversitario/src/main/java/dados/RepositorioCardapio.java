package dados;

import negocio.beans.Cardapio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCardapio implements IRepositorioCardapio {
    private List<Cardapio> cardapios;
    private static IRepositorioCardapio instance;

    private RepositorioCardapio() {
        cardapios = new ArrayList<>();
    }

    public static IRepositorioCardapio getInstance() {
        if (instance == null) {
            instance = new RepositorioCardapio();
        }

        return instance;
    }
}
