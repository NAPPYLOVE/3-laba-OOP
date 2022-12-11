package com.company;

public class Game implements Info {

    public int id;
    public int mark;
    public int genre;
    public int n;
    public float ar;

    public Game (int id, int mark, int genre) {
        this.id = id;
        this.mark = mark;
        this.genre = genre;
    }

    public void print() {
        System.out.println("Game - Жанр " + this.genre + ": Количество проданных копий " + this.n + ", средняя оценка " + (int) this.ar);
    }
}