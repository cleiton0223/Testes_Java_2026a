package aula05.reforco05;

import atividadesentrega.aula05.reforco05.Autenticador;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutenticadorTest {

    @ParameterizedTest
    @MethodSource("fornecerCenariosDeAutenticacao")
    public void testAutenticar(String usuario, String senha, boolean ativo, boolean esperado) {
        boolean resultado = Autenticador.autenticar(usuario, senha, ativo);
        assertEquals(esperado, resultado);
    }

    private static Stream<Arguments> fornecerCenariosDeAutenticacao() {
        return Stream.of(
                Arguments.of("admin", "Senai123", true, true),
                Arguments.of("admin", "SenhaErrada", true, false),
                Arguments.of("usuarioInvalido", "Senai123", true, false),
                Arguments.of("admin", "Senai123", false, false),
                Arguments.of(null, "Senai123", true, false),
                Arguments.of("admin", null, true, false));
    }
}




