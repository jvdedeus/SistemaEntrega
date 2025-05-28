package org.example;

public class PedidoEntregue extends PedidoEstado {

    private PedidoEntregue() {};
    private static PedidoEntregue instance = new PedidoEntregue();
    public static PedidoEntregue getInstance(){
        return instance;
    }

    @Override
    public String getEstado(){
        return "Seu pedido foi entregue";
    }

    @Override
    public String Processamento(Pedido pedido) {
        return pedido.getProcessoAtual().getEstado();
    }
}