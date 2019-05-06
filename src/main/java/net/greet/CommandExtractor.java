package net.greet;

public class CommandExtractor {
    String command;
    String name;
    String language;

    public CommandExtractor(String commandInput) {
        String[] commandParts = commandInput.split(" ");
        this.command = commandParts[0];
        if (commandParts.length > 1) {
            this.name = commandParts[1];
        }
        if (commandParts.length > 2) {
            this.language = commandParts[2];
        }
    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return this.name;
    }

    public String getLanguage() {
        return language;
    }

    public boolean nameEntered() {
        return name != null;
    }

    public boolean languageEntered() {
        return language != null;
    }

}
