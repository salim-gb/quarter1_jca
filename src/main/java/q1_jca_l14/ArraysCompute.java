package q1_jca_l14;

public class ArraysCompute {
    public int[] getNewArray(int a, int[] arr) {
        int lastIndexOfNumber = getLastIndexOfNumberInArray(a, arr);
        int[] newArray = new int[arr.length - lastIndexOfNumber - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i > lastIndexOfNumber) newArray[i - lastIndexOfNumber - 1] = arr[i];
        }
        return newArray;
    }

    public boolean isArrayContainNumber(int a, int[] arr) {
        int count = 0;
        for (int e : arr) {
            if (e == a) {
                count++;
            }
        }
        return (count != 0);
    }

    public int getLastIndexOfNumberInArray(int a, int[] arr) {
        if (!isArrayContainNumber(a, arr)) throw new RuntimeException("The array dont contain number " + a);
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) lastIndex = i;
        }
        return lastIndex;
    }

    public boolean checkArrayNumbers(int a, int b, int[] arr) {
        boolean isPresentA = false;
        boolean isPresentB = false;
        boolean isPresentAnotherDigit = false;
        for (int e : arr) {
            if (e == a) isPresentA = true;
            if (e == b) isPresentB = true;
            if (e != a && e != b) isPresentAnotherDigit = true;
        }
        return isPresentA && isPresentB && !isPresentAnotherDigit;
    }
}
