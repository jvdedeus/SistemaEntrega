import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {
    Usuario usuario;
    Pedido pedido;
    FormaPagamento forma;
    Desconto desconto;

    @BeforeEach
    void setUp() {
        usuario = new Usuario.Builder().setNome("Maria").build();
        desconto = new CupomDesconto10();
        pedido = new Pedido.Builder().setUsuario(usuario).setValorTotal(100.0).setDesconto(desconto).build();
        PedidoEmProcesso.getInstance().setProximoEstadoNaCadeia(PedidoEmPreparo.getInstance());
        PedidoEmPreparo.getInstance().setProximoEstadoNaCadeia(PedidoEmTransporte.getInstance());
        PedidoEmTransporte.getInstance().setProximoEstadoNaCadeia(PedidoEntregue.getInstance());
    }

    @Test
    void testValorComTaxaCartaoCredito() {
        forma = new FormaCartaoCredito();
        double valorFinal = pedido.calcularValor(forma);
        assertEquals(94.5, valorFinal, 0.001);
    }

    @Test
    void testValorComTaxaCartaoDebito() {
        forma = new FormaCartaoDebito();
        double valorFinal = pedido.calcularValor(forma);
        assertEquals(91.8, valorFinal, 0.001);
    }

    @Test
    void testValorComTaxaPix() {
        forma = new FormaPix();
        double valorFinal = pedido.calcularValor(forma);
        assertEquals(90.9, valorFinal, 0.001);
    }
}