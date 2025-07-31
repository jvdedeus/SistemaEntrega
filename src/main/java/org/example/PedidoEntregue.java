package org.example;

public class PedidoEntregue extends PedidoEstado {
    private PedidoEntregue() {}
    private static PedidoEntregue instance = new PedidoEntregue();
    public static PedidoEntregue getInstance() {
        return instance;
    }
    @Override
    protected String finalizarPedido(Pedido pedido) {
        pedido.setMensagem("Pedido entregue ao cliente.");
        return pedido.getMensagem();
    }
}