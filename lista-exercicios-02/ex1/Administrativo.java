package ex1;

public class Administrativo extends Assistente {

    private int turno;
    private double adicional;

    private enum Turno {
        dia, noite
    };

    public Administrativo() {
        super();
        this.adicional = 0;
    }

    public Administrativo(String nome, String email, int matricula, int turno, double adicional) {
        super(nome, email, matricula);
        this.turno = turno;
        this.adicional = adicional;
    }

    public int getTurno() {
        return this.turno;
    }

    public void setTurno(int novoTurno) {
        this.turno = novoTurno;
    }

    public double getAdicional() {
        return this.adicional;
    }

    public void setAdicional(double novoAdicional) {
        this.adicional = novoAdicional;
    }

    @Override
    public void exibeDados() {
        System.out.println(String.format("Nome = %s | Email = %s | Matrícula = %d | Turno = %s | Adicional = %.2f",
                this.getNome(), this.getEmail(), this.getMatricula(), Turno.values()[this.getTurno()],
                this.getAdicional()));
    }

}
