package exception;

import java.time.LocalDate;

public class DiaNaoPossuiCardapioCadastradoException extends Exception {
    private LocalDate data;
    private String tipo;

    public DiaNaoPossuiCardapioCadastradoException(LocalDate data, String tipo) {
        super("O dia " + data + " não possui cardápio para o tipo: " + tipo);
        this.data = data;
        this.tipo = tipo;
    }
}
