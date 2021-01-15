package sevod.ep3.part2;

public class Solution_10 {
    public static void main(String[] args) {
        //напишите тут ваш код
        Jedi Joda = new Jedi("Joda", 20000);
        Jedi Obi = new Jedi("Obi", 50, 12000, "Tera", "human");
        Jedi Anakin = new Jedi("Anakin", 25, 20000, "Tera", "human");
        Anakin.sideForce = "dark";

    }
    static class Jedi {
        String name;
        int age;
        int midichlorians;
        String homeworld;
        String species;
        String sideForce = "light";
        //напишите тут ваш код


        public Jedi(String name, int midichlorians) {
            this.name = name;
            this.midichlorians = midichlorians;

        }

        public Jedi(String name, int age, int midichlorians, String homeworld, String species) {
            this.name = name;
            this.age = age;
            this.midichlorians = midichlorians;
            this.homeworld = homeworld;
            this.species = species;
        }
    }
}
