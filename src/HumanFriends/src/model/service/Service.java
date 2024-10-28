package model.service;

import model.animal.Animal;
import model.animal.IdGenerator;
import model.animal.pack_animal.camel.Camel;
import model.animal.pack_animal.camel.CamelBuilder;
import model.animal.pack_animal.donkey.Donkey;
import model.animal.pack_animal.donkey.DonkeyBuilder;
import model.animal.pack_animal.horse.Horse;
import model.animal.pack_animal.horse.HorseBuilder;
import model.animal.pet.cat.Cat;
import model.animal.pet.cat.CatBuilder;
import model.animal.pet.dog.Dog;
import model.animal.pet.dog.DogBuilder;
import model.animal.pet.hamster.Hamster;
import model.animal.pet.hamster.HamsterBuilder;
import model.animal_registry.AnimalRegistry;
import model.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class Service {
    FileHandler fileHandler;
    AnimalRegistry animalRegistry;
    IdGenerator idGenerator;

    public Service() {
        fileHandler = new FileHandler();
        animalRegistry = new AnimalRegistry();
        idGenerator = new IdGenerator();
    }

    public void createCamel(String name, LocalDate birthDate, int numberOfHumps) {
        Camel camel = new CamelBuilder(idGenerator)
                .withName(name)
                .withBirthDate(birthDate)
                .withNumberOfHumps(numberOfHumps)
                .build();
        animalRegistry.addAnimal(camel);
    }

    public void createDonkey(String name, LocalDate birthDate, int stamina) {
        Donkey donkey = new DonkeyBuilder(idGenerator)
                .withName(name)
                .withBirthDate(birthDate)
                .withStamina(stamina)
                .build();
        animalRegistry.addAnimal(donkey);
    }

    public void createHorse(String name, LocalDate birthDate, int weight) {
        Horse horse = new HorseBuilder(idGenerator)
                .withName(name)
                .withBirthDate(birthDate)
                .withWeight(weight)
                .build();
        animalRegistry.addAnimal(horse);
    }

    public void createCat(String name, LocalDate birthDate, String color) {
        Cat cat = new CatBuilder(idGenerator)
                .withName(name)
                .withBirthDate(birthDate)
                .withColor(color)
                .build();
        animalRegistry.addAnimal(cat);
    }

    public void createDog(String name, LocalDate birthDate, String breed) {
        Dog dog = new DogBuilder(idGenerator)
                .withName(name)
                .withBirthDate(birthDate)
                .withBreed(breed)
                .build();
        animalRegistry.addAnimal(dog);
    }

    public void createHamster(String name, LocalDate birthDate, int wheelSize) {
        Hamster hamster = new HamsterBuilder(idGenerator)
                .withName(name)
                .withBirthDate(birthDate)
                .withWheelSize(wheelSize)
                .build();
        animalRegistry.addAnimal(hamster);
    }

    public void trainAnimal(String name, String command) {
        animalRegistry.trainAnimal(name, command);
    }

    public void printAnimalCommands(String name) {
        animalRegistry.printAnimalCommands(name);
    }

    public boolean isAnimalExist(String name) {
        return animalRegistry.isAnimalExist(name);
    }

    public void getAnimalsSortedByBirthdate() {
        List<Animal> allAnimals = animalRegistry.getAnimalsSortedByBirthdate();
        for (Animal animal : allAnimals) {
            System.out.println(animal);
        }
    }

    public void getAnimalsSortedById() {
        List<Animal> allAnimals = animalRegistry.getAnimalsSortedById();
        for (Animal animal : allAnimals) {
            System.out.println(animal);
        }
    }

    public void printAllAnimals() {
        animalRegistry.printAllAnimals();
    }

    public int totalCountOfAnimals() {
        return animalRegistry.totalCountOfAnimals();
    }

    public void saveAnimalData() {
        fileHandler.save(animalRegistry);
    }

    public void readAnimalData() {
        if (fileHandler.read() != null) {
            animalRegistry = (AnimalRegistry) fileHandler.read();
        }
    }

    public void setPath(String filePath) {
        fileHandler.setPath(filePath);
    }
}