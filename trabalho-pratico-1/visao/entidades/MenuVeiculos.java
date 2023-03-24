package visao.entidades;

import modelo.*;
import persistencia.*;

public class MenuVeiculos extends MenuEntidade {

    private Persistente veiculos;

    public MenuVeiculos(Persistente veiculos) {
        super("Veículo");
        this.veiculos = veiculos;
    }

    public void insereEntidade() {
        System.out.println("Adicionar veículo");

        System.out.print("Id: ");
        int id = scan.nextInt();
        scan.nextLine();

        try {
            veiculos.buscaId(id);
            System.out.println("\nId já existente");
        } catch (IdException e) {
            System.out.print("Modelo: ");
            String modelo = scan.nextLine();
            System.out.print("Placa: ");
            String placa = scan.nextLine();
            System.out.print("Nome do Cliente: ");
            String nomeCliente = scan.nextLine();

            Veiculo novoVeiculo = new Veiculo(id, modelo, placa, nomeCliente);
            this.veiculos.insere(novoVeiculo);
            System.out.println("\nVeículo adicionado com sucesso");
        }
    }

    public void alteraEntidade() {
        System.out.println("Alterar dados do veículo");

        System.out.print("Id: ");
        int id = scan.nextInt();
        scan.nextLine();

        try {
            Entidade antigoVeiculo = veiculos.buscaId(id);

            System.out.print("Modelo: ");
            String modelo = scan.next();
            System.out.print("Placa: ");
            String placa = scan.next();
            System.out.print("Nome do Cliente: ");
            String nomeCliente = scan.next();

            Veiculo novoVeiculo = new Veiculo(id, modelo, placa, nomeCliente);
            veiculos.altera(antigoVeiculo, novoVeiculo);

            System.out.println("\nVeículo alterado com sucesso");
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    public void removeEntidade() {
        System.out.println("Remover veículo");

        System.out.print("Id: ");
        int id = scan.nextInt();

        try {
            Entidade veiculo = veiculos.buscaId(id);
            veiculos.remove(veiculo);
            System.out.println("\nVeículo deletado com sucesso");
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    public void buscaIdEntidade() {
        System.out.println("Busca por Id");

        System.out.print("Id: ");
        int id = scan.nextInt();

        try {
            Entidade veiculo = veiculos.buscaId(id);
            System.out.println(veiculo.toString());
        } catch (IdException e) {
            System.out.println("\nId não encontrado");
        }
    }

    public void verTodosEntidade() {
        System.out.println("Todos os Veículos = " + this.veiculos.getEntidades().size());

        for (Entidade veiculo : this.veiculos.getEntidades()) {
            System.out.printf("%d { %s }\n", veiculo.getId(), veiculo.toString());
        }
    }

}
