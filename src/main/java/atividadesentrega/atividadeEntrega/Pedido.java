package atividadesentrega.atividadeEntrega;


public class Pedido {

    private final int id;
    private final double subtotal;
    private final String cep;
    private double total;

    public Pedido(int id, double subtotal, String cep) {
        this.id = id;
        this.subtotal = subtotal;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public String getCep() {
        return cep;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}