package visao.entidades;

import modelo.*;
import persistencia.*;

public class MenuProcedimentos extends MenuEntidade {

    private Persistente procedimentos;

    public MenuProcedimentos(Persistente procedimentos) {
        super("Procedimentos");
        this.procedimentos = procedimentos;
    }

    private Procedimento getProcedimento(int id) {
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Valor: ");
        Double valor = this.getDouble();

        return new Procedimento(id, nome, valor);
    }

    protected void insereEntidade() {
        System.out.println("Adicionar procedimento");

        int id = this.getId();
        try {
            procedimentos.buscaId(id);
            System.out.println("\nId já existente");
        } catch (IdException _e) {
            Procedimento novoProcedimento = getProcedimento(id);
            this.procedimentos.insere(novoProcedimento);
            System.out.println("\nProcedimento adicionado com sucesso");
        }
    }

    protected void alteraEntidade() {
        System.out.println("Alterar dados do procedimento");

        int id = this.getId();
        try {
            Entidade antigoProcedimento = procedimentos.buscaId(id);
            Procedimento novoProcedimento = getProcedimento(id);
            procedimentos.altera(antigoProcedimento, novoProcedimento);
            System.out.println("\nProcedimento alterado com sucesso");
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void removeEntidade() {
        System.out.println("Remover procedimento");

        int id = this.getId();
        try {
            Entidade procedimento = procedimentos.buscaId(id);
            procedimentos.remove(procedimento);
            System.out.println("\nProcedimento deletado com sucesso");
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void buscaIdEntidade() {
        System.out.println("Busca por Id");

        int id = this.getId();
        try {
            Entidade procedimento = procedimentos.buscaId(id);
            System.out.println(procedimento.toString());
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void verTodosEntidade() {
        System.out.println(this.procedimentos.toString());
    }

}
