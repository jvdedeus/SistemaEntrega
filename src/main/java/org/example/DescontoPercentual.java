package org.example;

public class DescontoPercentual extends DescontoDecorator {
    private double percentual;

    public DescontoPercentual(Desconto desconto, double percentual) {
        super(desconto);
        this.percentual = percentual;
    }

    @Override
    public double aplicarDesconto(double valor) {
        double valorComDesconto = desconto.aplicarDesconto(valor);
        return valorComDesconto * (1 - percentual);
    }
}

