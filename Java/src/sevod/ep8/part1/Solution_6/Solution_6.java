package sevod.ep8.part1.Solution_6;

public class Solution_6 {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }
    public static Drink getDeliciousDrink() {
        return new Wine();
    }
    public static Wine getWine() {
        return new Wine();
    }
    public static Wine getBubblyWine() {
        return new BubblyWine();
    }
}
