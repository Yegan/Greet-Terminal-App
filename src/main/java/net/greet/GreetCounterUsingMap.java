package net.greet;

import java.util.HashMap;

public class GreetCounterUsingMap implements GreetCounter {
    HashMap<String, Integer> greetedMap = new HashMap<>();

    @Override
    public void countGreet(String name) {
        if (name != null && !greetedMap.containsKey(name)) {
            greetedMap.put(name, 0);
        }
        Integer currentCounter = greetedMap.get(name);
        currentCounter++;
        greetedMap.put(name, currentCounter);
    }

    @Override
    public int greetCount() {
        return greetedMap.size();
    }

    @Override
    public int greetCount(String name) {
        return greetedMap.get(name);
    }

    @Override
    public String greeted() {
        String result = "> These people were greeted: \n";
        for (HashMap.Entry entry : greetedMap.entrySet()) {
            result += "\t" + entry.getKey() + " : " + entry.getValue() + "\n";
        }
        return result;
    }

    @Override
    public void clear() {
        greetedMap.clear();
    }

    @Override
    public void clearUser(String name) {
        greetedMap.get(name);
        greetedMap.remove(name);
    }

}

