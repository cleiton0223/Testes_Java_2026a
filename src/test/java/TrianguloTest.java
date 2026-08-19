import atividadesentrega.aula04.Triangulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrianguloTest {

    @Test
    void calcularPerimetroDeveSomarOsTresLados() {
        // Arrange
        Triangulo triangulo = new Triangulo(3, 4, 5);

        // Act
        double perimetro = triangulo.calcularPerimetro();

        // Assert
        assertEquals(12.0, perimetro);
    }

    @Test
    void ladoNegativoDeveLancarExcecao() {
        // Arrange, Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Triangulo(-1, 4, 5));
    }

    @Test
    void triangulo3_4_5DeveTerLadosCorretos() {
        // Arrange & Act
        Triangulo t = new Triangulo(3, 4, 5);

        // Assert
        assertAll(
                () -> assertEquals(3.0, t.getLadoA()),
                () -> assertEquals(4.0, t.getLadoB()),
                () -> assertEquals(5.0, t.getLadoC()));
    }
}