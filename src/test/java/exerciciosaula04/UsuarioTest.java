package exerciciosaula04;

import atividadesentrega.aula04.exercicios04.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UsuarioTest {

    @Test
    void usuarioRecemCriadoDeveTerDadosEEstadoInicialCorretos() {
        // Arrange  Act
        Usuario usuario = new Usuario(
                "maria",
                "maria@gmail.com"
        );

        // Assert
        assertAll(
                () -> assertEquals("maria", usuario.getNome()),
                () -> assertEquals(
                        "maria@gmail.com",
                        usuario.getEmail()
                ),
                () -> assertNull(usuario.getTelefone()),
                () -> assertTrue(usuario.isAtivo())
        );
    }

    @Test
    void definirTelefoneDeveArmazenarValorInformado() {
        // Arrange
        Usuario usuario = new Usuario(
                "maria",
                "maria@gmail.com"
        );

        // Act
        usuario.definirTelefone("(47) 988573944");

        // Assert
        assertAll(
                () -> assertNotNull(usuario.getTelefone()),
                () -> assertEquals(
                        "(47) 988573944",
                        usuario.getTelefone()
                )
        );
    }

    @Test
    void telefoneNuloDeveLancarExcecao() {
        Usuario usuario = new Usuario(
                "maria",
                "maria@gmail.com"
        );

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> usuario.definirTelefone(null)
        );

        assertEquals(
                "O telefone é obrigatório.",
                excecao.getMessage()
        );
    }

    @Test
    void telefoneEmBrancoDeveLancarExcecao() {
        Usuario usuario = new Usuario(
                "maria",
                "maria@gmail.com"
        );

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> usuario.definirTelefone("   ")
        );

        assertEquals(
                "O telefone é obrigatório.",
                excecao.getMessage()
        );
    }

    @Test
    void desativarDeveAlterarEstadoParaInativo() {
        // Arrange
        Usuario usuario = new Usuario(
                "maria",
                "maria@gmail.com"
        );

        // Act
        usuario.desativar();

        // Assert
        assertFalse(usuario.isAtivo());
    }
}
