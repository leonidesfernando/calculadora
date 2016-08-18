package com.github.leonidesfernando.calculadora;


import java.math.BigDecimal;

public enum Operacao {

    SOMA(Constantes.COMANDO_SOMA){

        @Override
        public BigDecimal calcular(BigDecimal valor1, BigDecimal valor2) {
            if(valor1 != null && valor2 != null) {
                return valor1.add(valor2);
            }
            throw new IllegalStateException("valores nulos");
        }
    };


    private final String comando;

    private Operacao(final String comando){
        this.comando = comando;
    }

    public abstract BigDecimal calcular(final BigDecimal valor1, final BigDecimal valor2);

}