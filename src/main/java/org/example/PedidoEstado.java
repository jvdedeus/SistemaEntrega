package org.example;

public abstract class PedidoEstado {

    public PedidoEstado proximoEstadoNaCadeia;

    public abstract String getEstado();

    public void setProximoEstadoNaCadeia(PedidoEstado proximoEstado) {
        this.proximoEstadoNaCadeia = proximoEstado;
    }

    public String Processamento(Pedido pedido) {
        if (proximoEstadoNaCadeia != null) {
            return proximoEstadoNaCadeia.Processamento(pedido);
        }
        return "Não existe próximo processo";
    }

    public String processar(Pedido pedido){
        return Processamento(pedido);
    }

    public String preparar(Pedido pedido){
        return Processamento(pedido);
    }

    public String transportar(Pedido pedido){
        return Processamento(pedido);
    }

    public String entregue(Pedido pedido){
        return Processamento(pedido);
    }
}