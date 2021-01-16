package sevod.ep5.part1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starwars_8 {
    public static void main(String[] args) throws IOException {
        //Напишите тут ваш код
        int max = 0;
        int tmpMax = 1;
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++)
            list.add(scanner.nextInt());

        for (int i = 1; i < 10; i++) {
            if (list.get(i) == list.get(i - 1))
                tmpMax++;
            else {
                if (tmpMax > max)
                    max = tmpMax;
                tmpMax = 1;
            }
        }

        System.out.println(max);
    }
}
