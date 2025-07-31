package org.example;

public class PedidoEmPreparo extends PedidoEstado {
    private PedidoEmPreparo() {}
    private static PedidoEmPreparo instance = new PedidoEmPreparo();
    public static PedidoEmPreparo getInstance() {
        return instance;
    }

    @Override
    protected void processarPedido(Pedido pedido) {

        pedido.setMensagem("Restaurante preparando o pedido.");
    }

    @Override
    protected String finalizarPedido(Pedido pedido) {
        if (proximoEstadoNaCadeia != null) {
            return proximoEstadoNaCadeia.processar(pedido);
        }
        return "Pedido entregue ou cancelado.";
    }
}