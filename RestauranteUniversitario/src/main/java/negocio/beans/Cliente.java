package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private long matricula;
    private List<Fichas> listaFichas = new ArrayList<>();

    Cliente (String senha, String login, String email, String nome,
             long cpf, boolean ativado, long matricula) {

        super(senha, login, email, nome, cpf, ativado);
        this.matricula = matricula;
    }

    // Getters
    @Override
    public String getSenha () {
        return super.getSenha();
    }

    @Override
    public String getLogin () {
        return super.getLogin();
    }

    @Override
    public String getEmail () {
        return super.getEmail();
    }

    @Override
    public String getNome () {
        return super.getNome();
    }

    @Override
    public long getCpf () {
        return super.getCpf();
    }

    @Override
    public boolean isAtivado () {
        return super.isAtivado();
    }

    public long getMatricula() {
        return matricula;
    }

    public List<Fichas> getListaFichas() {
        return listaFichas;
    }
    //

    public void adicionarFichas (List<Fichas> fichasCompradas) {
        listaFichas.addAll(fichasCompradas);
    }

    public String toString() {
        String toString;

        toString = "===============C===============\n";
        toString += String.format("Nome        : %s\n", super.getNome());
        toString += String.format("E-mail      : %s\n", super.getEmail());
        toString += String.format("CPF         : %s\n", super.getCpf());
        toString += String.format("Matrícula   : %d\n", matricula);
        toString += String.format("Qtd. negocio.beans.Fichas : %s\n", listaFichas.size());
        toString += String.format("Ativado     : %s\n", super.isAtivado());
        toString += "===============C===============\n";

        return toString;
    }

}
