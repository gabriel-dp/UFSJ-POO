package ex2;

public class UsaConta {
    public static void main(String[] args) {
        Conta conta = new Conta(123);
        ContaInterface contaInterface = new ContaInterface(conta);
        contaInterface.menu();
    }
}
