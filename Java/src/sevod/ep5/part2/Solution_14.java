package sevod.ep5.part2;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_14 {
    public static void main(String[] args) {
        readData();
    }
    public static void readData() {
        ArrayList<Integer> numb = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                numb.add(scanner.nextInt());
            }
        }catch (Exception e){

        }
        for (int num: numb){
            System.out.println(num);
        }
    }
}
