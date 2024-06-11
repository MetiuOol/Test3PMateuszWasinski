package pl.kurs.Task03.services;

import pl.kurs.Task03.models.Person;
import pl.kurs.Task03.models.Sex;
import pl.kurs.Task04.models.Figura;

import java.io.*;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    public static void savePersonToFile(Person[] persons, String fileName) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)

        ) {
                oos.writeObject(persons);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Person[] openPersonFromFile(String fileName) {
        int index = 0;
        try (
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            index = ois.available();
            return (Person[]) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Person[index];
    }

    public static Person getPersonWithHighestIncome(Person[] personArray) {
        Person personWithHighestIncome = personArray[0];
        for (Person person : personArray) {
            if (person.getIncome() > personWithHighestIncome.getIncome()) {
                personWithHighestIncome = person;
            }

        }
        return personWithHighestIncome;
    }

    public static List<Person> getListOfWoman(Person[] personArray) {
        List<Person> womanList = new ArrayList<>();
        for (Person person : personArray) {
            if (person.getSex() == Sex.KOBIETA) {
                womanList.add(person);
            }

        }

        return womanList;
    }

    public static int getWomanNumber(Person[] personArray) {
        int womanNumber = 0;
        for (Person person : personArray) {
            if (person.getSex() == Sex.KOBIETA) {
                womanNumber++;
            }

        }
        return womanNumber;
    }

    public static Person[] getWomanArray(Person[] personArray) {
        Person[] womanArray = new Person[getWomanNumber(personArray)];
        for (int i = 0; i < womanArray.length;) {
            for (Person person : personArray) {
                if (person.getSex() == Sex.KOBIETA) {
                    womanArray[i++] = person;
                }
            }
        }
        return womanArray;
    }


}
