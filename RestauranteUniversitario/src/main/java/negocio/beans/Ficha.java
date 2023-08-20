package negocio.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ficha {
    private long codigo;
    private double valor;
    private String tipo;
    private LocalDateTime dataCompra;
    private Cliente cliente;

    public long getCodigo() {
        return codigo;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Ficha(String tipo, String dataCompra, Cliente cliente) {
        if (tipo.equals("Janta")) {
            valor = 3;
        } else if (tipo.equals("Almoco")) {
            valor = 3.5;
        } else {
            valor = -1;
        }

        this.tipo = tipo;
        this.dataCompra = LocalDateTime.parse(dataCompra, formatoDataHora);
        this.cliente = cliente;
    }

    public void setCodigoFicha(long codigoFicha) {
        this.codigo = codigoFicha;
    }

    public long getCodigoFicha() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getDataDeAquisicao() {
        return dataCompra;
    }

    public String toString() {
        String toString;

        toString = "===============F===============\n";
        toString += String.format("Código Ficha   : %s\n", codigo);
        toString += String.format("Tipo Ficha     : %s\n", tipo);
        toString += String.format("Valor Unitário : %.2f\n", valor);
        toString += String.format("Data Aquisição : %s\n", dataCompra.format(formatoDataHora));
        toString += "==================F=================\n";

        return toString;
    }
}
