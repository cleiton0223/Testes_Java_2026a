package atividadesentrega.atividadeEntrega;


public interface PedidoRepository {
    void salvar(Pedido pedido);

    Pedido buscarPorId(int id);
}