package ru.ifmo.collections;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    static final int NO_ANSWER = -1;
    static final int UNIQUE = 1;
    static final int NOT_UNIQUE = 2;

    HashMap<Integer, Integer> elements;
    LinkedList<Integer> uniques;

    public FirstUnique(int[] numbers) {
        elements = new HashMap<>();
        uniques = new LinkedList<>();
        for (int number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        if (uniques.isEmpty()) {
            return NO_ANSWER;
        }
        return uniques.get(0);
    }

    public void add(int value) {
        if(elements.get(value) == null){
            elements.put(value, UNIQUE);
            uniques.add(value);
        }
        else if(elements.get(value) == 1){
            elements.put(value, NOT_UNIQUE);
            uniques.removeFirstOccurrence(value);
        }
    }
}
