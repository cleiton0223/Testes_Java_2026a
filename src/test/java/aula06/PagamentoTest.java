package aula06;

import atividadesentrega.aula06.Pagamento;
import atividadesentrega.aula06.PagamentoCartao;
import atividadesentrega.aula06.PagamentoPix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Pagamento via Pix")
class PixTest {

    @Test
    @DisplayName("Deve calcular taxa igual a zero para pagamentos via Pix")
    void deveCalcularTaxaZero() {
        PagamentoPix pix = new PagamentoPix(100.0);
        assertEquals(0.0, pix.calcularTaxa(), "A taxa do Pix deve ser 0");
    }

    @Test
    @DisplayName("Deve lançar exceção se o valor do Pix for zero ou negativo")
    void deveLancarExcecaoValorInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PagamentoPix(0.0);});
        assertEquals("O valor deve ser maior que zero.", exception.getMessage());
    }
}

@Nested
@Tag("cartao")
@DisplayName("Pagamento via Cartão")
class CartaoTest {

    @Test
    @DisplayName("Deve calcular taxa de 2,5% para pagamentos via Cartão")
    void deveCalcularTaxaDeDoisEMeioPorcento() {
        PagamentoCartao cartao = new PagamentoCartao(200.0);
        assertEquals(5.0, cartao.calcularTaxa(), 0.001, "A taxa do cartão deve ser de 2,5%");
    }

    @Test
    @DisplayName("Deve lançar exceção se o valor do Cartão for zero ou negativo")
    void deveLancarExcecaoValorInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PagamentoCartao(-50.0);});
        assertEquals("O valor deve ser maior que zero.", exception.getMessage());
    }
}

@Nested
@DisplayName("Polimorfismo")
class PolimorfismoTest {

    @Test
    @DisplayName("Garante que o polimorfismo chama a implementação correta da taxa")
    void deveAplicarTaxasCorretasViaPolimorfismo() {
        Pagamento pagamento1 = new PagamentoPix(100.0);
        Pagamento pagamento2 = new PagamentoCartao(100.0);

        assertAll("Verificação polimórfica das taxas",
                () -> assertEquals(0.0, pagamento1.calcularTaxa(), "A taxa resolvida dinamicamente deve ser 0 (Pix)"),
                () -> assertEquals(2.5, pagamento2.calcularTaxa(), 0.001, "A taxa resolvida dinamicamente deve ser 2.5 (Cartão)"));
    }
}

