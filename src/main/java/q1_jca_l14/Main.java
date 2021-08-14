package q1_jca_l14;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArraysCompute ac = new ArraysCompute();
        int[] a1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
//        int[] a1 = {1, 2, 1, 8, 2, 3, 9, 1, 7};
        int[] a2 = ac.getNewArray(4, a1);
        System.out.println(Arrays.toString(a2));

//        int[] arr = {1, 1, 1, 4, 4, 1, 4, 4};
//        int[] arr = {1, 1, 1, 1, 1, 1};
//        int[] arr = {4, 4, 4, 4};
        int[] arr = {1, 4, 4, 1, 1, 4, 3};
        System.out.println(ac.checkArrayNumbers(1, 4, arr));
    }
}
