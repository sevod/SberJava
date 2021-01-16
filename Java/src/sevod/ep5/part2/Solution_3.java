package sevod.ep5.part2;

public class Solution_3 {
    public static void main(String[] args) {
        int[] m = new int[3];
        //напишите тут ваш код
        try{
            m[6] = 5;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}
