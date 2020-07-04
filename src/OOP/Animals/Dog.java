package OOP.Animals;

public class Dog extends Animal {
    public Dog() {
        super(dispersion(0.1, 0.8), dispersion(200, 701), dispersion(5, 16));
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
