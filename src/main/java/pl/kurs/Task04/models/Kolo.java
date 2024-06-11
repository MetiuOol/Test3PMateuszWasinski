package pl.kurs.Task04.models;


import pl.kurs.Task04.services.Ksztalt;

import java.util.Objects;

public class Kolo extends Figura implements Ksztalt {
    int promien;

    public Kolo(int promien) {
        super();
        this.promien = promien;
    }



    @Override
    public String toString() {
        return super.toString() + "Kolo o promieniu " + promien + ".";
    }


    @Override
    public double obliczPole() {
        return promien * promien * Math.PI;
    }

    @Override
    public double obliczObwod() {
        return 2 * promien * Math.PI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kolo kolo = (Kolo) o;
        return promien == kolo.promien;
    }

    @Override
    public int hashCode() {
        return Objects.hash(promien);
    }
}
