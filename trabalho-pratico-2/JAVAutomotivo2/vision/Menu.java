package vision;

import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class Menu {

    private String title;
    private String[] options;

    public Menu(String title, String[] options) {
        this.title = title;
        this.options = options;
    }

    protected Scanner scan = new Scanner(System.in);

    protected int getInteger() {
        int value;
        do {
            try {
                value = scan.nextInt();
                scan.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.print("(Only integer numbers): ");
            }
        } while (true);
    }

    protected double getDouble() {
        double value;
        do {
            try {
                value = scan.nextDouble();
                scan.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.print("(Only numbers): ");
            }
        } while (true);
    }

    protected int getOption() {
        System.out.println(String.format("\n\n=== %s Menu ===", this.title));
        for (int i = 0; i < this.options.length; i++) {
            System.out.println(String.format("(%d) %s", i, this.options[i]));
        }

        System.out.print("Selected option: ");
        int option = this.getInteger();
        System.out.print("\n");

        return option;
    }

    abstract public void menu();

}
