package org.example;

public class DescontoFactory {
    public static Desconto criarDesconto(TipoDesconto tipo) {
        return tipo.criar();
    }
}

