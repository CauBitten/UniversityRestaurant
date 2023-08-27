package negocio;

import dados.IRepositorioFicha;
import dados.RepositorioFicha;
import exception.ClienteNaoPossuiFichasException;
import negocio.beans.Ficha;
import negocio.beans.Usuario;

import java.util.List;

public class ControladorFicha {
    private IRepositorioFicha repositorioFicha;
    private static ControladorFicha instance;

    private ControladorFicha() {
        this.repositorioFicha = RepositorioFicha.getInstance();
    }

    public static ControladorFicha getInstance() {
        if (instance == null) {
            instance = new ControladorFicha();
        }

        return instance;
    }

    public void adicionarFicha(Ficha f) {
        if (f != null) {
            if (f.getUsuario() != null && f.getTipo() != null && f.getDataCompra() != null &&
            f.getCodigo() >= 0) {
                this.repositorioFicha.adicionarFicha(f);
            }
        }
    }

    public void removerFicha(Ficha f) {
        if (f != null) {
            this.repositorioFicha.removerFicha(f);
        }
    }

    public List<Ficha> obterFichasDoCliente(Usuario u) {
        if (u != null) {
            return this.repositorioFicha.obterFichasDoCliente(u);
        }

        return null;
    }
    public Ficha obterFichaDoClienteDoTipo(Usuario u, String tipo) throws ClienteNaoPossuiFichasException {
        return this.repositorioFicha.obterFichaDoClienteDoTipo(u, tipo);
    }


}
