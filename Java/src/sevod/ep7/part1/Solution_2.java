package sevod.ep7.part1;

public class Solution_2 {
    public static void main(String[] args) {
        System.out.println(getObjectType(new AZI3()));
        System.out.println(getObjectType(new B21()));
        System.out.println(getObjectType(new IG88()));
        System.out.println(getObjectType(new R2D2()));
    }
    public static String getObjectType(Object o) {
        return o.getClass().getSimpleName();
    }
    public static class AZI3 {
    }
    public static class B21 {
    }
    public static class IG88 {
    }
    public static class R2D2 {
    }
}
