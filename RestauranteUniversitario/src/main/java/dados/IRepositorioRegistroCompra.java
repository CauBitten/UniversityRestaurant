package dados;

import negocio.beans.RegistroCompra;

import java.util.List;

public interface IRepositorioRegistroCompra {

    public void cadastrarRegistroCompra(RegistroCompra rc);

    public void removerRegistroCompra(RegistroCompra rc);

    public List<RegistroCompra> getListaRegistroCompra();
}
