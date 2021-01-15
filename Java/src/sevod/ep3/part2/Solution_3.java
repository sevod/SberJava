package sevod.ep3.part2;

public class Solution_3 {
    public static void main(String[] args) {
        Jedi Joda = new Jedi ("Joda", 150, 120, "jodanec");
        Jedi Obi = new Jedi ("Obi", 50, 180, "human");
        Jedi I = new Jedi ("I", 20, 190, "i");
    }

    public static class Jedi {
        private String name;
        private int age;
        private String race;
        private int height;

        public Jedi(String name, int age, int height, String race) {
            this.name = name;
            this.age = age;
            this.race = race;
            this.height = height;
        }
    }
}
