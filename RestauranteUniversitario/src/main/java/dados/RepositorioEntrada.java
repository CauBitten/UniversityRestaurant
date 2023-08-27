package dados;

import exception.EntradaJaRealizadaNesteTurnoException;
import negocio.beans.Entrada;

import java.time.LocalDate;
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
    @Override
    public void registrarEntrada(Entrada e) throws EntradaJaRealizadaNesteTurnoException {
        if (entradaJaRealizadaNesteTurno(e)) {
            throw new EntradaJaRealizadaNesteTurnoException(e);
        }
        else {
            entradas.add(e);
        }
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    private boolean entradaJaRealizadaNesteTurno(Entrada e) {
        for (Entrada entrada : entradas) {
            if (entrada.getTipo().equals(e.getTipo()) &&
                    entrada.getFicha().getUsuario().equals(e.getFicha().getUsuario())
                    && e.getDataHora().toLocalDate().equals(entrada.getDataHora().toLocalDate()))
                return true;
        }

        return false;
    }


}
