package dados;

import exception.EntradaJaRealizadaNesteTurnoException;
import negocio.beans.Entrada;

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
    public void registrarEntrada(Entrada e) throws EntradaJaRealizadaNesteTurnoException {
        entradas.add(e);

    }

    public List<Entrada> getEntradas() {
        return entradas;
    }


}
