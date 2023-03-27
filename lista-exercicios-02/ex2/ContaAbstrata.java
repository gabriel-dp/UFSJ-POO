package ex2;

public abstract class ContaAbstrata {

    protected String cliente;
    protected int numConta;
    protected double saldo;

    public ContaAbstrata(String cliente, int numConta) {
        this.cliente = cliente;
        this.numConta = numConta;
        this.saldo = 0;
    }

    public String getCliente() {
        return this.cliente;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public abstract double getSaldo();

    public boolean sacar(double valor) {
        if (this.saldo < valor) {
            return false;
        }

        this.saldo -= valor;
        return true;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

}