package view.console_ui;

import presenter.Presenter;
import view.View;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private String path = "src/model/writer/animal_registry.txt";
    private String[] animalTypes = {"Dog", "Cat", "Hamster", "Horse", "Camel", "Donkey"};
    private MenuHandler menuHandler;
    private Presenter presenter;
    private InputHandler inputHandler;
    private boolean work;

    public ConsoleUI() {
        inputHandler = new InputHandler(new Scanner(System.in));
        presenter = new Presenter(this);
        menuHandler = new MenuHandler(this);
        work = true;
        presenter.setPath(path);
    }

    @Override
    public void startWork() {
        greetings();
        selectItemFromMenu();
    }

    private void greetings() {
        System.out.println("Welcome to the Animals' Registry program!");
    }

    private void selectItemFromMenu() {
        while (work) {
            System.out.println(menuHandler.getMenu());
            String choiceStr = inputHandler.getInput();
            if (inputHandler.isValidMenuChoice(choiceStr, menuHandler.size())) {
                int choice = Integer.parseInt(choiceStr);
                menuHandler.execute(choice);
            } else {
                System.out.println("Invalid menu option entered.\nPlease enter a valid number from the menu: from 1 to " + menuHandler.size());
            }
        }
    }

    private void animalNameInputMessage(String animalType) {
        System.out.println("Enter " + animalType.toLowerCase() + "'s name:");
    }

    private void birthDayInputMessage(String name) {
        System.out.println("Enter " + name + "'s birth date with spaces in the format DD MM YYYY:");
    }

    public void createAnimal() {
        String animalType = getAnimalType();
        if (animalType.equalsIgnoreCase("dog")) {
            createDog(animalType);
        } else if (animalType.equalsIgnoreCase("cat")) {
            createCat(animalType);
        } else if (animalType.equalsIgnoreCase("hamster")) {
            createHamster(animalType);
        } else if (animalType.equalsIgnoreCase("camel")) {
            createCamel(animalType);
        } else if (animalType.equalsIgnoreCase("horse")) {
            createHorse(animalType);
        } else if (animalType.equalsIgnoreCase("donkey")) {
            createDonkey(animalType);
        }
        System.out.println("Animal has been created.\n");
    }

    public String getAnimalType() {
        System.out.println("Please choose the animal you want to create:");
        for (int i = 0; i < animalTypes.length; i++) {
            System.out.println((i + 1) + ". " + animalTypes[i]);
        }
        return inputHandler.getAnimalTypeInput(animalTypes);
    }

    private void createCamel(String animalType) {
        animalNameInputMessage(animalType);
        String name = inputHandler.getInput();

        birthDayInputMessage(name);
        LocalDate birthDate = inputHandler.getBirthDateInput();

        System.out.println("Enter the number of humps of the " + animalType.toLowerCase() + " . 1 or 2:");
        int numberOfHumps = inputHandler.getNumberInput("humps");

        presenter.createCamel(name, birthDate, numberOfHumps);
    }

    private void createDonkey(String animalType) {
        animalNameInputMessage(animalType);
        String name = inputHandler.getInput();

        birthDayInputMessage(name);
        LocalDate birthDate = inputHandler.getBirthDateInput();

        System.out.println("Enter the " + animalType.toLowerCase() + "'s stamina:");
        int stamina = inputHandler.getNumberInput("stamina");

        presenter.createDonkey(name, birthDate, stamina);
    }

    private void createHorse(String animalType) {
        animalNameInputMessage(animalType);
        String name = inputHandler.getInput();

        birthDayInputMessage(name);
        LocalDate birthDate = inputHandler.getBirthDateInput();

        System.out.println("Enter the " + animalType.toLowerCase() + "'s weight:");
        int weight = inputHandler.getNumberInput("weight");

        presenter.createHorse(name, birthDate, weight);
    }

    private void createCat(String animalType) {
        animalNameInputMessage(animalType);
        String name = inputHandler.getInput();

        birthDayInputMessage(name);
        LocalDate birthDate = inputHandler.getBirthDateInput();

        System.out.println("Enter the " + animalType.toLowerCase() + "'s color:");
        String color = inputHandler.getInput();

        presenter.createCat(name, birthDate, color);
    }

    private void createDog(String animalType) {
        animalNameInputMessage(animalType);
        String name = inputHandler.getInput();

        birthDayInputMessage(name);
        LocalDate birthDate = inputHandler.getBirthDateInput();

        System.out.println("Enter the " + animalType.toLowerCase() + "'s breed:");
        String breed = inputHandler.getInput();

        presenter.createDog(name, birthDate, breed);
    }

    private void createHamster(String animalType) {
        animalNameInputMessage(animalType);
        String name = inputHandler.getInput();

        birthDayInputMessage(name);
        LocalDate birthDate = inputHandler.getBirthDateInput();

        System.out.println("Enter the " + animalType.toLowerCase() + "'s wheel size:");
        int wheelSize = inputHandler.getNumberInput("wheelSize");

        presenter.createHamster(name, birthDate, wheelSize);
    }

    public void trainAnimal() {
        while (true) {
            System.out.println("Please enter animal's name:");
            String name = inputHandler.getInput();
            if (presenter.isAnimalExist(name)) {
                System.out.println("Please enter command:");
                String command = inputHandler.getInput();
                presenter.trainAnimal(name, command);
                System.out.println("Animal with name " + name + " has learned command: " + command + ".\n");
                return;
            } else {
                System.out.println("Animal with name " + name + " not found.");
            }
        }
    }

    public void printAnimalCommands() {
        while (true) {
            System.out.println("Please enter animal's name:");
            String name = inputHandler.getInput();
            if (presenter.isAnimalExist(name)) {
                System.out.println("Commands for " + name + ": ");
                presenter.printAnimalCommands(name);
                return;
            } else {
                System.out.println("Animal with name " + name + " not found.");
            }
        }
    }

    public void getAnimalsSortedByBirthdate() {
        System.out.println("Animals sorted by birth date:");
        presenter.getAnimalsSortedByBirthdate();
    }

    public void getAnimalsSortedById() {
        System.out.println("Animals sorted by ID:");
        presenter.getAnimalsSortedById();
    }

    public void printAllAnimals() {
        presenter.printAllAnimals();
    }

    public void totalCountOfAnimals() {
        System.out.println("Total number of created animals: " + presenter.totalCountOfAnimals() + ".\n");
    }

    @Override
    public void finishWork() {
        work = false;
        System.out.println("Good bye!");
        presenter.saveAnimalData();
    }
}