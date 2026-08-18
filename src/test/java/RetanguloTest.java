import atividadesentrega.aula04.Retangulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RetanguloTest {

    @Test
    void calcularAreaDeveMultiplicarLados() {
        // Arrange
        Retangulo retangulo = new Retangulo(4.0, 5.0);

        // Act
        double area = retangulo.calcularArea();

        // Assert
        assertEquals(20.0, area);
    }

    @Test
    void larguraInvalidaDeveLancarExcecao() {
        // Arrange & Act / Assert
        assertThrows(IllegalArgumentException.class, () -> new Retangulo(-1, 5.0)
        );
    }

    @Test
    void retanguloDeveTerTodosOsDadosCorretos() {
        // Arrange & Act
        Retangulo retangulo = new Retangulo(4.0, 5.0);

        // Assert
        assertEquals(4.0, retangulo.getBase());
        assertEquals(5.0, retangulo.getAltura());
    }
}