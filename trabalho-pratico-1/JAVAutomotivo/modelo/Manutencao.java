package modelo;

import java.util.ArrayList;
import java.lang.StringBuilder;

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

    public void setVeiculo(Veiculo novoVeiculo) {
        this.veiculo = novoVeiculo;
    }

    public ArrayList<Servico> getServicos() {
        return this.servicos;
    }

    public void setServicos(ArrayList<Servico> novosServicos) {
        this.servicos = novosServicos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(veiculo.toString() + "\n");
        sb.append("Servicos: [\n");
        for (Servico servico : servicos) {
            sb.append("  " + servico.toString() + "\n");
        }
        sb.append("]");
        return sb.toString();
    }

}
