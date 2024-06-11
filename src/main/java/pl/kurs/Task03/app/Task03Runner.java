package pl.kurs.Task03.app;

import pl.kurs.Task03.models.Employee;
import pl.kurs.Task03.models.Person;
import pl.kurs.Task03.models.Sex;
import pl.kurs.Task03.models.Student;
import pl.kurs.Task03.services.PersonService;

import java.util.Arrays;

public class Task03Runner {
    public static void main(String[] args) {
        Person p1 = new Employee("Mateusz", "Wąsiński", "88061307712", "Olesno", "Przedsiebiorca", 10_000);
        Person p2 = new Student("Patryk", "Wachowski", "91021212614", "Opole", "grupa A", 1000);
        Person p3 = new Student("Ania", "Nowak", "94052701820", "Czestochowa", "grupa B", 2500);
        Person p4 = new Employee("Sylwia", "Ogorek", "64071203620", "Warszawa", "Szef kuchni", 6500);
        Person p5 = new Student("Jan", "Kowalski", "99011707432", "Gdansk", "grupa C", 500);
        Person p6 = new Employee("Karolina", "Fraczyk", "58030507444", "Wroclaw", "Ekspedientka", 4500);
        Person p7 = new Employee("Tomasz", "Jerzyk", "87061007434", "Krzepice", "Kierowca", 7000);
        Person p8 = new Employee("Amadeusz", "Piatek", "68021201830", "Katowice", "Księgowy", 8400);
        Person p9 = new Student("Sabina", "Golab", "99031403880", "Klobuck", "grupa D", 2400);
        Person p10 = new Student("Klaudia", "Czupryna", "98031808664", "Kluczbork", "grupa E", 1300);


        Person[] personArray = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};

        PersonService.savePersonToFile(personArray, "osoby");
        for (Person osoby : PersonService.openPersonFromFile("osoby")) {
            System.out.println(osoby);

        }
        System.out.println("Zad a)");
        System.out.println(" Osoba z największym dochodem:");
        System.out.println(" " + PersonService.getPersonWithHighestIncome(personArray));

        System.out.println("Zad b)");
        System.out.println(" Lista kobiet:");
        for (Person person : PersonService.getListOfWoman(personArray)) {
            System.out.println(" " + person);

        }

    }
}
