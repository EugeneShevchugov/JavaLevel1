import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // first task
        int[] zeroOne = new int[]{0, 1, 1, 1, 0, 0, 1, 0, 1, 0};
        for (int i = 0; i < zeroOne.length; i++) {
            if (zeroOne[i] == 0) {
                zeroOne[i] = 1;
            } else {
                zeroOne[i] = 0;
            }
        }
        // second task
        int[] eightSize = new int[8];
        for (int i = 0, j = 0; i < 8; i++, j += 3) {
            eightSize[i] = j;
        }
        // third task
        int[] third = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < third.length; i++) {
            if (third[i] < 6) {
                third[i] *= 2;
            }
        }
        // fourth task
        int[][] fourth = new int[][]{{2, 2, 3}, {2, 2, 3}, {2, 2, 3}};
        for (int i = 0; i < fourth.length; i++) {
            for (int j = 0; j < fourth.length; j++) {
                if (i == j) {
                    fourth[i][j] = 1;
                }
            }
        }
        // five task
        int[] five = new int[]{1, 5, 3, 10, 29, 15, 100, 209};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : five) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(Arrays.toString(move(new int[]{1, 2, 3, 4}, 3)));
        System.out.println(Arrays.toString(move(new int[]{1, 2, 3, 4}, -3)));
    }
    // I am not sure about this solution, six task
    public static boolean checkBalance(int[] array) {
        if (array.length <= 1) return false;
        return Arrays.stream(array).sum() % 2 == 0;
    }
    // seven task
    public static int[] move(int[] arr, int n) {
        int temp;
        if (n == 0) return arr;
        if (n > 0) {
            n = n % arr.length;
            for (int i = 0; i < n; i++) {
                temp = arr[arr.length - 1];
                System.arraycopy(arr, 0, arr, 1, arr.length - 1);
                arr[0] = temp;
            }
            return arr;
        }
        n *= -1;
        n %= arr.length;
        for (int i = 0; i < n; i++) {
            temp = arr[0];
            System.arraycopy(arr, 1, arr, 0, arr.length - 1);
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

} 