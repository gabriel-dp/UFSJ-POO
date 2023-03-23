package persistencia;

public class Dados {
    private Persistente clientes;
    private Persistente processos;
    private Persistente consultas;

    public Dados() {
        this.clientes = new Persistente();
        this.processos = new Persistente();
        this.consultas = new Persistente();
    }

    public Persistente getClientes() {
        return this.clientes;
    }

    public Persistente getProcessos() {
        return this.processos;
    }

    public Persistente getConsultas() {
        return this.consultas;
    }
}
