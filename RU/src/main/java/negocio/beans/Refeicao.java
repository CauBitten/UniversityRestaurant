package negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Refeicao {
    private Cardapio cardapio;
    private String tipo;
    private LocalDate data;

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Refeicao(Cardapio cardapio, String tipo, String data) {
        this.cardapio = cardapio;
        this.tipo = tipo;
        this.data = LocalDate.parse(data, formato);
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public String toString(){
        return "A refeição é um   : " + tipo + "\nData da refeição  : " + data.format(formato) + cardapio.toString();
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;

        if (o instanceof Refeicao) {

            if (((Refeicao) o).getData() == data &&
                    Objects.equals(((Refeicao) o).getTipo(), tipo)) {

            } else {
                result = true;
            }
        }

        return result;
    }
}
