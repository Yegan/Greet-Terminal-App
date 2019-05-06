package net.greet;

public interface GreetController {
    String greet(String name, String language);
    String greeted(String name);
    String greeted();
    String clear();
    String clearUsername(String name);
    void counter();

}
