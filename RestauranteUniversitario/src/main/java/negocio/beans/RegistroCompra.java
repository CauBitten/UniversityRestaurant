package negocio.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegistroCompra {

    private List<Ficha> fichasCompradas;
    private long codigoCompra;
    private String loginCliente;
    private String loginVendedor;
    private LocalDateTime dataHoraCompra;
    private String pagamento;
    private double valorCompra;

    DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public RegistroCompra(List<Ficha> fichasCompradas, String loginCliente,
                          String loginVendedor, String pagamento, LocalDateTime dataHoraCompra)
    {
        this.fichasCompradas = fichasCompradas;
        this.loginCliente = loginCliente;
        this.loginVendedor = loginVendedor;
        this.dataHoraCompra = dataHoraCompra;
        this.valorCompra = gerarValorDeCompra();
        this.pagamento = pagamento;
    }

    // Getters
    public List<Ficha> getFichasCompradas() {
        return fichasCompradas;
    }

    public long getCodigoCompra() {
        return codigoCompra;
    }

    public String getLoginCliente() {
        return loginCliente;
    }

    public String getLoginVendedor() {
        return loginVendedor;
    }

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    public String getPagamento() {
        return pagamento;
    }

    public double getValorCompra() {
        return valorCompra;
    }
    //

    private double gerarValorDeCompra() {
        double total = 0;

        for (Ficha ficha : fichasCompradas) {
            total += ficha.getValor();
        }

        return total;
    }

    public void setCodigoCompra(long codigoCompra) {
        this.codigoCompra = codigoCompra;
    }



//    public boolean pagamentoAutorizado() {
//        pagamento = new Pagamento(this.getValorCompra());
//
//        return pagamento.isAutorizado();
//    }

    public String toString() {
        String toString = "";

        toString = String.format("=============== %d ===============\n", codigoCompra);
        toString += String.format("negocio.beans.Cliente     : %s\n", loginCliente);
        toString += String.format("negocio.beans.Vendedor    : %s\n", loginVendedor);
        toString += String.format("Data & Hora : %s\n", dataHoraCompra.format(formatoDataHora));
        toString += String.format("Valor       : %.2f\n", valorCompra);
        toString += String.format("Pagamento   : %s\n", pagamento);
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
