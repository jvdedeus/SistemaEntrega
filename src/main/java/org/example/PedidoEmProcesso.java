package org.example;

public class PedidoEmProcesso extends PedidoEstado {

    private PedidoEmProcesso() {};
    private static PedidoEmProcesso instance = new PedidoEmProcesso();
    public static PedidoEmProcesso getInstance(){
        return instance;
    }

    @Override
    public String getEstado(){
        return "Seu pedido precisa ser aceito pelo restaurante";
    }

    @Override
    public String Processamento(Pedido pedido) {
        String mensagem = pedido.getProcessoAtual().getEstado();
        if (true) {
            mensagem += "\nRestaurante aceitou o pedido.";
            pedido.setProcessoAtual(PedidoEmPreparo.getInstance());
            pedido.updateEstado();

            if (this.proximoEstadoNaCadeia != null) {
                mensagem += "\n" + this.proximoEstadoNaCadeia.Processamento(pedido);
            }
            return mensagem;
        } else {
            mensagem += "\nRestaurante recusou o pedido. Transição negada.";
            return mensagem;
        }
    }

    @Override
    public String preparar(Pedido pedido){
        return Processamento(pedido);
    }
}