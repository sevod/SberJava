package sevod.ep3.part1;

import java.util.Scanner;

public class Solution_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        int n = scanner.nextInt();
        int i = 1;

        while (i <= n){
            System.out.println(message);
            i++;
        }
    }
}
