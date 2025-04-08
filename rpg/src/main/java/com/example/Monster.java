package com.example;
class Monstro extends Entidade {
    public Monstro(String id, String nome, int nivel) {
        super(id, nome, nivel, 80 + nivel*20);
    }
    public void atacar(Entidade alvo) {
        int dmg = 10 + nivel * 2;
        alvo.receberDano(dmg);
    }
}