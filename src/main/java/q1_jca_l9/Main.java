package q1_jca_l9;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "f", "4"},
                {"1", "2", "3", "3"}
        };
        sumArrayElements(array);
    }

    public static void sumArrayElements(String[][] array) {
        if (!checkArraySize(array, 4, 4)) throw new MyArraySizeException("Array have to be 4 * 4");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("In cell [" + (i + 1) + "][" + (j + 1) + "] not valid data");
                }
            }
        }
        System.out.printf("sum of array elements: %d\n", sum);
    }

    public static boolean checkArraySize(String[][] array, int a, int b) {
        if (array.length != a) return false;
        for (String[] arr : array) {
            if (arr.length != 4) return false;
        }
        return true;
    }
}
