package negocio.beans;

public class Pagamento {

    private double valor;

    Pagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public boolean isAutorizado() {
        boolean autorizar = false;

        /*
        *   Utilizar uma API?
        *
        * */

        return autorizar;
    }
}
