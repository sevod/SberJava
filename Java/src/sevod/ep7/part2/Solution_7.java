package sevod.ep7.part2;

import java.awt.*;

public class Solution_7 {
    public static void main(String[] args) throws Exception {
        Solo Ren = new Ren();
        System.out.println(Ren.getName());
        System.out.println(Ren.getSwordColor());
    }
    public interface Sith {
        Color getSwordColor();
    }
    public static abstract class Solo implements Sith {
        public String getName() {
            return "Kylo";
        }
    }
    public static class Ren extends Solo {
//        public Color SwordColor() {
//            return Color.RED;
//        }

        @Override
        public Color getSwordColor() {
            return Color.RED;
        }
    }
}
