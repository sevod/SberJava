package sevod.ep5.part1;

import java.util.HashSet;
import java.util.Set;

public class Collection_1 {
    public static void main(String[] args) {
        //напишите тут ваш код
        Set<String> strings = new HashSet<>();
        strings.add("dron");
        strings.add("galaxy");
        strings.add("jedi");
        strings.add("wars");
        strings.add("star");
        strings.add("yoda");
        strings.add("master");
        strings.add("luke");
        strings.add("force");
        strings.add("sith");

        for (String string:strings){
            System.out.println(string);
        }
    }
}
