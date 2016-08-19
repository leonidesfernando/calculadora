package com.github.leonidesfernando.calculadora;


import java.math.BigDecimal;

public enum Operacao {

    SOMAR(Constantes.COMANDO_SOMAR){

        @Override
        public BigDecimal efetuar(BigDecimal valor1, BigDecimal valor2) {

                return valor1.add(valor2);
        }

        @Override
        public boolean isValido(BigDecimal valor1, BigDecimal valor2) {
            return (valor1 != null && valor2 != null);
        }

        @Override
        public String getMensagemInvalido(final BigDecimal valor1, final BigDecimal valor2) {
            return String.format("Os valores não podem ser nulos para a soma, primeiro número(%f) segundo número(%f)", valor1, valor2);
        }
    }

    ;


    private final String comando;

    private Operacao(final String comando){
        this.comando = comando;
    }

    protected abstract BigDecimal efetuar(final BigDecimal valor1, final BigDecimal valor2);

    protected abstract boolean isValido(final BigDecimal valor1, final BigDecimal valor2);

    protected abstract String getMensagemInvalido(final BigDecimal valor1, final BigDecimal valor2);

    public void imprimeResultado(final BigDecimal valor1, final BigDecimal valor2){

        if(isValido(valor1, valor2)){
            final BigDecimal resultado =  efetuar(valor1, valor2);
            System.out.println();
            System.out.printf("Resultado: %.2f %s %.2f = %.2f", valor1, comando, valor2, resultado);
        }else {
            System.out.println();
            System.out.println(getMensagemInvalido(valor1, valor2));
        }
    }

}