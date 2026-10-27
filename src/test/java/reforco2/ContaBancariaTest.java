package reforco2;
import atividadesentrega.reforco2.ContaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void configurarCadaTeste() {
        conta = new ContaBancaria("Maria");
    }

    @Test
    void deveVerificarSaldoInicial() {
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveDepositarComSucesso() {
        conta.depositar(50.0);
        assertEquals(150.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSacarComSucesso() {
        conta.sacar(30.0);
        assertEquals(70.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSaqueMaiorQueSaldo() {
        assertThrows(IllegalStateException.class, () -> {
            conta.sacar(200.0);});
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }
}
