package pl.kurs.Task01.app;

import pl.kurs.Task01.models.Baby;
import pl.kurs.Task01.models.Mother;
import pl.kurs.Task01.services.BabyService;

import java.io.File;
import java.util.List;

public class Task01Runner {
    public static void main(String[] args) {
        File fileMothers = new File("C:\\Users\\MATEUSZ\\IdeaProjects\\Test3P\\mamy.txt");
        File fileBabies = new File("C:\\Users\\MATEUSZ\\IdeaProjects\\Test3P\\noworodki.txt");
        Mother[] mothersArray = BabyService.getMothersArray(fileMothers);
//        for (Mother mother : mothersArray) {
//            System.out.println(mother);
//
//        }
        Baby[] babiesArray = BabyService.getBabiesArray(fileBabies, mothersArray);
//        for (Baby baby : babiesArray) {
//            System.out.println(baby);
//        }
//        for (Mother mother : mothersArray) {
//            System.out.println(mother);

//        }
        System.out.println("Zad a)");
        System.out.println("  Najwyższy chłopieć to " + BabyService.getHighestBoy(babiesArray).getName() + ", o wzroscie " + BabyService.getHighestBoy(babiesArray).getGrowthInCentimeters() + " cm.");
        System.out.println("  Najwyższa dziewczynka to " + BabyService.getHighestGirl(babiesArray).getName() + ", o wzroscie " + BabyService.getHighestGirl(babiesArray).getGrowthInCentimeters() + " cm.");

        System.out.println("Zad b)  Dzień z największą ilością urodzeń to:");
        System.out.println("   " + BabyService.getDayWithMostBornBabies(babiesArray).getDayName() + ", urodziło się " + BabyService.getDayWithMostBornBabies(babiesArray).getCounter() + " dzieci.");


        System.out.println("Zad c) Imiona kobiet poniżej 25lat, które urodziły dzieci powyżej 4000 gram:");
        for (Mother mother : BabyService.getWomanWhoHaveUnder25AndBornBabyHeavier4000(babiesArray)) {
            System.out.println(" " + mother.getName());
        }
        System.out.println("Zad d) Imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce:");
        for (Baby girl : BabyService.getGirlsWhoHasTheSameNameAsMother(babiesArray)) {
            System.out.println(" " + girl.getName() + ", urodzona: " + girl.getDateOfBirth());
        }

        System.out.println("Zad e) Matki które urodziły bliźnięta:");
//        System.out.println(BabyService.getMothersWhoBirthTwins(mothersArray));
        for (Mother motherOfTwins : BabyService.getMothersWhoBirthTwins(mothersArray)) {
            System.out.println("   " + motherOfTwins);
        }
    }
}



