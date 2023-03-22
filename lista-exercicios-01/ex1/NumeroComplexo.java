package ex1;

public class NumeroComplexo {

    private double a;
    private double b;

    public NumeroComplexo(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public NumeroComplexo getSoma(NumeroComplexo operando) {
        double novoA = this.a + operando.a;
        double novoB = this.b + operando.b;

        NumeroComplexo resultado = new NumeroComplexo(novoA, novoB);
        return resultado;
    }

    public NumeroComplexo getProduto(NumeroComplexo operando) {
        double novoA = this.a * operando.a - this.b * operando.b;
        double novoB = this.b * operando.a + this.a * operando.b;

        NumeroComplexo resultado = new NumeroComplexo(novoA, novoB);
        return resultado;
    }

    public NumeroComplexo getConjugado() {
        NumeroComplexo conjugado = new NumeroComplexo(this.a, -this.b);
        return conjugado;
    }

    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", this.a, this.b);
    }

}