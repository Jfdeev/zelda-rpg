abstract class Entidade {
    protected String id;
    protected String nome;
    protected int nivel;
    protected int vidaMax, vidaAtual;
    public Entidade(String id, String nome, int nivel, int vida) {
        this.id = id; this.nome = nome; this.nivel = nivel;
        this.vidaMax = vida; this.vidaAtual = vida;
    }
    public boolean estaVivo() { return vidaAtual > 0; }
    public void receberDano(int dmg) {
        vidaAtual = Math.max(0, vidaAtual - dmg);
        System.out.println(nome + " recebeu " + dmg + " de dano. Vida atual: " + vidaAtual);
    }
    public void curar(int amt) {
        vidaAtual = Math.min(vidaMax, vidaAtual + amt);
        System.out.println(nome + " foi curado em " + amt + ". Vida atual: " + vidaAtual);
    }
    public String getNome() { return nome; }
}