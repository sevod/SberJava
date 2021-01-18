package sevod.ep8.part1;

import sevod.ep8.part1.Solution_6.Drink;

public class Solution_7 {
    public static void main(String[] args) {
        Object obj = new Circle();
        Movable movable = (Movable) obj;
        Drawable drawable = new Rectangle();
        printMainInfo(drawable);
        printMainInfo(movable);
    }
    public static void printMainInfo(Object object) {
        //напишите тут ваш код
        if (object instanceof Drawable)
            ((Drawable)object).draw();
        if (object instanceof Movable)
            ((Movable)object).move();
    }
    static interface Movable {
        void move();
    }
    static class Circle implements Movable {
        public void draw() {
            System.out.println("Can be drawn");
        }
        public void move() {
            System.out.println("Can be moved");
        }
    }
    static interface Drawable {
        void draw();
    }
    static class Rectangle implements Drawable {
        public void draw() {
            System.out.println("Can be drawn");
        }
        public void move() {
            System.out.println("Can be moved");
        }
    }
}
