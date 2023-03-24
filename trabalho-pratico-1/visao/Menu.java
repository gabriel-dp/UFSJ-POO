package visao;

import java.util.Scanner;

public abstract class Menu {

    private String titulo;
    private String[] opcoes;

    Scanner scan = new Scanner(System.in);

    public Menu(String titulo, String[] opcoes) {
        this.titulo = titulo;
        this.opcoes = opcoes;
    }

    public int getOpcao() {
        System.out.println(String.format("\n\n=== Menu %s ===", titulo));
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(String.format("(%d) %s", i, opcoes[i]));
        }

        System.out.print("Opção escolhida: ");
        int opcao = scan.nextInt();
        System.out.print("\n");

        return opcao;
    }

    abstract public void menu();

}
