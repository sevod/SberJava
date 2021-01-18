package sevod.ep8.part1.Solution_10;

public class Singleton {
    private static Singleton singleton = null;

    public static Singleton getSingleton() {
        if (singleton != null)
            return singleton;
        singleton = new Singleton();
        return singleton;
    }

    private Singleton() {
        this.singleton = singleton;
    }
}
