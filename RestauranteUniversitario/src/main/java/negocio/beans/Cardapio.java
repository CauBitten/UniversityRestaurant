package negocio.beans;

import java.util.Objects;

public class Cardapio {
    private String principal1;
    private String principal2;
    private String vegetariano;
    private String guarnicao;
    private String salada;
    private String sobremesa;
    private String suco;

    public Cardapio(String principal1, String principal2, String vegetariano,
                    String guarnicao, String salada, String sobremesa, String suco) {

        this.principal1 = principal1;
        this.principal2 = principal2;
        this.vegetariano = vegetariano;
        this.guarnicao = guarnicao;
        this.salada = salada;
        this.sobremesa = sobremesa;
        this.suco = suco;
    }

    public String toString(){
        return    "Prato principal 1 : " + principal1 + "\nPrato principal 2 : " + principal2 +
                "\nVegetariano       : " + vegetariano +"\nGuarnicao         : " + guarnicao +
                "\nSalada            : " + salada +
                "\nSobremesa         : " + sobremesa +  "\nSuco : " + suco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Cardapio cardapio = (Cardapio) o;
        return Objects.equals(principal1, cardapio.principal1) && Objects.equals(principal2, cardapio.principal2)
                && Objects.equals(vegetariano, cardapio.vegetariano) && Objects.equals(guarnicao, cardapio.guarnicao)
                && Objects.equals(salada, cardapio.salada) && Objects.equals(sobremesa, cardapio.sobremesa) && Objects.equals(suco, cardapio.suco);
    }
}
