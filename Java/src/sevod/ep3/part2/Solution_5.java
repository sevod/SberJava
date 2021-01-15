package sevod.ep3.part2;

public class Solution_5 {
    public static void main(String[] args) {
        Jedi jedi = new Jedi();
        jedi.initialize("Jedi", 42, 100);
    }

    static class Jedi {
        String name;
        int age;
        int midichlorians;

        public void initialize(String name, int age, int midichlorians){
            this.name = name;
            this.age = age;
            this.midichlorians = midichlorians;
        }
    }
}
