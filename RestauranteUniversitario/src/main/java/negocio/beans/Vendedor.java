package negocio.beans;

public class Vendedor extends Usuario {

    private int qntFichasVendidas;
    private double faturamentoInd;

    Vendedor(String senha, String login, String email,
             String nome, long cpf, boolean ativado) {

        super(senha, login, email, nome, cpf, ativado);
        qntFichasVendidas = 0;
        faturamentoInd = 0;
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
    //

    public int getQntFichasVendidas() {
        return qntFichasVendidas;
    }

    public double getFaturamentoInd() {
        return faturamentoInd;
    }

    public void vender(RegistroCompra rc){
        for(Fichas fichas : rc.getFichasCompradas()){
            this.qntFichasVendidas++;
            this.faturamentoInd += fichas.getValor();
        }
    }

    public String toString() {
        String toString;

        toString = "===============V===============\n";
        toString += String.format("Nome         : %s\n", super.getNome());
        toString += String.format("E-mail       : %s\n", super.getEmail());
        toString += String.format("CPF          : %s\n", super.getCpf());
        toString += String.format("Ativado      : %s\n", super.isAtivado());
        toString += String.format("T. de Vendas : %d\n", qntFichasVendidas);
        toString += String.format("T. em Vendas : R$ %.2f\n", faturamentoInd);
        toString += "===============V===============\n";

        return toString;
    }
}
