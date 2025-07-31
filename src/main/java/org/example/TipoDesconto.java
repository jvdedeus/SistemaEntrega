package org.example;

public enum TipoDesconto {
    CUPOM10 {
        public Desconto criar() { return new CupomDesconto10(); }
    },
    CUPOM15 {
        public Desconto criar() { return new CupomDesconto15(); }
    },
    CUPOM20 {
        public Desconto criar() { return new CupomDesconto20(); }
    },
    NENHUM {
        public Desconto criar() { return new SemDesconto(); }
    };
    public abstract Desconto criar();
}
