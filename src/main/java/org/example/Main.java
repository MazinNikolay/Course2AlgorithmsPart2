package org.example;

import org.example.model.IntegerListImpl;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rnd = new Random();

        int arr1[] = new int[100_000];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rnd.nextInt(50);
        }
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);

        long start = System.currentTimeMillis();
        sortBubble(arr1);
        System.out.println(System.currentTimeMillis() - start);

        sortSelection(arr2);
        System.out.println(System.currentTimeMillis() - start);

        sortInsertion(arr3);
        System.out.println(System.currentTimeMillis() - start);
        IntegerListImpl stringList = new IntegerListImpl(8);
        stringList.add(111);
        System.out.println(stringList.get(0));
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}