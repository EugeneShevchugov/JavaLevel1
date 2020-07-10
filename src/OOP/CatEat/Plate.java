package OOP.CatEat;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n > food) {
            System.out.println("В тарелке нет столько еды");
            return false;
        }
        else {
            System.out.println("Кот поел");
            food -= n;
            return true;
        }
    }

    public void info() {
        System.out.println("В тарелке " + food + " еды");
    }

    public void addFood(int n) {
        food += n;
    }
}
