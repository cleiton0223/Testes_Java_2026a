package atividadesentrega.aula04;

public class Retangulo {

    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("A base e a altura devem ser maiores que zero.");
        }
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return this.base * this.altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
}