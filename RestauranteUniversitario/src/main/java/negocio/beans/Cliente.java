package negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private long matricula;

    public Cliente (String senha, String login, String email, String nome,
             long cpf, boolean ativado, String perfil, long matricula)
    {
        super(senha, login, email, nome, cpf, ativado, perfil);
        this.matricula = matricula;
    }

    public long getMatricula() {
        return matricula;
    }

    public String toString() {
        String toString;

        toString = "===============C===============\n";
        toString += String.format("Nome        : %s\n", super.getNome());
        toString += String.format("E-mail      : %s\n", super.getEmail());
        toString += String.format("CPF         : %s\n", super.getCpf());
        toString += String.format("Matrícula   : %d\n", matricula);
        toString += String.format("Ativado     : %s\n", super.isAtivado());
        toString += "===============C===============\n";

        return toString;
    }

}
