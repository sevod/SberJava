package sevod.ep5.part2;

public class Solution_6 {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        }catch (NumberFormatException e){
            System.out.println(e);
        }
    }
}
