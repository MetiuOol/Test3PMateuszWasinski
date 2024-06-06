package pl.kurs.Task01.app;

import pl.kurs.Task01.models.Baby;
import pl.kurs.Task01.models.Mother;
import pl.kurs.Task01.services.BabyService;

import java.io.File;

public class Ex01Runner {
    public static void main(String[] args) {
        File fileMothers = new File("C:\\Users\\MATEUSZ\\IdeaProjects\\Test3P\\mamy.txt");
        File fileBabies = new File("C:\\Users\\MATEUSZ\\IdeaProjects\\Test3P\\babies.txt");
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
//
//        }
        BabyService.printInfoAboutNameAndGrowthOfHighestGirlAndBoy(babiesArray);
        BabyService.printInfoAboutDayOfWeekWithMostBornBabies(babiesArray);
        BabyService.printNameWomanWhoHaveUnder25AndBornBabyHeavier4000(babiesArray);
        BabyService.printNameAndDateOfBirthGirlsWhoHasTheSameNameAsMother(babiesArray);
        System.out.println("Zad e): Matki które urodziły bliźnięta:");
        for (Mother motherOfTwins : BabyService.getMothersWhoBirthTwins(mothersArray)) {
            if (motherOfTwins != null) {
                System.out.println("   " + motherOfTwins);
            }
        }
    }
}
