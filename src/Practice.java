import java.util.Random;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        String[] words = {"apple", "orange",
                "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        game2(words);
    }

    public static void game() {
        Random r = new Random();
        int guess = r.nextInt(10);
        String s = "";
        Scanner scanner = new Scanner(System.in);
        while (!s.equals("0")) {
            int count = 3;
            System.out.println("Угадайте число от 0 до 9!");
            do {
                int number = scanner.nextInt();
                count--;
                if (number < guess) {
                    System.out.println("Число больше!");
                }
                else if (number > guess) {
                    System.out.println("Число меньше!");
                }
                else {
                    System.out.println("Вы победили!");
                    break;
                }
            } while (count > 0);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            scanner.nextLine();
            s = scanner.nextLine();
        }
    }

    public static void game2(String[] words) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        int number = r.nextInt(words.length);
        String guess = words[number];
        System.out.println("Угадайте слово, загаданное компьютером!");
        String s;
        while (true) {
            String ans = "";
            s = scanner.nextLine();
            if (s.equals(guess)) {
                System.out.println("Вы угадали!");
                break;
            }
            int length = findLength(guess, s);
            for (int i = 0; i < length; i++) {
                if (guess.charAt(i) == s.charAt(i)) {
                    ans += guess.charAt(i);
                }
                else {
                    ans += "#";
                }
            }
            System.out.print(ans);
            for (int i = 0; i < 15 - ans.length(); i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static int findLength(String a, String b) {
        if (a.length() > b.length()) {
            return b.length();
        }
        return a.length();
    }
}
