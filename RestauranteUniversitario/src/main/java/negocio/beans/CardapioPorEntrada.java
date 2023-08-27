package negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardapioPorEntrada {
    private LocalDate data;
    private Cardapio cardapio;
    private String tipo;

    public CardapioPorEntrada(LocalDate data, Cardapio cardapio, String tipo) {
        this.data = data;
        this.cardapio = cardapio;
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean equals(Object o) {
        if (o instanceof CardapioPorEntrada) {
            return data.equals(((CardapioPorEntrada) o).getData()) &&
                    cardapio.equals(((CardapioPorEntrada) o).getCardapio()) &&
                    tipo.equals(((CardapioPorEntrada) o).getTipo());
        }

        return false;
    }

}
