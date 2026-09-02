package exerciciosaula04;

import atividadesentrega.aula04.Triangulo;
import atividadesentrega.aula04.exercicios04.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {


    @Test
    void calcularValorEmEstoqueDeveMultiplicarPrecoPelaQuantidade() {
        // Arrange
        Produto produto = new Produto("Martelo", 10.0, 5);

        // Act
        double obtido = produto.calcularValorEmEstoque();

        // Assert
        assertEquals(50, obtido, 0.001);
    }
    @Test
    void produtosNoEstoqueRetornaTrue(){
        // Arrange
        Produto produto = new Produto("Martelo", 10.0, 5);

        // Act
        boolean obtido = produto.temEstoque();

        // Assert
        assertTrue(obtido);
    }

    @Test
    void retornaFalseQuandoNaoTemEstoque(){
        // Arrange
        Produto produto = new Produto("Martelo", 10.0, 0);

        // Act
        boolean obtido = produto.temEstoque();

        // Assert
        assertFalse(obtido);
    }
    @Test
    void verificarSeRejeitaQuandoPrecoForZero(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Martelo", 0, 10)
        );
    }

    @Test
    void verificarSeRejeitaQuandoPrecoForNegativo(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Martelo", -10, 10)
        );
    }

    @Test
    void verificarRejeicaoQuantidadeInicialNegativa(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Martelo", 10.0, -1)
        );
    }
    @Test
    void verificarMensagensExcecoes(){
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Martelo", 0, 10)
        );

        assertEquals("O preço deve ser maior que zero.",excecao.getMessage());

        excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Martelo", -10, 10)
        );

        assertEquals("O preço deve ser maior que zero.",excecao.getMessage());

        excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new Produto("Martelo", 10.0, -1)
        );

        assertEquals("O estoque não pode ser negativo.",excecao.getMessage());
    }
}
