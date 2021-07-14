package q1_jca_l6.obstacle;

public class Treadmill extends Obstacle{

    public Treadmill(int length) {
        this.obstacleValue = length;
    }

    @Override
    public void pass(int runD, int swimD, int jumpD, String name) {
        this.distanceCanRun = runD;
        this.name = name;
        runThrowTheTradmill();
    }

    public void runThrowTheTradmill() {
        if (distanceCanRun == 0) {
            System.out.printf("%s can not run.\n", this.name);
        } else if (obstacleValue <= distanceCanRun) {
            System.out.printf("%s has run throw the tradmill.\n", this.name);
        } else {
            System.out.printf("%s has run just %dm\n", this.name, distanceCanRun);
        }
    }
}