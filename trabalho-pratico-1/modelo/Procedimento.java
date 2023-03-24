package modelo;

public class Procedimento extends Entidade {

    private String nomeProcedimento;
    private double valor;

    public Procedimento(int id, String nomeProcedimento, double valor) {
        super(id);
        this.nomeProcedimento = nomeProcedimento;
        this.valor = valor;
    }

    public String getNomeProcedimento() {
        return this.nomeProcedimento;
    }

    public void setNomeProcedimento(String novoNomeProcedimento) {
        this.nomeProcedimento = novoNomeProcedimento;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double novoValor) {
        this.valor = novoValor;
    }

    public String toString() {
        return String.format("Nome do procedimento = %s | Valor = %.2f", this.nomeProcedimento, this.valor);
    }

}
