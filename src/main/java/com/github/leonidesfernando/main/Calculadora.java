package com.github.leonidesfernando.main;


import com.github.leonidesfernando.calculadora.Menu;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();

        do{
            menu.exibirMenu(scanner);
            if(!menu.isSair()){
                menu.getOperacao().imprimeResultado(menu.getValor1(), menu.getValor2());
            }

        }while (!menu.isSair());

        scanner.close();
    }
}
