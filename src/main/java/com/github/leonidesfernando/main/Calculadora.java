package com.github.leonidesfernando.main;


import com.github.leonidesfernando.calculadora.Menu;
import com.github.leonidesfernando.calculadora.Operacao;

import java.math.BigDecimal;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();

        menu.exibirMenu(scanner);

        String cmd = "somar";
        BigDecimal valor1 =null;
        BigDecimal valor2 = BigDecimal.TEN;


         Operacao.valueOf(cmd.toUpperCase()).imprimeResultado(valor1, valor2);

    }
}
