package OOP.Animals;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.swim(5);
        animal1.swim(11);
        animal1.jump(0.4);
        animal1.jump(0.6);
        animal1.run(499);
        animal1.swim(501);

        Animal animal2 = new Cat();
        animal2.swim(0);
        animal2.swim(10);
        animal2.jump(1.9);
        animal2.jump(2.5);
        animal2.run(180);
        animal2.swim(205);
    }
}
