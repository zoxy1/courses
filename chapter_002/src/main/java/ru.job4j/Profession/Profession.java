package ru.job4j.Profession;

import java.util.ArrayList;

/**
 * Created by Zoxy1 on 23.09.17.
 */
public class Profession {
    protected String name;
    protected Degree degree;
    protected ArrayList<Skill> skills;

    public Profession() {
    }

    public Profession(String name, Degree degree, ArrayList<Skill> skills) {
        this.name = name;
        this.degree = degree;
        this.skills = skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
}
