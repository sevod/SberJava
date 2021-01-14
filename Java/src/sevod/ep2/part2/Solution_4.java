package sevod.ep2.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution_4 {
    public static void main(String[] args) throws IOException {
        String name;

        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        name = bufferedReader.readLine();

        System.out.println("" + name + " - is a header of the Senate");
    }
}
