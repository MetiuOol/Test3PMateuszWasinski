package pl.kurs.Task04.models;


import pl.kurs.Task04.services.Ksztalt;

import java.io.Serializable;


public abstract class Figura implements Ksztalt, Serializable {

    private static int counter = 0;
    private int numerFigury;

    protected Figura() {
        this.numerFigury = 0;
    }


    public static Kolo stworzKolo(int srednica) {
        Kolo kolo = new Kolo((srednica /2));
        kolo.setNumerFigury();
        return kolo;
    }

    public static Kwadrat stworzKwadrat(int bok) {
        Kwadrat kwadrat = new Kwadrat(bok);
        kwadrat.setNumerFigury();
        return kwadrat;

    }
    public static Prostokat stworzProstokat(int bokA, int bokB) {
        Prostokat prostokat = new Prostokat(bokA, bokB);
        prostokat.setNumerFigury();
        return prostokat;

    }

    public void setNumerFigury() {
        this.numerFigury = ++counter;
    }



    @Override
    public String toString() {
        return "Figura nr " + numerFigury  + ":";
    }
}
