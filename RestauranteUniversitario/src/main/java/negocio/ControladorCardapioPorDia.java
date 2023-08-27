package negocio;

import dados.IRepositorioCardapioDoDia;
import dados.RepositorioCardapioDoDia;
import exception.DiaNaoPossuiCardapioCadastradoException;
import negocio.beans.Cardapio;
import negocio.beans.CardapioPorEntrada;
import negocio.beans.Entrada;

import java.time.LocalDate;
import java.util.List;

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

    public void registrarCardapioDoDia(CardapioPorEntrada ce) {
        this.repositorioCardapioDoDia.registrarCardapioDoDia(ce);
    }

    public CardapioPorEntrada obterCardapioDoDia(LocalDate data, String tipo) throws
            DiaNaoPossuiCardapioCadastradoException {
        return this.repositorioCardapioDoDia.obterCardapioPorDiaETipo(data, tipo);
    }

    public List<CardapioPorEntrada> getCardapiosPorEntrada() {
        return this.repositorioCardapioDoDia.getCardapiosPorEntrada();
    }

    public void alterarCardapioDoDiaETipo(LocalDate data, Cardapio c, String tipo) {
        this.repositorioCardapioDoDia.alterarCardapioDoDiaETipo(data, c, tipo);
    }

    public boolean haDiaAssociadoAoCardapio(Cardapio c) {
        return this.repositorioCardapioDoDia.haDiaAssociadoAoCardapio(c);
    }

}
