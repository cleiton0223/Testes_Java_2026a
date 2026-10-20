package atividadesentrega.atividadereforco;

/** Representa os dados de um usuário no exercício. */
public class Usuario {
    private final String nome;
    private final String login;


    public Usuario(String nome, String login) {
        // this identifica os atributos do objeto que está sendo criado.
        this.nome = nome;
        this.login = login;
    }
    public String getNome() { return nome; } // Consulta o nome armazenado.
    public String getLogin() { return login; } // Consulta o login armazenado.

}
