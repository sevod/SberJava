package sevod.ep2.part2;

import java.util.Scanner;

public class Solution_6 {
    public static void main(String[] args) {
        String name;
        int count;
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        count = scanner.nextInt();

        System.out.println("Master " + name + " is here with " + count + " jedis");
    }
}
