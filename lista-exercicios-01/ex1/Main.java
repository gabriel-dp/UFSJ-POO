package ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a1, b1, a2, b2;

        System.out.println("\nNúmero Complexo 1");
        System.out.print("a: ");
        a1 = scan.nextDouble();
        System.out.print("b: ");
        b1 = scan.nextDouble();
        System.out.println("\nNúmero Complexo 2");
        System.out.print("a: ");
        a2 = scan.nextDouble();
        System.out.print("b: ");
        b2 = scan.nextDouble();

        NumeroComplexo complexo1 = new NumeroComplexo(a1, b1);
        NumeroComplexo complexo2 = new NumeroComplexo(a2, b2);

        System.out.println("\nSoma = " + complexo1.getSoma(complexo2));
        System.out.println("Produto = " + complexo1.getProduto(complexo2));
        System.out.println("Conjugado 1 = " + complexo1.getConjugado());
        System.out.println("Conjugado 2 = " + complexo2.getConjugado() + "\n");

        scan.close();
    }
}
