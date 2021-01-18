package sevod.ep8.part1.Solution_8;

public class TalonStarFighter extends StarFighter{
    @Override
    public int getSalesPerMonth() {
        return 4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Type - " + this.getClass().getSimpleName() + getSalesPerMonth() + " purchases per month.";
    }
}
