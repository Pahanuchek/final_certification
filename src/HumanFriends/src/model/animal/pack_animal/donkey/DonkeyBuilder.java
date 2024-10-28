package model.animal.pack_animal.donkey;

import model.animal.AnimalBuilder;
import model.animal.IdGenerator;

public class DonkeyBuilder extends AnimalBuilder<DonkeyBuilder> {
    private int stamina;

    public DonkeyBuilder(IdGenerator idGenerator) {
        super(idGenerator);
    }

    public DonkeyBuilder withStamina(int stamina) {
        this.stamina = stamina;
        return this;
    }

    @Override
    protected DonkeyBuilder self() {
        return this;
    }

    @Override
    public Donkey build() {
        return new Donkey(idGenerator, name, birthDate, stamina);
    }
}