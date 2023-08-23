package negocio.beans;

import java.util.Objects;

public class Cardapio {
    private String principal;
    private String vegetariano;
    private String guarnicao;
    private String salada;
    private String sobremesa;
    private String suco;
    private long id;
    private static long contador = 0;

    public Cardapio(String principal, String vegetariano, String guarnicao,
                    String salada, String sobremesa, String suco) {
        //implementar o id
        this.principal = principal;
        this.vegetariano = vegetariano;
        this.guarnicao = guarnicao;
        this.salada = salada;
        this.sobremesa = sobremesa;
        this.suco = suco;
        this.id = contador;

        contador++;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(String vegetariano) {
        this.vegetariano = vegetariano;
    }

    public String getGuarnicao() {
        return guarnicao;
    }

    public void setGuarnicao(String guarnicao) {
        this.guarnicao = guarnicao;
    }

    public String getSalada() {
        return salada;
    }

    public void setSalada(String salada) {
        this.salada = salada;
    }

    public String getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }

    public String getSuco() {
        return suco;
    }

    public void setSuco(String suco) {
        this.suco = suco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString(){
        return    "Prato principal 1 : " + principal +
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
        return Objects.equals(principal, cardapio.principal) && Objects.equals(vegetariano, cardapio.vegetariano) && Objects.equals(guarnicao, cardapio.guarnicao)
                && Objects.equals(salada, cardapio.salada) && Objects.equals(sobremesa, cardapio.sobremesa) && Objects.equals(suco, cardapio.suco);
    }
}
