package q1_jca_l7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Bowl bowl) {
        if (bowl.decreaseFoodFromBowl(appetite)) {
            this.satiety = true;
            System.out.printf("%s поел %d еды\n", this.name, this.appetite);
            System.out.printf("Еда в миске уменшелась на %d, сейчас в миске: %d\n", appetite, bowl.getFood());
        } else {
            System.out.printf("Не достаточно еды в миске что бы %s поел\n", this.name);
        }
    }

    public void isSatiety() {
        System.out.println(this.satiety ? this.name + " Сытый" : this.name + " Голодный");
    }
}
