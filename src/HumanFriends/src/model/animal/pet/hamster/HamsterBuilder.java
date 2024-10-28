package model.animal.pet.hamster;

import model.animal.AnimalBuilder;
import model.animal.IdGenerator;

public class HamsterBuilder extends AnimalBuilder<HamsterBuilder> {
    private int wheelSize;

    public HamsterBuilder(IdGenerator idGenerator) {
        super(idGenerator);
    }

    public HamsterBuilder withWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
        return this;
    }

    @Override
    protected HamsterBuilder self() {
        return this;
    }

    @Override
    public Hamster build() {
        return new Hamster(idGenerator, name, birthDate, wheelSize);
    }
}