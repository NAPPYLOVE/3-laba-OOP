package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n_f = 6, n_s = 5, n_g = 4;

        FilmIndustry[] film = new FilmIndustry[n_f + n_s];
        film[0] = new Film(1, 5, 1);
        film[1] = new Film(5, 3, 1);
        film[2] = new Film(17, 4, 2);
        film[3] = new Film(31, 3, 4);
        film[4] = new Film(40, 1, 1);
        film[5] = new Film(45, 5, 2);
        film[6] = new Serial(40, 5, 2, 10);
        film[7] = new Serial(12, 4, 4, 15);
        film[8] = new Serial(4, 5, 1, 6);
        film[9] = new Serial(9, 3, 4, 2);
        film[10] = new Serial(12, 4, 3, 10);

        Game[] game = new Game[n_g];
        game[0] = new Game(12,4,2);
        game[1] = new Game(4,2,4);
        game[2] = new Game(17,3,2);
        game[3] = new Game(45,1,1);

        ArrayList<Info> obj = new ArrayList<>();

        int max = 0, min, n = 0, t, q = n_f + n_s, h = 0, z = n_f;
        float ar = 0, s = 0;
        int[] myArray = new int[q];
        int[] myArray2 = new int[n_g];
        min = film[0].mark;

        for (int i = 0; i < q; i++) {
            ar = ar + film[i].mark;
            n++;
            if (film[i].mark > max)
                max = film[i].mark;
            if (film[i].mark < min)
                min = film[i].mark;
            if (i == n_f - 1) {
                System.out.println();
                System.out.println("Статистика фильмов:");
                System.out.println("Средняя оценка = " + ar/n);
                System.out.println("Максимальная оценка = " + max);
                System.out.println("Минимальная оценка = " + min);
                System.out.println();
                ar = 0;
                n = 0;
                max = 0;
                min = film[i].mark;
            }
        }

        System.out.println("Статистика сериалов:");
        System.out.println("Средняя оценка = " + ar/n);
        System.out.println("Максимальная оценка = " + max);
        System.out.println("Минимальная оценка = " + min);
        System.out.println();

        min = game[0].mark;
        max = 0;
        n = 0;
        ar = 0;

        for (int i = 0; i < n_g; i++) {
            ar = ar + game[i].mark;
            n++;
            if (game[i].mark > max)
                max = game[i].mark;
            if (game[i].mark < min)
                min = game[i].mark;
        }

        System.out.println("Статистика игр:");
        System.out.println("Средняя оценка = " + ar/n);
        System.out.println("Максимальная оценка = " + max);
        System.out.println("Минимальная оценка = " + min);
        System.out.println();

        for (int i = 0; i < q; i++) {
            if (i == n_f) {
                h = n_f;
                z = z + n_s;
                System.out.println();
            }
            t = 0;
            for (int j = h; j < myArray.length; j++) {
                if (film[i].genre == myArray[j]) {
                    t = 1;
                    continue;
                }
            }
            if (t == 1) continue;
            ar = film[i].mark;
            s = film[i].series;
            n = 1;

            for (int j = i+1; j < z; j++) {
                if (film[i].genre == film[j].genre) {
                    n++;
                    ar = ar + film[j].mark;
                    s = s + film[j].series;
                    myArray[i] = film[i].genre;
                }
            }

            ar = ar/n;

            film[i].ar = ar;
            film[i].s = s;
            film[i].n = n;

            obj.add(film[i]);
        }

        for (int i = 0; i < n_g; i++) {
            t = 0;
            for (int j = 0; j < myArray2.length; j++) {
                if (game[i].genre == myArray2[j]) {
                    t = 1;
                    continue;
                }
            }
            if (t == 1) continue;
            ar = game[i].mark;
            n = 1;

            for (int j = i+1; j < n_g; j++) {
                if (game[i].genre == game[j].genre) {
                    n++;
                    ar = ar + game[j].mark;
                    myArray2[i] = game[i].genre;
                }
            }
            ar = ar/n;
            game[i].ar = ar;
            game[i].n = n;

            obj.add(game[i]);
        }

        for (int i = 0; i < obj.size(); i++) {
            obj.get(i).print();
        }
    }
}