package dados;

import negocio.beans.Cliente;
import negocio.beans.RegistroCompra;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioRegistroCompra {

    public void cadastrarRegistroCompra(RegistroCompra rc);

    public void removerRegistroCompra(RegistroCompra rc);

    public List<RegistroCompra> getListaRegistroCompra();

    public List<RegistroCompra> getRegistrosComprasDoCliente(Cliente c);

    public List<RegistroCompra> getRegistrosComprasPorIntervaloDeDataHora(
            LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);

    public List<RegistroCompra> getRegistrosComprasComValorMaiorOuIgualQue(double valor);

    public RegistroCompra getRegistroCompraPorCodigo(long codigo);

    public List<RegistroCompra> getRegistrosComprasDoVendedor(String vendedor);
}
