package pl.kurs.Task02.comparators;

import pl.kurs.Task02.models.Doctor;

import java.util.Comparator;

public class DoctorComparators {

    private final static AgeDoctorComparator AGE_DOCTOR_COMPARATOR = new AgeDoctorComparator();
    private final static PopularDoctorComparator POPULAR_DOCTOR_COMPARATOR = new PopularDoctorComparator();

    public DoctorComparators() {
    }

    public static Comparator<Doctor> ageDoctorComparator() {
        return AGE_DOCTOR_COMPARATOR;
    }
    public static Comparator<Doctor> popularDoctorComparator() {
        return POPULAR_DOCTOR_COMPARATOR;
    }
    private static class AgeDoctorComparator implements Comparator<Doctor> {
        @Override
        public int compare(Doctor o1, Doctor o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());

        }
    }

    private static class PopularDoctorComparator implements Comparator<Doctor> {
        @Override
        public int compare(Doctor o1, Doctor o2) {
           return Integer.compare(o2.getNumberOfVisit(), o1.getNumberOfVisit());

        }
    }
}



