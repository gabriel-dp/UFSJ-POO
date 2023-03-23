package modelo;

public class Processo extends Entidade {

    private String nome;
    private double valor;

    public Processo(String nome, double valor) {
        super(1);
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }

}
