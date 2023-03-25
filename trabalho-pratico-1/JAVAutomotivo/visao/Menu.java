package visao;

import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class Menu {

    private String titulo;
    private String[] opcoes;

    public Menu(String titulo, String[] opcoes) {
        this.titulo = titulo;
        this.opcoes = opcoes;
    }

    protected Scanner scan = new Scanner(System.in);

    protected int getInteger() {
        int value;
        do {
            try {
                value = scan.nextInt();
                scan.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.print("(Apenas números inteiros): ");
            }
        } while (true);
    }

    protected double getDouble() {
        double value;
        do {
            try {
                value = scan.nextDouble();
                scan.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.print("(Apenas números): ");
            }
        } while (true);
    }

    protected int getOpcao() {
        System.out.println(String.format("\n\n=== Menu %s ===", titulo));
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(String.format("(%d) %s", i, opcoes[i]));
        }

        System.out.print("Opção escolhida: ");
        int opcao = this.getInteger();
        System.out.print("\n");

        return opcao;
    }

    abstract public void menu();

}
