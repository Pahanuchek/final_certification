package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class PrintAnimalCommands extends Button {
    public PrintAnimalCommands(ConsoleUI consoleUI) {
        super("Show selected animal's commands.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().printAnimalCommands();
    }
}