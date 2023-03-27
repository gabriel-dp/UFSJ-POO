package ex3;

public class Circulo implements Geometria {

    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return this.raio;
    }

    public double area() {
        return (Math.PI * this.raio * this.raio);
    }

    public double comprimento() {
        return (2 * Math.PI * this.raio);
    }

}
