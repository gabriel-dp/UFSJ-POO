package ex1;

public class Funcionario {

    private String nome, email;

    public Funcionario() {
        this.nome = "";
        this.email = "";
    }

    public Funcionario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public void exibeDados() {
        System.out.println(String.format("Nome = %s | Email = %s", this.getNome(), this.getEmail()));
    }

}