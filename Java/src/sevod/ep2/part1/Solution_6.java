package sevod.ep2.part1;

public class Solution_6 {
    public static void main(String[] args) {
        Dias dias = new Dias();
        Clone1 clone1 = new Clone1();
        Clone2 clone2 = new Clone2();
        Clone3 clone3 = new Clone3();

        clone1.owner = dias;
        clone2.owner = dias;
        clone3.owner = dias;
    }
    public static class Clone1 {
        public Dias owner;
    }
    public static class Clone2 {
        public Dias owner;
    }
    public static class Clone3 {
        public Dias owner;
    }
    public static class Dias {
    }
}
