package com.engeto.examples;

public class Hulka {
    public static Object SimpleLock;
    private Integer poradi;
    private Fylozof fylozof;

    public Hulka(Integer poradi) {
        this.poradi = poradi;
        this.fylozof = null;
    }

    public synchronized Boolean nastavFylozofa(Fylozof fylozof) {
        if (this.fylozof == null) {
            this.fylozof = fylozof;
            System.out.println("Jsem fylozof " + fylozof.getPoradi() +" a beru si hulku " + this.poradi);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }

    }

    public synchronized void uvolniFylozofa() {
        this.fylozof = null;
    }

    public Integer getPoradi() {
        return poradi;
    }

    public synchronized void uvolni()  {
        this.fylozof = null;
    }


    public class SimpleLock {

        private boolean isLocked = false;

        public synchronized void lock() throws InterruptedException {
            while (isLocked) {
                wait();
            }
            isLocked = true;
        }

        public synchronized void unlock() {
            isLocked = false;
            notify();
        }

    }

}
