import java.util.ArrayList;

public interface IRepositorioRefeicao {

    public void cadastrarCardapio(Cardapio cardapio);

    public void cadastrarRefeicao(Refeicao refeicao);

    public void removeRefeicao(Refeicao refeicao);

    public ArrayList<Refeicao> getRefeicoes();

    public ArrayList<Cardapio> getCardapios();
}
