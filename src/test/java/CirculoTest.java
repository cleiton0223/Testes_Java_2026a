import atividadesentrega.aula04.Circulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CirculoTest {

    @Test
    void calcularAreaDeveRetornarValorCorreto() {
        // Arrange
        Circulo circulo = new Circulo(3.0);

        // Act
        double area = circulo.calcularAreaa();

        // Assert
        Assertions.assertEquals(28.274333882308138, area, 0.0001);
    }

    @Test
    void raioDeveSerMaiorQueDezRetornaTrue() {
        // Arrange
        Circulo circulo = new Circulo(15.0);

        // Act
        boolean resultado = circulo.maiorQueDez();

        // Assert
        Assertions.assertTrue(resultado);
    }

    @Test
    void raioInvalidoDeveLancarExcecao() {
        // Arrange, Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Circulo(0));
    }

    @Test
    void circuloDeveAgruparMultiplasVerificacoesCorretamente() {
        // Arrange & Act
        Circulo circulo = new Circulo(5.0);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(5.0, circulo.getRaio()),
                () -> Assertions.assertFalse(circulo.maiorQueDez()));
    }
}