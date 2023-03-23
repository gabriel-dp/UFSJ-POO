package modelo;

public class Servico {

    private Procedimento procedimento;
    private int quantidade;

    public Servico(Procedimento procedimento) {
        this.procedimento = procedimento;
        this.quantidade = 1;
    }

    public Servico(Procedimento procedimento, int quantidade) {
        this.procedimento = procedimento;
        this.quantidade = quantidade;
    }

    public Procedimento getProcedimento() {
        return this.procedimento;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

}
