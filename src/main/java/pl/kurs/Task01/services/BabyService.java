package pl.kurs.Task01.services;

import pl.kurs.Task01.models.Baby;
import pl.kurs.Task01.models.Day;
import pl.kurs.Task01.models.Mother;
import pl.kurs.Task01.models.Sex;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BabyService {

    public static Mother createMotherFromString(String line) {
        String[] propertiesArray = line.split(" ");

        return new Mother(
                Integer.parseInt(propertiesArray[0]),
                propertiesArray[1],
                Integer.parseInt(propertiesArray[2]));

    }

    public static int countLineInFiles(File file) {
        int lineCounter = 0;
        try (
                Scanner scanner = new Scanner(file)
        ) {
            if (scanner.hasNext())

                while (scanner.hasNext()) {
                    lineCounter++;
                    scanner.nextLine();
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lineCounter;
    }

    public static Baby createBabyFromString(String line, Mother[] mothersArray) {
        String[] propertiesArray = line.split(" ");

        Baby baby = new Baby(
                Integer.parseInt(propertiesArray[0]),
                setSex(propertiesArray[1]),
                propertiesArray[2],
                LocalDate.parse((propertiesArray[3])),
                Integer.parseInt(propertiesArray[4]),
                Integer.parseInt(propertiesArray[5]),
                setMother(Integer.parseInt(propertiesArray[6]), mothersArray)
        );
        baby.getMother().addBabies(baby);
        return baby;

    }

    private static Sex setSex(String sex) {
        Sex babySex = null;
        if (sex.equals("c")) {
            babySex = Sex.DAUGHTER;
        } else if (sex.equals("s")) {
            babySex = Sex.SON;
        } else {
            System.out.println("błędne dane");
        }

        return babySex;
    }

    private static Mother setMother(int motherId, Mother[] mothers) {
        Mother mother = null;
        for (Mother mother1 : mothers) {
            if (motherId == mother1.getMotherId()) {
                mother = mother1;
            }

        }

        return mother;
    }


        public static int countLineInBabyFiles(File file) {
        int lineBabyCounter = 0;
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Windows-1252"))
        ) {

            while ((br.readLine()) != null) {
               lineBabyCounter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineBabyCounter;
    }

    public static Mother[] getMothersArray(File file) {
        Mother[] array = new Mother[countLineInFiles(file)];
        int index = 0;

        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                array[index++] = createMotherFromString(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;

    }

    public static Baby[] getBabiesArray(File file, Mother[] mothersArray) {
        Baby[] babies = new Baby[countLineInBabyFiles(file)];
        int index = 0;

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Windows-1252"))

        ) {
            String line;
            while ((line = br.readLine()) != null) {
                babies[index++] = createBabyFromString(line, mothersArray);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return babies;
    }




    public static Baby[] getBoysArray(Baby[] babies) {
        int index = 0;
        for (Baby baby : babies) {
            if (baby.getSex() == Sex.SON) {
                index++;
            }
        }
        Baby[] boysArray = new Baby[index];
        int i = 0;
        for (Baby baby : babies) {
            if (baby.getSex() == Sex.SON) {
                boysArray[i++] = baby;

            }

        }
        return boysArray;
    }

    public static Baby[] getGirlsArray(Baby[] babies) {
        int index = 0;
        for (Baby baby : babies) {
            if (baby.getSex() == Sex.DAUGHTER) {
                index++;
            }
        }
        Baby[] girlsArray = new Baby[index];
        int i = 0;
        for (Baby baby : babies) {
            if (baby.getSex() == Sex.DAUGHTER) {
                girlsArray[i++] = baby;

            }

        }
        return girlsArray;
    }

    public static Baby getHighestGirl(Baby[] babies) {
        Baby highestGirl = getGirlsArray(babies)[0];

        for (Baby baby : getGirlsArray(babies)) {
            if (highestGirl.getGrowthInCentimeters() < baby.getGrowthInCentimeters()) {
                highestGirl = baby;
            }
        }
        return highestGirl;

    }

    public static Baby getHighestBoy(Baby[] babies) {
        Baby highestBoy = getBoysArray(babies)[0];

        for (Baby baby : getBoysArray(babies)) {
            if (highestBoy.getGrowthInCentimeters() < baby.getGrowthInCentimeters()) {
                highestBoy = baby;
            }
        }
        return highestBoy;
    }

    public static Day getDayWithMostBornBabies(Baby[] babies) {

        Day[] dayOfWeeks = {
                new Day(DayOfWeek.MONDAY, 0),
                new Day(DayOfWeek.TUESDAY, 0),
                new Day(DayOfWeek.WEDNESDAY, 0),
                new Day(DayOfWeek.THURSDAY, 0),
                new Day(DayOfWeek.FRIDAY, 0),
                new Day(DayOfWeek.SATURDAY, 0),
                new Day(DayOfWeek.SUNDAY, 0),
        };


        for (Baby baby : babies) {
            switch (baby.getDateOfBirth().getDayOfWeek()) {
                case MONDAY -> dayOfWeeks[0].setCounter();
                case TUESDAY -> dayOfWeeks[1].setCounter();
                case WEDNESDAY -> dayOfWeeks[2].setCounter();
                case THURSDAY -> dayOfWeeks[3].setCounter();
                case FRIDAY -> dayOfWeeks[4].setCounter();
                case SATURDAY -> dayOfWeeks[5].setCounter();
                case SUNDAY -> dayOfWeeks[6].setCounter();
            }

        }

        Day dayWithHighestBorn = dayOfWeeks[0];

        for (Day dayOfWeek : dayOfWeeks) {
            if (dayOfWeek.getCounter() > dayWithHighestBorn.getCounter()) {
                dayWithHighestBorn = dayOfWeek;
            }
        }
        return dayWithHighestBorn;
    }

    public static List<Mother> getWomanWhoHaveUnder25AndBornBabyHeavier4000(Baby[] babies) {
        List<Mother> mothers = new ArrayList<>();

        for (Baby baby : babies) {
            if (baby.getWeightInGrams() > 4000 && baby.getMother().getAge() < 25) {
                mothers.add(baby.getMother());
            }

        }
        return mothers;

    }


    public static List<Baby> getGirlsWhoHasTheSameNameAsMother(Baby[] babies) {
        Baby[] girlsArray = getGirlsArray(babies);
        List<Baby> girlsWithTheSameNameAsMother = new ArrayList<>();

        for (Baby baby : girlsArray) {
            if (baby.getName().equals(baby.getMother().getName())) {
                girlsWithTheSameNameAsMother.add(baby);
            }
        }
        return  girlsWithTheSameNameAsMother;
    }

    public static boolean isTwin(List<Baby> babies) {
        boolean isTwin = false;
        for (int i = 1; i < babies.size(); i++) {
            if (babies.get(i - 1).getDateOfBirth().isEqual(babies.get(i).getDateOfBirth())) {
                isTwin = true;
            }

        }


        return isTwin;
    }

    public static List<Mother> getMothersWhoBirthTwins(Mother[] mothers) {
        List<Mother> mothersOfTwins = new ArrayList<>();

        for (Mother mother : mothers) {
            if (mother.getBabies().size() >= 2 && isTwin(mother.getBabies())) {
                mothersOfTwins.add(mother);
            }
        }
        return mothersOfTwins;
    }

}