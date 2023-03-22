package ex3;

public class UsaBanco {

    public static void main(String[] args) {
        Banco bradesco = new Banco();
        BancoInterface bancointerface = new BancoInterface(bradesco);
        bancointerface.menu();
    }
}
