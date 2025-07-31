package org.example;

public class PedidoEmTransporte extends PedidoEstado {

    private PedidoEmTransporte() {}
    private static PedidoEmTransporte instance = new PedidoEmTransporte();
    public static PedidoEmTransporte getInstance() {
        return instance;
    }

    @Override
    protected void transportarPedido(Pedido pedido) {
        pedido.setMensagem("Restaurante transportando o pedido.");
    }

    @Override
    protected String finalizarPedido(Pedido pedido) {
        if (proximoEstadoNaCadeia != null) {
            return proximoEstadoNaCadeia.processar(pedido);
        }
        return "Pedido entregue ou cancelado.";
    }
}