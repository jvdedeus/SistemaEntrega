package org.example;

public class FormaPix implements FormaPagamento{
    @Override
    public String tipoPagamento() {
        return "Pagamento feito por Pix";
    }

    @Override
    public double getTaxa() {
        return 0.01;
    }
}
