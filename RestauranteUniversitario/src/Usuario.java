import java.util.Objects;

public abstract class Usuario {

    private String senha;
    private String login;
    private String email;
    private String nome;
    private long cpf;
    private boolean ativado;

    Usuario(String senha, String login, String email,
            String nome, long cpf, boolean ativado) {

        this.senha = senha;
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.ativado = ativado;

    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public boolean isAtivado() {
        return ativado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Usuario){
            Usuario user = (Usuario) obj;

            return this.cpf == user.getCpf() || Objects.equals(this.login, user.getLogin());
        }

        return false;
    }
}
