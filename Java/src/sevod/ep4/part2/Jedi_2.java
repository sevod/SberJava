package sevod.ep4.part2;

import java.io.Reader;
import java.util.Scanner;

public class Jedi_2 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int arr[] = new int[10];
        String strArr[] = new String[10];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            strArr[i] = scanner.nextLine();
        }

        for (int i = 0; i < 10; i++) {
            arr[i] = strArr[i].length();
        }

        for (int len: arr){
            System.out.println(len);
        }
    }
}
