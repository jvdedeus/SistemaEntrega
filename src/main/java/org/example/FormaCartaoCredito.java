package org.example;

public class FormaCartaoCredito implements FormaPagamento{
    @Override
    public String tipoPagamento() {
        return "Pagamento feito por cartão de Crédito";
    }
}
