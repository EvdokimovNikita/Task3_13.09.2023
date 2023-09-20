// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
import java.util.stream.*;



public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int count = 15;
        // Create random array of numbers.
        int[] unordered = new int[count];
        for (int i = 0; i < 15; i++) {
            unordered[i] = Math.abs(random.nextInt()) % 45;
        }
        // Fill array using binary search
        // Expect resulting array to be ordered.
        List<Integer> result = new ArrayList<Integer>();
        for (int a : unordered) {
            int[] arr = result.stream().mapToInt(i -> i).toArray();
            int index = binarySearchWithRecursion(a, arr);
            result.add(index, a);
        }
        int[] array = result.stream().mapToInt(i -> i).toArray();
        System.out.println("Source: " + Arrays.toString(unordered));
        System.out.println("Ordered: " + Arrays.toString(array));
        // Test binary search over the ordered array.
        for (int i = 0; i < 51; i++) {
            int index = binarySearchWithRecursion(i, array);
            if (index < array.length && array[index] == i) {
                System.out.println(i + ": Found at: " + index);
            } else {
                System.out.println(i + ": Not found, insert index: " + index);
            }
        }
    }

    public static int binarySearchWithRecursion(int value, int[] array) {
        return binarySearchWithRecursion(0, array.length, value, array);
    }

    private static int binarySearchWithRecursion(int from, int to, int value, int[] array) {
       // System.out.println(from + "..." + to);
        int mid = (from + to) / 2;
        if (from >= to) {
            return mid;
        }
        if (array[mid] > value) {
            return binarySearchWithRecursion(from, mid, value, array);
        }
        if (array[mid] < value) {
            return binarySearchWithRecursion(mid + 1, to, value, array);
        }
        return mid;
    }
}