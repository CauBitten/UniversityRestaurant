package negocio.beans;

import negocio.Fachada;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ficha {

    // API: string uuid
    private long codigo;
    private double valor;
    private String tipo;
    private LocalDateTime dataCompra;
    private Usuario usuario;

    DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Ficha(String tipo, Usuario usuario) {
        if(usuario.getNome() != "avulso") {
            if (tipo.equals("Janta")) {
                valor = 3;
            } else if (tipo.equals("Almoco")) {
                valor = 3.5;
            } else {
                valor = -1;
            }
        }
        else {
            if (tipo.equals("Janta")) {
                valor = 13;
            } else if (tipo.equals("Almoco")) {
                valor = 13.5;
            } else {
                valor = -1;
            }
        }
                this.tipo = tipo;
                this.dataCompra = LocalDateTime.now();
                this.usuario = usuario;
            }

            public long getCodigo() {
                return codigo;
            }

            public LocalDateTime getDataCompra() {
                return dataCompra;
            }

            public Usuario getUsuario() {
                return usuario;
            }

            public double getValor() {
                return valor;
            }

            public String getTipo() {
                return tipo;
            }

            public LocalDateTime getDataDeAquisicao() {
                return dataCompra;
            }

            public String toString() {
                String toString;

                toString = "===============F===============\n";
                toString += String.format("Código Ficha   : %s\n", codigo);
                toString += String.format("Tipo Ficha     : %s\n", tipo);
                toString += String.format("Valor Unitário : %.2f\n", valor);
                toString += String.format("Data Aquisição : %s\n", dataCompra.format(formatoDataHora));
                toString += "==================F=================\n";

                return toString;
            }
        }

