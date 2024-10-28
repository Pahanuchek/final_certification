package model.animal.pet.dog;

import model.animal.AnimalBuilder;
import model.animal.IdGenerator;

public class DogBuilder extends AnimalBuilder<DogBuilder> {
    private String breed;

    public DogBuilder(IdGenerator idGenerator) {
        super(idGenerator);
    }

    public DogBuilder withBreed(String breed) {
        this.breed = breed;
        return this;
    }

    @Override
    protected DogBuilder self() {
        return this;
    }

    @Override
    public Dog build() {
        return new Dog(idGenerator, name, birthDate, breed);
    }
}