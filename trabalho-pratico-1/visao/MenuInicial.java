package visao;

import persistencia.*;

public class MenuInicial extends Menu {

    private Dados dados;

    public MenuInicial(Dados dados) {
        super("Inicial", new String[] { "Sair", "Veiculo", "Procedimento", "Servico" });
        this.dados = dados;
    }

    public void menu() {
        int opcao;
        do {
            opcao = this.getOpcao();
            switch (opcao) {
                case 0:
                    System.out.println("Programa encerrado");
                    break;
                case 1:
                    new MenuEntidade(dados.getVeiculos()).menu();
                    break;
                case 2:
                    new MenuEntidade(dados.getProcedimentos()).menu();
                    break;
                case 3:
                    new MenuEntidade(dados.getServicos()).menu();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }

}
