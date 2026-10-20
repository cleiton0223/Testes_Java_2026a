package atividadesentrega.atividadereforco;


/** Operações pequenas: o aluno pode prever cada resultado antes de testar. */
public class Calculadora {
    public int somar(int a, int b) {
        // Devolve a soma para que o teste possa compará-la com o esperado.
        return a + b;
    }
    public double dividir(double a, double b) {
        // A regra desta calculadora proíbe divisão por zero explicitamente.
        if (b == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return a / b;
    }
    public int multiplicar(int a, int b) {
        return a * b;
    }
    public int subtrair(int a,int b){
        return a - b;
    }
    public boolean ehPar(int numero) {
        // % calcula o resto. Resto zero na divisão por 2 indica número par.
        return numero % 2 == 0;
    }
    public int[] gerarSequencia() {
        // Extensão opcional: devolve um novo array com três posições.
        return new int[] {1, 2, 3};
    }
}

