package aula05.reforco05;

import atividadesentrega.aula05.reforco05.ValidadorNumero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorNumeroTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10, 20, 100, 1000})
    @DisplayName("Deve retornar true para números pares")
    public void testNumerosPares(int numero) {
        assertTrue(ValidadorNumero.ehPar(numero));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7, 15, 99, 101})
    @DisplayName("Deve retornar false para números ímpares")
    public void testNumerosImpares(int numero) {
        assertFalse(ValidadorNumero.ehPar(numero));
    }
}

