package q1_jca_l11;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d"};
        System.out.println("Array origin: " + Arrays.toString(array));
        swapArrayElements(array, 0, 1);
        System.out.println("Array after swapping: " + Arrays.toString(array));

        List<String> list = convertArrayToList(array);

        Orange orange = new Orange();
        Apple apple = new Apple();

        Box<Apple> boxA1 = new Box<>();
        boxA1.putFruitInBox(new Apple());
        boxA1.putFruitInBox(new Apple());

        Box<Apple> boxA2 = new Box<>();
        boxA2.putFruitInBox(new Apple());
        boxA2.putFruitInBox(new Apple());

        Box<Orange> boxO1 = new Box<>();
        boxO1.putFruitInBox(new Orange());
        boxO1.putFruitInBox(new Orange());

        Float appleWeight = boxA1.getWeight();
        System.out.println("коробка яблока весит: " + appleWeight);

        Float orangeWeight = boxO1.getWeight();
        System.out.println("коробка апельсина весит: " + orangeWeight);

        System.out.println("Сравнивание весь коробки boxA1 и boxA2 : " + boxA1.compare(boxA2));
        System.out.println("Сравнивание весь коробки boxA1 и boxO1 : " + boxA1.compare(boxO1));

        boxA1.info();
        boxA2.info();
        boxA1.moveFruitToAnotherBox(boxA2);
        boxA1.info();
        boxA2.info();

        boxO1.info();

    }

    public static <T> void swapArrayElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static <E> List<E> convertArrayToList(E[] array) {
        return Arrays.asList(array);
    }
}

