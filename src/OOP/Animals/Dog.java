package OOP.Animals;

public class Dog extends Animal {
    public Dog() {
        super(0.5, 500, 10);
    }

    @Override
    public void run(double value) {
        System.out.println(value <= maxRun);
    }

    @Override
    public void swim(double value) {
        System.out.println(value <= maxSwim);
    }

    @Override
    public void jump(double value) {
        System.out.println(value <= maxJump);
    }
}
