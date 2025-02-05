package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Animal {

    @JsonProperty("Id")
    private int id;

    @JsonProperty("Age")
    private int age;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Color")
    private String color;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;

    @JsonProperty("Health")
    private Health health;

    @JsonProperty("Owner")
    private Owner owner;

    @JsonProperty("Diet")
    private Diet diet;

    @JsonProperty("Cat")
    private Cat cat;

    public Animal() { }

    public Animal(int id, int age, String name, String color, Date birthDate, Health health, Owner owner, Diet diet, Cat cat) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
        this.health = health;
        this.owner = owner;
        this.diet = diet;
        this.cat = cat;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Health getHealth() {
        return health;
    }
    public void setHealth(Health health) {
        this.health = health;
    }
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Diet getDiet() {
        return diet;
    }
    public void setDiet(Diet diet) {
        this.diet = diet;
    }
    public Cat getCat() {
        return cat;
    }
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", birthDate=" + birthDate +
                ", health=" + health +
                ", owner=" + owner +
                ", diet=" + diet +
                ", cat=" + cat +
                '}';
    }
}
