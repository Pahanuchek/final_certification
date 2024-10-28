package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class PrintAllAnimals extends Button {
    public PrintAllAnimals(ConsoleUI consoleUI) {
        super("Show all animals.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().printAllAnimals();
    }
}