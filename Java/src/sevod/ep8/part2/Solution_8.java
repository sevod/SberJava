package sevod.ep8.part2;

import java.util.Scanner;

public class Solution_8 {
    public static int A;
    public static int B;

    static {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        scanner.close();
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) {

        System.out.println(MIN);
    }
    public static int min(int a, int b) {
        return Math.min(a, b);
    }
}
