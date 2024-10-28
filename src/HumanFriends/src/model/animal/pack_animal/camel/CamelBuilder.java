package model.animal.pack_animal.camel;

import model.animal.AnimalBuilder;
import model.animal.IdGenerator;

public class CamelBuilder extends AnimalBuilder<CamelBuilder> {
    private int numberOfHumps;

    public CamelBuilder(IdGenerator idGenerator) {
        super(idGenerator);
    }

    public CamelBuilder withNumberOfHumps(int numberOfHumps) {
        this.numberOfHumps = numberOfHumps;
        return this;
    }

    @Override
    protected CamelBuilder self() {
        return this;
    }

    @Override
    public Camel build() {
        return new Camel(idGenerator, name, birthDate, numberOfHumps);
    }
}