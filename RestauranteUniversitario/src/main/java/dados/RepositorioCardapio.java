package dados;

import exception.CardapioJaCadastradoException;
import exception.NaoHaCardapioDeIdException;
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

    @Override
    public void cadastrarCardapio(Cardapio c) throws CardapioJaCadastradoException {
        if (c != null) {
            if (obterCardapioIgualA(c) != null) {
                throw new CardapioJaCadastradoException(obterCardapioIgualA(c));
            }
            else {
                cardapios.add(c);
            }
        }
    }

    @Override
    public Cardapio encontrarCardapioPorID(long id) throws NaoHaCardapioDeIdException {
        for (Cardapio cardapio : cardapios) {
            if (cardapio.getId() == id)
                return cardapio;
        }

        throw new NaoHaCardapioDeIdException(id);
    }

    @Override
    public void removerCardapio(Cardapio c) {
        if (c != null) {
            cardapios.remove(c);
        }
    }

    @Override
    public List<Cardapio> getCardapios() {
        return cardapios;
    }

    private Cardapio obterCardapioIgualA(Cardapio c) {
        for (Cardapio cardapio : cardapios) {
            if (cardapio.equals(c))
                return cardapio;
        }

        return null;
    }

    @Override
    public void alterarCardapio(Cardapio c, Cardapio editado) throws CardapioJaCadastradoException {
        if (obterCardapioIgualA(editado) != null) {
            throw new CardapioJaCadastradoException(obterCardapioIgualA(editado));
        }
        else {
            for (Cardapio cardapio : cardapios) {
                if (cardapio.equals(c)) {
                    cardapio.setGuarnicao(editado.getGuarnicao());
                    cardapio.setVegetariano(editado.getVegetariano());
                    cardapio.setSalada(editado.getSalada());
                    cardapio.setSuco(editado.getSuco());
                    cardapio.setSobremesa(editado.getSobremesa());
                    cardapio.setPrincipal(editado.getPrincipal());
                }
            }
        }
    }

    @Override
    public List<Cardapio> obterCardapiosComOsPratosIguaisA(Cardapio modelo)
    {
        List<Cardapio> cardapiosFiltrados = new ArrayList<>();

        for (Cardapio cardapio : cardapios) {
            if (compararCardapioAoModelo(cardapio, modelo))
            {
                cardapiosFiltrados.add(cardapio);
            }
        }

        return cardapiosFiltrados;
    }

    private boolean compararCardapioAoModelo(Cardapio c, Cardapio modelo) {
        return c.getPrincipal().contains(modelo.getPrincipal()) && c.getVegetariano().contains(modelo.getVegetariano()) &&
                c.getGuarnicao().contains(modelo.getGuarnicao()) && c.getSalada().contains(modelo.getSalada())
                && c.getSobremesa().contains(c.getSobremesa()) && c.getSuco().contains(modelo.getSuco());
    }
}
