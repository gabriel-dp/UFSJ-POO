package modelo;

public class Procedimento extends Entidade {

    private String nome;
    private double valor;

    public Procedimento(String nome, double valor) {
        super(1);
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double novoValor) {
        this.valor = novoValor;
    }

}
