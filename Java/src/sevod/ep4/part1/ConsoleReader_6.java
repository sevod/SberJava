package sevod.ep4.part1;

import java.util.Scanner;

public class ConsoleReader_6 {
    public static String readString() throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static int readInt() throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static double readDouble() throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        return scanner.nextBoolean();
    }
    public static void main(String[] args) throws Exception {
    }
}
