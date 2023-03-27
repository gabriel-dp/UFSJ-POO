package ex1;

public class Tecnico extends Assistente {

    private double bonus;

    public Tecnico() {
        super();
        this.bonus = 0;
    }

    public Tecnico(String nome, String email, int matricula, double bonus) {
        super(nome, email, matricula);
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double novoBonus) {
        this.bonus = novoBonus;
    }

    @Override
    public void exibeDados() {
        System.out.println(String.format("Nome = %s | Email = %s | Matrícula = %d | Bônus Salarial = %.2f",
                this.getNome(), this.getEmail(), this.getMatricula(), this.getBonus()));
    }

}
