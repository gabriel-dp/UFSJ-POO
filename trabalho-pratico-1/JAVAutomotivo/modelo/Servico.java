package modelo;

public class Servico {

    private Procedimento procedimento;
    private int quantidade;

    public Servico(Procedimento procedimento, int quantidade) {
        this.procedimento = procedimento;
        this.quantidade = quantidade;
    }

    public Procedimento getProcedimento() {
        return this.procedimento;
    }

    public void setProcedimento(Procedimento novoProcedimento) {
        this.procedimento = novoProcedimento;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    public String toString() {
        return String.format("Procedimento = { %s } | Quantidade = %d", this.procedimento.toString(),
                this.quantidade);
    }

}
