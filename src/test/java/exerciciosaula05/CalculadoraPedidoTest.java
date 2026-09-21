package exerciciosaula05;
import atividadesentrega.aula05.exercicios05.CalculadoraPedido;
import atividadesentrega.aula05.exercicios05.Item;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraPedidoTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("cenariosDePedido")
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void calcularDeveAtenderCenariosValidos(
            String descricao,
            Item item,
            int percentualCupom,
            double esperado) {

        // Act
        double obtido = CalculadoraPedido.calcular(item, percentualCupom);

        // Assert
        assertEquals(esperado, obtido, 0.001);
    }

    static Stream<Arguments> cenariosDePedido() {
        return Stream.of(
                Arguments.of("Cupom de 0% (fronteira inferior)", new Item("Teclado", 100.0, 1), 0, 100.0),
                Arguments.of("Cupom de 1% (vizinho interno inferior)", new Item("Mouse", 200.0, 2), 1, 396.0),
                Arguments.of("Cupom de 29% (vizinho interno superior)", new Item("Monitor", 1000.0, 1), 29, 710.0),
                Arguments.of("Cupom de 30% (fronteira superior)", new Item("Cadeira", 500.0, 2), 30, 700.0),
                Arguments.of("Compra em lote com desconto intermediário", new Item("Headset", 50.0, 4), 10, 180.0)
        );
    }

    @ParameterizedTest
    @NullSource
    void itemNuloDeveLancarExcecao(Item item) {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraPedido.calcular(item, 10)
        );

        assertEquals("O item é obrigatório.", excecao.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "\t"})
    void nomeAusenteDeveLancarExcecao(String nome) {
        Item itemInvalido = new Item(nome, 100.0, 1);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraPedido.calcular(itemInvalido, 10)
        );

        assertEquals("O nome do item é obrigatório.", excecao.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 31})
    void cupomInvalidoDeveLancarExcecao(int percentualCupom) {
        Item itemValido = new Item("Notebook", 1000.0, 1);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraPedido.calcular(itemValido, percentualCupom)
        );

        assertEquals("O cupom deve estar entre 0 e 30.", excecao.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -0.01, -10.0})
    void precoInvalidoDeveLancarExcecao(double preco) {
        Item itemInvalido = new Item("Produto", preco, 1);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraPedido.calcular(itemInvalido, 10)
        );

        assertEquals("O preço deve ser maior que zero.", excecao.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void quantidadeInvalidaDeveLancarExcecao(int quantidade) {
        Item itemInvalido = new Item("Produto", 10.0, quantidade);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraPedido.calcular(itemInvalido, 10)
        );

        assertEquals("A quantidade deve ser maior que zero.", excecao.getMessage());
    }
}