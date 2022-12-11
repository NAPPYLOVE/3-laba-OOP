package com.company;

public class Serial extends FilmIndustry {

    public Serial(int id, int mark, int genre, int series) {
        this.id = id;
        this.mark = mark;
        this.genre = genre;
        this.series = series;
    }

    public void print() {
        System.out.println("Serial - Жанр "+this.genre +": просмотрено "+ this.n +", средняя оценка "+(int)this.ar +", общее количество серий "+(int)this.s);
    }
}