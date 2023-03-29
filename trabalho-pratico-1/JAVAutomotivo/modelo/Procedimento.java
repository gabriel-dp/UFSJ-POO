package modelo;

public class Procedimento extends Entidade {

    private String nomeProcedimento;
    private double valor;

    public Procedimento(int id, String nomeProcedimento, double valor) {
        super(id);
        this.nomeProcedimento = nomeProcedimento;
        this.valor = valor;
    }

    public String toString() {
        return String.format("Nome = %s | Valor = %.2f", this.nomeProcedimento, this.valor);
    }

}
