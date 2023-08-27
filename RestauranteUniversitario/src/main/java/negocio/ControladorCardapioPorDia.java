package negocio;

import dados.IRepositorioCardapioDoDia;
import dados.RepositorioCardapioDoDia;
import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;
import negocio.beans.Entrada;

import java.time.LocalDate;

public class ControladorCardapioPorDia {
    private IRepositorioCardapioDoDia repositorioCardapioDoDia;
    private static ControladorCardapioPorDia instance;

    private ControladorCardapioPorDia() {
        this.repositorioCardapioDoDia = RepositorioCardapioDoDia.getInstance();
    }

    public static ControladorCardapioPorDia getInstance() {
        if (instance == null) {
            instance = new ControladorCardapioPorDia();
        }

        return instance;
    }

    public void associarCardapioAoDiaETipo(Cardapio c, String tipo, String data) {
        this.repositorioCardapioDoDia.associarCardapioAoDiaeTipo(c, tipo, data);
    }

    public CardapioPorEntrada obterCardapioDoDia(LocalDate data, String tipo) {
        return this.repositorioCardapioDoDia.obterCardapioPorDiaETipo(data, tipo);
    }
}
