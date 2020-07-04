package OOP.Animals;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.swim(6);
        animal1.swim(17);
        animal1.jump(0.2);
        animal1.jump(0.9);
        animal1.run(250);
        animal1.run(690);

        Animal animal2 = new Cat();
        animal2.swim(0);
        animal2.swim(10);
        animal2.jump(1.1);
        animal2.jump(2.2);
        animal2.run(51);
        animal2.run(205);
    }

}
