package ru.ylab;

public class Main {

    /**
     * Main method to create matrix and get minimum, maximum and average value from it
     *
     * @param args arguments from command line
     */
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = new int[5][5];
        int min = 1000, max = 0;
        double average = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                element = random(0, 100);
                if (element > max) {
                    max = element;
                }
                if (element < min) {
                    min = element;
                }
                average += element;
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println("Minimum value = " + min
                + "\nMaximum value = " + max
                + "\nAverage value = " + average / (matrix.length * matrix.length));
    }

    /**
     * Method to generate random value
     *
     * @param minValue minimum value to generate
     * @param maxValue maximum value to generate
     * @return random value
     */
    private static int random(int minValue, int maxValue) throws InterruptedException {
        Thread.sleep(5);
        return (int) (System.currentTimeMillis() % (maxValue - minValue) + minValue);
    }
}
