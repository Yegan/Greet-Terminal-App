package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class H2DB_ServiceTest {

    Connection conn;

    @BeforeEach
    public void getConnection() {
        try {
            GreetCounterUsingJdbc greetCounterUsingJdbc = new GreetCounterUsingJdbc();
            conn = DriverManager.
                    getConnection("jdbc:h2:./target/testDataBase", "yegan", "");
            Statement statement = conn.createStatement();
            statement.addBatch("delete from countperson");
            statement.executeBatch();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void greetCommandAuthentication() {
        // Testing GreetCounterUsingJdbc Greet Command
        GreetCounterUsingJdbc greetCounterUsingJdbc = new GreetCounterUsingJdbc();
        String person1 = "Alice";
        greetCounterUsingJdbc.countGreet(person1);
        greetCounterUsingJdbc.countGreet(person1);
        assertEquals(2, greetCounterUsingJdbc.greetCount());
        assertEquals(2, greetCounterUsingJdbc.greetCount(person1));
    }

    @Test
    public void greetedCommandNoParamenterAuthentication() {
        GreetCounterUsingJdbc greetCounterUsingJdbc = new GreetCounterUsingJdbc();
        String person1 = "Alice";
        greetCounterUsingJdbc.countGreet(person1);
        greetCounterUsingJdbc.countGreet(person1);
        String person2 = "Yegan";
        greetCounterUsingJdbc.countGreet(person2);
        assertEquals("> These people were greeted: \n\t" + person1 + " : " +2  +"\n" + "\t" + person2 + " : " + 1 +"\n", greetCounterUsingJdbc.greeted());
    }

    @Test
    public void deletePersonCounter() {
        GreetCounterUsingJdbc greetCounterUsingJdbc = new GreetCounterUsingJdbc();
        String person1 = "Yegan";
        greetCounterUsingJdbc.countGreet(person1);
        greetCounterUsingJdbc.clearUser(person1);
        assertEquals(0, greetCounterUsingJdbc.findUserCounter(person1));
    }


    @Test
    public void deleteAllPersonsCounter() {
        GreetCounterUsingJdbc greetCounterUsingJdbc = new GreetCounterUsingJdbc();
        String person1 = "Yegan";
        greetCounterUsingJdbc.countGreet(person1);
        String person2 = "Andre";
        greetCounterUsingJdbc.countGreet(person2);
        greetCounterUsingJdbc.clear();
        assertEquals(0, greetCounterUsingJdbc.greetCount());
    }

}