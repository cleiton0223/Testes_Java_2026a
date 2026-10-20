package aulareforco;

import atividadesentrega.atividadereforco.Portal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PortalTest {



    @Test
    void cadastroCorretoUsuarioCadastrado(){

        Portal portal = new Portal();

        boolean retorno = portal.entrar("ana","1234");

        assertTrue(retorno);
    }

}
