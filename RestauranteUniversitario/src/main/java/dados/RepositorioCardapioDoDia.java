package dados;

import exception.DiaNaoPossuiCardapioCadastradoException;
import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCardapioDoDia implements IRepositorioCardapioDoDia {
    private List<CardapioPorEntrada> cardapiosPorEntrada;
    private static IRepositorioCardapioDoDia instance;

    private RepositorioCardapioDoDia() {
        this.cardapiosPorEntrada = new ArrayList<>();
    }

    public static IRepositorioCardapioDoDia getInstance() {
        if (instance == null) {
            instance = new RepositorioCardapioDoDia();
        }

        return instance;
    }

    @Override
    public void registrarCardapioDoDia(CardapioPorEntrada ce) {
           cardapiosPorEntrada.add(ce);
    }

    @Override
    public CardapioPorEntrada obterCardapioPorDiaETipo(LocalDate data, String tipo) throws
            DiaNaoPossuiCardapioCadastradoException {
        for (CardapioPorEntrada ce : this.cardapiosPorEntrada){
            if (ce.getData().equals(data) && ce.getTipo().equals(tipo)){
                return ce;
            }
        }

        throw new DiaNaoPossuiCardapioCadastradoException(data, tipo);
    }

    @Override
    public List<CardapioPorEntrada> getCardapiosPorEntrada() {
        return this.cardapiosPorEntrada;
    }

    private boolean haCardapiosPorDiaIguaisA(CardapioPorEntrada ce) {
        for (CardapioPorEntrada cardapioPorEntrada : cardapiosPorEntrada) {
            if (ce.equals(cardapioPorEntrada))
                return true;
        }

        return false;
    }

    @Override
    public void alterarCardapioDoDiaETipo(LocalDate data, Cardapio c, String tipo) {
        for (CardapioPorEntrada cardapioPorEntrada : cardapiosPorEntrada) {
            if (cardapioPorEntrada.getData().equals(data) && cardapioPorEntrada.getTipo().equals(tipo)) {
                cardapioPorEntrada.setCardapio(c);
            }
        }
    }

    @Override
    public boolean haDiaAssociadoAoCardapio(Cardapio c) {
        for (CardapioPorEntrada cardapioPorEntrada : cardapiosPorEntrada) {
            if (cardapioPorEntrada.getCardapio().equals(c))
                return true;
        }

        return false;
    }

    @Override
    public List<CardapioPorEntrada> obterCardapiosComInformacoesContidasEm(CardapioPorEntrada modelo) {
        List<CardapioPorEntrada> cardapiosFiltrados = new ArrayList<>();

        for (CardapioPorEntrada cardapioPorEntrada : cardapiosPorEntrada) {
            if (compararCardapioPorDiaAoModelo(modelo, cardapioPorEntrada))
                cardapiosFiltrados.add(cardapioPorEntrada);
        }

        return cardapiosFiltrados;
    }

    private boolean compararCardapioPorDiaAoModelo(CardapioPorEntrada modelo, CardapioPorEntrada ce) {
        return ce.getTipo().contains(modelo.getTipo()) &&
                (ce.getData().isAfter(modelo.getData()) ||  ce.getData().equals(modelo.getData())) &&
                modelo.getCardapio().getId() >= ce.getCardapio().getId();
    }

}
