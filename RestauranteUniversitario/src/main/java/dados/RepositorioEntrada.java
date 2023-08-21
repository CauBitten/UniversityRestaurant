package dados;

import negocio.beans.Cliente;
import negocio.beans.Entrada;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEntrada implements IRepositorioEntrada {
    private List<Entrada> entradas;
    private static IRepositorioEntrada instance;

    private RepositorioEntrada() {
        entradas = new ArrayList<>();
    }

    public static IRepositorioEntrada getInstance() {
        if (instance == null) instance = new RepositorioEntrada();

        return instance;
    }

    public void adicionarEntrada(Entrada e) {
        if (e != null) {
            entradas.add(e);
        }
    }

    public List<Entrada> obterEntradasDosDias(LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Entrada> entradasPorDia = new ArrayList<>();

        return entradasPorDia;
    }

    public List<Entrada> obterEntradasPorClienteComMatricula(long matricula) {
        List<Entrada> entradasPorCliente = new ArrayList<>();

        for (Entrada entrada : entradas) {
            long idDoCliente = entrada.getFicha().getCliente().getMatricula();

            if (idDoCliente == matricula)
                entradasPorCliente.add(entrada);
        }

        return entradasPorCliente;
    }

    public List<Entrada> obterEntradasPorTipo(String tipo) {
        List<Entrada> entradasPorTipo = new ArrayList<>();

        for (Entrada entrada : entradas) {
            String tipoEntrada = entrada.getTipo();

            if (tipoEntrada.equals(tipo))
                entradasPorTipo.add(entrada);
        }

        return entradasPorTipo;
    }

    public Entrada obterEntradaComFichaDeID(long id) {
        for (Entrada entrada : entradas) {
            if (entrada.getFicha().getCodigo() == id)
                return entrada;
        }

        return null;
    }

    public List<Entrada> obterEntradasComCardapioDeID(long id) {
        List<Entrada> entradasPorCardapio = new ArrayList<>();

        for (Entrada entrada : entradas) {
            if (entrada.getCardapio().getId() == id)
                entradasPorCardapio.add(entrada);
        }

        return entradasPorCardapio;
    }
}
