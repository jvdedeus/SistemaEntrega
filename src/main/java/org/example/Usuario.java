package org.example;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void pedir(Pedido pedido){
        pedido.addObserver(this);
    }

    public void update(Observable pedido, Object arg1){
        this.ultimaNotificacao = pedido.toString();
    }
}
