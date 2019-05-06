package net.greet;
public class GreetingLanguage {

    public String greetingLanguageSelection(String name, String language) {
        if (language.equals("English")) {
            return "> Hello, " + name;
        }
        if (language.equals("Xhosa")) {
            return "> Molo, " + name;
        }
        if (language.equals("French")) {
            return "Bonjour, " + name;
        }
        return "> Hello, " + name;
    }
}


