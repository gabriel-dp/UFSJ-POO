package visao;

import persistencia.*;

public class MenuEntidade extends Menu {
    private Persistente entidadePersistente;

    public MenuEntidade(Persistente entidadePersistente) {
        super("Entidade", new String[] { "Voltar", "Inserir", "Alterar", "Apagar", "Consultar Id", "Ver todos" });
        this.entidadePersistente = entidadePersistente;
    }

    public void menu() {
        int opcao;
        do {
            opcao = this.getOpcao();
            switch (opcao) {
                case 0:
                    System.out.println("Saiu da edição da entidade");
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }
}
