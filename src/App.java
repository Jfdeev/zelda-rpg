
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;

public class App {
    private static Map<String, Jogador> jogadores = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao RPG Turn-Based");
        Jogador user = loginFlow();

        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Criar Personagem");
            System.out.println("2. Listar Personagens");
            System.out.println("3. Iniciar Batalha PvE");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.print("Digite nome do novo personagem: ");
                    String nomeChar = sc.nextLine();
                    user.criarPersonagem(nomeChar);
                    break;
                case 2:
                    List<PersonagemJogador> personagens = user.getPersonagens();
                    if (personagens.isEmpty()) System.out.println("Nenhum personagem criado.");
                    else {
                        for (int i = 0; i < personagens.size(); i++) {
                            System.out.println((i + 1) + ". " + personagens.get(i).getNome());
                        }
                    }
                    break;
                case 3:
                    List<PersonagemJogador> chars = user.getPersonagens();
                    if (chars.isEmpty()) {
                        System.out.println("Você precisa criar um personagem antes.");
                        break;
                    }
                    PersonagemJogador pc = chars.get(0); // usar o primeiro
                    Monstro m1 = new Monstro("m1", "Goblin", 1);
                    Monstro m2 = new Monstro("m2", "Orc", 2);
                    List<Entidade> participantes = new ArrayList<>();
                    participantes.add(pc);
                    participantes.add(m1);
                    participantes.add(m2);
                    Arena arena = new Arena(participantes);
                    arena.iniciarBatalha();
                    arena.executarTurnos();
                    break;
                case 0:
                    System.out.println("Saindo do jogo. Até a próxima!");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static Jogador loginFlow() {
        System.out.print("Digite nome: "); String nome = sc.nextLine();
        System.out.print("Digite senha: "); String senha = sc.nextLine();
        Jogador j = jogadores.get(nome);
        if (j != null && j.autenticar(senha)) return j;
        System.out.println("Criando nova conta...");
        j = new Jogador(UUID.randomUUID().toString(), nome, senha);
        jogadores.put(nome, j);
        return j;
    }
}