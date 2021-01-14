package sevod.ep1.part1;

public class Solution_7 {
    public static void main(String[] args) {
        int x = 2;
        int y = 12;

        //y = x * y;
        y = x + y;

        x = y - x;
        y = y - x;

        System.out.println(x);
        System.out.println(y);
    }
}
