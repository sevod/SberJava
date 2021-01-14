package sevod.ep3.part1;

import java.util.Scanner;

public class Solution_4 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number > 0 && number % 2 == 0)
            System.out.println("compassion");
        else if (number > 0 && number % 2 != 0)
            System.out.println("mercy");
        else if (number < 0 && number % 2 == 0)
            System.out.println("pain");
        else if (number < 0 && number % 2 != 0)
            System.out.println("anger");
        else
            System.out.println("balance");
    }
}
