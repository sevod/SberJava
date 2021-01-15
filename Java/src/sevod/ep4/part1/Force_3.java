package sevod.ep4.part1;

public class Force_3 {
        public static int theForce = 0;
        //напишите тут ваш код


    public Force_3() {
        theForce++;
    }

    protected void finalize() throws Throwable{
        theForce--;
    }

    public static void main(String[] args) {
        }
}
