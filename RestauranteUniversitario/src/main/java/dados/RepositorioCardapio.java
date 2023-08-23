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
            if (verificarSeHaCardapiosIguaisA(c)) {
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

    public void removerCardapio(Cardapio c) {
        if (c != null) {
            cardapios.remove(c);
        }
    }

    public List<Cardapio> getCardapios() {
        return cardapios;
    }

    private boolean verificarSeHaCardapiosIguaisA(Cardapio c) {
        for (Cardapio cardapio : cardapios) {
            if (cardapio.equals(c))
                return true;
        }

        return false;
    }
}
