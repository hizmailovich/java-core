package io.ylab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> pairs = new HashMap<>();

        System.out.println("Enter elements of array: ");
        int[] array = new BufferedReader(new InputStreamReader(System.in))
                .readLine()
                .chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .toArray();

        System.out.println("Enter number: ");
        int sum = new Scanner(System.in).nextInt();

        System.out.println("Array: ");
        Arrays.stream(array)
                .peek(number -> {
                    OptionalInt result = Arrays.stream(array)
                            .filter(el -> el == (sum - number))
                            .findFirst();
                    result.ifPresent(res -> pairs.put(number, result.getAsInt()));
                })
                .forEach(System.out::print);

        System.out.println("\nResult: ");
        pairs.entrySet().stream()
                .findFirst().ifPresent(item -> System.out.println("[" + item.getKey() + ", " + item.getValue() + "]"));
    }
}
