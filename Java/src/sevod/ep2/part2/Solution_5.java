package sevod.ep2.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution_5 {
    public static void main(String[] args) throws IOException {
        String name1;
        String name2;
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        name1 = bufferedReader.readLine();
        name2 = bufferedReader.readLine();

        System.out.println("" + name1 + " + " + name2 + " = True love!" );

    }
}
