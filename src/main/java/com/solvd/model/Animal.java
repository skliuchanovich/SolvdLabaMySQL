package com.solvd.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;

@XmlRootElement(name = "Animal")
@XmlType(propOrder = {"id", "name", "color", "age", "birthDate", "cat", "health", "diet", "owner"})
public class Animal {

    private int id;
    private int age;
    private String name;
    private String color;
    private Date birthDate;

    private Health health;
    private Owner owner;
    private Diet diet;
    private Cat cat;

    public Animal() {
    }

    public Animal(int age, String name, String color, Date birthDate) {
        this.age = age;
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    @XmlElement(name = "Id")
    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    @XmlElement(name = "Age")
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    @XmlElement(name = "Color")
    public void setColor(String color) {
        this.color = color;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @XmlElement(name = "birthDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Health getHealth() {
        return health;
    }

    @XmlElement(name = "Health")
    public void setHealth(Health health) {
        this.health = health;
    }

    public Owner getOwner() {
        return owner;
    }

    @XmlElement(name = "Owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Diet getDiet() {
        return diet;
    }

    @XmlElement(name = "Diet")
    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public Cat getCat() {
        return cat;
    }

    @XmlElement(name = "Cat")
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Animal{" + "age=" + age + ", name='" + name + '\'' + ", color='" + color + '\'' + ", birthDate=" + birthDate + ", health=" + health + ", owner=" + owner + ", diet=" + diet + ", cat=" + cat + '}';
    }
}
