package com.engeto.examples;

public class Hulka {
    private Integer poradi;
    private Fylozof fylozof;

    public Hulka(Integer poradi) {
        this.poradi = poradi;
        this.fylozof = null;
    }

    public synchronized Boolean nastavFylozofa(Fylozof fylozof) {
        if (this.fylozof == null) {
            this.fylozof = fylozof;
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }

    }

    public synchronized void uvolni()  {
        this.fylozof = null;
    }

}
