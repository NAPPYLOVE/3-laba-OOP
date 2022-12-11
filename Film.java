package com.company;

public class Film extends FilmIndustry {

    public Film (int id, int mark, int genre) {
        this.id = id;
        this.mark = mark;
        this.genre = genre;
    }

    public void print() {
        System.out.println("Film - Жанр " + this.genre + ": просмотрено " + this.n + ", средняя оценка " + (int) this.ar);
    }
}