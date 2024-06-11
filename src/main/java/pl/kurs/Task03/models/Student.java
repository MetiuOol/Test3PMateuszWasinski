package pl.kurs.Task03.models;

public class Student extends Person {
    private String group;
    private double scholarship;

    public Student(String name, String lastName, String pesel, String city, String group, double scholarship) {
        super(name, lastName, pesel, city);
        this.group = group;
        this.scholarship = scholarship;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getPesel() {
        return super.getPesel();
    }

    @Override
    public String getCity() {
        return super.getCity();
    }

    @Override
    public double getIncome() {
        return scholarship;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(double scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public Sex getSex() {
        Sex sex;
        char sexDigit = getPesel().charAt(9);
        if (Character.getNumericValue(sexDigit) % 2 == 0) {
            sex = Sex.KOBIETA;
        } else {
            sex = Sex.MEZCZYZNA;
        }
        return sex;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", pesel='" + getPesel() + '\'' +
                ", city='" + getCity() + '\'' +
                ", group='" + group + '\'' +
                ", scholarship=" + scholarship +
                '}';
    }

}

