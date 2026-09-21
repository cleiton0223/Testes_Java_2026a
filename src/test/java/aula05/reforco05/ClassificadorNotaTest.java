package aula05.reforco05;

import atividadesentrega.aula05.reforco05.ClassificadorNota;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassificadorNotaTest {

    @ParameterizedTest
    @CsvSource({
            "0.0, REPROVADO",
            "2.5, REPROVADO",
            "4.9, REPROVADO",
            "5.0, RECUPERACAO",
            "6.0, RECUPERACAO",
            "6.9, RECUPERACAO",
            "7.0, APROVADO",
            "8.5, APROVADO",
            "10.0, APROVADO"
    })
    public void testClassificacaoValida(double nota, String esperado) {
        String resultado = ClassificadorNota.classificar(nota);
        assertEquals(esperado, resultado);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -1.0, -5.0, 10.1, 11.0, 20.0})
    public void testNotasInvalidas(double nota) {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> ClassificadorNota.classificar(nota));

        assertEquals("Nota deve estar entre 0 e 10.", excecao.getMessage());
    }
}
