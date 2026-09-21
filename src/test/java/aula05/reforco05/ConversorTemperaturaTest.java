package aula05.reforco05;

import atividadesentrega.aula05.reforco05.ConversorTemperatura;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversorTemperaturaTest {

    @ParameterizedTest
    @CsvSource({
            "0, 32",
            "10, 50",
            "20, 68",
            "30, 86",
            "100, 212",
            "-10, 14",
            "-40, -40"
    })
    public void testConversaoCelsiusFahrenheit(double celsius, double esperado) {
        double resultado = ConversorTemperatura.celsiusParaFahrenheit(celsius);

        assertEquals(esperado, resultado, 0.001);
    }
}

