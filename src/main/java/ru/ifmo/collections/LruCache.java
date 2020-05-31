package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 * <p>
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 * <p>
 * This class should not have any other public methods.
 * <p>
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {
    private static final float LOAD_FACTOR = 1f;
    private final Integer Capacity;

    private LinkedHashMap<K, V> elements;

    public LruCache(int capacity) {
        Capacity = capacity;
        elements = new LinkedHashMap<>(capacity, 1f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > Capacity;
            }
        };
    }

    public V get(K key) {
        return elements.get(key);
    }

    public void put(K key, V value) {
        elements.put(key, value);
    }

    public int elements() {
        return elements.size();
    }

}