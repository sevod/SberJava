package sevod.ep4.part2;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrList_6 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> arrStr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            arrStr.add(scanner.nextLine());
        }

        for (int i = 0; i < 13; i++) {
            arrStr.add(0, arrStr.get(4));
            arrStr.remove(5);
        }

        for (String str: arrStr){
            System.out.println(str);
        }
    }
}
