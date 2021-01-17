package sevod.ep7.part1;

public class Solution_8 {
    public static void main(String[] args) {
    }
    public interface Fly {
        public void fly();
    }
    public interface Move {
        public void move();
    }
    public interface Eat {
        public void eat();
    }
    public class Rathtar implements Move, Eat {
        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }
    public class Starkiller implements Fly {
        @Override
        public void fly() {

        }
    }
    public class Jedi implements Move, Fly, Eat {
        @Override
        public void fly() {

        }

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }
}
