package aula05.reforco05;
import atividadesentrega.aula05.reforco05.EntregaAtividade;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntregaAtividadeTest {

    @ParameterizedTest
    @CsvSource({
            "-5, false, NO_PRAZO",
            "-1, false, NO_PRAZO",
            "0, true, NO_PRAZO",
            "1, false, ATRASO_TOLERADO",
            "5, true, ATRASO_TOLERADO",
            "10, false, ATRASO_TOLERADO",
            "11, true, ANALISE_PROFESSOR",
            "11, false, ATRASADA",
            "30, true, ANALISE_PROFESSOR",
            "30, false, ATRASADA"
    })
    public void testVerificarEntrega(int minutosAtraso, boolean justificativa, String esperado) {
        String resultado = EntregaAtividade.verificar(minutosAtraso, justificativa);
        assertEquals(esperado, resultado);
    }
}