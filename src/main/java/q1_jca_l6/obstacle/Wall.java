package q1_jca_l6.obstacle;

public class Wall extends Obstacle{

    public Wall(int height) {
        this.obstacleValue = height;
    }

    @Override
    public void pass(int runD, int swimD, int jumpH, String name) {
        this.heightCanJump = jumpH;
        this.name = name;
        jumpOverWall();
    }

    public void jumpOverWall() {
        if (heightCanJump == 0) {
            System.out.printf("%s can not jump.\n", this.name);
        } else if (obstacleValue <= heightCanJump) {
            System.out.printf("%s jump over the wall.\n", this.name);
        } else {
            System.out.printf("%s has jump just %dm\n", this.name, heightCanJump);
        }
    }
}
