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
    },
    SUBTRAIR(Constantes.COMANDO_SUBTRACAO){

        @Override
        protected BigDecimal efetuar(BigDecimal valor1, BigDecimal valor2) {
            return valor1.subtract(valor2);
        }

        @Override
        public boolean isValido(BigDecimal valor1, BigDecimal valor2) {
            return (valor1 != null && valor2 != null);
        }


        @Override
        protected String getMensagemInvalido(BigDecimal valor1, BigDecimal valor2) {
            return String.format("Os valores não podem ser nulos para a subtração, primeiro número(%f) segundo número(%f)", valor1, valor2);
        }
    },

    MULTIPLICAR(Constantes.COMANDO_MULTIPLICACAO){
        @Override
        protected BigDecimal efetuar(BigDecimal valor1, BigDecimal valor2) {
            return valor1.multiply(valor2);
        }

        @Override
        public boolean isValido(BigDecimal valor1, BigDecimal valor2) {
            return (valor1 != null && valor2 != null);
        }

        @Override
        protected String getMensagemInvalido(BigDecimal valor1, BigDecimal valor2) {
            return String.format("Os valores não podem ser nulos para a multiplicação, primeiro número(%f) segundo número(%f)", valor1, valor2);
        }
    },
    DIVIDIR(Constantes.COMANDO_DIVISAO){
        @Override
        protected BigDecimal efetuar(BigDecimal valor1, BigDecimal valor2) {
            return valor1.divide(valor2);
        }

        @Override
        public boolean isValido(BigDecimal valor1, BigDecimal valor2) {
            return (valor1 != null && valor2 != null && !BigDecimal.ZERO.equals(valor2));
        }

        @Override
        protected String getMensagemInvalido(BigDecimal valor1, BigDecimal valor2) {
            return String.format("Os valores não podem ser nulos ou o segundo número ser zero para a divisão, primeiro número(%f) segundo número(%f)", valor1, valor2);
        }
    },
    MODULO(Constantes.COMANDO_MODULO){
        @Override
        protected BigDecimal efetuar(BigDecimal valor1, BigDecimal valor2) {
            return valor1.remainder(valor2);
        }

        @Override
        public boolean isValido(BigDecimal valor1, BigDecimal valor2) {
            return (valor1 != null && valor2 != null && !BigDecimal.ZERO.equals(valor2));
        }

        @Override
        protected String getMensagemInvalido(BigDecimal valor1, BigDecimal valor2) {
            return String.format("Os valores não podem ser nulos ou o segundo número ser zero para a operação de módulo, primeiro número(%f) segundo número(%f)", valor1, valor2);
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
            System.out.printf("Resultado: %.2f %s %.2f = %.2f\n", valor1, comando, valor2, resultado);
        }else {
            System.out.println();
            System.out.println(getMensagemInvalido(valor1, valor2));
            System.out.println();
        }
    }

}