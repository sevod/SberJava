package sevod.ep2.part2;

import java.util.Scanner;

public class Solution_9 {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        System.out.println(sumDigitsInNumber(num));
    }
    public static int sumDigitsInNumber(int number) {
        int a = 0;

        for (int i = 0; i < 3; i++) {
            a = a + number % 10;
            number = (number - number % 10) / 10;
        }
        return a;
    }
}
