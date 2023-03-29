/*
 *  Trabalho Prático 1 - Programação Orientada a Objetos
 *  Estudantes - [ Gabriel de Paula Meira ]
 *  Professor - Matheus Viana
 */

import persistencia.*;
import visao.*;

public class Programa {
    public static void main(String[] args) {
        Dados dados = new Dados();
        MenuInicial inicio = new MenuInicial(dados);
        inicio.menu();
    }
}
