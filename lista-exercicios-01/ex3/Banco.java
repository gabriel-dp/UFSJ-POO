package ex3;

import ex2.*;

import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<Conta>();
    }

    public void adicionaConta(Conta novaConta) {
        this.contas.add(novaConta);
    }

    public Conta getConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero)
                return conta;
        }
        return null;
    }

}
