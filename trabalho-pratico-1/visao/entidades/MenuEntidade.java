package visao.entidades;

import visao.*;
import java.util.Scanner;

public abstract class MenuEntidade extends Menu {

    Scanner scan = new Scanner(System.in);

    public MenuEntidade(String titulo) {
        super(titulo, new String[] { "Voltar", "Inserir", "Alterar", "Apagar", "Buscar Id", "Ver todos" });
    }

    abstract public void insereEntidade();

    abstract public void alteraEntidade();

    abstract public void removeEntidade();

    abstract public void buscaIdEntidade();

    abstract public void verTodosEntidade();

    public void menu() {
        int opcao;
        do {
            opcao = this.getOpcao();
            switch (opcao) {
                case 0:
                    System.out.println("Saiu da edição da entidade");
                    break;
                case 1:
                    this.insereEntidade();
                    break;
                case 2:
                    this.alteraEntidade();
                    break;
                case 3:
                    this.removeEntidade();
                    break;
                case 4:
                    this.buscaIdEntidade();
                    break;
                case 5:
                    this.verTodosEntidade();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }
}
