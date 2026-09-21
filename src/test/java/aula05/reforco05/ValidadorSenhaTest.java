package aula05.reforco05;

import atividadesentrega.aula05.reforco05.ValidadorSenha;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidadorSenhaTest {

    @ParameterizedTest
    @CsvSource({
            "Senha123, true",
            "Teste2026, true",
            "senha123, false",
            "SENHAAAA, false",
            "Abc1, false",
            "12345678, false",
            "A1bcdefg, true",
            "Senha12, false",
            "SemNumeroAqui, false"
    })
    public void testValidarSenha(String senha, boolean esperado) {
        boolean resultado = ValidadorSenha.senhaValida(senha);
        assertEquals(esperado, resultado);
    }
}
