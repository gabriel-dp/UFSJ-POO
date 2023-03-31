package ex3;

import java.util.Scanner;

public class Main {

    public static int getNumber(Scanner scan) throws EmptyStringException, NegativeNumberException {
        System.out.print("\nInsert an integer number: ");
        String input = scan.nextLine();

        if (input.isEmpty())
            throw new EmptyStringException();

        int inputNumber = Integer.parseInt(input);
        if (inputNumber < 0)
            throw new NegativeNumberException(inputNumber);

        return inputNumber;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int factorial = 1;
        do {
            try {
                int number = getNumber(scan);
                for (int i = number; i > 1; i--) {
                    factorial *= i;
                }
                break;
            } catch (EmptyStringException error) {
                System.out.println(error.getMessage());
            } catch (NegativeNumberException error) {
                System.out.println(error.getMessage());
            }
        } while (true);

        System.out.println("Factorial = " + factorial + "\n");
    }

}
