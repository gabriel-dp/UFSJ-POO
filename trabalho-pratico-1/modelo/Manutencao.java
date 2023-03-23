package modelo;

import java.util.ArrayList;

public class Manutencao extends Entidade {

    private Veiculo cliente;
    private ArrayList<Servico> servicos;

    public Manutencao(Veiculo cliente, ArrayList<Servico> servicos) {
        super(1);
        this.cliente = cliente;
        this.servicos = servicos;
    }

    public Veiculo getCliente() {
        return this.cliente;
    }

    public ArrayList<Servico> getServicos() {
        return this.servicos;
    }

}
