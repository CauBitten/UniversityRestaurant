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

    private DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
    public Cardapio obterCardapioPorDiaETipo(String data, String tipo) {
        LocalDate aux = LocalDate.parse(data , formato2);
        for(CardapioPorEntrada ce : this.cardapioPorEntrada){
            if(ce.getData() == aux && ce.getTipo() == tipo){
                return ce.getCardapio();
            }
        }
        //Tentei retornar nulo, mas n funfou
        return null;
    }

}
