package sevod.ep4.part2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Order_8 {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        int len = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++)
            strings.add(scanner.nextLine());

        for (int i = 0; i < 10; i++){
            if (strings.get(i).length() < len){
                System.out.println(i + 1);
                break;
            } else
                len = strings.get(i).length();
        }
    }
}
