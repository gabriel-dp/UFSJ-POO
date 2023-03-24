import persistencia.*;
import visao.*;

public class Programa {
    public static void main(String[] args) {
        Dados dados = new Dados();
        MenuInicial inicio = new MenuInicial(dados);
        inicio.menu();
    }
}
