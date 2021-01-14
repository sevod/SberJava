package sevod.ep2.part1;

public class Solution_10 {
    public static int max(int a, int b, int c, int d) {
        if (max(a, b) > max(c, d))
            return max(a, b);
        else
            return max(c, d);
    }
    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(max(-20, -10));
        System.out.println(max(-40, -10, -30, 40));
        System.out.println(max(-20, -40, -30, 40));
        System.out.println(max(-20, -10, -40, 40));
        System.out.println(max(-20, -10, -30, -40));
    }
}
