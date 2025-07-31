package org.example;

public abstract class PedidoEstado {

    protected PedidoEstado proximoEstadoNaCadeia;

    public void setProximoEstadoNaCadeia(PedidoEstado proximo) {
        this.proximoEstadoNaCadeia = proximo;
    }

    public final String processar(Pedido pedido) {
        prepararPedido(pedido);
        processarPedido(pedido);
        transportarPedido(pedido);
        return finalizarPedido(pedido);
    }

    protected void prepararPedido(Pedido pedido) {}
    protected void processarPedido(Pedido pedido) {}
    protected void transportarPedido(Pedido pedido) {}
    protected String finalizarPedido(Pedido pedido) { return "Pedido entregue ou cancelado."; }

    public Boolean processar(){
        return false;
    }

    public Boolean preparar(){
        return false;
    }

    public Boolean transportar(){
        return false;
    }

    public Boolean entregue(){
        return false;
    }

    public PedidoEstado getProximoEstadoNaCadeia() {
        return proximoEstadoNaCadeia;
    }
}