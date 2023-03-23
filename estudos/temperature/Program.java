import java.util.Locale;
import java.util.Scanner;

import scales.*;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.print("Insert the °C temperature: ");
        double temperature = scan.nextDouble();

        Celsius c = new Celsius(temperature);
        System.out.println("°F: " + c.convertoToF());
        System.out.println("K: " + c.convertoToK());
    }
}