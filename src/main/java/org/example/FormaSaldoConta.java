package org.example;

public class FormaSaldoConta implements FormaPagamento{
    @Override
    public String tipoPagamento() {
        return "Pagamento feito por Saldo existente em Conta";
    }
}
