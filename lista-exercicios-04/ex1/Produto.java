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

    public boolean igual(Produto<T> p1, Produto<T> p2) {
        if (p1.nome.equals(p2.nome) && p1.valor == p2.valor)
            return true;
        return false;
    }

    public String toString() {
        return "Código = " + this.codigo + " | Nome = " + this.nome + " | Valor = " + String.format("%.2f", this.valor);
    }

    public static void main(String[] args) {
        Produto<T> p1 = new Produto<T>("Pasta de dente", 12.59F, 1234);
        Produto<T> p2 = new Produto<T>("Escova de dente", 12.59F, 4321);
        System.out.println(igual(p1, p2));
    }
}