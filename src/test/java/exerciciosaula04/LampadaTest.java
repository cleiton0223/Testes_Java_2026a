package exerciciosaula04;

import atividadesentrega.aula04.exercicios04.Lampada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LampadaTest {

    @Test
    public void deveCriarLampadaDesligadaComIntensidadeZero() {
        // ARRANGE
        Lampada lampada = new Lampada("Sala");

        // ASSERT
        assertFalse(lampada.isLigada());
        assertEquals(0, lampada.getIntensidade());
    }

    @Test
    public void deveTerIntensidadeZeroAoDesligar() {
        // ARRANGE
        Lampada lampada = new Lampada("Sala");
        lampada.ligar();

        // ACT
        lampada.desligar();

        // ASSERT
        assertFalse(lampada.isLigada());
        assertEquals(0, lampada.getIntensidade());
    }

    @Test
    public void deveAlterarOEstadoDaLampadaAoLigar() {
        // ARRANGE
        Lampada lampada = new Lampada("Sala");

        // ACT
        lampada.ligar();

        // ASSERT
        assertTrue(lampada.isLigada());
        assertEquals(100, lampada.getIntensidade());
    }
}
