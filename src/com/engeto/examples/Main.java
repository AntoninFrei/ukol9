package com.engeto.examples;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int pocet = 10;

        seznamHulek hulky = new seznamHulek();

        List<Hulka> hulky1 = new ArrayList<>();
        List<Thread> fylozofove = new ArrayList<>();
        for (int i=1; i <= pocet; i++) {
            System.out.println("cyklus " + i);
            hulky1.add(new Hulka(i));
            List<Integer> sousedniHulky = new ArrayList<>();
        }
        for (int i=1; i <= pocet; i++) {
            if (i == pocet) {
                //sousedniHulky.add(1);
                //Thread fylozof = new Thread(new Fylozof(i, hulky1.get(1), hulky1.get(i)));
                Hulka leva = hulky1.get(0);
                Hulka prava = hulky1.get(i-1);
                Thread fylozof = new Thread(new Fylozof(i, leva, prava));
                fylozofove.add(fylozof);
                fylozof.start();
            } else {
                //Thread fylozof = new Thread(new Fylozof(i, hulky1.get(i), hulky1.get(i+1)));
                //sousedniHulky.add(i+1);
                Hulka leva = hulky1.get(i-1);
                Hulka prava = hulky1.get(i);
                Thread fylozof = new Thread(new Fylozof(i, leva, prava));
                fylozofove.add(fylozof);
                fylozof.start();
            }








        }
        //Hulka xxx = hulky1.get(2);
        //System.out.println(xxx.getPoradi());
        //Thread fff = fylozofove.get(0);
        //fff.
        //Thread fylozof1 = new Thread(new Fylozof(1));
        //Thread fylozof2 = new Thread(new Fylozof(2));

        //fylozof1.start();
        //fylozof2.start();
    }
}
