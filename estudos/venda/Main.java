import venda.*;

import java.util.ArrayList;
import java.util.Scanner;

import venda.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Menu menu = new Menu(produtos, scan);
        menu.runMenu();

        scan.close();
    }
}