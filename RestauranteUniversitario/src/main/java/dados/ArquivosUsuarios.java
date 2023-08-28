package dados;

import negocio.beans.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivosUsuarios {
    public static void salvarAtributosEmArquivo(String nomeArquivo, Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("Login: " + usuario.getLogin());
            writer.newLine();
            writer.write("Email: " + usuario.getEmail());
            writer.newLine();
            writer.write("Nome: " + usuario.getNome());
            writer.newLine();
            writer.write("Senha: " + usuario.getSenha());
            writer.newLine();
            writer.write("Cpf: " + usuario.getCpf());
            writer.newLine();
            writer.write("Perfil: " + usuario.getPerfil());
            writer.newLine();
            writer.write("Ativado: " + usuario.isAtivado());
            writer.newLine();
            writer.newLine(); // Linha em branco entre as entradas

            System.out.println("Atributos da pessoa salvos em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar atributos: " + e.getMessage());
        }
    }

    public static List<Usuario> recuperarAtributosDeArquivo(String nomeArquivo) {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            String nome = null;
            String login = null;
            String email = null;
            long cpf = -1L;
            boolean ativado = true;
            String perfil = null;
            String senha = null;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Nome: ")) {
                    nome = linha.substring(6);

                 } else if (linha.startsWith("Login: ")) {
                  login = linha.substring(7);
                 } else if (linha.startsWith("Email: ")) {
                  email = linha.substring(7);
                } else if (linha.startsWith("Senha: ")) {
                   senha = linha.substring(7);
                } else if (linha.startsWith("Cpf: ")) {
                    cpf = Long.parseLong(linha.substring(5));
                } else if (linha.startsWith("Perfil: ")) {
                    perfil = linha.substring(8);
                }else if (linha.startsWith("Ativado: ")) {
                    ativado = Boolean.parseBoolean(linha.substring(9));
                }

                if (nome != null && login!= null && email!= null && senha!= null && cpf!= -1L && perfil!= null) {
                    usuarios.add(new Usuario(senha,login,email,nome,cpf,ativado,perfil));
                    nome = null;
                    login = null;
                    email = null;
                    cpf = -1L;
                    ativado = true;
                    perfil = null;
                    senha = null;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return usuarios;
    }

}
