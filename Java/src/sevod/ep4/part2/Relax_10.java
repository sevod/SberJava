package sevod.ep4.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Relax_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        ArrayList<Integer> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 9; i >= 0 ; i--) {
            System.out.println(strings.get(i));
        }
    }
}
