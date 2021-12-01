package com.engeto.examples;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int pocet = 10;

        //seznamHulek hulky = new seznamHulek();

        List<Hulka> hulky1 = new ArrayList<>();
        List<Thread> fylozofove = new ArrayList<>();
        for (int i=1; i <= pocet; i++) {
            hulky1.add(new Hulka(i));
        }
        Hulka leva;
        Hulka prava;
        for (int i=1; i <= pocet; i++) {
            if (i == pocet) {
                leva = hulky1.get(0);
                prava = hulky1.get(i-1);
            } else {

                leva = hulky1.get(i-1);
                prava = hulky1.get(i);

            }
            Thread fylozof = new Thread(new Fylozof(i, leva, prava));
            fylozofove.add(fylozof);
            fylozof.start();


        }

    }
}
