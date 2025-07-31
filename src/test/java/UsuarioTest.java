import org.example.Endereco;
import org.example.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    @Test
    public void testCloneSuccess() {
        Endereco endereco = new Endereco.Builder()
            .setRua("Rua A")
            .setNumero("123")
            .setCidade("CidadeX")
            .setEstado("EstadoY")
            .setCep("00000-000")
            .build();
        Usuario usuarioOriginal = new Usuario.Builder()
            .setNome("João")
            .setEndereco(endereco)
            .build();
        Usuario usuarioClonado = usuarioOriginal.clone();

        assertNotSame(usuarioOriginal, usuarioClonado);
        assertEquals(usuarioOriginal.getNome(), usuarioClonado.getNome());
        assertNotSame(usuarioOriginal.getEndereco(), usuarioClonado.getEndereco());
        assertEquals(usuarioOriginal.getEndereco().getRua(), usuarioClonado.getEndereco().getRua());
    }
}
