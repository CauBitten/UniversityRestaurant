package negocio;

import dados.IRepositorioFicha;
import negocio.beans.Cliente;
import negocio.beans.Ficha;
import negocio.beans.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public class ControladorFicha {
    private IRepositorioFicha repositorioFicha;
    private static ControladorFicha instance;

    private ControladorFicha() {
        this.repositorioFicha = instance.repositorioFicha;
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

    public List<Ficha> obterFichasDoTipo(String tipo) {
        //melhorar exceção
        if (tipo != null)
            return this.repositorioFicha.obterFichasDoTipo(tipo);
        else
            throw new RuntimeException();
    }

    List<Ficha> obterFichasCompradasNoIntervalo(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        if (dataHoraInicio != null && dataHoraFim != null) {
            return this.repositorioFicha.obterFichasCompradasNoIntervalo(dataHoraInicio, dataHoraFim);
        }

        return null;
    }
}
