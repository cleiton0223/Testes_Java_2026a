package atividadesentrega.aula05.reforco05;

public class ValidadorUsuario {

    public static boolean nomeValido(String nome) {

        if (nome == null || nome.isBlank()) {
            return false;
        }

        return nome.length() >= 3;
    }
}
