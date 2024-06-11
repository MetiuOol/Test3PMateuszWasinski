package pl.kurs.Task04.models;

import pl.kurs.Task04.services.Ksztalt;

import java.util.Objects;

public class Prostokat extends Figura implements Ksztalt {
    private int bokA;
    private int bokB;

    public Prostokat(int bokA, int bokB) {
        super();
        this.bokA = bokA;
        this.bokB = bokB;
    }

    @Override
    public String toString() {
        return super.toString() + "Prostokat o bokach " + bokA + "x" + bokB + ".";
    }

    @Override
    public double obliczPole() {
        return bokA * bokB;
    }

    @Override
    public double obliczObwod() {
        return (2 * bokA) + (2 * bokB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prostokat prostokat = (Prostokat) o;
        return bokA == prostokat.bokA && bokB == prostokat.bokB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bokA, bokB);
    }
}
