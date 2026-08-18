package atividadesentrega.aula04;

public class Circulo {

    private double raio;

    public Circulo(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("O raio deve ser maior que zero.");
        }
        this.raio = raio;
    }

    public double calcularAreaa() {
        return Math.PI * Math.pow(this.raio, 2);
    }

    public boolean maiorQueDez() {
        return this.raio > 10;
    }

    public double getRaio() {
        return raio;
    }
}