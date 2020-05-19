package ru.ifmo.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    static final int NO_ANSWER = -1;

    private final int K;

    PriorityQueue<Integer> elements;
    private int lastAnswer;

    public KthLargest(int k, int[] numbers) {
        K = k;
        lastAnswer = NO_ANSWER;
        elements = new PriorityQueue<>(new ReverseComparator());
        for (int number : numbers) {
            add(number);
        }
    }

    public int add(int value) {
        if(value < lastAnswer) {
            return lastAnswer;
        }
        elements.add(value);
        if(elements.size() < K){
            return NO_ANSWER;
        }
        if(elements.size() > K){
            elements.remove();
        }
        lastAnswer = elements.peek();
        return lastAnswer;
    }

    static class ReverseComparator implements Comparator<Integer> {
        public int compare(Integer int1, Integer int2)
        {
            return int1.compareTo(int2);
        }
    }
}