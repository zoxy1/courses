package ru.job4j.profession;

/**
 * Created by Zoxy1 on 23.09.17.
 */
public class People {

    private String name;
    private int age;
    private int health;

    public People(String name, int age, int health) {
        this.name = name;
        this.age = age;
        this.health = health;
    }

    public void addHealth(int health) {
        this.health = this.health + health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
