package pl.kurs.Task02.models;

public enum Speciality {
    LARYNGOLOG(0), NEFROLOG(0), UROLOG(0), OKULISTA(0),
    PEDIATRA(0), ORTOPEDA(0), DERMATOLOG(0), ALERGOLOG(0),
    CHIRURG(0), KARDIOLOG(0), REUMATOLOG(0), INTERNISTA(0),
    ONKOLOG(0), ENDOKRYNOLOG(0), NEUROLOG(0);


    private int countersOfVisits;

    Speciality(int countersOfVisits) {
        this.countersOfVisits = countersOfVisits;
    }

    public static Speciality setSpeciality(String s) {
        if (s == null) {
            return null;
        }
        try {
            return Speciality.valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Nie ma takiej specjalizacji w bazie: " + s);
            return null;
        }
    }

    public int getCountersOfVisits() {
        return countersOfVisits;
    }

    public int setCountersOfVisits() {
        return countersOfVisits += 1;
    }

}

