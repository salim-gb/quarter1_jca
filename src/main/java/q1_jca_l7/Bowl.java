package q1_jca_l7;

public class Bowl {
    private int food;

    public void putFoodIntoBowl(int amount) {
        this.food += amount;
        System.out.printf("Еда в миске добавлена на %d, сейчас в миске: %d\n", amount, this.food);
    }

    public boolean decreaseFoodFromBowl(int amount) {
        if (this.food - amount >= 0) {
            this.food -= amount;
            return true;
        }
        return false;
    }

    public int getFood() {
        return food;
    }
}
