package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GreetAppMockTest {

    @Test
    public void  greetServiceAndGreetCounterIntegration(){
        // assemble
        GreetService greetService = mock(GreetService.class);
        when(greetService.greet("Yegan", "English")).thenReturn("Hello, Yegan");
        CommandExtractor commandExtractor = new CommandExtractor("greet Yegan English");
        CommandExecuter commandExecuter = new CommandExecuter(greetService);
        // act
        String result = commandExecuter.excuteCommand(commandExtractor);
        // assert
        verify(greetService).greet("Yegan", "English");
        assertEquals("Hello, Yegan", result);
    }

    @Test
    public void greetCommandWithoutGreetCommand(){
        // assemble
        GreetService greetService = mock(GreetService.class);
        when(greetService.greet("Alice")).thenReturn("Hello, Alice");
        CommandExtractor commandExtractor = new CommandExtractor("greet Alice");
        CommandExecuter commandExecuter = new CommandExecuter(greetService);
        //act
        String result = commandExecuter.excuteCommand(commandExtractor);
        //assert
        verify(greetService).greet("Alice");
        assertEquals("Hello, Alice",result);
    }

}
