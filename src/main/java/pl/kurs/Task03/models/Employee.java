package pl.kurs.Task03.models;

public class Employee extends Person {
    private String jobPosition;
    private double salary;

    public Employee(String name, String lastName, String pesel, String city, String jobPosition, double salary) {
        super(name, lastName, pesel, city);
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Employee(String name, String lastName, String pesel, String city) {
        super(name, lastName, pesel, city);
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
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public void setPesel(String pesel) {
        super.setPesel(pesel);
    }

    @Override
    public void setCity(String city) {
        super.setCity(city);
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getIncome() {
        return salary;
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
                ", jobPosition='" + jobPosition + '\'' +
                ", salary=" + salary +
                '}';
    }

}
