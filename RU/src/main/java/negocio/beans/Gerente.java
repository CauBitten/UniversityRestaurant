package negocio.beans;

public class Gerente extends Usuario {

    Gerente(String senha, String login, String email,
            String nome, long cpf, boolean ativado) {

        super(senha, login, email, nome, cpf, ativado);
    }
}
