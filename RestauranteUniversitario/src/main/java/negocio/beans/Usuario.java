package negocio.beans;

import java.util.Objects;

public abstract class Usuario {

    private String senha;
    private String login;
    private String email;
    private String nome;
    private long cpf;
    private boolean ativado;
    private int perfil;

    Usuario(String senha, String login, String email,
            String nome, long cpf, boolean ativado, int perfil) {

        if (senha != null && login != null && email != null && nome != null) {
            this.senha = senha;
            this.login = login;
            this.email = email;
            this.nome = nome;
            this.cpf = cpf;
            this.ativado = ativado;
        }

        //0 para admin, 1 para vendedor e 2 para cliente
        if (perfil >= 0 && perfil <= 2) {
            this.perfil = perfil;
        }
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public int getPerfilAdmin() {
        return perfil;
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

            return (this.cpf == user.getCpf() || Objects.equals(this.login, user.getLogin()));
        }

        return false;
    }
}
