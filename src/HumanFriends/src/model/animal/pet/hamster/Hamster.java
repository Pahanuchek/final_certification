package model.animal.pet.hamster;

import model.animal.Animal;
import model.animal.IdGenerator;
import model.animal.pet.Pet;

import java.time.LocalDate;

public class Hamster extends Pet {
    private int wheelSize;

    public Hamster(IdGenerator idGenerator, String name, LocalDate birthDate, int wheelSize) {
        super(idGenerator, name, birthDate);
        this.wheelSize = wheelSize;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    @Override
    public void makeSound() {
        System.out.println("Squeak! Squeak!");
    }

    @Override
    public void play() {
        System.out.println("The hamster is running on the wheel.");
    }

    @Override
    public Class<? extends Animal> getType() {
        return Hamster.class;
    }

    @Override
    public String toString() {
        return String.format("%s\nWheel size: %d\n", super.toString(), wheelSize);
    }
}