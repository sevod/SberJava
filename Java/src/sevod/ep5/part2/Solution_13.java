package sevod.ep5.part2;

public class Solution_13 {
    public static void main(String[] args) {
        try {
            divideByZero();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void divideByZero() {
        System.out.println(12/0);
    }
}
