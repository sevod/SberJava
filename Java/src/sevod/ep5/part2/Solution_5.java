package sevod.ep5.part2;

import java.util.HashMap;

public class Solution_5 {
    public static void main(String[] args) {

        try {
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);
        }
        catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
