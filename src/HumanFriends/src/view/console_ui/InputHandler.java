package view.console_ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {
    private static final String INVALID_FORMAT_MESSAGE = "Invalid format. Please enter a number.";
    private static final String INVALID_DATE_MESSAGE = "Invalid birth date format. Please enter the date in the format DD MM YYYY:";
    private static final String INVALID_HUMPS_MESSAGE = "Incorrect number of humps. Please enter 1 or 2.";
    private static final String INVALID_NUMBER_MESSAGE = "Incorrect number of %s. Please enter a positive number.";
    private static final String WRONG_CHOICE_MESSAGE = "Wrong choice. Please select animal type from provided list:";
    private static final String WRONG_DATE_MESSAGE = "The birth date cannot be later than the current date. Please enter a valid date:";

    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine().trim();
    }

    public LocalDate getBirthDateInput() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                String[] parts = input.split(" ");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                LocalDate birthDate = LocalDate.of(year, month, day);
                if (birthDate.isAfter(LocalDate.now())) {
                    System.out.println(WRONG_DATE_MESSAGE);
                } else {
                    return birthDate;
                }
            } catch (DateTimeException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println(INVALID_DATE_MESSAGE);
            }
        }
    }

    public boolean isValidMenuChoice(String choiceStr, int menuSize) {
        try {
            int choice = Integer.parseInt(choiceStr);
            return choice >= 1 && choice <= menuSize;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getNumberInput(String value) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(input);
                if ("humps".equals(value)) {
                    if (number == 1 || number == 2) {
                        return number;
                    } else {
                        System.out.println(INVALID_HUMPS_MESSAGE);
                    }
                } else {
                    if (number > 0) {
                        return number;
                    } else {
                        System.out.println(String.format(INVALID_NUMBER_MESSAGE, value));
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_FORMAT_MESSAGE);
            }
        }
    }

    public String getAnimalTypeInput(String[] animalTypes) {
        while (true) {
            String animalType = getInput();
            for (String animal : animalTypes) {
                if (animalType.equalsIgnoreCase(animal)) {
                    return animalType;
                }
            }
            System.out.println(WRONG_CHOICE_MESSAGE);
            for (int i = 0; i < animalTypes.length; i++) {
                System.out.println((i + 1) + ". " + animalTypes[i]);
            }
        }
    }

    public String getValueInput(String value) {
        while (true) {
            if (value.equalsIgnoreCase("dog") || value.equalsIgnoreCase("cat")) {
                return getInput();
            } else {
                String input = getInput();
                try {
                    int number = Integer.parseInt(input);
                    if (value.equalsIgnoreCase("camel")) {
                        if (number == 1 || number == 2) {
                            return Integer.toString(number);
                        } else {
                            System.out.println("Incorrect number for " + value + ". Please enter 1 or 2.");
                        }
                    } else {
                        if (number > 0) {
                            return Integer.toString(number);
                        } else {
                            System.out.println("Incorrect number for " + value + ". Please enter a positive number.");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid format. Please enter a number.");
                }
            }
        }
    }
}
