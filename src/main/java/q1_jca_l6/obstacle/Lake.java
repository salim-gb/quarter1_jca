package q1_jca_l6.obstacle;

public class Lake extends Obstacle{

    public Lake(int length) {
        this.obstacleValue = length;
    }

    @Override
    public void pass(int runD, int swimD, int jumpD, String name) {
        this.distanceCanSwim = swimD;
        this.name = name;
        swimThrowTheLake();
    }

    public void swimThrowTheLake() {
        if (distanceCanSwim == 0) {
            System.out.printf("%s can not swim.\n", this.name);
        } else if (obstacleValue <= distanceCanSwim) {
            System.out.printf("%s has swim throw lake.\n", this.name);
        } else {
            System.out.printf("%s has swim just %dm\n", this.name, distanceCanSwim);
        }
    }
}