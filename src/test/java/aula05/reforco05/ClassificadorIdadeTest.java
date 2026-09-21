package aula05.reforco05;

import atividadesentrega.aula05.reforco05.ClassificadorIdade;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassificadorIdadeTest {

    @ParameterizedTest
    @CsvSource({
            "0, CRIANCA",
            "5, CRIANCA",
            "12, CRIANCA",
            "13, ADOLESCENTE",
            "17, ADOLESCENTE",
            "18, ADULTO",
            "30, ADULTO",
            "59, ADULTO",
            "60, IDOSO",
            "80, IDOSO"
    })
    public void testClassificacaoIdade(int idade, String esperado) {
        String resultado = ClassificadorIdade.classificar(idade);
        assertEquals(esperado, resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -20, -100})
    public void testIdadeInvalida(int idade) {

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> ClassificadorIdade.classificar(idade));

        assertEquals("Idade não pode ser negativa.", excecao.getMessage());
    }
}