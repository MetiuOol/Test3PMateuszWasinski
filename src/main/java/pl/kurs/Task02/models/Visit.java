package pl.kurs.Task02.models;

import java.time.LocalDate;

public class Visit {
    private Doctor doctor;
    private Patient patient;
    private LocalDate dateOfVisit;

    public Visit(Doctor doctor, Patient patient, LocalDate dateOfVisit) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateOfVisit = dateOfVisit;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "doctorId=" + doctor.getDoctorId() +
                ", patientId=" + patient.getPatientId() +
                ", dateOfVisit=" + dateOfVisit +
                '}';
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }
}
