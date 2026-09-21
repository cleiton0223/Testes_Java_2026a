package aula05.exercicios05;

import atividadesentrega.aula05.exercicios05.CalculadoraFrete;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraFreteTest {

    // Verifica diferentes pesos e modalidades com novos valores.
    @ParameterizedTest(
            name = "peso={0}, expressa={1}, esperado={2}"
    )
    @CsvSource({
            // peso, expressa, esperado
            "0.50, false,  9.00",
            "2.50, false, 13.00",
            "4.00, false, 16.00",
            "2.00, true,  20.00",
            "3.50, true,  23.50"
    })
    void calcularDeveRetornarFreteCorreto(
            double peso,
            boolean expressa,
            double esperado) {

        double obtido = CalculadoraFrete.calcular(
                peso,
                expressa
        );

        assertEquals(esperado, obtido, 0.001);
    }

    // Verifica a fronteira inválida e valores negativos alterados.
    @ParameterizedTest(name = "peso inválido: {0}")
    @ValueSource(doubles = {0.0, -0.50, -5.00})
    void pesoInvalidoDeveLancarExcecao(double peso) {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFrete.calcular(peso, false)
        );

        assertEquals(
                "O peso deve ser maior que zero.", excecao.getMessage());
    }
}
