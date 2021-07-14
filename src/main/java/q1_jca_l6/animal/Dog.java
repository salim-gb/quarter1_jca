package q1_jca_l6.animal;

import q1_jca_l6.obstacle.Obstacle;

public class Dog extends Animal{
    public Dog(String name) {
        this.runDistance = 500;
        this.swimDistance = 10;
        this.jumpHeight = 2;
        this.name = name;
    }

    @Override
    public void passObstacle(Obstacle obstacle) {
        obstacle.pass(runDistance, swimDistance, jumpHeight, name);
    }
}