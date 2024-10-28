package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class CreateAnimal extends Button {
    public CreateAnimal(ConsoleUI consoleUI) {
        super("Create animal.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().createAnimal();
    }
}