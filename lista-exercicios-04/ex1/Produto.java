package ex1;

public class Produto<T> implements Comparable<Produto<T>> {
    private String nome;
    private float valor;
    private T codigo;

    public Produto(String nome, float valor, T codigo) {
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
    }

    public int compareTo(Produto<T> p) {
        int r = this.nome.compareTo(p.nome);
        if (r != 0)
            return r;
        return (int) ((this.valor - p.valor) * 100);
    }

    public String toString() {
        return "Código = " + this.codigo + " | Nome = " + this.nome + " | Valor = " + String.format("%.2f", this.valor);
    }

}