package org.example;

public class FormaCartaoCredito implements FormaPagamento{
    @Override
    public String tipoPagamento() {
        return "Pagamento feito por cartão de Crédito";
    }

    @Override
    public double getTaxa() {
        return 0.05;
    }
}
