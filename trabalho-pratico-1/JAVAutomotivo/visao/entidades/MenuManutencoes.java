package visao.entidades;

import modelo.*;
import persistencia.*;
import java.util.ArrayList;

public class MenuManutencoes extends MenuEntidade {

    private Persistente manutencoes;
    private Persistente veiculos;
    private Persistente procedimentos;

    public MenuManutencoes(Persistente manutencoes, Persistente veiculos, Persistente procedimentos) {
        super("Manutenções");
        this.manutencoes = manutencoes;
        this.veiculos = veiculos;
        this.procedimentos = procedimentos;
    }

    private ArrayList<Servico> criaServicos() {
        ArrayList<Servico> novosServicos = new ArrayList<Servico>();

        do {
            try {
                int idProcedimento = this.getId();
                Procedimento procedimento = (Procedimento) procedimentos.buscaId(idProcedimento);

                System.out.print("Quantidade: ");
                int quantidade = this.getInteger();

                novosServicos.add(new Servico(procedimento, quantidade));
            } catch (IdException erroIdProcedimento) {
                System.out.println("Procedimento não encontrado");
                break;
            }
        } while (true);

        return novosServicos;
    }

    private Veiculo recebeVeiculo() {
        try {
            int idVeiculo = this.getId();

            return ((Veiculo) veiculos.buscaId(idVeiculo));
        } catch (IdException erroIdVeiculo) {
            System.out.println("Veículo não encontrado");
            return null;
        }
    }

    protected void insereEntidade() {
        System.out.println("Adicionar Manutenção");

        int idManutencao = this.getId();
        try {
            manutencoes.buscaId(idManutencao);
            System.out.println("\nId já existente");
        } catch (IdException erroIdManutencao) {
            Veiculo veiculo = recebeVeiculo();
            if (veiculo == null)
                return;
            ArrayList<Servico> servicos = this.criaServicos();
            if (servicos.size() == 0)
                return;

            Manutencao novoManutencao = new Manutencao(idManutencao, veiculo, servicos);
            this.manutencoes.insere(novoManutencao);
            System.out.println("\nManutenção adicionada com sucesso");
        }
    }

    protected void alteraEntidade() {
        System.out.println("Alterar dados da Manutenção");

        int id = this.getId();
        try {
            Entidade antigaManutencao = manutencoes.buscaId(id);

            Veiculo novoVeiculo = recebeVeiculo();
            if (novoVeiculo == null)
                return;
            ArrayList<Servico> novosServicos = this.criaServicos();
            if (novosServicos.size() == 0)
                return;

            Manutencao novaManutencao = new Manutencao(id, novoVeiculo, novosServicos);
            manutencoes.altera(antigaManutencao, novaManutencao);

            System.out.println("\nManutenção alterada com sucesso");
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    protected void removeEntidade() {
        System.out.println("Remover Manutenção");

        int id = this.getId();
        try {
            Entidade manutencao = manutencoes.buscaId(id);
            manutencoes.remove(manutencao);
            System.out.println("\nManutenção deletada com sucesso");
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    protected void buscaIdEntidade() {
        System.out.println("Busca por Id");

        int id = this.getId();
        try {
            Entidade manutencao = manutencoes.buscaId(id);
            System.out.println(manutencao.toString());
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    protected void verTodosEntidade() {
        System.out.print(this.manutencoes.toString());
    }

}
