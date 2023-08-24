package negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardapioPorEntrada {
    private LocalDate data;
    private Cardapio cardapio;
    private String tipo;
    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public CardapioPorEntrada(String data, Cardapio cardapio, String tipo) {
        this.data = LocalDate.parse(data, formato2);
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

    public DateTimeFormatter getFormato2() {
        return formato2;
    }

    public void setFormato2(DateTimeFormatter formato2) {
        this.formato2 = formato2;
    }

}
