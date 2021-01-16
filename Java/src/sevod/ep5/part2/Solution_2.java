package sevod.ep5.part2;

public class Solution_2 {
    public static void main(String[] args) {
        //напишите тут ваш код
        String s = null;
        try {
            String m = s.toLowerCase();
        }catch (NullPointerException e){
            System.out.println(e);
        }
    }
}
