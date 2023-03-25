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
                System.out.print("Procedimento ");
                int idProcedimento = this.getId();
                Procedimento procedimento = (Procedimento) this.procedimentos.buscaId(idProcedimento);

                System.out.print("Quantidade: ");
                int quantidade = this.getInteger();

                novosServicos.add(new Servico(procedimento, quantidade));
            } catch (IdException erro) {
                System.out.println(erro.getMessage());
                break;
            }
        } while (true);

        return novosServicos;
    }

    private Veiculo getVeiculo() {
        try {
            System.out.print("Veículo ");
            int idVeiculo = this.getId();
            return ((Veiculo) this.veiculos.buscaId(idVeiculo));
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
            return null;
        }
    }

    protected void insereEntidade() {
        System.out.println("Adicionar Manutenção");

        int idManutencao = this.getId();
        try {
            this.manutencoes.buscaId(idManutencao);
            System.out.println("\nId já existente");
        } catch (IdException _erro) {
            Veiculo veiculo = this.getVeiculo();
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
            Entidade antigaManutencao = this.manutencoes.buscaId(id);

            Veiculo novoVeiculo = this.getVeiculo();
            if (novoVeiculo == null)
                return;
            ArrayList<Servico> novosServicos = this.criaServicos();
            if (novosServicos.size() == 0)
                return;

            Manutencao novaManutencao = new Manutencao(id, novoVeiculo, novosServicos);
            this.manutencoes.altera(antigaManutencao, novaManutencao);

            System.out.println("\nManutenção alterada com sucesso");
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void removeEntidade() {
        System.out.println("Remover Manutenção");

        int id = this.getId();
        try {
            Entidade manutencao = this.manutencoes.buscaId(id);
            this.manutencoes.remove(manutencao);
            System.out.println("\nManutenção deletada com sucesso");
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void buscaIdEntidade() {
        System.out.println("Busca por Id");

        int id = this.getId();
        try {
            Entidade manutencao = this.manutencoes.buscaId(id);
            System.out.println(manutencao.toString());
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void verTodosEntidade() {
        System.out.print(this.manutencoes.toString());
    }

}
