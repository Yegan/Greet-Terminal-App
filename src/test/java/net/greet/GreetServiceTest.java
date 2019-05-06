package net.greet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GreetServiceTest {
    @Test
    public void greetCommandAuthentication(){
        // Testing Greet Service Greeted Command
        GreetService greetService = new GreetService(new GreetCounterUsingMap(), new GreetingLanguage());
        String person1 = "Yegan";
        String person1Language = "English";
        greetService.greet(person1, person1Language);
        assertEquals("> Hello, Yegan", greetService.greet(person1, person1Language));
    }
    @Test
    public void greetedCommandNoParameterAuthentication(){
        GreetService greetService = new GreetService(new GreetCounterUsingMap(), new GreetingLanguage());
        String person1 = "Yegan";
        String person1Language = "English";
        greetService.greet(person1, person1Language);
        greetService.greeted();
        assertEquals("> These people were greeted: \n\tYegan : 1\n",greetService.greeted());
    }
    @Test
    public void greetedCommandAuthentication(){
        // Testing Greet Service Greeted Command
        GreetService greetService = new GreetService(new GreetCounterUsingMap(), new GreetingLanguage());
        String person1 = "Yegan";
        String language = "French";
        greetService.greet(person1, language);
        greetService.greet(person1, language);
        greetService.greeted();
        assertEquals( person1 + " greeted count: 2",greetService.greeted(person1));
    }
//
    @Test
    public void greetCounterAuthentication(){
        GreetService greetService = new GreetService(new GreetCounterUsingMap(), new GreetingLanguage());
        String person1 = "Yegan";
        String person1Language = "English";
        greetService.greet(person1, person1Language);
        String person2 = "Sandiso";
        String person2Language = "French";
        greetService.greet(person2, person2Language);
        greetService.counter();
        assertEquals( 2,greetService.NumberOfPeopleGreeted());
    }
    @Test
    public void greetClearUserNameAuthentication(){
        GreetService greetService = new GreetService(new GreetCounterUsingMap(), new GreetingLanguage());
        String person1 = "Yegan";
        String language = "Xhosa";
        greetService.greet(person1, language);
        String person2 = "Sandiso";
        greetService.greet(person2, language);
        greetService.clearUsername(person1);
        assertEquals( 1,greetService.NumberOfPeopleGreeted());
    }
    @Test
    public void greetClearAllUserNameAuthentication(){
        GreetService greetService = new GreetService(new GreetCounterUsingMap(), new GreetingLanguage());
        String person1 = "Yegan";
        String language = "French";
        greetService.greet(person1, language);
        String person2 = "Sandiso";
        greetService.greet(person2, language);
        greetService.clearUsername(person1);
        greetService.clearUsername(person2);
        assertEquals( 0,greetService.NumberOfPeopleGreeted());
    }
}