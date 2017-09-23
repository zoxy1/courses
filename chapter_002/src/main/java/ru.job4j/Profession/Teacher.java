package ru.job4j.Profession;

import java.util.ArrayList;

/**
 * Created by Zoxy1 on 23.09.17.
 */
public class Teacher extends Profession {

    private ArrayList<Subject> subjectsLead;

    public Teacher(String name, Degree degree, ArrayList<Skill> skills, ArrayList<Subject> subjectsLead) {
        super(name, degree, skills);
        this.subjectsLead = subjectsLead;
    }

    public Student teach(Student student) {
        Skill skill = new Skill("программировать");
        student.getSkills().add(skill);
        System.out.println("Учитель " + this.getName() + "дал навык студенту " + student.getName() + " " + skill.getSkill());
        return student;
    }

    public void addSubject(Subject subject) {
        subjectsLead.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjectsLead.remove(subject);
    }

    public void setSubjectsLead(ArrayList<Subject> subjectsLead) {
        this.subjectsLead = subjectsLead;
    }
}
