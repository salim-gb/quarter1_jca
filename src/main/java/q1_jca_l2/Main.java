package q1_jca_l2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // sample for first problem
        int[] array1 = {0, 1, 1, 1, 0, 1, 0, 0, 1};
        reverseArrayNumbers(array1);
        System.out.println(Arrays.toString(array1));

        // sample for second problem
        int[] array2 = new int[8];
        fillArray(array2, 0, 3);
        System.out.println(Arrays.toString(array2));

        // sample for third problem
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        fillArrayByMultiplication(array3, 6, 2);
        System.out.println(Arrays.toString(array3));

        // sample for fourth problem
        int[][] array4 = new int[5][5];
        fillArrayDiagonals(array4, 1);

        // sample for fifth problem
        int[] array5 = {1, 4, 5, 9, 14, 0, 60, 8, 33, 7, -3};
        findMinMaxInArray(array5);

        // sample for six problem
        int[] array6 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(array6));

        // sample for seven problem
        int[] array7 = {1, 2, 3};
        shiftArrayNumbers(array7, -2);
        System.out.println(Arrays.toString(array7));
    }

    /**
     * This method get array of 0, 1 and reverse its values using a for loop.
     *
     * @param array int array.
     */
    private static void reverseArrayNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
    }

    /**
     * This method fill empty int array with arithmetic progression using for loop.
     *
     * @param array empty int array.
     * @param a     the first term.
     * @param d     the common difference between terms.
     */
    private static void fillArray(int[] array, int a, int d) {
        for (int i = 0; i < array.length; i++) {
            array[i] = a + d * i;
        }
    }

    /**
     * This method accept int array, multiply values that less than a with number d.
     *
     * @param array int array.
     * @param a     int number below which we will multiply.
     * @param d     int number with which we will multiply.
     */
    private static void fillArrayByMultiplication(int[] array, int a, int d) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < a) array[i] *= d;
        }
    }

    /**
     * This method fill array diagonals with int number a.
     *
     * @param array int array.
     * @param a     int number with which to fill array diagonals.
     */
    private static void fillArrayDiagonals(int[][] array, int a) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || i + j == array.length - 1)
                    array[i][j] = 1;
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * This method accept int array and find min and max numbers.
     *
     * @param array int array.
     */
    private static void findMinMaxInArray(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.printf("min: %d\n", min);
        System.out.printf("max: %d\n", max);
    }

    /**
     * This method accept int array and check balance
     *
     * @param array int array
     * @return return true if there is a place in the array where
     * the sum of the left and right parts of the array are equal
     * return false if not.
     */
    private static boolean checkBalance(int[] array) {
        int sumLeft = 0;
        for (int i = 0; i < array.length; i++) {
            sumLeft += array[i];
            int sumRight = 0;
            for (int j = i + 1; j < array.length; j++) {
                sumRight += array[j];
            }
            if (sumLeft == sumRight)
                return true;
        }
        return false;
    }

    /**
     * This method shift int array numbers by int n.
     * @param array int array.
     * @param n quantity of times that numbers will be shift.
     */
    private static void shiftArrayNumbers(int[] array, int n) {
        int lastIndex = array.length - 1;
        for (int j = 0; j < (n < 0 ? n * -1 : n); j++) {
            if (n > 0) {
                int lastNumber = array[lastIndex];
                for (int i = lastIndex; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = lastNumber;
            } else {
                int firstNumber = array[0];
                for (int i = 0; i < lastIndex; i++) {
                    array[i] = array[i + 1];
                }
                array[lastIndex] = firstNumber;
            }
        }
    }
}
