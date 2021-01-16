package sevod.ep4.part2;

import java.util.Arrays;
import java.util.Scanner;

public class Select_3 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] mainArr = new int[20];
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int sum1;
        int sum2;

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 20; i++) {
            mainArr[i] = scanner.nextInt();
        }

        System.arraycopy(mainArr, 0, arr1, 0, 10);

        System.arraycopy(mainArr, 10, arr2, 0, 10);

        sum1 = Arrays.stream(arr1).sum();
        sum2 = Arrays.stream(arr2).sum();

        System.out.println(Math.max(sum1, sum2));
    }
}
