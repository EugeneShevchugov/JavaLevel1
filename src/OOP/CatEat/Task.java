package OOP.CatEat;

public class Task {
    public static void printInfoAboutCats() {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Tom", 1);
        cats[1] = new Cat("Murzik", 5);
        cats[2] = new Cat("Barsik", 3);
        Plate plate = new Plate(6);
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            System.out.println(String.format("Кот %s сыт? : %s", cats[i].getName(), cats[i].isSatiety()));
        }
    }
}
