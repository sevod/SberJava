package sevod.ep5.part2;

import java.util.ArrayList;

public class Solution_4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            String s = list.get(18);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}
