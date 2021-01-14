package sevod.ep3.part1;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;





public class Solution_10  {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            int i = 0;

            while (true) {
                i = scanner.nextInt();
                if (i > 0)
                    while (i > 0) {
                        System.out.println("Feel the power of Light Side");
                        i--;
                    }
                else if (i < 0)
                    while (i < 0) {
                        System.out.println("Feel the power of the Dark Side");
                        i++;
                    }
                else
                    break;
            }
        }
}
