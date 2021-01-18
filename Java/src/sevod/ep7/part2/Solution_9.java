package sevod.ep7.part2;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_9 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            while (fileInputStream.available() > 0){
                System.out.println((char)fileInputStream.read());
            }
            fileInputStream.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
