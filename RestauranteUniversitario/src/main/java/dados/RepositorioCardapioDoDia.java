package dados;

import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCardapioDoDia implements IRepositorioCardapioDoDia {
    private List<CardapioPorEntrada> cardapioPorEntrada;
    private static IRepositorioCardapioDoDia instance;

    private RepositorioCardapioDoDia() {
        this.cardapioPorEntrada = new ArrayList<>();
    }

    public static IRepositorioCardapioDoDia getInstance() {
        if (instance == null) {
            instance = new RepositorioCardapioDoDia();
        }

        return instance;
    }

    @Override
    public void associarCardapioAoDiaeTipo(Cardapio cardapio, String tipo, String data) {
        CardapioPorEntrada ce = new CardapioPorEntrada(data, cardapio, tipo);
        this.cardapioPorEntrada.add(ce);
    }

    @Override
    public CardapioPorEntrada obterCardapioPorDiaETipo(LocalDate data, String tipo) {
        for (CardapioPorEntrada ce : this.cardapioPorEntrada){
            if (ce.getData().equals(data) && ce.getTipo().equals(tipo)){
                return ce;
            }
        }

        return null;
    }

}
