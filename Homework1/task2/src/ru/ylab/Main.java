package ru.ylab;

import java.util.Arrays;

public class Main {

    /**
     * Main method to sort array
     *
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        int[] array = {5,6,3,2,5,1,4,9};
        System.out.println("Array before sorting: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("Array after sorting: " + Arrays.toString(array));
    }

    /**
     * Method to realize Quick Sort
     *
     * @param array array to sort
     * @param low
     * @param high
     */
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0 || low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int support = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < support) {
                i++;
            }
            while (array[j] > support) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, low, j);
        }
        if (high > i) {
            quickSort(array, i, high);
        }
    }
}