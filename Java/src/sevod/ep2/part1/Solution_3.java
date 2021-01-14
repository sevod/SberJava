package sevod.ep2.part1;

public class Solution_3 {
    public static void main(String[] args) {
        Zam zam = new Zam();
        Dron dron = new Dron();
        zam.spy = dron;
        dron.hunter = zam;
    }
    public static class Zam {
        String name;
        int id;
        Dron spy;
    }
    public static class Dron {
        String name;
        int id;
        Zam hunter;
    }
}
