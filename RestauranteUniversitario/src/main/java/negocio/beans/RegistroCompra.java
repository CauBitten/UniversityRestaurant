package negocio.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegistroCompra {

    private List<Fichas> fichasCompradas;
    private long codigoCompra;
    private Cliente cliente;
    private String vendedor;
    private LocalDateTime dataHoraCompra;
    private Pagamento pagamento;
    private double valorCompra;

    DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public RegistroCompra(List<Fichas> fichasCompradas, Cliente cliente,
                          String vendedor, String dataHora)
    {
        this.fichasCompradas = fichasCompradas;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.dataHoraCompra = LocalDateTime.parse(dataHora, formatoDataHora);
        this.valorCompra = gerarValorDeCompra();
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

    public String getVendedor() {
        return vendedor;
    }

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public double getValorCompra() {
        return valorCompra;
    }
    //

    private double gerarValorDeCompra() {
        double total = 0;

        for (Fichas fichas : fichasCompradas) {
            total += fichas.getValor();
        }

        return total;
    }

    public void setCodigoCompra(long codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public boolean pagamentoAutorizado() {
        pagamento = new Pagamento(this.getValorCompra());

        return pagamento.isAutorizado();
    }

    public String toString() {
        String toString = "";

        toString = String.format("=============== %d ===============\n", codigoCompra);
        toString += String.format("negocio.beans.Cliente     : %s\n", cliente.getNome());
        toString += String.format("negocio.beans.Vendedor    : %s\n", vendedor);
        toString += String.format("Data & Hora : %s\n", dataHoraCompra.format(formatoDataHora));
        toString += String.format("Valor       : %.2f\n", valorCompra);
        toString += "==================RC=================\n";

        return toString;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RegistroCompra) {
            return ((RegistroCompra) o).getCodigoCompra() != codigoCompra;
        }

        return false;
    }
}
