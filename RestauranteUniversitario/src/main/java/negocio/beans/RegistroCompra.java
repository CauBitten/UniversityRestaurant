package negocio.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegistroCompra {

    private List<Ficha> fichasCompradas;
    private long codigoCompra;
    private Usuario usuario;
    private String vendedor;
    private LocalDateTime dataHoraCompra;
    private String pagamento;
    private double valorCompra;

    DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public RegistroCompra(List<Ficha> fichasCompradas, Usuario usuario,
                          String vendedor, String pagamento)
    {
        this.fichasCompradas = fichasCompradas;
        this.usuario = usuario;
        this.vendedor = vendedor;
        this.dataHoraCompra = LocalDateTime.now();
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

    public Usuario getUsuario() {
        return usuario;
    }

    public String getVendedor() {
        return vendedor;
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
        toString += String.format("negocio.beans.Cliente     : %s\n", usuario.getNome());
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
