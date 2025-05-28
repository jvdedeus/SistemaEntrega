import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoEstadoTest {

    @Test
    void emProcessoParaEmPreparo() {
        PedidoEmProcesso emProcesso = PedidoEmProcesso.getInstance();
        PedidoEmPreparo emPreparo = PedidoEmPreparo.getInstance();

        emProcesso.setProximoEstadoNaCadeia(emPreparo);
        assertSame(emPreparo, emProcesso.proximoEstadoNaCadeia);
    }

    @Test
    void emPreparoParaEmTransporte() {
        PedidoEmPreparo emPreparo = PedidoEmPreparo.getInstance();
        PedidoEmTransporte emTransporte = PedidoEmTransporte.getInstance();

        emPreparo.setProximoEstadoNaCadeia(emTransporte);
        assertSame(emTransporte, emPreparo.proximoEstadoNaCadeia);
    }

    @Test
    void emTransporteParaEmEntrega() {
        PedidoEmTransporte emTransporte = PedidoEmTransporte.getInstance();
        PedidoEntregue emEntrega = PedidoEntregue.getInstance();

        emTransporte.setProximoEstadoNaCadeia(emEntrega);
        assertSame(emEntrega, emTransporte.proximoEstadoNaCadeia);
    }

    @Test
    void processamentoComEstadoNaoExistente() {
        PedidoEstado estado = new PedidoEstado() {
            @Override
            public String getEstado() {
                return "Estado Genérico";
            }
        };
        Pedido pedido = new Pedido();
        String resultado = estado.Processamento(pedido);
        assertEquals("Não existe próximo processo", resultado);
    }
}