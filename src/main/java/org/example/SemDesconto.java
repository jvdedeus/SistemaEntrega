package org.example;

public class SemDesconto implements Desconto {
    @Override
    public double aplicarDesconto(double valor) {
        return valor;
    }
}

