package pl.kurs.Ex01.models;

import java.util.ArrayList;
import java.util.List;

public class Mother {

    private int motherId;
    private String name;
    private int age;
    private List<Baby> babies;

    public Mother(int motherId, String name, int age) {
        this.motherId = motherId;
        this.name = name;
        this.age = age;
        this.babies = new ArrayList<>();
    }

    public int getMotherId() {
        return motherId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setMotherId(int motherId) {
        this.motherId = motherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Baby> getBabies() {
        return babies;
    }

    public void setBabies(List<Baby> babies) {
        this.babies = babies;
    }

    public void addBabies(Baby baby) {
        babies.add(baby);
    }

    @Override
    public String toString() {
        return "Mother{" +
                "motherId=" + motherId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
