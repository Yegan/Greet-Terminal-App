package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandExecuterTest {
    @Test
    public void commandExecuterTest(){
        String input = "greet Yegan English";
        CommandExtractor commandExtractor = new CommandExtractor(input);
        GreetingLanguage greetingLanguage = new GreetingLanguage();
        GreetService greetService = new GreetService(new GreetCounterUsingJdbc(), greetingLanguage);
        CommandExecuter commandExecuter = new CommandExecuter(greetService);

        String command = commandExtractor.getCommand();
        String name = commandExtractor.getName();
        String language = commandExtractor.getLanguage();

        commandExecuter.excuteCommand(commandExtractor);
        greetService.greet(name, language);

        assertEquals("> Hello, Yegan",greetService.greet(name, language));

    }
}
