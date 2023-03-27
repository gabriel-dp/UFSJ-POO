package ex1;

public class Main {
    public static void main(String[] args) {
        Administrativo ad = new Administrativo("Gabriel de Paula", "gabriel.meira.2004@gmail.com", 222050003, 0, 240);
        Tecnico at = new Tecnico("Matheus Viana", "matheus.viana@ufsj.edu.br", 1, 1000);
        Assistente a = new Assistente("Douglas Dinali", "douglas@ufsj.edu.br", 2);
        Funcionario f = new Funcionario("Rafael Sachetto", "sachetto@ufsj.edu,br");

        ad.exibeDados();
        at.exibeDados();
        a.exibeDados();
        f.exibeDados();
    }
}
