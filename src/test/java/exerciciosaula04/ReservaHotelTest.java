package exerciciosaula04;

import atividadesentrega.aula04.exercicios04.ReservaHotel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReservaHotelTest {

    @Test
    void reservaRecemCriadaDeveTerDadosEEstadoInicialCorretos() {
        ReservaHotel reserva = new ReservaHotel("Maria", 3, 250.0);

        assertAll(
                () -> assertEquals("Maria", reserva.getHospede()),
                () -> assertEquals(3, reserva.getQuantidadeDiarias()),
                () -> assertEquals(250.0, reserva.getValorDiaria(), 0.001),
                () -> assertFalse(reserva.isConfirmada()),
                () -> assertNull(reserva.getCodigoConfirmacao()));
    }

    @Test
    void calcularTotalDeveMultiplicarDiariasPeloValor() {
        // Arrange
        ReservaHotel reserva = new ReservaHotel("Maria", 4, 180.0);

        // Act
        double obtido = reserva.calcularTotal();

        // Assert
        assertEquals(720.0, obtido, 0.001);
    }

    @Test
    void confirmarDeveAlterarEstadoEArmazenarCodigo() {
        // Arrange
        ReservaHotel reserva = new ReservaHotel("Maria", 2, 300.0);

        // Act
        reserva.confirmar("2026-04");

        // Assert
        assertAll(
                () -> assertTrue(reserva.isConfirmada()),
                () -> assertNotNull(reserva.getCodigoConfirmacao()),
                () -> assertEquals("2026-04", reserva.getCodigoConfirmacao()));
    }

    @Test
    void hospedeNuloDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel(null, 2, 200.0));

        assertEquals("O hóspede é obrigatório.", excecao.getMessage());
    }

    @Test
    void hospedeEmBrancoDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel("   ", 10, 600.0));

        assertEquals("O hóspede é obrigatório.", excecao.getMessage());
    }

    @Test
    void quantidadeZeroDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel("lucas", 0, 100.0));

        assertEquals("A quantidade de diárias deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void quantidadeNegativaDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel("Diego", -5, 100.0));

        assertEquals("A quantidade de diárias deve ser maior que zero.",
                excecao.getMessage());
    }

    @Test
    void valorZeroDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel("lara", 2, 0.0));

        assertEquals(
                "O valor da diária deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void valorNegativoDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel("lara", 2, -1.0));

        assertEquals(
                "O valor da diária deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void codigoNuloDeveLancarExcecao() {
        ReservaHotel reserva = new ReservaHotel("maila",
                2, 150.0);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> reserva.confirmar(null));

        assertEquals(
                "O código de confirmação é obrigatório.",
                excecao.getMessage()
        );
    }

    @Test
    void codigoEmBrancoDeveLancarExcecao() {
        ReservaHotel reserva = new ReservaHotel("maria", 2, 150.0
        );

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class, () -> reserva.confirmar("   "));
        assertEquals("O código de confirmação é obrigatório.", excecao.getMessage());
    }

    @Test
    void confirmarDuasVezesDeveLancarExcecao() {
        ReservaHotel reserva = new ReservaHotel("fernanda", 5,
                220.0);
        reserva.confirmar("2026-01");

        IllegalStateException excecao = assertThrows(
                IllegalStateException.class, () -> reserva.confirmar("2026-01"));

        assertAll(
                () -> assertEquals("A reserva já está confirmada.",
                        excecao.getMessage()),
                () -> assertEquals(
                        "2026-01",
                        reserva.getCodigoConfirmacao()));
    }
}
