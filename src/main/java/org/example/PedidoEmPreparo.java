package org.example;

public class PedidoEmPreparo extends PedidoEstado {

    private PedidoEmPreparo() {};
    private static PedidoEmPreparo instance = new PedidoEmPreparo();
    public static PedidoEmPreparo getInstance(){
        return instance;
    }

    @Override
    public String getEstado(){
        return "Seu pedido está sendo preparado";
    }

    @Override
    public String Processamento(Pedido pedido) {
        String mensagem = pedido.getProcessoAtual().getEstado();
        if (true) {
            mensagem += "\nPedido preparado.";
            pedido.setProcessoAtual(PedidoEmTransporte.getInstance());
            pedido.updateEstado();

            if (this.proximoEstadoNaCadeia != null) {
                mensagem += "\n" + this.proximoEstadoNaCadeia.Processamento(pedido);
            }
            return mensagem;
        } else {
            mensagem += "\nFalha no preparo do pedido.";
            return mensagem;
        }
    }

    @Override
    public String transportar(Pedido pedido){
        return Processamento(pedido);
    }
}