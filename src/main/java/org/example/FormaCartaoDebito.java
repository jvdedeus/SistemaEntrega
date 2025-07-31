package org.example;

public class FormaCartaoDebito implements FormaPagamento{
    @Override
    public String tipoPagamento() {
        return "Pagamento feito por cartão de Débito";
    }

    @Override
    public double getTaxa() {
        return 0.02;
    }
}
