package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private final TreeMap<T, Object> elements;

    private SortedSet(Comparator<T> comparator) {
        elements = new TreeMap<>(comparator);
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<>(null);
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }

    public List<T> getSorted() {
        return new ArrayList<>(elements.keySet());
    }

    public List<T> getReversed() {
        return new ArrayList<>(elements.descendingKeySet());
    }

    @Override
    public boolean add(T key) {
        return elements.put(key, null) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean answer = true;
        for (T key : collection){
            answer &= add(key);
        }
        return answer;
    }

    @Override
    public boolean remove(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        return elements.remove(key) != null;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean answer = true;
        for (Object key : collection) {
            answer &= remove(key);
        }
        return answer;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.keySet().iterator();
    }

}


