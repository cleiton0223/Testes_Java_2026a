package aula05;

import atividadesentrega.aula05.CalculadoraFrete;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraFreteTest {

    @ParameterizedTest(name = "Peso: {0}kg, Expressa: {1} -> Esperado: {2}")
    @CsvSource({
            "0.01, false, 8.02",
            "2.5,  false, 13.0",
            "2.5,  true,  19.5",
            "3.0,  false, 14.0",
            "10.0, true,  42.0"
    })
    void deveCalcularFrete(double peso, boolean entregaExpressa, double esperado) {
        double resultado = CalculadoraFrete.calcular(peso, entregaExpressa);
        assertEquals(esperado, resultado, 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -0.01, -1.0})
    void deveLancarExcecaoParaPesoInvalido(double pesoInvalido) {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFrete.calcular(pesoInvalido, false)
        );

        assertEquals("O peso deve ser maior que zero.", excecao.getMessage());
    }
}