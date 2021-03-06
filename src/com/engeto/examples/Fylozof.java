package com.engeto.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Fylozof implements Runnable{
    private Integer poradi;
    private Integer porce = 0;
    private Integer celkemPorci = 1000;
    private List<Integer> sousedniHulky = new ArrayList<>();
    private Hulka levaHulka;
    private Hulka pravaHulka;

    public Fylozof(Integer poradi, Hulka levaHulka, Hulka pravaHulka)
    {
        this.poradi = poradi;
        this.levaHulka = levaHulka;
        this.pravaHulka = pravaHulka;
    }


    public Integer getPoradi() {
        return poradi;
    }


    @Override
    public void run() {
        int i = 0;
        while (porce < celkemPorci) {
            Boolean drzimLevou = levaHulka.nastavFylozofa(this);
            Boolean drzimPravou = false;
            if (drzimLevou) {
                drzimPravou = pravaHulka.nastavFylozofa(this);
            } else
            {
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if (drzimLevou) {
                if (drzimPravou) {
                    porce++;
                    System.out.println("Jsem fylozof " + poradi +" a jím porci " + porce);
                    pravaHulka.uvolniFylozofa();
                    levaHulka.uvolniFylozofa();
                } else {
                    levaHulka.uvolniFylozofa();
                    System.out.println("Jsem fylozof " + poradi +" a nemám volnou hůlku " + this.pravaHulka.getPoradi()
                            + ", tak pouštím hůlku " + this.levaHulka.getPoradi());
                }
            }





        }

    }





}
