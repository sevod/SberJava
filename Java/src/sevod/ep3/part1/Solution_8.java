package sevod.ep3.part1;

import java.util.Scanner;

public class Solution_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        int j = 1;

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        while (i <= m){
            while (j <= n){
                System.out.print("*");
                j++;
            }
            System.out.println("");
            j = 1;
            i++;
        }
    }
}
