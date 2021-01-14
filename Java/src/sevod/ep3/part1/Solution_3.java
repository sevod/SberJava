package sevod.ep3.part1;

import java.util.Scanner;

public class Solution_3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number > 0)
            System.out.println("it’s Light side");
        else if (number < 0)
            System.out.println("it’s Dark side");
        else
            System.out.println("it’s balance");
    }
}
