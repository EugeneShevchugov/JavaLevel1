import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        game();
    }

    public static void game() {
        boolean isGameOver = true;
        char playerChar = 'X';
        char computerChar = 'O';
        char emptyChar = '-';
        int SIZE = 5;
        char[][] field = new char[SIZE][SIZE];
        Scanner scanner = new Scanner(System.in);
        while (isGameOver) {
            initField(emptyChar, field, SIZE);
            printField(field, SIZE);
            while (true) {
                humanMove(playerChar, scanner, field, SIZE);
                printField(field, SIZE);
                if (checkWin(playerChar, field, SIZE)) {
                    System.out.println("Победил человек");
                    break;
                }
                if (checkMap(field, SIZE, emptyChar)) {
                    System.out.println("Ничья");
                    break;
                }
                computerMove(computerChar, field, SIZE);
                printField(field, SIZE);
                if (checkWin(computerChar, field, SIZE)) {
                    System.out.println("Победил компьютер");
                    break;
                }
                if (checkMap(field, SIZE, emptyChar)) {
                    System.out.println("Ничья");
                    break;
                }
            }
            System.out.println("Вы хотите продолжить? true - Да, false - Нет");
            isGameOver = scanner.nextBoolean();
        }

    }

    public static void initField(char emptyChar, char[][] field, int SIZE) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = emptyChar;
            }
        }
    }

    public static void printField(char[][] field, int SIZE) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checkMap(char[][] field, int SIZE, char sign) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == sign) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void humanMove(char playerChar, Scanner scanner, char[][] field, int SIZE) {
        int x, y;
        do {
            System.out.println("Ваш ход");
            System.out.println("Введите координаты x и y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!checkPos(x, y, field, SIZE));
        field[x][y] = playerChar;
    }

    public static boolean checkPos(int x, int y, char[][] field, int SIZE) {
        char emptyChar = '-';
        if (x < 0 || x > SIZE || y < 0 || y > SIZE) return false;
        return field[x][y] == emptyChar;
    }

    public static void computerMove(char computerChar, char[][] field, int SIZE) {
        int x, y;
        Random random = new Random();
        System.out.println("Ходит компьютер");
        do {
            if (computerThinking(field, SIZE, computerChar)) {
                return;
            } else {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }
        } while (!checkPos(x, y, field, SIZE));
        field[x][y] = computerChar;
    }

    public static boolean computerThinking(char[][] field, int SIZE, char sign) {
        int row = checkWinHorizontal('X', field, SIZE);
        if (thinkHorizontal(field, SIZE, sign, row)) {
            return true;
        }
        row = checkWinVertical('X', field, SIZE);
        return thinkVertical(field, SIZE, sign, row);
    }

    public static boolean thinkHorizontal(char[][] field, int SIZE, char sign, int row) {
        int countX = countDiagonalX(field, SIZE, row);
        if (countX != SIZE - 1) return false;
        return blockHorizontal(field, SIZE, row, sign);
    }

    public static boolean thinkVertical(char[][] field, int SIZE, char sign, int row) {
        int countX = countVerticalX(field, SIZE, row);
        if (countX != SIZE - 1) return false;
        return blockVertical(field, SIZE, row, sign);
    }

    public static boolean blockHorizontal(char[][] field, int SIZE, int row, char sign) {
        for (int j = 0; row < SIZE && j < SIZE; j++) {
            if (field[row][j] == '-') {
                field[row][j] = sign;
                return true;
            }
        }
        return false;
    }

    public static boolean blockVertical(char[][] field, int SIZE, int row, char sign) {
        int temp = row;
        row = 0;
        for (int j = temp; j < SIZE && row < SIZE; row++) {
            if (field[row][j] == '-') {
                field[row][j] = sign;
                return true;
            }
        }
        return false;
    }

    public static int countDiagonalX(char[][] field, int SIZE, int row) {
        int count = 0;
        for (int j = 0; j < SIZE && row < SIZE; j++) {
            if (field[row][j] == 'X') {
                count++;
            }
        }
        return count;
    }

    public static int countVerticalX(char[][] field, int SIZE, int row) {
        int count = 0;
        for (int i = 0; i < SIZE && row < SIZE; i++) {
            if (field[i][row] == 'X') {
                count++;
            }
        }
        return count;
    }

    public static int checkWinHorizontal(char sign, char[][] field, int SIZE) {
        int check = 0;
        int number = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == sign) {
                    check++;
                }
            }
            if (check == SIZE) {
                return check;
            }
            if (check == SIZE - 1) {
                number = i;
            }
            check = 0;
        }
        return number;
    }

    public static int checkWinVertical(char sign, char[][] field, int SIZE) {
        int check = 0;
        int number = 0;
        for (int i = 0, j = 0; i < SIZE && j < SIZE; i++) {
            if (field[i][j] == sign) {
                check++;
            } else {
                if (j == SIZE - 1) {
                    check = 0;
                } else {
                    check = 0;
                    j++;
                    i = -1;
                }
            }
            if (check == SIZE) {
                return check;
            }
            if (check == SIZE - 1) {
                number = j;
            }
        }
        return number;
    }

    public static int checkWinLeftDiagonal(char sign, char[][] field, int SIZE) {
        int check = 0;
        for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) {
            if (field[i][j] == sign) {
                check++;
            } else {
                return check;
            }
            if (check == SIZE) {
                return check;
            }
        }
        return 0;
    }


    public static int checkWinRightDiagonal(char sign, char[][] field, int SIZE) {
        int check = 0;
        for (int i = 0, j = SIZE - 1; i < SIZE && j >= 0; i++, j--) {
            if (field[i][j] == sign) {
                check++;
            } else {
                return check;
            }
            if (check == SIZE) {
                return check;
            }
        }
        return 0;
    }

    public static boolean checkWin(char sign, char[][] field, int SIZE) {
        return checkWinVertical(sign, field, SIZE) == SIZE || checkWinHorizontal(sign, field, SIZE) == SIZE
                ||
                checkWinLeftDiagonal(sign, field, SIZE) == SIZE || checkWinRightDiagonal(sign, field, SIZE) == SIZE;
    }
}
