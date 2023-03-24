package modelo;

import java.util.ArrayList;

public class Manutencao extends Entidade {

    private Veiculo veiculo;
    private ArrayList<Servico> servicos;

    public Manutencao(int id, Veiculo veiculo, ArrayList<Servico> servicos) {
        super(id);
        this.veiculo = veiculo;
        this.servicos = servicos;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public ArrayList<Servico> getServicos() {
        return this.servicos;
    }

}
