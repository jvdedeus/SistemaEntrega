import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("João");
        pedido = new Pedido(usuario);
        usuario.pedir(pedido);
    }

    @Test
    void deveCompararResultadosDaCadeiaDoPedido() {
        String resultadoCadeia = pedido.iniciarProcessamentoCadeia();

        assertTrue(resultadoCadeia.contains("Seu pedido precisa ser aceito pelo restaurante"));
        assertTrue(resultadoCadeia.contains("Restaurante aceitou o pedido."));
        assertTrue(resultadoCadeia.contains("Seu pedido está sendo preparado"));
        assertTrue(resultadoCadeia.contains("Pedido preparado."));
        assertTrue(resultadoCadeia.contains("Seu pedido está à caminho"));
        assertTrue(resultadoCadeia.contains("Pedido entregue."));
        assertTrue(resultadoCadeia.contains("Seu pedido foi entregue"));

        assertEquals("Seu pedido foi entregue", pedido.toString());
        assertEquals("Seu pedido foi entregue", usuario.getUltimaNotificacao());
    }

    @Test
    void deveRetornarPagamentoCartaoCredito() {
        FormaPagamento cartaoCredito = new FormaCartaoCredito();
        String tipo = pedido.tipoPagamento(cartaoCredito);
        assertEquals("Pagamento feito por cartão de Crédito", tipo);
    }

    @Test
    void deveRetornarPagamentoCartaoDebito() {
        FormaPagamento cartaoDebito = new FormaCartaoDebito();
        String tipo = pedido.tipoPagamento(cartaoDebito);
        assertEquals("Pagamento feito por cartão de Débito", tipo);
    }

    @Test
    void deveRetornarPagamentoPix() {
        FormaPagamento pix = new FormaPix();
        String tipo = pedido.tipoPagamento(pix);
        assertEquals("Pagamento feito por Pix", tipo);
    }

    @Test
    void deveRetornarPagamentoSaldoConta() {
        FormaPagamento saldoConta = new FormaSaldoConta();
        String tipo = pedido.tipoPagamento(saldoConta);
        assertEquals("Pagamento feito por Saldo existente em Conta", tipo);
    }
}