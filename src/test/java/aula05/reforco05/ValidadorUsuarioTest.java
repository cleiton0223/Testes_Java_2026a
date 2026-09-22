package aula05.reforco05;

import atividadesentrega.aula05.reforco05.ValidadorUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorUsuarioTest {


    @ParameterizedTest
    @ValueSource(strings = {"ana", "carlos", "maria", "joao123", "usuario"})
    public void validarNome(String nome){
        assertTrue(ValidadorUsuario.nomeValido(nome));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    public void validarNomesAusentesEEspacos(String nome) {
        assertFalse(ValidadorUsuario.nomeValido(nome));
    }
    @DisplayName("Nomes nulos ou vazios devem ser rejeitados")
    @ParameterizedTest(name = "Ausência de valor: {0}")
    @NullAndEmptySource
    void valoresAusentesDevemRetornaFalso(String nome){
        assertFalse(ValidadorUsuario.nomeValido(nome));
    }

}

