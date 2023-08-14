package negocio.beans;

import java.util.Objects;

public class Cardapio {

    private String principal1;
    private String principal2;
    private String naGrelha;
    private String fastGrill;
    private String vegetariano;
    private String guarnicao;
    private String saladaCrua;
    private String saladaCozida;
    private String sobremesa;
    private String suco;

    public Cardapio(String principal1, String principal2, String naGrelha, String fastGrill, String vegetariano,
                    String guarnicao, String saladaCrua, String saladaCozida, String sobremesa, String suco) {

        this.principal1 = principal1;
        this.principal2 = principal2;
        this.naGrelha = naGrelha;
        this.fastGrill = fastGrill;
        this.vegetariano = vegetariano;
        this.guarnicao = guarnicao;
        this.saladaCrua = saladaCrua;
        this.saladaCozida = saladaCozida;
        this.sobremesa = sobremesa;
        this.suco = suco;
    }

    public String toString(){
        return    "Prato principal 1 : " + principal1 + "\nPrato principal 2 : " + principal2 +
                "\nNa grelha         : " + naGrelha +   "\nFast Grill        : " + fastGrill +
                "\nVegetariano       : " + vegetariano +"\nGuarnicao         : " + guarnicao +
                "\nSalada Crua       : " + saladaCrua + "\nSalada Cozida     : " + saladaCozida +
                "\nSobremesa         : " + sobremesa +  "\nSuco : " + suco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cardapio cardapio = (Cardapio) o;
        return Objects.equals(principal1, cardapio.principal1) && Objects.equals(principal2, cardapio.principal2) && Objects.equals(naGrelha, cardapio.naGrelha) && Objects.equals(fastGrill, cardapio.fastGrill) && Objects.equals(vegetariano, cardapio.vegetariano) && Objects.equals(guarnicao, cardapio.guarnicao) && Objects.equals(saladaCrua, cardapio.saladaCrua) && Objects.equals(saladaCozida, cardapio.saladaCozida) && Objects.equals(sobremesa, cardapio.sobremesa) && Objects.equals(suco, cardapio.suco);
    }
}
