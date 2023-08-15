package dados;

import negocio.beans.Cardapio;
import negocio.beans.Refeicao;

import java.util.ArrayList;

public class RepositorioRefeicao implements IRepositorioRefeicao {
    private ArrayList<Refeicao> refeicoes = new ArrayList<>();
    private ArrayList<Cardapio> cardapios = new ArrayList<>();

    @Override
    public void cadastrarCardapio(Cardapio cardapio){
        if (!cardapios.contains(cardapio)) {
            this.cardapios.add(cardapio);
        }
    }

    @Override
    public void cadastrarRefeicao(Refeicao refeicao){
        if (!refeicoes.contains(refeicao)) {
            this.refeicoes.add(refeicao);
        }
    }

    @Override
    public void removeRefeicao(Refeicao refeicao){
        this.refeicoes.remove(refeicao);
    }

    @Override
    public ArrayList<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    @Override
    public ArrayList<Cardapio> getCardapios() {
        return cardapios;
    }
}
