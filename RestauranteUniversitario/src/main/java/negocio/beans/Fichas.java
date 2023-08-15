package negocio.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fichas {

    private long codigoFicha;
    private double valor;
    private String tipo;
    private LocalDateTime dataDeAquisicao;

    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    Fichas (String tipo, String dataDeAquisicao) {

        if (tipo.equals("Janta")) {
            valor = 3;
        } else if (tipo.equals("Almoco")) {
            valor = 3.5;
        } else {
            valor = -1;
        }

        this.tipo = tipo;
        this.dataDeAquisicao = LocalDateTime.parse(dataDeAquisicao, formato2);

    }

    // Setter
    public void setCodigoFicha(long codigoFicha) {
        this.codigoFicha = codigoFicha;
    }
    //

    // Getters
    public long getCodigoFicha() {
        return codigoFicha;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getDataDeAquisicao() {
        return dataDeAquisicao;
    }
    //

    public String toString() {
        String toString;

        toString = "===============F===============\n";
        toString += String.format("Código Ficha   : %s\n", codigoFicha);
        toString += String.format("Tipo Ficha     : %s\n", tipo);
        toString += String.format("Valor Unitário : %.2f\n", valor);
        toString += String.format("Data Aquisição : %s\n", dataDeAquisicao.format(formato2));
        toString += "==================F=================\n";

        return toString;
    }
}
