import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
        usuario = new Usuario("João");
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
}