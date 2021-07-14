package q1_jca_l6.animal;

import q1_jca_l6.obstacle.Obstacle;

public class Cat extends Animal{
    public Cat(String name) {
        this.runDistance = 200;
        this.swimDistance = 0;
        this.jumpHeight = 1;
        this.name = name;
    }

    @Override
    public void passObstacle(Obstacle obstacle) {
        obstacle.pass(runDistance, swimDistance, jumpHeight, name);
    }
}