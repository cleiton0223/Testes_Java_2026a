package atividadesentrega.aula05.exercicios05;

public class CalculadoraPedido {

    private CalculadoraPedido() {
        throw new UnsupportedOperationException("Esta é uma classe utilitária e não pode ser instanciada.");
    }

    public static double calcular(Item item, int percentualCupom) {
        if (item == null) {
            throw new IllegalArgumentException("O item é obrigatório.");
        }
        if (item.nome() == null || item.nome().isBlank()) {
            throw new IllegalArgumentException("O nome do item é obrigatório.");
        }
        if (item.precoUnitario() <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        if (item.quantidade() <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        if (percentualCupom < 0 || percentualCupom > 30) {
            throw new IllegalArgumentException("O cupom deve estar entre 0 e 30.");
        }

        double subtotal = item.precoUnitario() * item.quantidade();

        return subtotal - (subtotal * (percentualCupom / 100.0));
    }
}