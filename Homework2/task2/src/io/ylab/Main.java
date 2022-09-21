package io.ylab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] array = getArray();

        System.out.println("Enter number: ");
        int sum = new Scanner(System.in).nextInt();

        List<Integer> pair = Arrays.stream(getSum(array, sum))
                .collect(Collectors.toList());
        System.out.println(pair);
    }

    private static int[] getArray() throws IOException {
        System.out.println("Enter elements of array: ");
        return new BufferedReader(new InputStreamReader(System.in))
                .readLine()
                .chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .toArray();
    }

    private static Integer[] getSum(int[] array, int sum) {
        if (array.length < 1) {
            return new Integer[]{null};
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    return new Integer[]{array[i], array[j]};
                }
            }
        }
        return new Integer[]{null};
    }
}
