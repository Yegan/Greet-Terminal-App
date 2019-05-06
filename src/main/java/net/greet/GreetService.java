package net.greet;

public class GreetService implements GreetController {
    private final GreetCounter greetCounter;
    GreetingLanguage greetingLanguage;

    public GreetService(GreetCounter greetCounter, GreetingLanguage greetingLanguage) {
        this.greetCounter = greetCounter;
        this.greetingLanguage = greetingLanguage;
    }

    public String greet(String name) {
        return greet(name, "");
    }

    public String greet(String name, String language) {
        greetCounter.countGreet(name);
        return greetingLanguage.greetingLanguageSelection(name, language);
    }

    public String greeted(String name) {
        Integer greetedCount = greetCounter.greetCount(name); // ;
        return name + " greeted count: " + greetedCount;
    }

    public String greeted() {
        return greetCounter.greeted();
    }

    public String clear() {
        greetCounter.clear();
        return "All users were deleted from the system";
    }

    public String clearUsername(String name) {
        greetCounter.clearUser(name);
        return name + " has been cleared.";
    }

    public void counter() {
        NumberOfPeopleGreeted();
    }

    public int NumberOfPeopleGreeted() {
        return greetCounter.greetCount();
    }
}



























