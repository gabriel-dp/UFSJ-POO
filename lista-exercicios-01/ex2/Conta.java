package ex2;

public class Conta {

    private int numero;
    private double saldo;

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public int getNumero() {
        return this.numero;
    }

    private void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void sacar(double valor) {
        double novoSaldo = this.saldo - valor;
        this.setSaldo(novoSaldo);
    }

    public void depositar(double valor) {
        double novoSaldo = this.saldo + valor;
        this.setSaldo(novoSaldo);
    }

}
