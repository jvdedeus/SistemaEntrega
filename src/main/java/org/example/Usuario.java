package org.example;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer, Cloneable {
    private String nome;
    private String ultimaNotificacao;
    private Endereco endereco;

    private Usuario(Builder builder) {
        this.nome = builder.nome;
        this.endereco = builder.endereco;
    }

    public static class Builder {
        private String nome;
        private Endereco endereco;

        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }
        public Builder setEndereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }
        public Usuario build() {
            return new Usuario(this);
        }
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
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void pedir(Pedido pedido){
        pedido.addObserver(this);
    }
    public void update(Observable pedido, Object arg1){
        this.ultimaNotificacao = pedido.toString();
    }
    @Override
    public Usuario clone() {
        try {
            Usuario clone = (Usuario) super.clone();
            clone.endereco = this.endereco != null ? this.endereco.clone() : null;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
