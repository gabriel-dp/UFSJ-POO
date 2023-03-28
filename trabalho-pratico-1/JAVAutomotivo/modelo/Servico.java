package modelo;

public class Servico {

    private Procedimento procedimento;
    private int quantidade;

    public Servico(Procedimento procedimento, int quantidade) {
        this.procedimento = procedimento;
        this.quantidade = quantidade;
    }

    public String toString() {
        return String.format("Procedimento = { %s } | Quantidade = %d", this.procedimento.toString(),
                this.quantidade);
    }

}
