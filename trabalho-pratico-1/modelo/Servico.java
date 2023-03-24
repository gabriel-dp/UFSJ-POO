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

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    public String toString() {
        return String.format("Procedimento = {\n%s\n}\nQuantidade = %d", this.procedimento.toString(), this.quantidade);
    }

}
