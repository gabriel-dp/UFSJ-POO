package ex3;

public class Retangulo implements Geometria {

    private double base, altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return this.base;
    }

    public double getAltura() {
        return this.altura;
    }

    public double area() {
        return (this.base * this.altura);
    }

    public double comprimento() {
        return (2 * this.base + 2 * this.altura);
    }

}
