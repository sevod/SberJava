package sevod.ep7.part1;

public class Solution_7 {
    public static void main(String[] args) {
    }
    public static abstract class Predator {
        public abstract String getName();
    }
    public static class Rathtar extends Predator {
        public String name = "Rathtar";

        public String getName(){
            return name;
        }
    }
}
