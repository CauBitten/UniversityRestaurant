package negocio.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistroCompra {

    private List<Fichas> fichasCompradas = new ArrayList<>();
    private long codigoCompra;
    private Cliente cliente;
    private Vendedor vendedor;
    private LocalDateTime dataHora;
    private Pagamento pagamento;
    private double valor;

    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public RegistroCompra(List<Fichas> fichasCompradas, Cliente cliente,
                          Vendedor vendedor, String dataHora) {

        this.fichasCompradas = fichasCompradas;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.dataHora = LocalDateTime.parse(dataHora, formato2);

        gerarValor();
    }

    // Getters
    public List<Fichas> getFichasCompradas() {
        return fichasCompradas;
    }

    public long getCodigoCompra() {
        return codigoCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public double getValor() {
        return valor;
    }
    //

    public void gerarValor () {
        double total = 0;

        for (Fichas fichas : fichasCompradas) {
            total += fichas.getValor();
        }

        this.valor = total;
    }

    public void setCodigoCompra(long codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public boolean autorizacaoPagamento() {
        pagamento = new Pagamento(valor);

        return pagamento.autorizarPag();
    }

    public String toString() {
        String toString;

        toString = String.format("=============== %d ===============\n", codigoCompra);
        toString += String.format("negocio.beans.Cliente     : %s\n", cliente.getNome());
        toString += String.format("negocio.beans.Vendedor    : %s\n", vendedor.getNome());
        toString += String.format("Data & Hora : %s\n", dataHora.format(formato2));
        toString += String.format("Valor       : %.2f\n", valor);
        toString += "==================RC=================\n";

        return toString;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;

        if (o instanceof RegistroCompra) {

            if (((RegistroCompra) o).getCodigoCompra() != codigoCompra) {
                result = true;
            }

        }

        return result;
    }
}
