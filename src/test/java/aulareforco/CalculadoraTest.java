package aulareforco;

import atividadesentrega.atividadereforco.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {


    @Test
    void deveRetornarSoma() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(2, 3);


        assertEquals(5, resultado);


    }

    @Test
    void naoDeveDeixarDividirPorZero() {

        Calculadora calculadora = new Calculadora();

        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class, () -> calculadora.dividir(10, 0));

        assertEquals("Não é possível dividir por zero.", erro.getMessage());
    }

    @Test
    void numeroPar() {

        Calculadora calculadora = new Calculadora();

        boolean par = calculadora.ehPar(2);
        boolean impar = calculadora.ehPar(5);

        assertTrue(par);
        assertTrue(impar);

    }

    @Test
    void deveRetornarMultiplicacao() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.multiplicar(10, 5);

        assertEquals(50, resultado);
    }

    @Test
    void deveRetornarSubtracao() {
        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.subtrair(50, 25);

        assertEquals(24, resultado);
    }
}

