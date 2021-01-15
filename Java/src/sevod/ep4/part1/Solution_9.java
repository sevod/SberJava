package sevod.ep4.part1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution_9 {
    public static int max = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String max = "The max is ";
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        max = max + (a > b ? a : b);
        System.out.println(max);
    }
}
