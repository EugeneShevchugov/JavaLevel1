package OOP.CatEat;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            satiety = true;
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}
