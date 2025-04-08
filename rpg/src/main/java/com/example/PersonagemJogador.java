package com.example;
class PersonagemJogador extends Entidade {
    private int manaMax, manaAtual;
    public PersonagemJogador(String id, String nome) {
        super(id, nome, 1, 100);
        this.manaMax = 50; this.manaAtual = 50;
    }
    public void usarHabilidade(Habilidade h, Entidade alvo) {
        if (manaAtual >= h.getCustoMana()) {
            manaAtual -= h.getCustoMana();
            h.usar(this, alvo);
        } else System.out.println("Mana insuficiente!");
    }
}