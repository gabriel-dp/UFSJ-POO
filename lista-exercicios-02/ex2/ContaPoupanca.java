package ex2;

public class ContaPoupanca extends ContaAbstrata {

    private double rendimento;

    public ContaPoupanca(String cliente, int numConta, double rendimento) {
        super(cliente, numConta);
        this.rendimento = rendimento;
    }

    public double getSaldo() {
        double resultado = this.saldo * (1 + this.rendimento);
        return resultado;
    }

}
