package sevod.ep8.part1.Solution_8;

public class ChelaStarFighter extends StarFighter{
    @Override
    public int getSalesPerMonth() {
        return 2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Type - " + this.getClass().getSimpleName() + getSalesPerMonth() + " purchases per month.";
    }
}
