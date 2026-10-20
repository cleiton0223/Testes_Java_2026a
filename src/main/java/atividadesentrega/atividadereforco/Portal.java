package atividadesentrega.atividadereforco;

public class Portal {
    private final Usuario cadastrado = new Usuario("Ana", "ana");
    private Usuario usuarioLogado; // Começa null: ainda não existe sessão.

    public boolean entrar(String login, String senha) {
        // Uma nova tentativa encerra a sessão anterior, inclusive se falhar.
        usuarioLogado = null;
        // Credenciais fictícias fixas para estudar testes, sem banco de dados.
        // A constante antes do equals permite receber null sem lançar exceção.
        if ("ana".equals(login) && "1234".equals(senha)) {
            usuarioLogado = cadastrado;
            return true;
        }
        return false;
    }
    public Usuario getUsuarioLogado() {
        return usuarioLogado; // Devolve o objeto da sessão ou null.
    }
    public void sair() {
        usuarioLogado = null; // Remove a referência que representa a sessão.
    }
}

