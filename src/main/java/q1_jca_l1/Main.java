package q1_jca_l1;

public class Main {
    public static void main(String[] args) {
        float g = getResult(1, 3, 4, 5);
        System.out.println(g);

        System.out.println(checkNumbers(122, 8));

        checkNumberSign(-3);

        System.out.println(checkSignOfNumber(-2));

        greeting("Василий");

        checkYear(900);
    }

    private static float getResult(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean checkNumbers(int a, int b) {
        int s = a + b;
        return 10 <= s && s <= 20;
    }

    private static void checkNumberSign(int a) {
        String st = a < 0 ? "Число отрицательное!" : "Число положительное!";
        System.out.println(st);
    }

    private static boolean checkSignOfNumber(int a) {
        return a < 0;
    }

    private static void greeting(String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static void checkYear(int i) {
        String st = i % 4 == 0 && i % 100 != 0 || i % 400 == 0 ? "Год високосный!" : "Год не високосный!";
        System.out.println(st);
    }
}
