package sevod.ep2.part2;

import java.util.Scanner;

public class Solution_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        if ((name1.equals("Anakin") && name2.equals("Obi-Wan")) || (name2.equals("Anakin") && name1.equals("Obi-Wan")))
            System.out.println(name1 + " and "  + name2 + " - friends");
        else if ((!name1.equals("Anakin") && !name2.equals("Obi-Wan")) && (!name2.equals("Anakin") && !name1.equals("Obi-Wan")))
            System.out.println(name1 + " and "  + name2 + " - foes");
        else if (name1.equals("Anakin") || name1.equals("Obi-Wan"))
            System.out.println(name1 + "- friend, " + name2 + " - foe" );
        else
            System.out.println(name1 + " - foe, " + name2 + "- friend" );
    }
}
