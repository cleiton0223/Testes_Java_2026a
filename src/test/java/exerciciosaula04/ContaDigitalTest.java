package exerciciosaula04;

import atividadesentrega.aula04.exercicios04.ContaDigital;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaDigitalTest {


    @Test
    void contaRecemCriadaDeveTerSaldoZero() {

        ContaDigital contaDigital = new ContaDigital("lucas");

        assertEquals(0.0, contaDigital.getSaldo(), 0.001);

    }
    @Test
    void depositarValorAumentaSaldo(){

        ContaDigital contaDigital = new ContaDigital("lucas");

        contaDigital.depositar(100.0);

        assertEquals(100.0, contaDigital.getSaldo(), 0.001);
    }
    @Test
    void sacarValorReduzirSaldo(){
        ContaDigital contaDigital = new ContaDigital("lucas");

        contaDigital.depositar(100.0);

        contaDigital.sacar(100.0);

        assertEquals(0, contaDigital.getSaldo(), 0.001);

    }
    @Test
    void depositoZeroLancarExecao(){
        ContaDigital contaDigital = new ContaDigital("lucas");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> contaDigital.depositar(0.0));

        assertAll(
                () -> assertEquals(
                        "O depósito deve ser maior que zero.", excecao.getMessage()),
                () -> assertEquals(0.0,
                        contaDigital.getSaldo(),0.001));
    }
    @Test
    void depositoNegativoDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("lucas");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> conta.depositar(-50.0));

        assertEquals(
                "O depósito deve ser maior que zero.",excecao.getMessage());
    }
    @Test
    void saqueZeroDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("lucas");
        conta.depositar(200.0);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> conta.sacar(0.0));

        assertEquals(
                "O saque deve ser maior que zero.",excecao.getMessage());
    }

    @Test
    void saqueNegativoDeveLancarExcecao() {
        ContaDigital conta = new ContaDigital("lucas");
        conta.depositar(100.0);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> conta.sacar(-10.0));

        assertEquals(
                "O saque deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void saqueMaiorQueSaldoDeveLancarExcecaoESaldoNaoDeveMudar() {
        ContaDigital conta = new ContaDigital("lucas");
        conta.depositar(100.0);

        IllegalStateException excecao = assertThrows(
                IllegalStateException.class,
                () -> conta.sacar(10.0));

        assertAll(
                () -> assertEquals(
                        "Saldo insuficiente.",excecao.getMessage()),
                () -> assertEquals(50.0,conta.getSaldo(), 0.001));
    }
}

