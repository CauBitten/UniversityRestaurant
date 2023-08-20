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

    public void cadastrarCardapio(Cardapio c) {
        if (c != null) {
            Cardapio cardapio = encontrarCardapioPorID(c.getId());

            if (cardapio != null) {
                //adicionar exceçao cardapioexiste
            }
            else {
                cardapios.add(c);
            }
        }
    }

    public Cardapio encontrarCardapioPorID(long id) {
        for (Cardapio cardapio : cardapios) {
            if (cardapio.getId() == id)
                return cardapio;
        }

        return null;
    }

    public void removerCardapioComId(long id) {
        for (Cardapio cardapio : cardapios) {
            if (cardapio.getId() == id) {
                cardapios.remove(cardapio);
                break;
            }
        }
    }
}
