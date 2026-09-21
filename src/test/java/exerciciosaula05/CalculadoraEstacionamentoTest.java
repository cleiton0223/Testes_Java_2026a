package exerciciosaula05;
import atividadesentrega.aula05.exercicios05.CalculadoraEstacionamento;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraEstacionamentoTest {

    @ParameterizedTest(
            name = "horas={0}, fim de semana={1}, esperado={2}"
    )
    @CsvSource({
            "1, false, 5.00",
            "1, true, 6.00",
            "2, false, 8.00",
            "2, true, 9.60",
            "24, false, 74.00",
            "24, true, 88.80"
    })
    void calcularDeveRetornarValorCorreto(
            int horas,
            boolean fimDeSemana,
            double esperado) {


        CalculadoraEstacionamento calculadora = new CalculadoraEstacionamento();

        double obtido = calculadora.calcular(horas, fimDeSemana);

        assertEquals(esperado, obtido, 0.001);
    }

    @ParameterizedTest(name = "permanência inválida: {0}")
    @ValueSource(ints = {0, -1, 25})
    void permanenciaInvalidaDeveLancarExcecao(int horas) {


        CalculadoraEstacionamento calculadora = new CalculadoraEstacionamento();

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcular(horas, false));

        assertEquals(
                "A permanência deve estar entre 1 e 24 horas.", excecao.getMessage());}
}