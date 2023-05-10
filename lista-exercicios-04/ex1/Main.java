package ex1;

public class Main {
    public static void main(String[] args) {
        Produto<Integer> p1 = new Produto<Integer>("Pasta de dente", 12.59F, 1234);
        Produto<Integer> p2 = new Produto<Integer>("Escova de dente", 12.59F, 4321);
        System.out.println("Produto 1 - " + p1);
        System.out.println("Produto 2 - " + p2);
        System.out.println(p1.igual(p2));
    }
}
