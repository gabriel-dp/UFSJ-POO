package ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("First string: ");
        String string1 = scan.nextLine();
        System.out.print("Second string: ");
        String string2 = scan.nextLine();

        System.out.print("\nResult = ");
        try {
            int result = string1.compareTo(string2);
            System.out.println(result);
        } catch (NullPointerException error) {
            System.out.println("Cannot compare null strings");
        }

        scan.close();
    }
}