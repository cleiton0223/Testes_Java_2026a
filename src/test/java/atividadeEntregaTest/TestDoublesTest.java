package atividadeEntregaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import atividadesentrega.atividadeEntrega.CalculadoraFrete;
import atividadesentrega.atividadeEntrega.Notificador;
import atividadesentrega.atividadeEntrega.Pedido;
import atividadesentrega.atividadeEntrega.PedidoRepository;
import atividadesentrega.atividadeEntrega.PedidoService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TestDoublesTest {

    @Test
    void dummy_rejeitaPedidoComSubtotalZero() {
        // Os 3 dummies: existem só para preencher o construtor, ninguém os usa
        CalculadoraFrete freteDummy = null;
        PedidoRepository repositorioDummy = null;
        Notificador notificadorDummy = null;

        PedidoService service = new PedidoService(freteDummy, repositorioDummy, notificadorDummy);

        // Subtotal zero = pedido inválido
        Pedido pedido = new Pedido(1, 0.0, "89010-000");

        // A exceção é lançada na validação, antes de tocar em qualquer dummy
        assertThrows(IllegalArgumentException.class, () -> service.finalizar(pedido));
    }

    @Test
    void stub_calculaTotalSomandoSubtotalEFrete() {
        // Stub: qualquer que seja o CEP, a resposta é sempre 15.0
        CalculadoraFrete freteStub = cep -> 15.0;

        // Repositório e notificador não são usados em calcularTotal (null = dummies)
        PedidoService service = new PedidoService(freteStub, null, null);
        Pedido pedido = new Pedido(1, 100.0, "89010-000");

        double total = service.calcularTotal(pedido);

        // 100.0 (subtotal) + 15.0 (frete do stub)
        assertEquals(115.0, total);
    }

    @Test
    void fake_pedidoFinalizadoPodeSerBuscadoDepois() {
        // Fake: repositório funcional que guarda os pedidos na memória
        PedidoRepositoryEmMemoria repositorioFake = new PedidoRepositoryEmMemoria();

        // Frete fixo de 10.0 (só para o teste andar) e notificador que não faz nada
        PedidoService service = new PedidoService(cep -> 10.0, repositorioFake, mensagem -> { });

        service.finalizar(new Pedido(1, 100.0, "89010-000"));

        // Busca no fake para confirmar que o pedido foi realmente salvo
        Pedido salvo = repositorioFake.buscarPorId(1);
        assertNotNull(salvo);
        assertEquals(110.0, salvo.getTotal()); // 100.0 (subtotal) + 10.0 (frete)
    }

    @Test
    void spy_registraANotificacaoEnviadaAoFinalizar() {
        // Spy: vai anotar tudo o que o service mandar para o notificador
        NotificadorSpy notificadorSpy = new NotificadorSpy();
        PedidoService service = new PedidoService(cep -> 10.0, new PedidoRepositoryEmMemoria(), notificadorSpy);

        service.finalizar(new Pedido(1, 100.0, "89010-000"));

        // Depois de executar, "perguntamos" ao spy o que aconteceu
        assertEquals(1, notificadorSpy.getTotalDeChamadas());
        assertEquals("Pedido 1 finalizado", notificadorSpy.getMensagens().get(0));
    }

    @Test
    void mock_finalizarSalvaOPedidoENotificaUmaVez() {
        // O Mockito cria os mocks automaticamente a partir das interfaces
        PedidoRepository repositorioMock = mock(PedidoRepository.class);
        Notificador notificadorMock = mock(Notificador.class);
        PedidoService service = new PedidoService(cep -> 10.0, repositorioMock, notificadorMock);
        Pedido pedido = new Pedido(1, 100.0, "89010-000");

        service.finalizar(pedido);

        // Verificações de comportamento: quem foi chamado, quantas vezes, com o quê
        verify(repositorioMock).salvar(pedido);                           // salvou este pedido?
        verify(notificadorMock, times(1)).enviar("Pedido 1 finalizado");  // avisou exatamente 1 vez?
    }

    // Teste 5.2: caminho de erro. O pedido é inválido, então NADA deve ser chamado.
    @Test
    void mock_pedidoInvalidoNaoSalvaNemNotifica() {
        PedidoRepository repositorioMock = mock(PedidoRepository.class);
        Notificador notificadorMock = mock(Notificador.class);
        PedidoService service = new PedidoService(cep -> 10.0, repositorioMock, notificadorMock);

        // Subtotal zero = pedido inválido
        Pedido pedidoInvalido = new Pedido(2, 0.0, "89010-000");

        assertThrows(IllegalArgumentException.class, () -> service.finalizar(pedidoInvalido));

        // never(): o método NUNCA pode ter sido chamado
        verify(repositorioMock, never()).salvar(any());
        // verifyNoInteractions: nenhum método do notificador pode ter sido chamado
        verifyNoInteractions(notificadorMock);
    }


    static class PedidoRepositoryEmMemoria implements PedidoRepository {

        // "Banco de dados" falso: guarda os pedidos pelo id
        private final Map<Integer, Pedido> banco = new HashMap<>();

        @Override
        public void salvar(Pedido pedido) {
            banco.put(pedido.getId(), pedido);
        }

        @Override
        public Pedido buscarPorId(int id) {
            return banco.get(id);
        }
    }

    static class NotificadorSpy implements Notificador {

        // Lista com todas as mensagens que "foram enviadas"
        private final List<String> mensagens = new ArrayList<>();

        @Override
        public void enviar(String mensagem) {
            mensagens.add(mensagem); // não envia nada, só anota o que aconteceu
        }

        // Quantas vezes o notificador foi chamado
        public int getTotalDeChamadas() {
            return mensagens.size();
        }

        // Quais mensagens foram recebidas, na ordem
        public List<String> getMensagens() {
            return mensagens;
        }
    }
}