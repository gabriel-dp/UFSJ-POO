package ex1;

public class Assistente extends Funcionario {

    private int matricula;

    public Assistente() {
        super();
        this.matricula = 0;
    }

    public Assistente(String nome, String email, int matricula) {
        super(nome, email);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int novaMatricula) {
        this.matricula = novaMatricula;
    }

    @Override
    public void exibeDados() {
        System.out.println(String.format("Nome = %s | Email = %s | Matrícula = %d", this.getNome(), this.getEmail(),
                this.getMatricula()));
    }

}
