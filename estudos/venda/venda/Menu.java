package venda;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Produto> produtos;
    private Scanner scan;

    public Menu(ArrayList<Produto> produtos, Scanner scan) {
        this.produtos = produtos;
        this.scan = scan;
    }

    public int getMenuOption() {
        System.out.println("\n\nMENU");
        System.out.println("(1) - Cadastrar produto");
        System.out.println("(2) - Realizar venda");
        System.out.println("(3) - Sair do programa");
        System.out.print("Opcaoo escolhida: ");

        int option = scan.nextInt();

        return option;
    }

    private void CadastraProduto() {
        System.out.println("\nCADASTRAR PRODUTO ");

        System.out.print("Id: ");
        int id = scan.nextInt();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                System.out.println("Outro produto possui esse id");
            }
        }

        System.out.print("Nome: ");
        String nome = scan.next();

        System.out.print("Valor: ");
        double valor = scan.nextDouble();

        System.out.print("Quantidade: ");
        int quantidade = scan.nextInt();

        Produto novo = new Produto(id, nome, valor, quantidade);
        produtos.add(novo);
    }

    private void RealizaVenda() {
        System.out.println("\nREALIZAR VENDA");

        ArrayList<Produto> venda = new ArrayList<Produto>();

        int id;
        do {
            System.out.print("\nId: ");
            id = scan.nextInt();

            for (Produto produto : produtos) {
                if (produto.getId() == id) {
                    System.out.println("(" + produto.getNome() + ")");

                    System.out.print("Quantidade: ");
                    int quantidade = scan.nextInt();

                    int restante = produto.getQuantidade() - quantidade;
                    if (restante >= 0) {
                        produto.setQuantidade(restante - quantidade);
                        venda.add(produto);
                    } else {
                        System.out.println("\nQunatidade insuficiente de " + produto.getNome());
                    }
                }
            }
        } while (id != 0);

    }

    public void runMenu() {
        int option;
        do {
            option = this.getMenuOption();

            switch (option) {
                case 1:
                    CadastraProduto();
                    break;
                case 2:
                    RealizaVenda();
                    break;
                case 3:
                    System.out.println("\nPrograma encerrado.");
                    break;
                default:
                    System.out.println("\nOpcao Invalida. Tente novamente.");
                    break;
            }
        } while (option != 3);

    }
}
