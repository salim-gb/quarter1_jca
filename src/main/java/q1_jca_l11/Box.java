package q1_jca_l11;

import java.util.ArrayList;

public class Box<F extends Fruit> {
    private ArrayList<F> list;

    public Box() {
        list = new ArrayList<F>();
    }

    public void putFruitInBox(F fruit) {
        list.add(fruit);
    }

    public Float getWeight() {
        return list.size() * list.get(0).getWeight();
    }

    public boolean compare(Box<? extends Fruit> another) {
        return this.getWeight().equals(another.getWeight());
    }

    public void moveFruitToAnotherBox(Box<F> box) {
        box.list.addAll(this.list);
        this.list.clear();
    }

    public void info() {
        if (this.list.isEmpty()) {
            System.out.println("Коробка пустая");
        } else {
            System.out.println("В коробке есть " + this.list.size() + " кг " + this.list.get(0).kind);
        }
    }
}
