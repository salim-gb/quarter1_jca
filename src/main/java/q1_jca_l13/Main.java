package q1_jca_l13;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int CARS_COUNT = 4;
    public static CyclicBarrier barrier;
    public static Semaphore semaphore;
    public static int flag = 0;

    public static void main(String[] args) {
        barrier = new CyclicBarrier(CARS_COUNT, () -> {
            if (flag == 0) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                flag = 1;
            } else {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            }
        });
        semaphore = new Semaphore(CARS_COUNT / 2);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            int speed = 20 + (int) (Math.random() * 100);
            cars[i] = new Car(race, speed, barrier);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
    }
}



