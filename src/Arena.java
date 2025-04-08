import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Arena {
    private String idBatalha;
    private List<Entidade> participantes;
    private QueueCustom<Entidade> filaTurnos = new QueueCustom<>();
    private StackCustom<Entidade> pilhaHistorico = new StackCustom<>();
    public Arena(List<Entidade> participantes) {
        this.idBatalha = UUID.randomUUID().toString();
        this.participantes = participantes;
    }
    public void iniciarBatalha() {
        for (Entidade e : participantes) if (e.estaVivo()) filaTurnos.enqueue(e);
        System.out.println("Batalha iniciada com " + participantes.size() + " participantes.");
    }
    public void executarTurnos() {
        while (true) {
            Entidade atual = filaTurnos.dequeue();
            if (atual == null) break;
            if (!atual.estaVivo()) continue;
            // Simples ataque automático para monstro, prompt para jogador
            if (atual instanceof PersonagemJogador) {
                // atacar primeiro inimigo vivo
                Entidade alvo = participantes.stream().filter(e->e!=atual && e.estaVivo()).findFirst().orElse(null);
                if (alvo!=null) {
                    System.out.println(atual.getNome() + " ataca " + alvo.getNome());
                    alvo.receberDano(15);
                }
            } else if (atual instanceof Monstro) {
                Monstro m = (Monstro) atual;
                Entidade alvo = participantes.stream().filter(e->e!=m && e.estaVivo()).findFirst().orElse(null);
                if (alvo!=null) m.atacar(alvo);
            }
            if (!atual.estaVivo()) pilhaHistorico.push(atual);
            for (Entidade e : participantes) if (e.estaVivo()) filaTurnos.enqueue(e);
            // check winner
            List<Entidade> vivos = new ArrayList<>();
            for (Entidade e : participantes) if (e.estaVivo()) vivos.add(e);
            if (vivos.size() <= 1) {
                if (vivos.size()==1) pilhaHistorico.push(vivos.get(0));
                break;
            }
        }
        exibirRankingFinal();
    }
    public void exibirRankingFinal() {
        System.out.println("-- Ranking Final --");
        int pos = pilhaHistorico.toList().size();
        for (Entidade e : pilhaHistorico.toList()) {
            System.out.println(pos-- + ". " + e.getNome());
        }
    }
}