package ex3;

public class Main {
    public static void main(String[] args) {
        Circulo c = new Circulo(5);
        Retangulo r = new Retangulo(10, 20);

        System.out
                .println(String.format("\nCículo (raio = %.2f)\nÁrea = %.2f\nComprimento = %.2f", c.getRaio(), c.area(),
                        c.comprimento()));

        System.out.println(String.format("\nRetângulo (base = %.2f | altura = %.2f)\nÁrea = %.2f\nComprimento = %.2f\n",
                r.getBase(), r.getAltura(), r.area(), r.comprimento()));
    }
}