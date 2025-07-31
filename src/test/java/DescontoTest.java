import org.example.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DescontoTest {
    @Test
    public void testCupomDesconto10() {
        Desconto desconto = DescontoFactory.criarDesconto(TipoDesconto.CUPOM10);
        double valor = 100.0;
        double valorComDesconto = desconto.aplicarDesconto(valor);
        assertEquals(90.0, valorComDesconto, 0.01);
    }

    @Test
    public void testCupomDesconto15() {
        Desconto desconto = DescontoFactory.criarDesconto(TipoDesconto.CUPOM15);
        double valor = 100.0;
        double valorComDesconto = desconto.aplicarDesconto(valor);
        assertEquals(85.0, valorComDesconto, 0.01);
    }

    @Test
    public void testCupomDesconto20() {
        Desconto desconto = DescontoFactory.criarDesconto(TipoDesconto.CUPOM20);
        double valor = 100.0;
        double valorComDesconto = desconto.aplicarDesconto(valor);
        assertEquals(80.0, valorComDesconto, 0.01);
    }
}
