import persistencia.*;
import visao.*;

public class Main {
    public static void main(String[] args) {
        Dados dados = new Dados();
        MenuInicial inicio = new MenuInicial(dados);
        inicio.menu();
    }
}
