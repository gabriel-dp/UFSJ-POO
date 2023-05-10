package ex1;

public class Produto<T> {
    private String nome;
    private float valor;
    private T codigo;

    public Produto(String nome, float valor, T codigo) {
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
    }

    public boolean igual(Produto<T> p) {
        if (this.nome.equals(p.nome) && this.valor == p.valor)
            return true;
        return false;
    }

    public String toString() {
        return "Código = " + this.codigo + " | Nome = " + this.nome + " | Valor = " + String.format("%.2f", this.valor);
    }

}