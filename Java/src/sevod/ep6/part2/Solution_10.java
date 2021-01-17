package sevod.ep6.part2;

public class Solution_10 {
    public static void main(String[] args) {
    }
    //напишите ваш код тут
    public abstract class ForceUser{
        abstract void UseForce();
    }

    public class Jedi extends ForceUser{
        void UseForce(){
            System.out.println("push item");
        }
    }

    public class Sith extends ForceUser{
        void UseForce(){
            System.out.println("use the lightning");
        }
    }
}
