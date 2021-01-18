package sevod.ep8.part2;

import sevod.ep2.part1.Solution_3;

public class Solution_1 {
    //добавьте классы MagmaGuard и GalaticMarine тут
    public static class MagnaGuard extends Droid {
        @Override
        public String getName() {
            return "I am a Magma Guard, " + super.getName();
        }
    }

    public static class GalaticMarine extends Clone{
        @Override
        public String getName() {
            return "I am a Galactic Marine, " + super.getName();
        }
    }

    public static class Droid {
        protected String getName() {
            return "I am a droid";
        }
    }
    public static class Clone {
        String getName() {
            return "I am a clone soldier";
        }
    }

    public static void main(String[] args) {
        System.out.println((new MagnaGuard()).getName());
        System.out.println((new GalaticMarine()).getName());
    }
}
