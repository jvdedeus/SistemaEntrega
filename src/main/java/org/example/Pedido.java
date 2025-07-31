package org.example;

import java.util.Observable;

public class Pedido extends Observable {
    private PedidoEstado processoAtual;
    private Usuario usuario;
    private FormaPagamento formaPagamento;
    private String mensagem;
    private double valorTotal;
    private Desconto desconto;

    private Pedido(Builder builder) {
        this.usuario = builder.usuario;
        this.formaPagamento = builder.formaPagamento;
        this.valorTotal = builder.valorTotal;
        this.mensagem = builder.mensagem;
        this.desconto = builder.desconto;
        this.processoAtual = PedidoEmProcesso.getInstance();
    }

    public static class Builder {
        private Usuario usuario;
        private FormaPagamento formaPagamento;
        private double valorTotal;
        private String mensagem;
        private Desconto desconto;

        public Builder setUsuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }
        public Builder setFormaPagamento(FormaPagamento formaPagamento) {
            this.formaPagamento = formaPagamento;
            return this;
        }
        public Builder setValorTotal(double valorTotal) {
            this.valorTotal = valorTotal;
            return this;
        }
        public Builder setMensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }
        public Builder setDesconto(Desconto desconto) {
            this.desconto = desconto;
            return this;
        }
        public Pedido build() {
            return new Pedido(this);
        }
    }

    public PedidoEstado getProcessoAtual() {

        return processoAtual;
    }

    public void setProcessoAtual(PedidoEstado processoAtual) {

        this.processoAtual = processoAtual;
    }

    public void updateEstado(){
        setChanged();
        notifyObservers();
    }

    public double pagamento(double valorTotal){

        return valorTotal * formaPagamento.getTaxa();
    }

    public String getMensagem() {

        return mensagem;
    }

    public void setMensagem(String mensagem) {

        this.mensagem = mensagem;
    }

    @Override
    public String toString() {

        return mensagem;
    }
    public Usuario getUsuario() {

        return usuario;
    }

    public FormaPagamento getFormaPagamento() {

        return formaPagamento;
    }

    public double getValorTotal() {

        return valorTotal;
    }

    public Desconto getDesconto() {
        return desconto;
    }

    public double calcularValor(FormaPagamento formaPagamento) {
        double valorComDesconto;
        if (desconto != null) {
            valorComDesconto = desconto.aplicarDesconto(valorTotal);
        } else {
            valorComDesconto = valorTotal;
        }
        return valorComDesconto + (valorComDesconto * formaPagamento.getTaxa());
    }
}