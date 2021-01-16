package sevod.ep4.part2;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrList_5 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> arrStr = new ArrayList<>();
        int min;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            arrStr.add(scanner.nextLine());
        }

        min = arrStr.get(0).length();

        for (String str : arrStr)
            if (str.length() < min)
                min = str.length();

        for (String str : arrStr)
            if (str.length() == min)
                System.out.println(str);
    }
}
