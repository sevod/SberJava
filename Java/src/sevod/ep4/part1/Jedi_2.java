package sevod.ep4.part1;


public class Jedi_2 {
    public static void main(String[] args) {
    }
    protected void finalize(){
        System.out.println("A Jedi was destroyed");
    }
}

class Sith {
    //напишите тут ваш код
    protected void finalize(){
        System.out.println("A Sith was destroyed");
    }
}

