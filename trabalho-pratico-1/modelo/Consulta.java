package modelo;

import java.util.ArrayList;

public class Consulta extends Entidade {

    private Cliente cliente;
    private ArrayList<ProcessoRealizado> processos;

    public Consulta(Cliente cliente, ArrayList<ProcessoRealizado> processos) {
        super(1);
        this.cliente = cliente;
        this.processos = processos;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public ArrayList<ProcessoRealizado> getProcessos() {
        return this.processos;
    }

}
