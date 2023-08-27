package dados;

import exception.EntradaJaRealizadaNesteTurnoException;
import negocio.beans.Cardapio;
import negocio.beans.Entrada;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioEntrada {
    void registrarEntrada(Entrada e) throws EntradaJaRealizadaNesteTurnoException;

    List<Entrada> getEntradas();

}
