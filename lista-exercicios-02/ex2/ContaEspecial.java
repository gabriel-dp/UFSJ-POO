package ex2;

public class ContaEspecial extends ContaAbstrata {

    private double limite;

    public ContaEspecial(String cliente, int numConta, double limite) {
        super(cliente, numConta);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.saldo - valor < -limite) {
            return false;
        }

        this.saldo -= valor;
        return true;
    }

    public double getSaldo() {
        return this.saldo;
    }

}
