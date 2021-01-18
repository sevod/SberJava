package sevod.ep8.part1;

import java.util.Scanner;

public class Solution_9 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        try {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            int i = Math.min(num1, num2) - 1;

            while (i > 1){
                if (num1 % i == 0 && num2 % i == 0){
                    System.out.println(i);
                    break;
                }
                i--;
            }

        }catch (Exception e){

        }
    }
}
