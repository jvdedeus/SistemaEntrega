import org.example.Pedido;
import org.example.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;
    private Pedido pedido;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Ana");
        pedido = new Pedido(usuario);
    }

    @Test
    void deveRetornarNomeCerto() {
        assertEquals("Ana", usuario.getNome());
    }

    @Test
    void deveRetornarNotificacaoQuandoPedidoAtualiza() {
        usuario.pedir(pedido);
        pedido.iniciarProcessamentoCadeia();

        assertEquals("Seu pedido foi entregue", usuario.getUltimaNotificacao());
    }

    @Test
    void naoDeveRetornarNotificacaoSeNaoEstiverSendoObservado() {
        Pedido outroPedido = new Pedido(usuario);
        outroPedido.iniciarProcessamentoCadeia();
        assertNull(usuario.getUltimaNotificacao());
    }
}