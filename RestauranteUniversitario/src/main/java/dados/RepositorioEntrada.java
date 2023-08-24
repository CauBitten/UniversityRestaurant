package dados;

import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;
import negocio.beans.Cliente;
import negocio.beans.Entrada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class RepositorioEntrada implements IRepositorioEntrada {
    private List<Entrada> entradas;
    private List<CardapioPorEntrada> cardapioPorEntrada;
    private static IRepositorioEntrada instance;



    private RepositorioEntrada() {

        entradas = new ArrayList<>();
        cardapioPorEntrada = new ArrayList<>();
    }

    public static IRepositorioEntrada getInstance() {
        if (instance == null) instance = new RepositorioEntrada();

        return instance;
    }
    @Override
    public void adicionarEntrada(Entrada e) {
        if (e != null) {
            entradas.add(e);
        }
    }
    @Override
    public List<Entrada> obterEntradasDosDias(LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Entrada> entradasPorDia = new ArrayList<>();

        return entradasPorDia;
    }
    @Override
    public List<Entrada> obterEntradasPorClienteComMatricula(long matricula) {
        List<Entrada> entradasPorCliente = new ArrayList<>();

        for (Entrada entrada : entradas) {
            long idDoCliente = entrada.getFicha().getCliente().getMatricula();

            if (idDoCliente == matricula)
                entradasPorCliente.add(entrada);
        }

        return entradasPorCliente;
    }
    @Override
    public List<Entrada> obterEntradasPorTipo(String tipo) {
        List<Entrada> entradasPorTipo = new ArrayList<>();

        for (Entrada entrada : entradas) {
            String tipoEntrada = entrada.getTipo();

            if (tipoEntrada.equals(tipo))
                entradasPorTipo.add(entrada);
        }

        return entradasPorTipo;
    }
    @Override
    public Entrada obterEntradaComFichaDeID(long id) {
        for (Entrada entrada : entradas) {
            if (entrada.getFicha().getCodigo() == id)
                return entrada;
        }

        return null;
    }
    @Override
    public List<Entrada> obterEntradasComCardapioDeID(long id) {
        List<Entrada> entradasPorCardapio = new ArrayList<>();

        for (Entrada entrada : entradas) {
            if (entrada.getCardapio().getId() == id)
                entradasPorCardapio.add(entrada);
        }

        return entradasPorCardapio;
    }
    @Override
    public void associarCardapioAoDiaeTipo(Cardapio cardapio, String tipo, String data ){
        CardapioPorEntrada ce = new CardapioPorEntrada(data, cardapio, tipo);
        this.cardapioPorEntrada.add(ce);
    }
    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Override
    public Cardapio obterCardapioPorDiaeTipo(String data, String tipo){
        LocalDate aux = LocalDate.parse(data , formato2);
        for(CardapioPorEntrada ce : this.cardapioPorEntrada){
            if(ce.getData() == aux && ce.getTipo() == tipo){
                return ce.getCardapio();
            }
        }
        //Tentei retornar nulo, mas n funfou
        return (Cardapio) new Object();
    }
}
