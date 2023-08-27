package exception;

import negocio.beans.Entrada;

public class EntradaJaRealizadaNesteTurnoException extends Exception {
    private Entrada entrada;

    public EntradaJaRealizadaNesteTurnoException(Entrada e) {
        super("Entrada já realizada neste turno");
        this.entrada = e;
    }

    public Entrada getEntrada() {
        return this.entrada;
    }
}
