import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FormaPagamentoTest {

    @Test
    void testCartaoCreditoTipoPagamento() {
        FormaPagamento forma = new FormaCartaoCredito();
        assertEquals("Pagamento feito por cartão de Crédito", forma.tipoPagamento());
    }

    @Test
    void testCartaoCreditoTaxa() {
        FormaPagamento forma = new FormaCartaoCredito();
        assertEquals(0.05, forma.getTaxa());
    }

    @Test
    void testCartaoDebitoTipoPagamento() {
        FormaPagamento forma = new FormaCartaoDebito();
        assertEquals("Pagamento feito por cartão de Débito", forma.tipoPagamento());
    }

    @Test
    void testCartaoDebitoTaxa() {
        FormaPagamento forma = new FormaCartaoDebito();
        assertEquals(0.02, forma.getTaxa());
    }

    @Test
    void testPixTipoPagamento() {
        FormaPagamento forma = new FormaPix();
        assertEquals("Pagamento feito por Pix", forma.tipoPagamento());
    }

    @Test
    void testPixTaxa() {
        FormaPagamento forma = new FormaPix();
        assertEquals(0.01, forma.getTaxa());
    }
}