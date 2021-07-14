package q1_jca_l6.obstacle;

public abstract class Obstacle {
    protected int obstacleValue;
    protected int distanceCanRun;
    protected int distanceCanSwim;
    protected int heightCanJump;
    protected String name;

    public void pass(int runD, int swimD, int jumpD, String name) {}
}