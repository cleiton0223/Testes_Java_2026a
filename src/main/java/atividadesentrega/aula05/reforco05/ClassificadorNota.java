package atividadesentrega.aula05.reforco05;

public class ClassificadorNota {


    public static String classificar(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
        }

        if (nota < 5.0) {
            return "REPROVADO";
        }

        if (nota < 7.0) {
            return "RECUPERACAO";
        }

        return "APROVADO";
    }
}
