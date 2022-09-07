package ru.ylab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {

    private final int[] firstArray = {5, 6, 3, 2, 5, 1, 4, 9};
    private final int[] secondArray = {-5, 6, 3, -2, -5, 1, 4, 9, 15, 3, 1, 0};
    private final int[] thirdArray = {3, 3, 3, 3, 3, 3};
    private final int[] emptyArray = {};

    @Test
    public void testFirstCase() {
        Main.quickSort(firstArray, 0, firstArray.length - 1);
        int[] expectedArray = {1, 2, 3, 4, 5, 5, 6, 9};
        assertArrayEquals(firstArray, expectedArray);
    }

    @Test
    public void testSecondCase() {
        Main.quickSort(secondArray, 0, secondArray.length - 1);
        int[] expectedArray = {-5, -5, -2, 0, 1, 1, 3, 3, 4, 6, 9, 15};
        assertArrayEquals(secondArray, expectedArray);
    }

    @Test
    public void testThirdCase() {
        Main.quickSort(thirdArray, 0, thirdArray.length - 1);
        int[] expectedArray = {3, 3, 3, 3, 3, 3};
        assertArrayEquals(thirdArray, expectedArray);
    }

    @Test
    public void testEmptyCase() {
        Main.quickSort(emptyArray, 0, emptyArray.length - 1);
        int[] expectedArray = {};
        assertArrayEquals(emptyArray, expectedArray);
    }

}