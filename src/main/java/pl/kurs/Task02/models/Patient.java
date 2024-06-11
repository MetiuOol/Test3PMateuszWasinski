package pl.kurs.Task02.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int patientId;
    private String lastName;
    private String name;
    private String pesel;
    private LocalDate dateOfBirth;
    private List<Visit> visitList = new ArrayList<>();

    public Patient(int patientId, String lastName, String name, String pesel, LocalDate dateOfBirth) {
        this.patientId = patientId;
        this.lastName = lastName;
        this.name = name;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public List<Visit> getVisitList() {
        return visitList;
    }

    public void addNewVisit(Visit visit) {
        this.visitList.add(visit);

    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
