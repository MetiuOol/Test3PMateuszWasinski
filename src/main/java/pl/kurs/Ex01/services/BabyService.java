package pl.kurs.Ex01.services;

import pl.kurs.Ex01.models.Baby;
import pl.kurs.Ex01.models.Mother;
import pl.kurs.Ex01.models.Sex;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
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

    public static int countLineInBabyFiles(File file) {
        int lineBabyCounter = 0;
        try (
                Scanner scannerBaby = new Scanner(file)
        ) {
            if (scannerBaby.hasNext())

                while (scannerBaby.hasNext()) {
                    lineBabyCounter++;
                    scannerBaby.nextLine();
                }
        } catch (FileNotFoundException e) {
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
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)

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

    public static void printInfoAboutNameAndGrowthOfHighestGirlAndBoy(Baby[] babies) {
        Baby highestBoy = getBoysArray(babies)[0];
        Baby highestGirl = getGirlsArray(babies)[0];

        for (Baby baby : getBoysArray(babies)) {
            if (highestBoy.getGrowthInCentimeters() < baby.getGrowthInCentimeters()) {
                highestBoy = baby;
            }
        }

        for (Baby baby : getGirlsArray(babies)) {
            if (highestGirl.getGrowthInCentimeters() < baby.getGrowthInCentimeters()) {
                highestGirl = baby;
            }
        }
        System.out.println("Zad a):");
        System.out.println("  Najwyższy chłopieć to " + highestBoy.getName() + ", o wzroscie " + highestBoy.getGrowthInCentimeters() + " cm.");
        System.out.println("  Najwyższa dziewczynka to " + highestGirl.getName() + ", o wzroscie " + highestGirl.getGrowthInCentimeters() + " cm.");

    }

    public static void printInfoAboutDayOfWeekWithMostBornBabies(Baby[] babies) {

        class Day {
            private final DayOfWeek dayName;
            private int counter;

            public Day(DayOfWeek dayName, int counter) {
                this.dayName = dayName;
                this.counter = counter;
            }

            @Override
            public String toString() {
                return "Day{" +
                        "dayName=" + dayName +
                        ", counter=" + counter +
                        '}';
            }
        }

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
                case MONDAY -> dayOfWeeks[0].counter++;
                case TUESDAY -> dayOfWeeks[1].counter++;
                case WEDNESDAY -> dayOfWeeks[2].counter++;
                case THURSDAY -> dayOfWeeks[3].counter++;
                case FRIDAY -> dayOfWeeks[4].counter++;
                case SATURDAY -> dayOfWeeks[5].counter++;
                case SUNDAY -> dayOfWeeks[6].counter++;
            }

        }

        Day dayWithHighestBorn = dayOfWeeks[0];

        for (Day dayOfWeek : dayOfWeeks) {
            if (dayOfWeek.counter > dayWithHighestBorn.counter) {
                dayWithHighestBorn = dayOfWeek;
            }
        }
        System.out.println("Zad b)  Dzień z największą ilością urodzeń to:");
        System.out.println("   " + dayWithHighestBorn.dayName + ", urodziło się " + dayWithHighestBorn.counter + " dzieci.");


    }

    public static void printNameWomanWhoHaveUnder25AndBornBabyHeavier4000(Baby[] babies) {
        Mother[] mothers = new Mother[babies.length];
        int index = 0;

        for (Baby baby : babies) {
            if (baby.getWeightInGrams() > 4000 && baby.getMother().getAge() < 25) {
                mothers[index++] = baby.getMother();
            }

        }
        System.out.println("Zad c): Imiona kobiet poniżej 25 lat, które urodziły dzieci powyżej 4000 gram:");
        for (Mother mother : mothers) {
            if (mother != null) {
                System.out.println("   " + mother.getName());
            }

        }
    }



    public static void printNameAndDateOfBirthGirlsWhoHasTheSameNameAsMother(Baby[] babies) {
        Baby[] girlsArray = getGirlsArray(babies);
        Baby[] girlsArrayWithTheSameNameAsMother = new Baby[girlsArray.length];
        int index = 0;

        for (Baby baby : girlsArray) {
            if (baby.getName().equals(baby.getMother().getName())) {
                girlsArrayWithTheSameNameAsMother[index++] = baby;
            }
        }

        System.out.println("Zad d): Imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce:");
        for (Baby baby : girlsArrayWithTheSameNameAsMother) {
            if (baby != null) {
                System.out.println("   " + baby.getName() + ", urodzona: " + baby.getDateOfBirth());
            }

        }
    }
    public static boolean isTwin(List<Baby> babies){
        boolean isTwin = false;
        for (int i = 1; i < babies.size(); i++) {
            if (babies.get(i - 1).getDateOfBirth().isEqual(babies.get(i).getDateOfBirth())){
                isTwin = true;
            }

        }


        return isTwin;
    }

    public static Mother[] getMothersWhoBirthTwins(Mother[] mothers) {
        Mother[] mothersOfTwins = new Mother[mothers.length];
        int index = 0;


        for (Mother mother : mothers) {
            if (mother.getBabies().size() >= 2 && isTwin(mother.getBabies()))  {
                mothersOfTwins[index++] = mother;
            }

        }


        return mothersOfTwins;
    }


}