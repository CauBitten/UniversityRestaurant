package dados;

import exception.ClienteNaoPossuiFichasException;
import negocio.beans.Ficha;
import negocio.beans.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioFicha {

    void adicionarFicha(Ficha f);

    void removerFicha(Ficha f);

    Ficha obterFichaComCodigo(long codigo);

    List<Ficha> obterFichasDoCliente(Usuario u);

    Ficha obterFichaDoClienteDoTipo(Usuario u, String tipo) throws ClienteNaoPossuiFichasException;

}
