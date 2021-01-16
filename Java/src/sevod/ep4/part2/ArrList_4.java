package sevod.ep4.part2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrList_4 {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> str = new ArrayList<>();
        str.add("abc");
        str.add("qwe");
        str.add("zxc");
        str.add("yui");
        str.add("hjk");

        System.out.println(str.size());
        for (String s: str){
            System.out.println(s);
        }
    }
}
