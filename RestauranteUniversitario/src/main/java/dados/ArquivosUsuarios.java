package dados;

import javafx.scene.control.Alert;
import negocio.beans.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivosUsuarios {
    public static void salvarArquivo(String nomeArquivo, Usuario usuario) {
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

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao salvar atributos");
            alert.setHeaderText("Arquivo não pode ser salvo: " + e.getMessage());
            alert.show();
        }
    }

    public static List<Usuario> recuperarArquivoUsuario(String nomeArquivo) {
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro na leitura");
            alert.setHeaderText("Arquivo não pode ser lido: " + e.getMessage());
            alert.show();
        }
        return usuarios;
    }

    public static void sobrescreverArquivo(String nomeArquivo, List<Usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Usuario usuario : usuarios) {
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
            }

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao salvar");
            alert.setHeaderText("Arquivo não foi salvo: " + e.getMessage());
            alert.show();
        }
    }
}
