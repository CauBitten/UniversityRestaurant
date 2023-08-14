package negocio;

import dados.IRepositorioRefeicao;
import negocio.beans.Cardapio;
import negocio.beans.Refeicao;

import java.util.ArrayList;

public class ControladorRefeicao implements IRepositorioRefeicao {

    private IRepositorioRefeicao iRepositorioRefeicao;

    private static ControladorRefeicao instance;

    ControladorRefeicao (IRepositorioRefeicao iRepositorioRefeicao) {
        this.iRepositorioRefeicao = iRepositorioRefeicao;
    }

    public static ControladorRefeicao getInstance(IRepositorioRefeicao iRepositorioRefeicao) {
        if (instance == null) {
            instance = new ControladorRefeicao(iRepositorioRefeicao);
        }
        return instance;
    }

    @Override
    public void cadastrarCardapio(Cardapio cardapio) {
        if (cardapio != null) {
            iRepositorioRefeicao.cadastrarCardapio(cardapio);
        }
    }

    @Override
    public void cadastrarRefeicao(Refeicao refeicao) {
        if (refeicao != null) {
            iRepositorioRefeicao.cadastrarRefeicao(refeicao);
        }
    }

    @Override
    public void removeRefeicao(Refeicao refeicao) {
        if (refeicao != null) {
            iRepositorioRefeicao.removeRefeicao(refeicao);
        }
    }

    @Override
    public ArrayList<Refeicao> getRefeicoes() {
        return iRepositorioRefeicao.getRefeicoes();
    }

    @Override
    public ArrayList<Cardapio> getCardapios() {
        return iRepositorioRefeicao.getCardapios();
    }
}
