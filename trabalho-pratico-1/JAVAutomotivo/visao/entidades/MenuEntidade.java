package visao.entidades;

import visao.*;

import java.util.InputMismatchException;

public abstract class MenuEntidade extends Menu {

    public MenuEntidade(String titulo) {
        super(titulo, new String[] { "Voltar", "Inserir", "Alterar", "Apagar", "Buscar Id", "Ver todos" });
    }

    protected int getId() {
        int id;
        do {
            try {
                System.out.print("Id: ");
                id = this.scan.nextInt();
                scan.nextLine();
                return id;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Id inválido - tente novamente");
            }
        } while (true);
    }

    abstract protected void insereEntidade();

    abstract protected void alteraEntidade();

    abstract protected void removeEntidade();

    abstract protected void buscaIdEntidade();

    abstract protected void verTodosEntidade();

    public void menu() {
        int opcao;
        do {
            opcao = super.getOpcao();
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
