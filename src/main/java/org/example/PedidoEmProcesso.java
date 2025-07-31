package org.example;

public class PedidoEmProcesso extends PedidoEstado {
    private PedidoEmProcesso() {}
    private static PedidoEmProcesso instance = new PedidoEmProcesso();
    public static PedidoEmProcesso getInstance() {
        return instance;
    }

    @Override
    protected void prepararPedido(Pedido pedido) {
        pedido.setMensagem("Restaurante aceitou o pedido.");
    }

    @Override
    protected String finalizarPedido(Pedido pedido) {
        if (proximoEstadoNaCadeia != null) {
            return proximoEstadoNaCadeia.processar(pedido);
        }
        return "Pedido entregue ou cancelado.";
    }
}