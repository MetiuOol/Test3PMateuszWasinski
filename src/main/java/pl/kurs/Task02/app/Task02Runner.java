package pl.kurs.Task02.app;

import pl.kurs.Task02.models.Doctor;
import pl.kurs.Task02.models.Patient;
import pl.kurs.Task02.models.Visit;
import pl.kurs.Task02.services.VisitService;

import java.io.File;
import java.util.List;

public class Task02Runner {

    public static void main(String[] args) {
        File doctors = new File("C:\\Users\\MATEUSZ\\IdeaProjects\\Test3P\\lekarze.txt");
        File patients = new File("C:\\Users\\MATEUSZ\\IdeaProjects\\Test3P\\pacjenci.txt");
        File visits = new File("C:\\Users\\MATEUSZ\\IdeaProjects\\Test3P\\wizyty.txt");
        List<Doctor> doctorList = VisitService.getDoctorsList(doctors);
        List<Patient> patientList = VisitService.getPatientsList(patients);
        List<Visit> visitList = VisitService.getVisitsList(visits, doctorList, patientList);

//        for (Doctor doctor : VisitService.getDoctorsList(doctors)) {
//            System.out.println(doctor);
//        }
//
//        for (Patient patient : VisitService.getPatientsList(patients)) {
//            System.out.println(patient);
//        }
//
//        for (Visit visit : VisitService.getVisitsList(visits, doctorList, patientList)) {
//            System.out.println(visit);
//        }
//        System.out.println(VisitService.getDoctorList(doctors).size());
//        System.out.println(VisitService.getPatientList(patients).size());
//        System.out.println(visitList);
        System.out.println("Zad a)");
        System.out.println(" Doktor z największą ilością wizyt to: " + VisitService.getDoctorWithMostVisits(doctorList) + " z ilością "
                + VisitService.getDoctorWithMostVisits(doctorList).getVisitList().size() + " wizyt.");

        System.out.println("Zad b)");
        System.out.println(" Pacjent z największą ilością wizyt to: ");
        for (Patient patient : VisitService.getPatientWithMostVisits(patientList)) {
            System.out.println("  " + patient + " z ilością " + patient.getVisitList().size() + " wizyt.");

        }
        System.out.println("Zad c)");
        System.out.println(" Największym powodzeniem cieszy się specjalizacja: "
                + VisitService.getTheMostPopularSpeciality(visitList) + " z " + VisitService.getTheMostPopularSpeciality(visitList).getCountersOfVisits() + " wizytami.");
//        for (Speciality speciality : Speciality.values()) {
//            System.out.println(speciality.name() + " " + speciality.getCountersOfVisits());
//        }

        System.out.println("Zad d)");
      VisitService.printYearWithMostVisits(visitList);

        System.out.println("Zad e)");
        System.out.println("5 najstarszych lekarzy:");
        for (Doctor doctor : VisitService.getListOfFiveOldestDoctors(doctorList)) {
            System.out.println(" " + doctor);

        }

        System.out.println("Zad f)");
        System.out.println("5 najpopularniejszych lekarzy");
        for (Doctor popularDoctor : VisitService.getListOfFiveMostPopularDoctors(doctorList)) {
            System.out.println(" " + popularDoctor);

        }

        System.out.println("Zad g)");
        System.out.println("Zwroc pacjentow ktorzy byli u minumum 5ciu roznych lekarzy:");
        List<Patient> patientsTaskGList = VisitService.getListOfPatientTheyVisitAtLeastFiveDifferentDoctors(patientList, visitList);
        if (patientsTaskGList.size() == 0) {
            System.out.println(" Nie ma takich pacjentów");
        } for (Patient patient : patientsTaskGList) {
            System.out.println(" " + patient);
        }

        List<Doctor> doctorsTaskHList = VisitService.getListOfDoctorTheyHaveOnlyOnePatient(doctorList, visitList);
        for (Doctor doctor : doctorsTaskHList) {
            System.out.println(doctor);

        }

    }

}
