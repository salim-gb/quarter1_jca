package q1_jca_l7;

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl();
        bowl.putFoodIntoBowl(100);
        Cat[] cats = {
                new Cat("Nosik", 1),
                new Cat("Murzik", 20),
                new Cat("Barsik", 23),
                new Cat("Sharik", 15),
                new Cat("Rozik", 11),
                new Cat("Fozik", 27),
                new Cat("Zazik", 9),
        };

        for (Cat cat : cats) {
            cat.eat(bowl);
            cat.isSatiety();
        }
    }
}
