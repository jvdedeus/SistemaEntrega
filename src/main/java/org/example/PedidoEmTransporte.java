package org.example;

public class PedidoEmTransporte extends PedidoEstado {

    private PedidoEmTransporte() {};
    private static PedidoEmTransporte instance = new PedidoEmTransporte();
    public static PedidoEmTransporte getInstance(){
        return instance;
    }

    @Override
    public String getEstado(){
        return "Seu pedido está à caminho";
    }

    @Override
    public String Processamento(Pedido pedido) {
        String mensagem = pedido.getProcessoAtual().getEstado();
        if (true) {
            mensagem += "\nPedido entregue.";
            pedido.setProcessoAtual(PedidoEntregue.getInstance());
            pedido.updateEstado();

            if (this.proximoEstadoNaCadeia != null) {
                mensagem += "\n" + this.proximoEstadoNaCadeia.Processamento(pedido);
            }
            return mensagem;
        } else {
            mensagem += "\nFalha na entrega do pedido.";
            return mensagem;
        }
    }

    @Override
    public String entregue(Pedido pedido){
        return Processamento(pedido);
    }
}