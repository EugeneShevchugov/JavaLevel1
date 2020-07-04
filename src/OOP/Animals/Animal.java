package OOP.Animals;

public abstract class Animal {
    protected double maxJump;
    protected double maxRun;
    protected double maxSwim;

    public Animal(double maxJump, double maxRun, double maxSwim) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
    }

    public abstract void run(double value);

    public abstract void swim(double value);

    public abstract void jump(double value);

    protected static double dispersion(double left, double right) {
        return (Math.random() * (right - left) + left);
    }
}
