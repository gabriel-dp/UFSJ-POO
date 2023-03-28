package persistencia;

import modelo.*;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Persistente {

    private ArrayList<Entidade> entidades;

    public Persistente() {
        this.entidades = new ArrayList<Entidade>();
    }

    public void insere(Entidade entidade) {
        this.entidades.add(entidade);
    }

    public void altera(Entidade antiga, Entidade nova) {
        int index = this.entidades.indexOf(antiga);
        this.entidades.set(index, nova);
    }

    public void remove(Entidade entidade) {
        this.entidades.remove(entidade);
    }

    public Entidade buscaId(int id) throws IdException {
        for (Entidade entidade : this.entidades) {
            if (entidade.getId() == id) {
                return entidade;
            }
        }
        throw new IdException(id);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Total = %d\n", this.entidades.size()));
        for (Entidade entidade : this.entidades) {
            sb.append(String.format("%d { %s }\n", entidade.getId(), entidade.toString()));
        }
        return sb.toString();
    }

}
