import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoEstadoTest {
    Usuario usuario;
    Pedido pedido;
    String resultado;

    @BeforeEach
    void setUp() {
        usuario = new Usuario.Builder().setNome("João").build();
        pedido = new Pedido.Builder().setUsuario(usuario).build();
    }

    @Test
    void testPedidoEmProcesso() {
        resultado = PedidoEmProcesso.getInstance().processar(pedido);
        assertEquals("Restaurante aceitou o pedido.", pedido.getMensagem());
    }

    @Test
    void testPedidoEmPreparo() {
        resultado = PedidoEmPreparo.getInstance().processar(pedido);
        assertEquals("Restaurante preparando o pedido.", pedido.getMensagem());
    }

    @Test
    void testPedidoEmTransporte() {
        resultado = PedidoEmTransporte.getInstance().processar(pedido);
        assertEquals("Restaurante transportando o pedido.", pedido.getMensagem());
    }

    @Test
    void testPedidoEntregue() {
        resultado = PedidoEntregue.getInstance().processar(pedido);
        assertEquals("Pedido entregue ao cliente.", pedido.getMensagem());
    }
}