package sevod.ep5.part2;

import java.io.IOException;

public class Solution_1 {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            int a = 42 / 0;
        }catch (ArithmeticException e){
            //напишите тут ваш код
            System.out.println(e);
        }
    }
}
