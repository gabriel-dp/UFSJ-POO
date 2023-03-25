package visao.entidades;

import modelo.*;
import persistencia.*;

public class MenuProcedimentos extends MenuEntidade {

    private Persistente procedimentos;

    public MenuProcedimentos(Persistente procedimentos) {
        super("Procedimentos");
        this.procedimentos = procedimentos;
    }

    protected void insereEntidade() {
        System.out.println("Adicionar procedimento");

        int id = this.getId();
        try {
            procedimentos.buscaId(id);
            System.out.println("\nId já existente");
        } catch (IdException e) {
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("Valor: ");
            Double valor = this.getDouble();

            Procedimento novoProcedimento = new Procedimento(id, nome, valor);
            this.procedimentos.insere(novoProcedimento);
            System.out.println("\nProcedimento adicionado com sucesso");
        }
    }

    protected void alteraEntidade() {
        System.out.println("Alterar dados do procedimento");

        int id = this.getId();
        try {
            Entidade antigoProcedimento = procedimentos.buscaId(id);

            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("Valor: ");
            Double valor = this.getDouble();

            Procedimento novoProcedimento = new Procedimento(id, nome, valor);
            procedimentos.altera(antigoProcedimento, novoProcedimento);

            System.out.println("\nProcedimento alterado com sucesso");
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    protected void removeEntidade() {
        System.out.println("Remover procedimento");

        int id = this.getId();
        try {
            Entidade procedimento = procedimentos.buscaId(id);
            procedimentos.remove(procedimento);
            System.out.println("\nProcedimento deletado com sucesso");
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    protected void buscaIdEntidade() {
        System.out.println("Busca por Id");

        int id = this.getId();
        try {
            Entidade procedimento = procedimentos.buscaId(id);
            System.out.println(procedimento.toString());
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    protected void verTodosEntidade() {
        System.out.println(this.procedimentos.toString());
    }

}
