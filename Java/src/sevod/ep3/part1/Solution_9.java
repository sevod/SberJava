package sevod.ep3.part1;

import java.util.Scanner;

public class Solution_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        int j = 1;

        while (i <= 9) {
            while (j <= 9) {
                if (i * j < 10 && j > 1) //выравниваем по правому краю
                    System.out.print(" ");
                System.out.print(i * j + " ");
                j++;
            }
            System.out.println("");
            j = 1;
            i++;
        }
    }
}
