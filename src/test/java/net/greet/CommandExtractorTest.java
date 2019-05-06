package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandExtractorTest {

    @Test
    public void commandExtractorGetCommandTest(){
        String input = "greet Yegan English";
        CommandExtractor commandExtractor = new CommandExtractor(input);
        assertEquals("greet",commandExtractor.getCommand());
        assertEquals("Yegan",commandExtractor.getName());
        assertEquals("English",commandExtractor.getLanguage());
    }

}
