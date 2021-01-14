package sevod.ep2.part2;

import java.util.Scanner;

public class Solution_10 {
    public static void main(String[] args) {
        int year = 0;
        Scanner scanner = new Scanner(System.in);
        year = scanner.nextInt();

        System.out.println(getYear(year));
    }
    public static int getYear(int number) {
       //хз чего  в задании требуется
       return 35 - number;
    }
}
