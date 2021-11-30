package com.engeto.examples;

import java.util.ArrayList;
import java.util.List;

public class Fylozof implements Runnable{
    private Integer poradi;
    private Integer porce = 0;
    private Integer celkemPorci = 100;
    private List<Integer> sousedniHulky = new ArrayList<>();

    public Fylozof(Integer poradi, List sousedniHulky)
    {
        this.poradi = poradi;
        this.sousedniHulky = sousedniHulky;
    }

    @Override
    public void run() {
        for (int i = 0; i < celkemPorci; i++) {
            porce++;
            System.out.println("Jsem fylozof " + poradi +" a jím porci " + porce);
        }

    }



}
