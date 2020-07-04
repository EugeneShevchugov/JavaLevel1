package OOP.Animals;

public class Cat extends Animal {
    public Cat() {
        super(2, 200, 0);
    }

    @Override
    public void run(double value) {
        System.out.println(value <= maxRun);
    }

    @Override
    public void swim(double value) {
        System.out.println(false);
    }

    @Override
    public void jump(double value) {
        System.out.println(value <= maxJump);
    }
}
