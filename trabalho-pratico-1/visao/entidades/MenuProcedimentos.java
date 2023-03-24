package visao.entidades;

import modelo.*;
import persistencia.*;

public class MenuProcedimentos extends MenuEntidade {

    private Persistente procedimentos;

    public MenuProcedimentos(Persistente procedimentos) {
        super("Procedimentos");
        this.procedimentos = procedimentos;
    }

    public void insereEntidade() {
        System.out.println("Adicionar procedimento");

        System.out.print("Id: ");
        int id = scan.nextInt();

        try {
            procedimentos.buscaId(id);
            System.out.println("\nId já existente");
        } catch (IdException e) {
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("Valor: ");
            Double valor = scan.nextDouble();

            Procedimento novoProcedimento = new Procedimento(id, nome, valor);
            this.procedimentos.insere(novoProcedimento);
            System.out.println("\nProcedimento adicionado com sucesso");
        }
    }

    public void alteraEntidade() {
        System.out.println("Alterar dados do procedimento");

        System.out.print("Id: ");
        int id = scan.nextInt();

        try {
            Entidade antigoProcedimento = procedimentos.buscaId(id);

            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("Valor: ");
            Double valor = scan.nextDouble();

            Procedimento novoProcedimento = new Procedimento(id, nome, valor);
            procedimentos.altera(antigoProcedimento, novoProcedimento);

            System.out.println("\nProcedimento alterado com sucesso");
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    public void removeEntidade() {
        System.out.println("Remover procedimento");

        System.out.print("Id: ");
        int id = scan.nextInt();
        scan.nextLine();

        try {
            Entidade procedimento = procedimentos.buscaId(id);
            procedimentos.remove(procedimento);
            System.out.println("\nProcedimento deletado com sucesso");
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    public void buscaIdEntidade() {
        System.out.println("Busca por Id");

        System.out.print("Id: ");
        int id = scan.nextInt();
        scan.nextLine();

        try {
            Entidade procedimento = procedimentos.buscaId(id);
            System.out.println(procedimento.toString());
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    public void verTodosEntidade() {
        System.out.println("Todos os Procedimentos = " + this.procedimentos.getEntidades().size());

        for (Entidade procedimento : this.procedimentos.getEntidades()) {
            System.out.printf("%d { %s }\n", procedimento.getId(), procedimento.toString());
        }
    }

}
