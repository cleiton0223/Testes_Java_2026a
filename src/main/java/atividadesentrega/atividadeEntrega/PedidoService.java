package atividadesentrega.atividadeEntrega;

/**
 * Classe que vamos TESTAR. Ela depende de 3 colaboradores
 * (frete, repositório e notificador) que são substituídos por test doubles.
 */
public class PedidoService {

    private final CalculadoraFrete frete;
    private final PedidoRepository repositorio;
    private final Notificador notificador;

    public PedidoService(CalculadoraFrete frete, PedidoRepository repositorio, Notificador notificador) {
        this.frete = frete;
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    /** Usa apenas o frete. */
    public double calcularTotal(Pedido pedido) {
        return pedido.getSubtotal() + frete.calcular(pedido.getCep());
    }

    /** Valida, calcula o total, salva e avisa o cliente. */
    public Pedido finalizar(Pedido pedido) {
        if (pedido.getSubtotal() <= 0) {
            throw new IllegalArgumentException("Subtotal deve ser maior que zero");
        }
        pedido.setTotal(calcularTotal(pedido));
        repositorio.salvar(pedido);
        notificador.enviar("Pedido " + pedido.getId() + " finalizado");
        return pedido;
    }
}