package ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] divisores = new int[10];
        int length = 0;

        Scanner scan = new Scanner(System.in);
        System.out.print("Insert an integer number: ");
        int numero = scan.nextInt();

        try {
            for (int i = 1; i <= numero; i++) {
                if (numero % i == 0) {
                    divisores[length] = i;
                    length++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("ERROR - The number has more than 10 divisors");
        } finally {
            System.out.print("Divisors = [ ");
            for (int i = 0; i < length; i++) {
                System.out.print(divisores[i] + " ");
            }
            System.out.println("]");
        }

        scan.close();

    }
}
