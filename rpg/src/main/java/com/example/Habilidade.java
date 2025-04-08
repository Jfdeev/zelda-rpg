package com.example;
class Habilidade {
    private String nome;
    private int custoMana;
    private int dano;
    public Habilidade(String nome, int custoMana, int dano) {
        this.nome = nome; this.custoMana = custoMana; this.dano = dano;
    }
    public int getCustoMana() { return custoMana; }
    public void usar(Entidade usuario, Entidade alvo) {
        System.out.println(usuario.getNome() + " usa " + nome + " em " + alvo.getNome());
        alvo.receberDano(dano);
    }
}