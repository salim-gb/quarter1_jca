package q1_jca_l6.animal;

import q1_jca_l6.animal.Animal;
import q1_jca_l6.animal.Cat;
import q1_jca_l6.animal.Dog;
import q1_jca_l6.obstacle.Lake;
import q1_jca_l6.obstacle.Treadmill;
import q1_jca_l6.obstacle.Wall;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = {
                new Cat("Barsik"),
                new Cat("Murzik"),
                new Dog("Bobik"),
                new Dog("Sharik")
        };

        for (Animal animal : animals) {
            /* 1, 2, 3, 4 */
            animal.run(600);
            animal.swim(15);
            /* 5 */
            animal.passObstacle(new Wall(2));
            animal.passObstacle(new Lake(12));
            animal.passObstacle(new Treadmill(150));
            System.out.println();
        }
    }
}