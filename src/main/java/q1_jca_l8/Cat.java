package q1_jca_l8;

public class Cat implements Participant{
    private String name;
    private int maxRunDis;
    private int maxJumpHeight;
    private boolean droppedOut;

    public Cat(String name, int maxRunDis, int maxJumpHeight) {
        this.name = name;
        this.maxRunDis = maxRunDis;
        this.maxJumpHeight = maxJumpHeight;
        this.droppedOut = false;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDis) {
            System.out.printf("%s пробежал %d\n", name, dist);
        } else {
            System.out.printf("%s не смог пробежать %d\n", name, dist);
            droppedOut = true;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.printf("%s прыгнул %d\n", name, height);
        } else {
            System.out.printf("%s не смог прыгнуть %d\n", name, height);
            droppedOut = true;
        }
    }

    @Override
    public void info() {
        if (droppedOut){
            System.out.printf("%s вылетил из соревневании\n", name);
        } else {
            System.out.printf("%s прошел все этапы соревневании\n", name);
        }
    }

    @Override
    public boolean isDroppedOut() {
        return droppedOut;
    }
}
