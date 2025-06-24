package org.example;

import java.util.Observable;

public class Pedido extends Observable {

    private PedidoEstado processoAtual;
    private Usuario usuario;

    public Pedido(Usuario usuario){
        this.processoAtual = PedidoEmProcesso.getInstance();
        this.usuario = usuario;
        configurarCadeiaDeEstados();
    }

    private void configurarCadeiaDeEstados() {
        PedidoEmProcesso.getInstance().setProximoEstadoNaCadeia(PedidoEmPreparo.getInstance());
        PedidoEmPreparo.getInstance().setProximoEstadoNaCadeia(PedidoEmTransporte.getInstance());
        PedidoEmTransporte.getInstance().setProximoEstadoNaCadeia(PedidoEntregue.getInstance());
    }

    public PedidoEstado getProcessoAtual() {
        return processoAtual;
    }

    public void setProcessoAtual(PedidoEstado processoAtual) {
        this.processoAtual = processoAtual;
    }

    public void updateEstado(){
        setChanged();
        notifyObservers();
    }

    public String iniciarProcessamentoCadeia() {
        return this.processoAtual.Processamento(this);
    }

    @Override
    public String toString() {
        return processoAtual.getEstado();
    }
}