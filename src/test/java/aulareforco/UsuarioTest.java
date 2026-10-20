package aulareforco;

import atividadesentrega.atividadereforco.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    @Test
    void nomeCorreto(){

        Usuario usuario = new Usuario("maria","maria@maria");

        assertEquals("maria",usuario.getNome());

        assertEquals("maria@maria",usuario.getLogin());



    }
}
