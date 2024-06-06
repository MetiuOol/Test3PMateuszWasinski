package pl.kurs.Task01.models;


import java.time.LocalDate;

public class Baby {
    private int babyId;
    private Sex sex;
    private String name;
    private LocalDate dateOfBirth;
    private int weightInGrams;
    private int growthInCentimeters;
    private Mother mother;

    public Baby(int babyId, Sex sex, String name, LocalDate dateOfBirth, int weightInGrams, int highInCentimeters, Mother mother) {
        this.babyId = babyId;
        this.sex = sex;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weightInGrams = weightInGrams;
        this.growthInCentimeters = highInCentimeters;
        this.mother = mother;
    }

    public int getBabyId() {
        return babyId;
    }

    public void setBabyId(int babyId) {
        this.babyId = babyId;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public int getGrowthInCentimeters() {
        return growthInCentimeters;
    }

    public void setGrowthInCentimeters(int growthInCentimeters) {
        this.growthInCentimeters = growthInCentimeters;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Baby{" +
                "babyId=" + babyId +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", weightInGrams=" + weightInGrams +
                ", growthInCentimeters=" + growthInCentimeters +
                ", mother=" + mother +
                '}';
    }
}
