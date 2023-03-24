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
                System.out.print("\nId do Procedimento: ");
                int idProcedimento = scan.nextInt();
                Procedimento procedimento = (Procedimento) procedimentos.buscaId(idProcedimento);

                System.out.print("Quantidade: ");
                int quantidade = scan.nextInt();

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
            System.out.print("\nId do veículo: ");
            int idVeiculo = scan.nextInt();

            return ((Veiculo) veiculos.buscaId(idVeiculo));
        } catch (IdException erroIdVeiculo) {
            System.out.println("Veículo não encontrado");
            return null;
        }
    }

    public void insereEntidade() {
        System.out.println("Adicionar Manutenção");

        System.out.print("Id: ");
        int idManutencao = scan.nextInt();
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

    public void alteraEntidade() {
        System.out.println("Alterar dados da Manutenção");

        System.out.print("Id: ");
        int id = scan.nextInt();

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

    public void removeEntidade() {
        System.out.println("Remover Manutenção");

        System.out.print("Id: ");
        int id = scan.nextInt();

        try {
            Entidade manutencao = manutencoes.buscaId(id);
            manutencoes.remove(manutencao);
            System.out.println("\nManutenção deletada com sucesso");
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    public void buscaIdEntidade() {
        System.out.println("Busca por Id");

        System.out.print("Id: ");
        int id = scan.nextInt();

        try {
            Entidade manutencao = manutencoes.buscaId(id);
            System.out.println(manutencao.toString());
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    public void verTodosEntidade() {
        System.out.println("Todos as Manutenções = " + this.manutencoes.getEntidades().size());

        for (Entidade procedimento : this.manutencoes.getEntidades()) {
            System.out.printf("%d { %s }\n", procedimento.getId(), procedimento.toString());
        }
    }

}
