package ex3;

import java.util.Scanner;

import ex2.Conta;
import ex2.ContaInterface;

public class BancoInterface {

    private Banco banco;

    private Scanner scan = new Scanner(System.in);

    public BancoInterface(Banco banco) {
        this.banco = banco;
    }

    private enum OpcoesBanco {
        Sair, AbrirConta, SelecionarConta
    }

    public int getOpcao() {
        System.out.println("\n\n===MENU BANCO===");
        System.out.printf("(%d) Sair\n", OpcoesBanco.Sair.ordinal());
        System.out.printf("(%d) Abrir Conta\n", OpcoesBanco.AbrirConta.ordinal());
        System.out.printf("(%d) Selecionar Conta\n", OpcoesBanco.SelecionarConta.ordinal());
        System.out.print("Opcao escolhida: ");

        return this.scan.nextInt();
    }

    public void menu() {
        OpcoesBanco opcao;
        do {
            opcao = OpcoesBanco.values()[getOpcao()];
            switch (opcao) {
                case Sair:
                    System.out.println("\nPrograma encerrado");
                    break;
                case AbrirConta:
                    System.out.print("Número da conta: ");
                    int numeroNovaConta = scan.nextInt();
                    if (this.banco.getConta(numeroNovaConta) == null) {
                        Conta novaConta = new Conta(numeroNovaConta);
                        this.banco.adicionaConta(novaConta);
                        System.out.printf("\nConta %d criada com sucesso\n", numeroNovaConta);
                    } else {
                        System.out.println("\nEssa conta já existe");
                    }
                    break;
                case SelecionarConta:
                    System.out.print("Número da conta: ");
                    int numeroConta = scan.nextInt();
                    Conta conta = this.banco.getConta(numeroConta);
                    if (conta != null) {
                        ContaInterface contaInterface = new ContaInterface(conta);
                        contaInterface.menu();
                    } else {
                        System.out.println("\nConta não encontrada");
                    }
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    break;
            }
        } while (opcao != OpcoesBanco.Sair);
    }

}
