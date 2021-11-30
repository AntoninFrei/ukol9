package com.engeto.examples;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int pocet = 10;

        List<Hulka> hulky = new ArrayList<>();
        List<Thread> fylozofove = new ArrayList<>();
        for (int i=1; i <= pocet; i++) {
            System.out.println("cyklus " + i);
            hulky.add(new Hulka(i));
            List<Integer> sousedniHulky = new ArrayList<>();
            if (i == pocet) {
                sousedniHulky.add(1);
                sousedniHulky.add(i);
            } else {
                sousedniHulky.add(i);
                sousedniHulky.add(i+1);
            }

            Thread fylozof = new Thread(new Fylozof(i, sousedniHulky));
            fylozofove.add(fylozof);
            fylozof.start();



        }

        //Thread fylozof1 = new Thread(new Fylozof(1));
        //Thread fylozof2 = new Thread(new Fylozof(2));

        //fylozof1.start();
        //fylozof2.start();
    }
}
