package ex2;

import java.util.Scanner;

public class ContaInterface {

    private Conta conta;

    private Scanner scan = new Scanner(System.in);

    private enum OpcoesConta {
        Sair, Sacar, Depositar, VerSaldo
    }

    public ContaInterface(Conta conta) {
        this.conta = conta;
    }

    public int getOpcao() {
        System.out.printf("\n\n===MENU CONTA %d===\n", conta.getNumero());
        System.out.printf("(%d) Sair\n", OpcoesConta.Sair.ordinal());
        System.out.printf("(%d) Sacar\n", OpcoesConta.Sacar.ordinal());
        System.out.printf("(%d) Depositar\n", OpcoesConta.Depositar.ordinal());
        System.out.printf("(%d) Ver Saldo\n", OpcoesConta.VerSaldo.ordinal());
        System.out.print("Opcao escolhida: ");

        return this.scan.nextInt();
    }

    public void menu() {
        OpcoesConta opcao;
        do {
            opcao = OpcoesConta.values()[getOpcao()];
            switch (opcao) {
                case Sair:
                    System.out.printf("\nOperações com a conta %d encerradas\n", conta.getNumero());
                    break;
                case Sacar:
                    System.out.print("Valor: ");
                    double valor = scan.nextDouble();
                    if (conta.getSaldo() >= valor) {
                        conta.sacar(valor);
                        System.out.println("\nSaque efetuado");
                    } else {
                        System.out.println("\nSaldo insuficiente");
                    }
                    break;
                case Depositar:
                    System.out.print("Valor: ");
                    conta.depositar(scan.nextDouble());
                    System.out.println("\nDepósito efetuado");
                    break;
                case VerSaldo:
                    System.out.println("\nSaldo atual: " + conta.getSaldo());
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    break;
            }
        } while (opcao != OpcoesConta.Sair);
    }

}
