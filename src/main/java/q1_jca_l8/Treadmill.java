package q1_jca_l8;

public class Treadmill implements Obstacle{
    private int dist;

    public Treadmill(int dist) {
        this.dist = dist;
    }

    @Override
    public void passObstacle(Participant p) {
        p.run(dist);
    }
}
