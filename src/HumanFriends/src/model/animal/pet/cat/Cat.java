package model.animal.pet.cat;

import model.animal.Animal;
import model.animal.IdGenerator;
import model.animal.pet.Pet;

import java.time.LocalDate;

public class Cat extends Pet {
    private String color;

    public Cat(IdGenerator idGenerator, String name, LocalDate birthDate, String color) {
        super(idGenerator, name, birthDate);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void play() {
        System.out.println("The cat is chasing a laser pointer.");
    }

    @Override
    public Class<? extends Animal> getType() {
        return Cat.class;
    }

    @Override
    public String toString() {
        return String.format("%s\nColor: %s\n", super.toString(), color);
    }
}