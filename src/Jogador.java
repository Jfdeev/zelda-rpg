import java.util.List;
import java.util.UUID;

class Jogador {
    private String id, nome, senha;
    private int saldoMoedas;
    private LinkedListCustom<PersonagemJogador> personagens = new LinkedListCustom<>();
    public Jogador(String id, String nome, String senha) {
        this.id = id; this.nome = nome; this.senha = senha; this.saldoMoedas = 100;
    }
    public boolean autenticar(String senha) { return this.senha.equals(senha); }
    public void criarPersonagem(String nomeChar) {
        String pid = UUID.randomUUID().toString();
        personagens.add(new PersonagemJogador(pid, nomeChar));
    }
    public List<PersonagemJogador> getPersonagens() { return personagens.toList(); }
}
