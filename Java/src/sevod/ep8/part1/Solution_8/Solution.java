package sevod.ep8.part1.Solution_8;

public class Solution {
    public static void main(String[] args) {
        StarFighter starFighter = Shop.getStarFighter("TheStartSaber");
        System.out.println(starFighter.getDescription());
    }
    static class Shop {
        static StarFighter getStarFighter(String classOfStringFighter) {
            StarFighter starFighter = null;
            if (classOfStringFighter.equals("TheStartSaber")) {
                return new TheStartSaber();
            } else if (classOfStringFighter.equals("Chela")) {
                return new ChelaStarFighter();
            } else if (classOfStringFighter.equals("Aurek")) {
                return new AurekStarFighter();
            } else if (classOfStringFighter.equals("Talon")) {
                return new TalonStarFighter();
            } else {
                return starFighter;
            }
        }
    }
}
