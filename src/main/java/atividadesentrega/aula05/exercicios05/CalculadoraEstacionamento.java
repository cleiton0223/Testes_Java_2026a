package atividadesentrega.aula05.exercicios05;

public class CalculadoraEstacionamento {

    private int horas;
    private boolean fimDeSemana;

    public CalculadoraEstacionamento(int horas, boolean fimDeSemana) {
        this.horas = horas;
        this.fimDeSemana = fimDeSemana;
    }

    public CalculadoraEstacionamento() {

    }

    public double calcular(int horas, boolean fimDeSemana) {

        // 1. Validação de fronteira (1 a 24 horas)
        if (horas < 1 || horas > 24) {
            throw new IllegalArgumentException("A permanência deve estar entre 1 e 24 horas.");
        }

        double valorTotal;

        // 2. Regra da primeira hora
        if (horas == 1) {
            valorTotal = 5.00;
        } else {
            // 3. Regra das horas adicionais
            valorTotal = 5.00 + (horas - 1) * 3.00;
        }

        // 4. Regra do fim de semana (acréscimo de 20%)
        if (fimDeSemana) {
            valorTotal += valorTotal * 0.20;
        }

        return valorTotal;
    }
}