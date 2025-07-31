package org.example;

public class Endereco implements Cloneable {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    private Endereco(Builder builder) {
        this.rua = builder.rua;
        this.numero = builder.numero;
        this.cidade = builder.cidade;
        this.estado = builder.estado;
        this.cep = builder.cep;
    }

    public static class Builder {
        private String rua;
        private String numero;
        private String cidade;
        private String estado;
        private String cep;

        public Builder setRua(String rua) { this.rua = rua; return this; }
        public Builder setNumero(String numero) { this.numero = numero; return this; }
        public Builder setCidade(String cidade) { this.cidade = cidade; return this; }
        public Builder setEstado(String estado) { this.estado = estado; return this; }
        public Builder setCep(String cep) { this.cep = cep; return this; }
        public Endereco build() { return new Endereco(this); }
    }

    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    @Override
    public Endereco clone() {
        try {
            return (Endereco) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
