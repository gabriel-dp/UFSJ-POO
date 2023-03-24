package visao;

import persistencia.*;
import visao.entidades.*;

public class MenuInicial extends Menu {

    private Dados dados;

    public MenuInicial(Dados dados) {
        super("Inicial", new String[] { "Sair", "Veículos", "Procedimentos", "Manutenções" });
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
                    new MenuVeiculos(dados.getVeiculos()).menu();
                    break;
                case 2:
                    new MenuProcedimentos(dados.getProcedimentos()).menu();
                    break;
                case 3:
                    new MenuManutencoes(dados.getManutencoes(), dados.getVeiculos(), dados.getProcedimentos()).menu();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }

}
