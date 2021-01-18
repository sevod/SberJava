package sevod.ep8.part1;

public class Solution_2 {
    public static void main(String[] args) {
        Porg animal = new Animal();
        boolean isPorg = animal instanceof Porg;
        boolean isMovable = animal instanceof CanMove;
        boolean isAnimal = animal instanceof Animal;

        if (isPorg && isMovable && isAnimal)
            System.out.println("Ahhh!");
    }
    interface CanMove {
    }

    static class Porg implements CanMove {
    }

    static class Animal extends Porg {
    }
}
