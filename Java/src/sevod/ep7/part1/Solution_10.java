package sevod.ep7.part1;

public class Solution_10 {
    public static void main(String[] args) {
        Padavan padavan = new Padavan();
        System.out.println(padavan);
    }
    public static interface YodaStyle {
        public void workHard();
    }
    public static class Padavan extends Jedi implements YodaStyle {

    }

    public static class Jedi implements YodaStyle {
        @Override
        public void workHard() {

        }
    }
}
