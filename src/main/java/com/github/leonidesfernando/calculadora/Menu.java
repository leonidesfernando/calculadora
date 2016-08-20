package com.github.leonidesfernando.calculadora;


import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    private Operacao operacao;
    private BigDecimal valor1;
    private BigDecimal valor2;

    private final static String COMANDOS_MSG = "(0) - Sair  | (somar) - Somar 2 números | (subtrair) - Subtrair 2 números | (multiplicar) - Multiplicar 2 números | (dividir) - Dividir 2 números |(modulo) - Resto da divisão de 2 números";

    public void exibirMenu(final Scanner scanner){

        System.out.println("\n#--------------------------------------------------------------------------------#");
        System.out.println("#------------------------------- Menu de Opções ---------------------------------#");

        System.out.println(COMANDOS_MSG);

        operacao = getOperacao(scanner);
        if(!isSair()){
            valor1 = getNumero(scanner, "primeiro");
            valor2 = getNumero(scanner, "segundo");
        }
    }

    private BigDecimal getNumero(final Scanner scanner, String numero){

        BigDecimal valor = null;
        do {
            try {
                System.out.printf("\nInforme o %s número: ", numero);
                valor = scanner.nextBigDecimal();
                return valor;
            }catch (Exception e){
                valor = null;
            }

        }while (valor == null);
        return  null;
    }

    private Operacao getOperacao(final Scanner scanner) {

        String comando = "";
        do {
            System.out.print("Informe o nome da operação: ");
            comando = scanner.nextLine();
            try {
                return Operacao.valueOf(comando.toUpperCase());
            } catch (Exception ee) {
                if("0".equals(comando) || "sair".equalsIgnoreCase(comando)){
                    return null;
                }
                comando = "";
                System.out.println("\nOpção inválida, por favor informe um comando válido: " + COMANDOS_MSG);
            }
        }while ("".equals(comando));
        return null;
    }

    public BigDecimal getValor1() {
        return valor1;
    }

    public BigDecimal getValor2() {
        return valor2;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public boolean isSair(){
        return operacao == null;
    }
}
