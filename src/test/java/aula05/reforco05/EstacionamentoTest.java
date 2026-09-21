package aula05.reforco05;

import atividadesentrega.aula05.reforco05.Estacionamento;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EstacionamentoTest {


    @ParameterizedTest
    @CsvSource({
            "1, 5.0",
            "2, 10.0",
            "3, 10.0",
            "4, 15.0",
            "5, 15.0",
            "6, 15.0",
            "7, 25.0",
            "8, 25.0",
            "10, 25.0",
            "24, 25.0"
    })
    public void testValoresCobrados(int horas, double esperado) {
        double resultado = Estacionamento.calcularValor(horas);

        assertEquals(esperado, resultado, 0.001);
    }
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5, -100})
    public void testTemposInvalidos(int horas) {

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> Estacionamento.calcularValor(horas));

        assertEquals("Tempo inválido.", excecao.getMessage());
    }
}