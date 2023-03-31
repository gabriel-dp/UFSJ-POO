package ex4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Insert a number: ");
            String input = scan.nextLine();

            if (!input.chars().allMatch(Character::isDigit)) {
                throw new ItsNotANumberException(input);
            }

            System.out.println("The input is valid!");
        } catch (ItsNotANumberException error) {
            System.out.println(error.getMessage());
        } finally {
            scan.close();
        }

    }
}
