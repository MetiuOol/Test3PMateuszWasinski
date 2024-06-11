package pl.kurs.Task03.models;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name;
    private String lastName;
    private String pesel;
    private String city;

    public Person(String name, String lastName, String pesel, String city) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        setPesel(pesel);
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(String pesel) {
        if (pesel == null || pesel.length() != 11) {
            throw new IllegalArgumentException("Błędny pesel!! Pesel powinien mieć 11 znaków");
        }
        this.pesel = pesel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public abstract double getIncome();
    public abstract Sex getSex();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
