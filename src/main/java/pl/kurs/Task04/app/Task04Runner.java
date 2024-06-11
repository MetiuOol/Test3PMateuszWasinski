package pl.kurs.Task04.app;

import pl.kurs.Task04.models.Figura;
import pl.kurs.Task04.models.Kolo;
import pl.kurs.Task04.models.Kwadrat;
import pl.kurs.Task04.models.Prostokat;
import pl.kurs.Task04.services.FiguryService;

import java.util.Arrays;
import java.util.List;

public class Task04Runner {
    public static void main(String[] args) {
        List<Figura> figury = Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10, 20));
        for (Figura f : figury) {
            System.out.println(f);
        }

        System.out.println("Zad b)");
        System.out.println(" Figura z nawiększym obwodem to:");
        System.out.println("  " + FiguryService.najwiekszeObwod(figury).toString());
        System.out.println(" Figura z nawiększym polem to:");
        System.out.println("  " + FiguryService.najwiekszePole(figury).toString());

        System.out.println("Zad c)");
        System.out.println("  " + figury.contains(new Kwadrat(10)));

        FiguryService.saveFigureToFile(figury, "figury");
        for (Figura figura : FiguryService.openFigureFromFile("figury")) {
            System.out.println(figura);
        }





    }





}
