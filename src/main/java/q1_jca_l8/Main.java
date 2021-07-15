package q1_jca_l8;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human("Vasia", 200, 3),
                new Robot("RValodia", 150, 1),
                new Cat("Barsik", 300, 4),
                new Human("Maria", 250, 3),
                new Robot("RVania", 170, 2),
                new Cat("Murzik", 100, 2)
        };

        Obstacle[] obstacles = {
                new Treadmill(160),
                new Wall(3)
        };

        for (Participant p : participants) {
            for (Obstacle o : obstacles) {
                o.passObstacle(p);
                if (p.isDroppedOut()) {
                    break;
                }
            }
            p.info();
        }
    }
}
