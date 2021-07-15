package q1_jca_l8;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height= height;
    }
    @Override
    public void passObstacle(Participant p) {
        p.jump(height);
    }
}
