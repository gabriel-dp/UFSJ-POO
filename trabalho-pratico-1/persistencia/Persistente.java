package persistencia;

import modelo.*;
import java.util.ArrayList;

public class Persistente {

    private ArrayList<Entidade> entidades;

    public Persistente() {
        this.entidades = new ArrayList<Entidade>();
    }

    public void insere(Entidade entidade) {
        this.entidades.add(entidade);
    }

    public void remove(Entidade entidade) {
        this.entidades.remove(entidade);
    }

    public void substitui(Entidade antiga, Entidade nova) {
        int index = this.entidades.indexOf(antiga);
        this.entidades.set(index, nova);
    }

    public Entidade buscaId(int id) throws IdException {
        for (Entidade entidade : this.entidades) {
            if (entidade.getId() == id) {
                return entidade;
            }
        }
        throw new IdException(id);
    }
}
