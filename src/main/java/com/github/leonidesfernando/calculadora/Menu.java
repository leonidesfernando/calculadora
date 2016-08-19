package com.github.leonidesfernando.calculadora;


import java.util.Scanner;

public class Menu {

    private int opcao;
    public void exibirMenu(final Scanner scanner){

        System.out.println("\n#--------------------------------------------------------------------------------#");
        System.out.println("#------------------------------- Menu de Opções ---------------------------------#");

        System.out.println("(0) - Sair  | (somar [1]) - Somar 2 números | (subtrair - [2]) - Subtrair 2 números | (multiplicar - [3]) - Multiplicar 2 números | (dividir - [4]) - Dividir 2 números ");
        System.out.print("Informe um número ou o nome da operação: ");

        opcao = scanner.nextInt();

        while(opcao < 0 || opcao > 4){

            System.out.print("\nOpção inválida, por favor informe um número de 0(zero) a 2: ");
            opcao = scanner.nextInt();
        }
        scanner.nextLine();
    }

    public int getOpcao() {
        return opcao;
    }
}
