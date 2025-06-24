package org.example;

public class FormaPix implements FormaPagamento{
    @Override
    public String tipoPagamento() {
        return "Pagamento feito por Pix";
    }
}
