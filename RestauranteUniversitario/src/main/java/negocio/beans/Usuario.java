package negocio.beans;

import java.util.Objects;

public class Usuario {

    private String senha;
    private String login;
    private String email;
    private String nome;
    private long cpf;
    private boolean ativado;
    private String perfil;

    public Usuario(String senha, String login, String email,
            String nome, long cpf, boolean ativado, String perfil) {

        if (senha != null && login != null && email != null && nome != null && perfil != null) {
            this.senha = senha;
            this.login = login;
            this.email = email;
            this.nome = nome;
            this.cpf = cpf;
            this.ativado = ativado;
            this.perfil = perfil;
        }
    }

    public String getSenha() {
        return senha;
    }


    public String getLogin() {
        return login;
    }

    public String getPerfil() {
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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nLogin: " + login + "\nE-mail: " + email + "\nAtivo: " +
                ativado + "\nPerfil: " + perfil;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Usuario){
            Usuario user = (Usuario) obj;

            return (this.cpf == user.getCpf() || Objects.equals(this.login, user.getLogin()) ||
                    this.email.equals(user.getEmail()));
        }

        return false;
    }

}
