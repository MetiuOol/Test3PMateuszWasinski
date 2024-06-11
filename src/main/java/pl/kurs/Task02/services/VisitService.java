package pl.kurs.Task02.services;


import pl.kurs.Task02.comparators.DoctorComparators;
import pl.kurs.Task02.models.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VisitService {

    public static Doctor createDoctorFromString(String line) {
        String[] propertiesArray = line.split("\t");

        return new Doctor(
                Integer.parseInt(propertiesArray[0]),
                propertiesArray[1],
                propertiesArray[2],
                Speciality.setSpeciality(propertiesArray[3]),
                LocalDate.parse((propertiesArray[4])),
                propertiesArray[5],
                propertiesArray[6]
        );
    }

    public static List<Doctor> getDoctorsList(File file) {
        List<Doctor> list = new ArrayList<>();
        try (

                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Windows-1252"))
        ) {
            br.readLine();
            String line;
            Doctor firstDoctor = createDoctorFromString(br.readLine());
            list.add(firstDoctor);
            while ((line = br.readLine()) != null) {
                Doctor newDoctor = createDoctorFromString(line);
                if (list.stream().anyMatch(element -> !(element.getPesel().equals(newDoctor.getPesel()))) &&
                        list.stream().anyMatch(element -> !(element.getNip().equals(newDoctor.getNip())))) {
                    list.add(newDoctor);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static Patient createPatientFromString(String line) {
        String[] propertiesArray = line.split("\t");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

        return new Patient(
                Integer.parseInt(propertiesArray[0]),
                propertiesArray[1],
                propertiesArray[2],
                propertiesArray[3],
                LocalDate.parse((propertiesArray[4]), formatter)
        );
    }

    public static List<Patient> getPatientsList(File file) {
        List<Patient> list = new ArrayList<>();
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
        ) {
            br.readLine();
            String line;
            Patient firstPatient = createPatientFromString(br.readLine());
            list.add(firstPatient);
            while ((line = br.readLine()) != null) {
                Patient newPatient = createPatientFromString(line);
                if (list.stream().anyMatch(element -> !(element.getPesel().equals(newPatient.getPesel())))) {
                    list.add(newPatient);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static Visit createVisitFromString(String line, List<Doctor> doctors, List<Patient> patients) {
        String[] propertiesArray = line.split("\t");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

        return new Visit(
                setDoctor(Integer.parseInt(propertiesArray[0]), doctors),
                setPatient(Integer.parseInt(propertiesArray[1]), patients),
                LocalDate.parse(propertiesArray[2], formatter)
        );
    }

    private static Doctor setDoctor(int doctorId, List<Doctor> list) {
        Doctor doctor = null;
        for (Doctor doctor1 : list) {
            if (doctor1.getDoctorId() == doctorId) {
                doctor = doctor1;
            }
        }
        return doctor;
    }

    private static Patient setPatient(int patientId, List<Patient> list) {
        Patient patient = null;
        for (Patient patient1 : list) {
            if (patient1.getPatientId() == patientId) {
                patient = patient1;
            }
        }
        return patient;
    }


    public static List<Visit> getVisitsList(File file, List<Doctor> doctors, List<Patient> patients) {
        List<Visit> list = new ArrayList<>();
        try (
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
        ) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Visit newVisit = createVisitFromString(line, doctors, patients);
                if (!(newVisit.getDoctor() == null || newVisit.getPatient() == null)) {
                    list.add(newVisit);
                    newVisit.getDoctor().addNewVisit(newVisit);
                    newVisit.getPatient().addNewVisit(newVisit);
                    newVisit.getDoctor().setNumberOfVisit();
                    if (newVisit.getDoctor().getSpeciality() != null) {
                        newVisit.getDoctor().getSpeciality().setCountersOfVisits();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;

    }

    public static Doctor getDoctorWithMostVisits(List<Doctor> doctors) {
        Doctor doctorWithMostVisits = doctors.get(0);
        for (Doctor doctor : doctors) {
            if (doctorWithMostVisits.getVisitList().size() < doctor.getVisitList().size()) {
                doctorWithMostVisits = doctor;
            }
        }
        return doctorWithMostVisits;
    }

    private static int getMaxVisit(List<Patient> patientList) {
        int maxVisit = Integer.MIN_VALUE;
        for (Patient patient : patientList) {
            int visit = patient.getVisitList().size();
            if (visit > maxVisit) {
                maxVisit = visit;
            }
        }
        return maxVisit;
    }

    public static List<Patient> getPatientWithMostVisits(List<Patient> patients) {
        List<Patient> patientsWithMostVisitsList = new ArrayList<>();
        for (Patient patient : patients) {
            if (getMaxVisit(patients) == patient.getVisitList().size()) {
                patientsWithMostVisitsList.add(patient);
            }
        }
        return patientsWithMostVisitsList;
    }

    public static Speciality getTheMostPopularSpeciality(List<Visit> visitList) {
        List<Speciality> specialityList = new ArrayList<>();

        for (Visit visit : visitList) {
            for (Speciality speciality : Speciality.values()) {
                if (speciality == visit.getDoctor().getSpeciality()) {
                    if (!(specialityList.contains(speciality)))
                        specialityList.add(speciality);
                }
            }
        }
        Speciality mostPopularSpeciality = specialityList.get(0);
        for (Speciality speciality : specialityList) {
            if (mostPopularSpeciality.getCountersOfVisits() < speciality.getCountersOfVisits()) {
                mostPopularSpeciality = speciality;
            }

        }

        return mostPopularSpeciality;
    }

    private static int getMaxYear(List<Visit> visitList) {
        int maxYear = Integer.MIN_VALUE;
        for (Visit visit : visitList) {
            int year = visit.getDateOfVisit().getYear();
            if (year > maxYear) {
                maxYear = year;
            }
        }
        return maxYear;
    }

    public static void printYearWithMostVisits(List<Visit> visitList) {
        List<Integer> visitPerYear = new ArrayList<>();

        for (int i = 0; i <= getMaxYear(visitList); i++) {
            visitPerYear.add(0);
        }
        int maxYear = 0;
        int maxVisits = 0;

        for (Visit visit : visitList) {
            int year = visit.getDateOfVisit().getYear();
            visitPerYear.set(year, visitPerYear.get(year) + 1);
            for (int i = 0; i < visitPerYear.size(); i++) {
                if (visitPerYear.get(i) > maxVisits) {
                    maxYear = i;
                    maxVisits = visitPerYear.get(i);
                }
            }

        }
        System.out.println(" Najwięcej wizyt było w roku " + maxYear + ". Było " + maxVisits + " wizyt.");

    }

    public static List<Doctor> getListOfFiveOldestDoctors(List<Doctor> doctors) {
        List<Doctor> fiveOldestDoctors = new ArrayList<>();
        doctors.sort(DoctorComparators.ageDoctorComparator());
        for (int i = 0; i < 5; i++) {
            fiveOldestDoctors.add(doctors.get(i));
        }


        return fiveOldestDoctors;
    }

    public static List<Doctor> getListOfFiveMostPopularDoctors(List<Doctor> doctors) {
        List<Doctor> fiveMostPopularDoctors = new ArrayList<>();
        doctors.sort(DoctorComparators.popularDoctorComparator());
        for (int i = 0; i < 5; i++) {
            fiveMostPopularDoctors.add(doctors.get(i));
        }


        return fiveMostPopularDoctors;
    }

    public static List<Patient> getListOfPatientTheyVisitAtLeastFiveDifferentDoctors(List<Patient> patients, List<Visit> visits) {
        List<Patient> patientsList = new ArrayList<>();
        for (Patient patient : patients) {
            List<Integer> doctorsId = new ArrayList<>();
            for (Visit visit : visits) {
                if (visit.getPatient().getPatientId() == patient.getPatientId() && !doctorsId.contains(visit.getDoctor().getDoctorId())) {
                    doctorsId.add(visit.getDoctor().getDoctorId());
                }
            }
            if (doctorsId.size() >= 5) {
                patientsList.add(patient);
            }
        }
        return patientsList;
    }

    public static List<Doctor> getListOfDoctorTheyHaveOnlyOnePatient(List<Doctor> doctors, List<Visit> visits) {
        List<Doctor> doctorWithOnePatient = new ArrayList<>();
        for (Doctor doctor : doctors) {
            List<Integer> patientId = new ArrayList<>();
            for (Visit visit : visits) {
                if (visit.getDoctor().getDoctorId() == doctor.getDoctorId() && !patientId.contains(visit.getPatient().getPatientId())){
                    patientId.add(visit.getDoctor().getDoctorId());
                }
            }
            if (patientId.size() == 1) {
                doctorWithOnePatient.add(doctor);
            }
        }
        return doctorWithOnePatient;
    }
}

