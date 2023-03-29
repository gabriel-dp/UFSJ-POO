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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.veiculo.toString() + "\n");
        sb.append("Servicos: [\n");
        for (Servico servico : this.servicos) {
            sb.append("  " + servico.toString() + "\n");
        }
        sb.append("]");
        return sb.toString();
    }

}
