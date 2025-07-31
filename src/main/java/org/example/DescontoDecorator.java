package org.example;

public abstract class DescontoDecorator implements Desconto {
    protected Desconto desconto;

    public DescontoDecorator(Desconto desconto) {
        this.desconto = desconto;
    }
}

