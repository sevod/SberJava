package sevod.ep7.part2;

public class Solution_6 {
    public static void main(String[] args) throws Exception {
    }
    public interface Weapon {
        //Power getPower(); кривая задача
    }
    public abstract static class Starkiller implements Weapon {
        public String getName() {
            return "Starkiller";
        }
    }
}
