package dados;

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
       if (haCardapiosPorDiaIguaisA(ce)) {
           //atirar excecao
       }
       else {
           cardapiosPorEntrada.add(ce);
       }
    }

    @Override
    public CardapioPorEntrada obterCardapioPorDiaETipo(LocalDate data, String tipo) {
        for (CardapioPorEntrada ce : this.cardapiosPorEntrada){
            if (ce.getData().equals(data) && ce.getTipo().equals(tipo)){
                return ce;
            }
        }

        return null;
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

}
