package sevod.ep4.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrList_7 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("darth");
        strings.add("veider");
        strings.add("skywalker");
        strings.add("jedi");
        strings = Arraylist(strings);
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public static ArrayList<String> Arraylist(ArrayList<String> strings) {
        //напишите тут ваш код
        String str;

        ListIterator<String> listIterator = strings.listIterator();
        while (listIterator.hasNext()){
            str = listIterator.next();
            if (str.contains("d") && !str.contains("j"))
                listIterator.remove();
            else if (str.contains("s") && !str.contains("d"))
                listIterator.add(str);
        }
        return strings;
    }
}
