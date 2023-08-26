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
    private static IRepositorioEntrada instance;

    private RepositorioEntrada() {
        entradas = new ArrayList<>();
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

}
