package net.greet;

public interface GreetCounter {
    void countGreet(String user);
    int greetCount();
    int greetCount(String name);
    String greeted();
    void clear();
    void clearUser(String name);
}
