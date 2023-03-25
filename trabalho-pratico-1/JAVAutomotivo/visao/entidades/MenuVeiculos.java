package visao.entidades;

import modelo.*;
import persistencia.*;

public class MenuVeiculos extends MenuEntidade {

    private Persistente veiculos;

    public MenuVeiculos(Persistente veiculos) {
        super("Veículo");
        this.veiculos = veiculos;
    }

    private Veiculo getVeiculo(int id) {
        System.out.print("Modelo: ");
        String modelo = scan.nextLine();
        System.out.print("Placa: ");
        String placa = scan.nextLine();
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scan.nextLine();

        return new Veiculo(id, modelo, placa, nomeCliente);
    }

    protected void insereEntidade() {
        System.out.println("Adicionar veículo");

        int id = this.getId();
        try {
            veiculos.buscaId(id);
            System.out.println("\nId já existente");
        } catch (IdException _erro) {
            Veiculo novoVeiculo = this.getVeiculo(id);
            this.veiculos.insere(novoVeiculo);
            System.out.println("\nVeículo adicionado com sucesso");
        }
    }

    protected void alteraEntidade() {
        System.out.println("Alterar dados do veículo");

        int id = this.getId();
        try {
            Entidade antigoVeiculo = this.veiculos.buscaId(id);
            Veiculo novoVeiculo = this.getVeiculo(id);
            this.veiculos.altera(antigoVeiculo, novoVeiculo);
            System.out.println("\nVeículo alterado com sucesso");
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void removeEntidade() {
        System.out.println("Remover veículo");

        int id = this.getId();
        try {
            Entidade veiculo = this.veiculos.buscaId(id);
            this.veiculos.remove(veiculo);
            System.out.println("\nVeículo deletado com sucesso");
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void buscaIdEntidade() {
        System.out.println("Busca por Id");

        int id = this.getId();
        try {
            Entidade veiculo = this.veiculos.buscaId(id);

            System.out.println(veiculo.toString());
        } catch (IdException erro) {
            System.out.println(erro.getMessage());
        }
    }

    protected void verTodosEntidade() {
        System.out.println(this.veiculos.toString());
    }

}
