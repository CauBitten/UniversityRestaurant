package negocio.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Entrada {
    private Cardapio cardapio;
    private String tipo;
    private LocalDateTime dataHora;
    private Ficha ficha;

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Entrada(Cardapio cardapio, String tipo, String dataHora, Ficha ficha) {
        this.cardapio = cardapio;
        this.tipo = tipo;
        this.dataHora = LocalDateTime.parse(dataHora, formato);
        this.ficha = ficha;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String toString(){
        return "A refeição é um   : " + tipo + "\nData da refeição  : " + dataHora.format(formato) + cardapio.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Entrada) {
            return ((Entrada) o).getDataHora() == dataHora &&
                    Objects.equals(((Entrada) o).getTipo(), tipo);
        } else {
            return false;
        }
    }
}
