package q1_jca_l11;

public abstract class Fruit {
    protected String kind;
    protected float weight;

    public Fruit(float weight, String kind) {
        this.weight = weight;
        this.kind = kind;
    }

    public float getWeight() {
        return weight;
    }
}
