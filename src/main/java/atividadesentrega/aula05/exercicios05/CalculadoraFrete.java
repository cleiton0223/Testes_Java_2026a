package atividadesentrega.aula05.exercicios05;

public final class CalculadoraFrete {

    private CalculadoraFrete() { }


    public static double calcular(double pesoKg, boolean entregaExpressa) {
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }

        double valorBase = 8.0 + (2.0 * pesoKg);

        // Se entregaExpressa for true, aplica acréscimo de 50% (* 1.5)
        if (entregaExpressa) {
            return valorBase * 1.5;
        }

        return valorBase;
    }
}