package pl.kurs.Task02.models;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private int doctorId;
    private String name;
    private String lastName;
    private Speciality speciality;
    private LocalDate dateOfBirth;
    private String nip;
    private String pesel;
    private List<Visit> visitList = new ArrayList<>();
    private int numberOfVisit = 0;

    public Doctor(int doctorId, String name, String lastName, Speciality speciality, LocalDate dateOfBirth, String nip, String pesel) {
        this.doctorId = doctorId;
        this.name = name;
        this.lastName = lastName;
        this.speciality = speciality;
        this.dateOfBirth = dateOfBirth;
        this.nip = nip;
        this.pesel = pesel;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void addNewVisit(Visit visit) {
        this.visitList.add(visit);

    }

    public int getNumberOfVisit() {
        return numberOfVisit;
    }

    public int setNumberOfVisit() {
        return numberOfVisit += 1;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality=" + speciality +
                ", dateOfBirth=" + dateOfBirth +
                ", nip='" + nip + '\'' +
                ", pesel='" + pesel + '\''  +
                '}';
    }
}
