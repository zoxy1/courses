package ru.job4j.Profession;

import java.util.ArrayList;

/**
 * Created by Zoxy1 on 23.09.17.
 */
public class Doctor extends Profession {

    private ArrayList<Specialization> specializations;

    public Doctor(String name, Degree degree, ArrayList<Skill> skills, ArrayList<Specialization> specializations) {
        super(name, degree, skills);
        this.specializations = specializations;
    }

    public People heal(People people, int health) {
        people.addHealth(health);
        System.out.println("Доктор " + this.getName() + " подправил здоровье " + people.getName() + " на " + health + " единиц.");
        return people;
    }

    public void addSpecialization(Specialization specialization) {
        this.specializations.add(specialization);
    }

    public ArrayList<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(ArrayList<Specialization> specializations) {
        this.specializations = specializations;
    }
}
