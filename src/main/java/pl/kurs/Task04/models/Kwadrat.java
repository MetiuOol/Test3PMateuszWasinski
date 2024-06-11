package pl.kurs.Task04.models;

import pl.kurs.Task04.services.Ksztalt;

import java.util.Objects;

public class Kwadrat extends Figura implements Ksztalt {
    private int bok;

    public Kwadrat(int bok) {
        super();
        this.bok = bok;
    }

    @Override
    public String toString() {
        return super.toString() + "Kwadrat o boku " + bok + ".";
    }

    @Override
    public double obliczPole() {
        return bok * bok;
    }

    @Override
    public double obliczObwod() {
        return 4 * bok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kwadrat kwadrat = (Kwadrat) o;
        return bok == kwadrat.bok;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bok);
    }
}
