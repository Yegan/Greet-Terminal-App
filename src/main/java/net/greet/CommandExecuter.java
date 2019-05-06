package net.greet;

public class CommandExecuter {
    private GreetService greetService;

    public CommandExecuter(GreetService greetService) {
        this.greetService = greetService;
    }

    public String excuteCommand(CommandExtractor commandExtractor) {
        String name = commandExtractor.getName();
        if ("greet".equals(commandExtractor.getCommand())) {
            if (commandExtractor.languageEntered()) {
                return this.greetService.greet(commandExtractor.getName(), commandExtractor.getLanguage());
            } else if (commandExtractor.nameEntered()) {
                return greetService.greet(commandExtractor.getName());
            }
        }
        if ("greeted".equals(commandExtractor.getCommand())) {
            if (commandExtractor.nameEntered()) {
                return this.greetService.greeted(name);
            } else {
                return this.greetService.greeted();
            }
        }
        if ("clear".equals(commandExtractor.getCommand())) {
            if (commandExtractor.nameEntered()) {
                return this.greetService.clearUsername(name);
            } else {
                return this.greetService.clear();
            }
        }
        if ("help".equals(commandExtractor.getCommand())) {
            String helpMessage = "These are common commands used in various situations:\n greet\t Greet a user\n greeted Show all greeted users\n clear\t Delete all users stored in the DB";
            return helpMessage;
        } else {
            return "Invalid command";
        }
    }

}
