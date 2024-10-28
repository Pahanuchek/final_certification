package model.animal.pack_animal.camel;

import model.animal.Animal;
import model.animal.IdGenerator;
import model.animal.pack_animal.PackAnimal;

import java.time.LocalDate;

public class Camel extends PackAnimal {
    private int numberOfHumps;

    public Camel(IdGenerator idGenerator, String name, LocalDate birthDate, int numberOfHumps) {
        super(idGenerator, name, birthDate);
        this.numberOfHumps = numberOfHumps;
    }

    public int getNumberOfHumps() {
        return numberOfHumps;
    }

    public void setNumberOfHumps(int numberOfHumps) {
        this.numberOfHumps = numberOfHumps;
    }

    @Override
    public void makeSound() {
        System.out.println("Grrr! Grrr!");
    }

    @Override
    public void carryLoad() {
        System.out.println("The camel is carrying supplies.");
    }

    @Override
    public Class<? extends Animal> getType() {
        return Camel.class;
    }

    @Override
    public String toString() {
        return String.format("%s\nNumber of humps: %d\n", super.toString(), numberOfHumps);
    }
}