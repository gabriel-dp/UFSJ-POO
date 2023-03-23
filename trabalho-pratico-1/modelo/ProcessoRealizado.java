package modelo;

public class ProcessoRealizado {

    private Processo processo;
    private int quantidade;

    public ProcessoRealizado(Processo processo) {
        this.processo = processo;
        this.quantidade = 1;
    }

    public ProcessoRealizado(Processo processo, int quantidade) {
        this.processo = processo;
        this.quantidade = quantidade;
    }

    public Processo getProcesso() {
        return this.processo;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

}
