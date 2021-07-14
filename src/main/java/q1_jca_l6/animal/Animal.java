package q1_jca_l6.animal;

import q1_jca_l6.obstacle.Obstacle;

public abstract class Animal {
    protected String name;
    protected int runDistance;
    protected int swimDistance;
    protected int jumpHeight;

    public void run(int length) {
        if (runDistance == 0) {
            System.out.printf("%s can not run.\n", name);
        } else if (length <= runDistance) {
            System.out.printf("%s has run %d\n", name, length);
        } else {
            System.out.printf("%s has run just %d\n", name, runDistance);
        }
    }

    public void swim(int length) {
        if (swimDistance == 0) {
            System.out.printf("%s can not swim.\n", name);
        } else if (length <= swimDistance) {
            System.out.printf("%s has swim %d\n", name, length);
        } else {
            System.out.printf("%s has swim just %d\n", name, swimDistance);
        }
    }

    public void jump(int height) {
        if (jumpHeight == 0) {
            System.out.printf("%s can not jump.\n", name);
        } else if (height <= jumpHeight) {
            System.out.printf("%s has swim %d\n", name, height);
        } else {
            System.out.printf("%s has swim just %d\n", name, jumpHeight);
        }
    }

    public void passObstacle(Obstacle obstacle){}
}