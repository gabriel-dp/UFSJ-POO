package ex1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Produto<Integer> p1 = new Produto<Integer>("Pasta de dente", 12.59F, 1234);
        Produto<Integer> p2 = new Produto<Integer>("Escova de dente", 12.59F, 4321);
        Produto<Integer> p3 = new Produto<Integer>("Arvore", 10.10F, 4321);

        ArrayList<Produto<Integer>> ptodos = new ArrayList<>();
        ptodos.add(p1);
        ptodos.add(p2);
        ptodos.add(p3);
        Collections.sort(ptodos);
        for (Produto<Integer> p : ptodos) {
            System.out.println(p);
        }
    }
}
