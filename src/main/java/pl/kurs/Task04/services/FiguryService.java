package pl.kurs.Task04.services;

import pl.kurs.Task03.models.Person;
import pl.kurs.Task04.models.Figura;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FiguryService {

    public static Figura najwiekszePole(List<Figura> figury) {
        Figura figuraNajwiekszePole = null;
        if (!figury.isEmpty()) {
            figuraNajwiekszePole = figury.get(0);
            for (Figura f : figury) {
                if (f != null && figuraNajwiekszePole.obliczPole() < f.obliczPole()) {
                    figuraNajwiekszePole = f;
                }
            }
        }
        return figuraNajwiekszePole;
    }

    public static Figura najwiekszeObwod(List<Figura> figury) {
        Figura figuraNajwiekszyObwod = null;
        if (!figury.isEmpty()) {
            figuraNajwiekszyObwod = figury.get(0);
            for (Figura f : figury) {
                if (f != null && figuraNajwiekszyObwod.obliczObwod() < f.obliczObwod()) {
                    figuraNajwiekszyObwod = f;

                }
            }
        }
        return figuraNajwiekszyObwod;
    }

    public static void saveFigureToFile(List<Figura> figury, String fileName) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)

        ) {
                oos.writeObject(figury);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
@SuppressWarnings("unchecked")
    public static List<Figura> openFigureFromFile(String fileName) {
        try (
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            return (List<Figura>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
