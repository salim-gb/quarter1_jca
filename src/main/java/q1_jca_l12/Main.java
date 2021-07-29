package q1_jca_l12;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    static final int QUARTER = SIZE / 4;

    public static void main(String[] args) {
        System.out.println("Процесс начался...");

        long a1 = System.currentTimeMillis();
        float[] array1 = computeInOneThread();
        System.out.printf("В 1 потоке понадебалось: %d\n",System.currentTimeMillis() - a1);

        long a2 = System.currentTimeMillis();
        float[] array2 = computeInTwoThread();
        System.out.printf("В 2 потоках понадебалось: %d\n",System.currentTimeMillis() - a2);

        long a3 = System.currentTimeMillis();
        float[] array3 = computeInFourThread();
        System.out.printf("В 4 потоках понадебалось: %d\n",System.currentTimeMillis() - a3);

        System.out.println("Процесс закончиля...");

        System.out.printf("Массив 1 и 2 равны: %b\n",Arrays.equals(array1, array2));
        System.out.printf("Массив 1 и 3 равны: %b\n",Arrays.equals(array1, array3));
    }

    static float[] computeInOneThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        computeWithFormula(arr, 0);
        return arr;
    }

    static float[] computeInTwoThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread t1 = new Thread(() -> computeWithFormula(a1, 0));
        Thread t2 = new Thread(() -> computeWithFormula(a2, HALF));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        return arr;
    }

    static float[] computeInFourThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        float[] a1 = new float[QUARTER];
        float[] a2 = new float[QUARTER];
        float[] a3 = new float[QUARTER];
        float[] a4 = new float[QUARTER];
        System.arraycopy(arr, 0, a1, 0, QUARTER);
        System.arraycopy(arr, QUARTER, a2, 0, QUARTER);
        System.arraycopy(arr, HALF, a3, 0, QUARTER);
        System.arraycopy(arr, HALF + QUARTER, a4, 0, QUARTER);

        Thread t1 = new Thread(() -> computeWithFormula(a1, 0));
        Thread t2 = new Thread(() -> computeWithFormula(a2, QUARTER));
        Thread t3 = new Thread(() -> computeWithFormula(a3, HALF));
        Thread t4 = new Thread(() -> computeWithFormula(a4, HALF + QUARTER));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, QUARTER);
        System.arraycopy(a2, 0, arr, QUARTER, QUARTER);
        System.arraycopy(a3, 0, arr, HALF, QUARTER);
        System.arraycopy(a4, 0, arr, HALF + QUARTER, QUARTER);
        return arr;
    }

    static void computeWithFormula(float[] arr, int a) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + a) / 5) * Math.cos(0.2f + (i + a) / 5) * Math.cos(0.4f + (i + a) / 2));
        }
    }
}
