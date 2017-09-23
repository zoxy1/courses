package ru.job4j.Profession;

import java.util.ArrayList;

/**
 * Created by Zoxy1 on 23.09.17.
 */
public class Student {
    private String name;
    private ArrayList<Skill> skills;

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
